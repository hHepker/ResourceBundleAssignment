/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hepker;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Haley
 */
public class Languages {
    public enum LanguageOptions { USA, JAPANESE };
    private static ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.getDefault());
    
    public static ResourceBundle getResourceBundle() {
        return messages;
    }

    public static void setResourceBundle(LanguageOptions language) {
        Locale locale = Locale.getDefault();
        switch(language) {
            case USA:
                locale = Locale.US;
                break;
            case JAPANESE:
                locale =new Locale("ja", "JP");
                break;
        }
        messages = ResourceBundle.getBundle("messages", locale);
    }
}
