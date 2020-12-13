/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hepker.left_form;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Haley
 */
public class FormPanel extends JPanel {
    private JLabel title_label;
    private JLabel red_label;
    private JLabel green_label;
    private JLabel blue_label;
    private JLabel bodyText_label;
    private JTextField title_field;
    private JTextField red_field;
    private JTextField green_field;
    private JTextField blue_field;
    private JTextField bodyText_field;
    private JButton go_button;
    private FormListener formListener;
    
    public FormPanel () {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        
        Border inner_border = BorderFactory.createTitledBorder("Webpage Generator");
        Border outer_border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outer_border, inner_border));
        
        title_label = new JLabel("HTML Title: ");
        red_label = new JLabel("Red: ");
        green_label = new JLabel("Green: ");
        blue_label = new JLabel("Blue: ");
        bodyText_label = new JLabel("Body Text: ");
        title_field = new JTextField(10);
        red_field = new JTextField(10);
        green_field = new JTextField(10);
        blue_field = new JTextField(10);
        bodyText_field = new JTextField(10);
        go_button = new JButton("Generate");
        go_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = title_field.getText();
                String red = red_field.getText();
                String green = green_field.getText();
                String blue = blue_field.getText();
                String bodyText = bodyText_field.getText();
                FormEvent event = new FormEvent(this, title, red, green, blue, bodyText);
                if(formListener != null) {
                    formListener.formSubmit(event);
                }
            }
        });
        
        layoutComponents();
        
    }
    
    public void setListener(FormListener formListener) {
        this.formListener = formListener;
    }
    
    public void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        /******** First row ********/
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(title_label, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(title_field, gc);
        
        /******** Second row ********/
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(red_label, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(red_field, gc);

        
        /******** Third row ********/
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        add(green_label, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(green_field, gc);
        
        
         /******** Fourth row ********/
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        add(blue_label, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(blue_field, gc);
        
        /******** Fifth row ********/
        gc.weightx = 1;
        gc.weighty = 10;
        
        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        add(bodyText_label, gc);
        
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(bodyText_field, gc);
        
        /******** Sixth row ********/
        gc.weightx = 1;
        gc.weighty = 10;
        
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(go_button, gc);
    }
}