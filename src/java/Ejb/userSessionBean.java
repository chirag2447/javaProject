/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Ejb;

import Entity.Cart;
import Entity.Category;
import Entity.Image;
import Entity.Product;
import Entity.Review;
import Entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author chirag
 */
@Stateless
public class userSessionBean implements userSessionBeanLocal {

    @PersistenceContext(unitName = "shoeStorePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public void addUser(String name, String email, String password, String address, String mobile) {

       User u = new User();
       u.setUName(name);
       u.setUEmail(email);
       u.setUPassword(password);
       u.setUAddress(address);
       u.setUMobile(mobile);
       em.persist(u);
    }

    @Override
    public User searchUser(String email) {

        User u = (User) em.createNamedQuery("User.findByUEmail").setParameter("uEmail", email).getSingleResult();
        return u;
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Category> getAllCategories() {
        List<Category> c = em.createNamedQuery("Category.findAll").getResultList();
        return c;
    }

    @Override
    public List<Product> searchProductByCat(int cat) {
        Category c =(Category) em.createNamedQuery("Category.findByCatId").setParameter("catId", cat).getSingleResult();
        List<Product> p =   em.createNamedQuery("Product.findByCategory").setParameter("catId", c).getResultList();
        return p;
    }

    @Override
    public Category searchCategory(int id) {
        Category c =(Category) em.createNamedQuery("Category.findByCatId").setParameter("catId", id).getSingleResult();
        return c;
    }

    @Override
    public List<Image> getImagesById(int id) {
        Product p = (Product) em.createNamedQuery("Product.findById").setParameter("id", id).getSingleResult();
        List<Image> i = em.createNamedQuery("Image.findBypId").setParameter("pId", p).getResultList();
        return i;
    }

    @Override
    public Product searchProductById(int id) {
        Product u = (Product) em.createNamedQuery("Product.findById").setParameter("id", id).getSingleResult();
        return u;
    }

    @Override
    public void addToCart(String user, int id) {
        Product p = searchProductById(id);
        Cart c = new Cart();
        c.setPId(p);
        c.setUserName(user);
        try{
        em.persist(c);
        }catch(ConstraintViolationException e){
            System.out.println("++++++++++++++++++"+e);
            
        }
        
    }

    @Override
    public List<Cart> getCartByUname(String name) {
        return em.createNamedQuery("Cart.findByUserName").setParameter("userName", name).getResultList();
    }

    @Override
    public Long getCartCount(String name) {
        return  em.createNamedQuery("Cart.findByUserName").setParameter("userName", name).getResultStream().count();
    }

    @Override
    public void deleteCartProduct(int id) {
        Product p = searchProductById(id);
        List<Cart>  c= em.createNamedQuery("Cart.findBypId").setParameter("pId", p).getResultList();
       c.forEach((n)->em.remove(n));
    }

     @Override
    public void addReview(int user_id, String comment, int product_id) {
        User u = (User) em.createNamedQuery("User.findByUId").setParameter("uId", user_id).getSingleResult();
        Product p = (Product) em.createNamedQuery("Product.findById").setParameter("id", product_id).getSingleResult();
        Review r = new Review();
        r.setUId(u);
        r.setRComment(comment);
        r.setPId(p);
        em.persist(r);
    }

    @Override
    public User findUserByName(String name) {
        User u =(User) em.createNamedQuery("User.findByUName").setParameter("uName", name).getSingleResult();
        return u;
    }
    
    
    
}
