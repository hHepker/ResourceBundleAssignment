/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hepker;

import com.hepker.left_form.FormEvent;
import com.hepker.left_form.FormListener;
import top_toolbar.StringListener;
import top_toolbar.Toolbar;
import com.hepker.left_form.FormPanel;
import com.hepker.menubar.MenuBar;
import com.hepker.menubar.MenuItemListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Haley
 */
public class MainFrame extends JFrame {
    private ResourceBundle messages = Languages.getResourceBundle();
    private MenuBar menuBar;
    private Toolbar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    
    public MainFrame() {
        super();
        setTitle(messages.getString("title"));
        setMinimumSize(new Dimension(600,500));
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
        setLayout(new BorderLayout());
        
        menuBar = new MenuBar();
        setJMenuBar(menuBar);
        fileChooser = new JFileChooser();
        menuBar.setMenuItemListener(new MenuItemListener() {
            @Override
            public void getMenuItem(JMenuItem menuItem) {
                String menuItemText = menuItem.getText();
                if(menuItemText.equals("Export Data...")) {
                    int action = fileChooser.showSaveDialog(MainFrame.this);
                    if(action == JFileChooser.APPROVE_OPTION) {
                        try (PrintWriter writer = new PrintWriter(
                                new File(fileChooser.getSelectedFile().getPath()))) {
                            writer.print(textPanel.getText());
                            JOptionPane.showMessageDialog(MainFrame.this,
                                    "File saved",
                                    "Save File",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } catch (FileNotFoundException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this,
                                    "Could not export " + ex.getMessage(),
                                    "File Not Found",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if(menuItemText.equals("Import Data...")) {
                    int action = fileChooser.showOpenDialog(MainFrame.this);
                    if(action == JFileChooser.APPROVE_OPTION) {
                        try {
                            byte[] encoded = Files.readAllBytes(
                                        Paths.get(fileChooser.getSelectedFile().getPath()));
                            String fileContents = new String(encoded);
                            textPanel.appendText(fileContents);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this,
                                    "Cannot open " + ex.getMessage(),
                                    "I/O Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }   
                } else if(menuItemText.equals("Quit")) {
                    closeWindow();
                }
            }
        });
        
        toolbar = new Toolbar();
        add(toolbar, BorderLayout.NORTH);
        toolbar.setStringListener(new StringListener() {
            @Override
            public void getText(String text) {
                textPanel.appendText(messages.getString("greeting") + ", " + "\n" );
            }
        });
  
        formPanel = new FormPanel();
        add(formPanel, BorderLayout.WEST);
        formPanel.setListener(new FormListener() {
            @Override
            public void formSubmit(FormEvent formEvent) {
                String title = formEvent.getTitle();
                String red = formEvent.getRed();
                String green = formEvent.getGreen();
                String blue = formEvent.getBlue();
                String bodyText = formEvent.getBodyText();
                textPanel.appendText(title + " " + red + " " + green + " " + blue + " " + bodyText + "\n");
            }
        });
        textPanel = new TextPanel();
        add(textPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    private void closeWindow() {
        int action = JOptionPane.showConfirmDialog(MainFrame.this, 
            "Do you really want to quit?",
            "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
        if(action == JOptionPane.OK_OPTION){
            System.exit(0); // or e.getWindow().dispose();
        }
    }
}