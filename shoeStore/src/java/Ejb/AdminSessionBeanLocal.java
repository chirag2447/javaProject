/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Ejb;

import Entity.Brand;
import Entity.Category;
import Entity.Color;
import Entity.Image;
import Entity.Product;
import Entity.Review;
import Entity.Size1;
import Entity.Subcategory;
import Entity.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chirag
 */
@Local
public interface AdminSessionBeanLocal {

    List<User> showAllUsers();
    void addUser(String name, String email, String password, String address, String mobile);

    void DeleteUser(int id);

    User searchUser(int id);

    void updateUser(int id, String name, String email, String password, String address, String mobile);

    List<Product> getAllProducts();

    List<Brand> showAllBrand();

    void addBrand(String name);

    void deleteBrand(int id);

    Brand searchBrand(int id);

    void updateBrand(int id, String name);

    List<Category> showAllCategory();

    void addCategory(String name, String image);

    void deleteCategory(int id);

    Category searchCategory(int id);

    void updateCategory(int id, String name, String image);

    List<Color> getAllColors();

    void addColor(String name);

    void deleteColor(int id);

    Color searchColor(int id);

    void updateColor(int id, String name);

    List<Image> showAllImage();

    Image searchImage(int id);

    List<Review> showAllReview();

    Review searchReview(int id);

    List<Size1> showAllSize();

    void addSize(String size);

    void deleteSize(int id);

    Size1 searchSize(int id);

    void updateSize(int id, String size);

    List<Subcategory> getAllSubCategory();

    Subcategory searchSubCategory(int id);
    
}
