/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hepker;

import com.hepker.Languages.LanguageOptions;
import javax.swing.SwingUtilities;

/**
 *
 * @author Haley
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Languages.setResourceBundle(LanguageOptions.JAPANESE);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            new MainFrame();
        }
    });	
    
}
    
}
