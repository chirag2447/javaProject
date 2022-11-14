/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import Ejb.AdminSessionBeanLocal;
import Entity.User;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author chirag
 */
@Named(value = "newJSFManagedBean")
@SessionScoped
public class NewJSFManagedBean implements Serializable {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    @EJB AdminSessionBeanLocal ejb;
    List<User> users ;
    String name,email,password,address,mobile;
    

    public List<User> getUsers() {
        
        return ejb.showAllUsers();
    }
    
    public void addUser(){
            ejb.addUser("test","t@gmail.com", "password", "abc", "1324648");
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("users.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeUser(){
        ejb.DeleteUser(2);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("users.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public NewJSFManagedBean() {
    }

    
    
}
