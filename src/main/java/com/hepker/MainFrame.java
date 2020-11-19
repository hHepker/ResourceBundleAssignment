/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hepker;

import java.awt.BorderLayout;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Haley
 */
public class MainFrame extends JFrame {
    private ResourceBundle messages = Languages.getResourceBundle();
    private Toolbar toolbar;
    private TextPanel textPanel;
    
    public MainFrame() {
        super();
        setTitle(messages.getString("title"));
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        toolbar = new Toolbar();
        add(toolbar, BorderLayout.NORTH);
        toolbar.setStringListener(new StringListener() {
            @Override
            public void getText(String text) {
                textPanel.appendText(messages.getString("greeting") + ", " + text + "\n");
            }
        });
        textPanel = new TextPanel();
        add(textPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }
}