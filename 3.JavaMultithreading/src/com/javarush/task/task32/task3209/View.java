package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by script972 on 12.09.2017.
 */
public class View extends JFrame implements ActionListener {

    private Controller controller;



    private JTabbedPane tabbedPane=new JTabbedPane();
    private JTextPane htmlTextPane=new JTextPane();
    private JEditorPane plainTextPane=new JEditorPane();

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

    }


    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init(){
        initGui();
        this.addWindowListener(new FrameListener(this));
        this.setVisible(true);


    }

    public void exit(){
        controller.exit();
    }

    public void initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();

        MenuHelper.initFileMenu(this, jMenuBar); //file
        MenuHelper.initEditMenu(this, jMenuBar); // edit
        MenuHelper.initStyleMenu(this, jMenuBar); //style
        MenuHelper.initAlignMenu(this, jMenuBar); // align
        MenuHelper.initColorMenu(this, jMenuBar); //colorFont
        MenuHelper.initFontMenu(this, jMenuBar); // fonts
        MenuHelper.initHelpMenu(this, jMenuBar); //help

        getContentPane().add(jMenuBar, BorderLayout.NORTH);

    }

    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        htmlTextPane.add(new JScrollPane());

        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));

        tabbedPane.setPreferredSize(new Dimension(100, 100));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }



    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged(){

    }

    public boolean canUndo() {
        //return undoManager.canUndo();
        return false;
    }

    //Проверка возможности перейти на действие вперед
    public boolean canRedo() {
        //return undoManager.canRedo();
        return false;

    }

    //отменяет последнее действие
    public void undo() {
       /* try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }*/
    }

    //возвращает ранее отмененное действие
    public void redo() {
       /* try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }*/
    }

    // геттер для слушателя изменений
  /*  public UndoListener getUndoListener() {
        return undoListener;
    }*/

    //должен сбрасывать все правки в менеджере
    public void resetUndo() {
       // undoManager.discardAllEdits();
    }

    //должен возвращать true, если выбрана вкладка, отображающая html в панели вкладок
    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    // Выбирать html вкладку
    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
      //  resetUndo();

    }

    // обновляет html страницу
    public void update() {
      //  htmlTextPane.setDocument(controller.getDocument());
    }

    // "О программе"
    public void showAbout() {
        JOptionPane.showMessageDialog(getContentPane(), "It hard to be God", "Information", JOptionPane.INFORMATION_MESSAGE);
    }





}
