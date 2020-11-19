/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hepker;

/**
 *
 * @author Haley
 */
import com.hepker.Languages;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Toolbar extends JPanel implements ActionListener {
    private ResourceBundle messages = Languages.getResourceBundle();
    private JLabel name_label;
    private JTextField name_field;
    private JButton go_button;
    private StringListener textListener;

    public Toolbar() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        name_label = new JLabel(messages.getString("inquiry"));
        add(name_label);
        
        name_field = new JTextField(10);
        add(name_field);
        
        go_button = new JButton(messages.getString("button"));
        add(go_button);
        go_button.addActionListener(this);
    }
    
    public void setStringListener(StringListener listener) {
        this.textListener = listener;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(textListener != null) { 
            String name = name_field.getText();
            textListener.getText(name);
        } 
    }
}