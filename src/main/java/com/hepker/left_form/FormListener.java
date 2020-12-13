/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hepker.left_form;

import java.util.EventListener;

/**
 *
 * @author Haley
 */
public interface FormListener extends EventListener {
    public void formSubmit(FormEvent form);
}

