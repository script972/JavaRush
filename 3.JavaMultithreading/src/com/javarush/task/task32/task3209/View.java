package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;

import javax.swing.*;
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

    private void initMenuBar(){

    }

    private void initEditor(){

    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
}
