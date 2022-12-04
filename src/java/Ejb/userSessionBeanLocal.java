/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Ejb;

import Entity.Cart;
import Entity.Category;
import Entity.Image;
import Entity.Product;
import Entity.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chirag
 */
@Local
public interface userSessionBeanLocal {

    void addUser(String name, String email, String password, String address, String mobile);

    User searchUser(String email);

    List<Category> getAllCategories();

   
     List<Product> searchProductByCat(int cat);

    Category searchCategory(int id);

    List<Image> getImagesById(int id);

    Product searchProductById(int id);

    void addToCart(String user, int id);

    List<Cart> getCartByUname(String name);

    Long getCartCount(String name);

    void deleteCartProduct(int id);
    void addReview(int user_id, String comment, int product_id);

    User findUserByName(String name);


}
