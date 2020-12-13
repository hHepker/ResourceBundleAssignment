/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hepker.left_form;

import java.util.EventObject;

/**
 *
 * @author Haley
 */
public class FormEvent extends EventObject {
    private String title;
    private String red;
    private String green;
    private String blue;
    private String bodyText;
    
    public FormEvent(Object source, String title, String red, String green, String blue, String bodyText) {
        super(source);
        this.title = title;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.bodyText = bodyText;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getRed() {
        return red;
    }
    
    public void setRed(String red) {
        this.red = red;
    }
    
    public String getGreen() {
        return green;
    }
    
    public void setGreen(String green) {
        this.green = green;
    }
    
    public String getBlue() {
        return blue;
    }
    
    public void setBlue(String blue) {
        this.blue = blue;
    }
    
    public String getBodyText() {
        return bodyText;
    }
    
    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }
}
