/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.services;

import greta.speedymarket.beans.LoginBean;
import greta.speedymarket.beans.RedirectBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean(name = "LoginService")
public class LoginService {

    @ManagedProperty(value = "#{LoginBean}")
    LoginBean loginBean;
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public void authenticate() {
        System.out.println("*********************** le " + new SimpleDateFormat("dd.MM.yyy").format(new Date()) + " a " + new SimpleDateFormat("HH:mm:ss").format(new Date()) + " : Tentative d'authentification d'un admin ");
        System.out.println("identificationLogin : " + loginBean.getLogin() + " - password : " + loginBean.getPassword());
        // Authentification en tant que admin : login : admin et password = adminadmin
        if (loginBean.getLogin().compareTo("admin") == 0 && loginBean.getPassword().compareTo("adminadmin") == 0) {
            /* Authentification reussie */
            System.out.println(" a\"+new SimpleDateFormat(\"HH:mm:ss\").format(new Date())+\" : Authentification admin success\"" + "*********************** le " + new SimpleDateFormat("dd.MM.yyy").format(new Date()));
            RedirectBean.redirectTo("./admin.jsf");
        } else {
            /* Mot de passe incorrect */
            RedirectBean.redirectTo("./login.jsf");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Erreur lors de la connexion"));
        }
    }
}
