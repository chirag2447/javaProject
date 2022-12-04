/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import Ejb.userSessionBeanLocal;
import Entity.Cart;
import Entity.Category;
import Entity.Image;
import Entity.Product;
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
import javax.servlet.http.HttpSession;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author chirag
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    userSessionBeanLocal ejb;
    
    String loggedUser;
    int category;
    String cat_name,cat_image;
    int shoe_id;
    String shoe_name,shoe_image;
    double shoe_price;
    List<Image> images;

    public int getShoe_id() {
        return shoe_id;
    }

    public void setShoe_id(int shoe_id) {
        this.shoe_id = shoe_id;
    }

    public String getShoe_name() {
        return shoe_name;
    }

    public void setShoe_name(String shoe_name) {
        this.shoe_name = shoe_name;
    }

    public String getShoe_image() {
        return shoe_image;
    }

    public void setShoe_image(String shoe_image) {
        this.shoe_image = shoe_image;
    }

    public Double getShoe_price() {
        return shoe_price;
    }

    public void setShoe_price(Double shoe_price) {
        this.shoe_price = shoe_price;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_image() {
        return cat_image;
    }

    public void setCat_image(String cat_image) {
        this.cat_image = cat_image;
    }
    List<Category> c;
    Boolean valid = false;
    String username;
    String email;
    String password;
    String mobile;
    String address;
   
    String getOut;

    public List<Category> getC() {
        
        return ejb.getAllCategories();
    }

    public void setC(List<Category> c) {
        this.c = c;
    }

    public String getGetOut() {
        return "login-reg/login.jsf";
    }

    public void setGetOut(String getOut) {
        this.getOut = getOut;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * Creates a new instance of userBean
     */
    public void addUser() {
        
         Pbkdf2PasswordHashImpl pb;
             pb = new Pbkdf2PasswordHashImpl();
            String enc = pb.generate(password.toCharArray());

        
        ejb.addUser(username, email, enc, address, mobile);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void checkUser() {
//        User u = ejb.searchUser(email);
//        String aname = u.getUName();
//        String apassword = u.getUPassword();
////        System.out.println(u.getUAddress());
//
//        if (aname.isEmpty()) {
//            valid = false;
//        } else if (!(apassword.equals(password))) {
//            valid = false;
//        } else {
//            loggedUser=aname;
//            valid = true;
//            try {
//                FacesContext.getCurrentInstance().getExternalContext().redirect("../home.jsf");
//            } catch (IOException ex) {
//                Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//    }
    public List<Product> searchProductByCat(){
        return ejb.searchProductByCat(category);
    }
    public void logout(){

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.invalidate();
//        try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("login-reg/login.jsf");
//        } catch (IOException ex) {
//            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
    int logged_id;

    public int getLogged_id() {
        return logged_id;
    }

    public void setLogged_id(int logged_id) {
        this.logged_id = logged_id;
    }
    

    public String getLoggedUser() {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//            User u =ejb.findUserByName(loggedUser);
//            logged_id = u.getUId();
        return (String) session.getAttribute("username");
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }
   public void gToCategory(int id){
       category = id;
       catById();
       try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("manShoes.jsf");
            } catch (IOException ex) {
                Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
            }
       
   }
   public void catById(){
       Category c = ejb.searchCategory(category);
       cat_name=c.getCatName();
       cat_image=c.getCatImage();
   }
   public void gToShoe(int id){
       
       shoe_id = id;
       Product p = ejb.searchProductById(id);
       shoe_name = p.getName();
       shoe_image = p.getImage();
       shoe_price = p.getPrice();
       images = ejb.getImagesById(id);
        try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("shoe.jsf");
            } catch (IOException ex) {
                Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       
       
   }
   public void imagesById(){
       images = ejb.getImagesById(shoe_id);
   }
   public void addToCart(int id){
       String user  = getLoggedUser();
       if(user == null){
        try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login-reg/login.jsf");
            } catch (IOException ex) {
                Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
            }
           
       }else{
           
       ejb.addToCart(user, id);
       }
   }
  
List<Cart> cart;

    public List<Cart> getCart() {
        return ejb.getCartByUname(getLoggedUser());
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

   Long count;

    public Long getCount() {
        return ejb.getCartCount(getLoggedUser());
    }
public void deleteCart(int id){
    ejb.deleteCartProduct(id);
}
    public void setCount(Long count) {
        this.count = count;
    }
    
    
    public void loggedId(){
       
          
                
        User u = ejb.findUserByName(getLoggedUser());
        logged_id = u.getUId();
            
        
    }
    
    String review;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    
   public void addReview(){
       if(getLoggedUser() != null){
           
       loggedId();
       
       ejb.addReview(logged_id, review, shoe_id);
       }
   }
    public UserBean() {
    }
    
}
