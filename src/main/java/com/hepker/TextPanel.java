/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hepker;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Haley
 */
public class TextPanel extends JPanel {
    private JTextArea textArea;
 
    public TextPanel() {
        textArea = new JTextArea();
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
 
    public void appendText(String text) {
        textArea.append(text);
    }
    
    public String getText() {
        return textArea.getText();
    }
}
