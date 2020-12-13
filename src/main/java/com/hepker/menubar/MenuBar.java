/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hepker.menubar;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Haley
 */
public class MenuBar extends JMenuBar implements ActionListener {
    private JMenu file_menu;
    private JMenuItem export_data_item;
    private JMenuItem import_data_item;
    private JMenuItem quit_item;
    private MenuItemListener listener;
    private JMenu window_menu;
    
    public MenuBar() {
        // Create File Menu
        file_menu = new JMenu("File");
        
        export_data_item = new JMenuItem("Export Data...");
        file_menu.add(export_data_item);
        export_data_item.addActionListener(this);
        
        import_data_item = new JMenuItem("Import Data...");
        file_menu.add(import_data_item);
        import_data_item.addActionListener(this);
        
        file_menu.addSeparator();
        
        quit_item = new JMenuItem("Quit");
        file_menu.add(quit_item);
        quit_item.addActionListener(this);
        
        this.add(file_menu);
        
        // Create Window Menu
        window_menu = new JMenu("Window");
        this.add(window_menu);
    }
    
    public void setMenuItemListener(MenuItemListener listener) {
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem clicked = (JMenuItem) e.getSource();
        if(listener != null) {
            listener.getMenuItem(clicked);
        }
    }
}
