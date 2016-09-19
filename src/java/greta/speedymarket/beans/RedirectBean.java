/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package greta.speedymarket.beans;

import java.io.IOException;

import javax.faces.context.FacesContext;

public class RedirectBean {

 public static void redirectTo(String dest) {

 try {

 FacesContext.getCurrentInstance().getExternalContext().redirect(dest);

 } catch (IOException e) {

 e.printStackTrace();

 }

 }

}
