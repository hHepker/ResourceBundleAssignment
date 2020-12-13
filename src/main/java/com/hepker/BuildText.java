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
public class BuildText {
    private String title;
    private String red;
    private String green;
    private String blue;
    private String bodyText;

public String StringBuilder(){
    
    String html = "<!doctype HTML>";
    html += "\n\t<head>";
    html += "\n\t\t<meta charset=\"utf-8\">";
    html += "\n\t\t<title>" + title + "</title>";
    html += "\n\t\t<style>";
    html += "\n\t\tbody {";
    html += "\n\t\t\tbackground-color: rgb(" + red + ", " + green + ", " + blue + ");";
    html += "\n\t\t</style>";
    html += "\n\t\t</head>";
    html += "\n\t\t<body>" + bodyText + "</body>";
    System.out.println(html);
        return html;
    }
}
