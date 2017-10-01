package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Server {
    private static Map<String,Connection> connectionMap = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        System.out.println("Введите номер порта сервера: ");
        int port=ConsoleHelper.readInt();
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(port);
            System.out.println("Сервер запущен.");
            do{
                new Handler(serverSocket.accept()).start(); // lunching server and listen for client(s)
            }
            while (true);
        }
        catch (Exception e){
            System.out.println(e);
            if (serverSocket!=null){
                try{
                    serverSocket.close();
                }
                catch (IOException ex){}
            }
        }
    }

    public static void sendBroadcastMessage(Message message){
        for (String key:connectionMap.keySet()){
            try {
                connectionMap.get(key).send(message);
            }
            catch (IOException e){
                System.out.println("Не удалось отправить сообщение.");
            }
        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message nameMessage = connection.receive();
                if ((nameMessage.getType()==MessageType.USER_NAME)&&(!nameMessage.getData().isEmpty())) {
                    String userName=nameMessage.getData();
                    if (!connectionMap.containsKey(userName)){
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return userName;
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (String user:connectionMap.keySet()){
                    if (!user.equals(userName)){
                        connection.send(new Message(MessageType.USER_ADDED,user));
                    }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true){
                Message recievedMessage = connection.receive();
                if (recievedMessage.getType()==MessageType.TEXT){
                    String text = String.format("%s: %s",userName,recievedMessage.getData());
                    sendBroadcastMessage(new Message(MessageType.TEXT,text));
                }
                else {
                    System.out.println("Ошибка отправки сообщения.");
                }
            }
        }

        @Override
        public void run() {
            System.out.println("Установленно сообщение с удаленным адресом "+socket.getRemoteSocketAddress());
            Connection connection = null;
            String clientName = null;
            try {
                connection = new Connection(socket);
                clientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,clientName));
                sendListOfUsers(connection,clientName);
                serverMainLoop(connection,clientName);

            } catch (IOException e) {
                System.out.println("Произошла ошибка при обмене данными с удаленным адресом "+ socket.getRemoteSocketAddress());
            }
            catch (ClassNotFoundException ex){
                System.out.println("Произошла ошибка при обмене данными с удаленным адресом "+ socket.getRemoteSocketAddress());
            }
            finally {
                try {
                    if (connection!=null){
                        connection.close();}
                } catch (IOException e) {
                }
                if (clientName!=null){
                    connectionMap.remove(clientName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED,clientName));
                }
            }
            System.out.println("Соединение с удаленным адресом закрыто.");
        }
    }
}
