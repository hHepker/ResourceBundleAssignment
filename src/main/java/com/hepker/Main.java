/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hepker;

import com.hepker.Languages.LanguageOptions;
import java.awt.Color;
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
    int r = 255;
    int g = 255;
    int b = 255;
    Color background = new Color(r, g, b);
    Color text;
    
     if(r*0.299 + g*0.587 + b*0.114 > 186){
    text = Color.BLACK;
    } else{
    text = Color.WHITE;
    }
    printColors(background, text);
    
        Languages.setResourceBundle(LanguageOptions.USA);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            new MainFrame();
        }
    });	
    
}
     public static void printColors(Color bg, Color t){
    String result = "<style type=\"text/css\">";
    result += "\n\tbody {";
    result += "\n\t\tbackground-color: rgb(" + bg.getRed() + ", " + bg.getGreen()+ 
            ", " + bg.getBlue() + ");";
    result += "\n\t\tcolor: rgb(" + t.getRed() + ", " + t.getGreen()+ 
            ", " + t.getBlue() + ");";
    result += "\n\t}";
    result += "\n</style>";
    System.out.println(result);
    }
    
}
