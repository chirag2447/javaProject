/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Ejb;

import Entity.Brand;
import Entity.Category;
import Entity.Color;
import Entity.Groups;
import Entity.Image;
import Entity.Product;
import Entity.Review;
import Entity.Size1;
import Entity.Subcategory;
import Entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chirag
 */
@Stateless
public class AdminSessionBean implements AdminSessionBeanLocal {

    @PersistenceContext(unitName = "shoeStorePU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    //---------------------------User-------------------------------
    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<User> showAllUsers() {
        List<User> u = em.createNamedQuery("User.findAll").getResultList();
        return u;
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
    public void DeleteUser(int id) {

        User u = (User) em.createNamedQuery("User.findByUId").setParameter("uId", id).getSingleResult();
        em.remove(u);
    }

    @Override
    public User searchUser(int id) {

        User u = (User) em.createNamedQuery("User.findByUId").setParameter("uId", id).getSingleResult();
        return u;
    }

    @Override
    public void updateUser(int id, String name, String email, String password, String address, String mobile) {
        User u = (User) em.createNamedQuery("User.findByUId").setParameter("uId", id).getSingleResult();

        u.setUName(name);
        u.setUEmail(email);
        u.setUPassword(password);
        u.setUAddress(address);
        u.setUMobile(mobile);

        em.merge(u);

    }

    //==============product===============
    @Override
    public List<Product> getAllProducts() {
        List<Product> p = em.createNamedQuery("Product.findAll").getResultList();
        return p;
    }

    @Override
    public void addProduct(String name, int brand, String image, String price, int color, int size, int category) {

        Product p = new Product();
        Brand b = (Brand) em.createNamedQuery("Brand.findByBrandId").setParameter("brandId", brand).getSingleResult();
        Color c = (Color) em.createNamedQuery("Color.findByColorId").setParameter("colorId", color).getSingleResult();
        Size1 s = (Size1) em.createNamedQuery("Size1.findBySizeId").setParameter("sizeId", size).getSingleResult();
        Category cat = (Category) em.createNamedQuery("Category.findByCatId").setParameter("catId", category).getSingleResult();
        p.setName(name);
        p.setBrandId(b);
        p.setImage(image);
        p.setPrice(Double.parseDouble(price));
        p.setColorId(c);
        p.setSizeId(s);
        p.setCatId(cat);
        em.persist(p);
    }

    @Override
    public void deleteProduct(int id) {
        Product p = (Product) em.createNamedQuery("Product.findById").setParameter("id", id).getSingleResult();
        em.remove(p);
    }

    @Override
    public Product searchProduct(int id) {
        Product p = (Product) em.createNamedQuery("Product.findById").setParameter("id", id).getSingleResult();
        return p;
    }

    @Override
    public void updateProduct(int id, String name, int brand, int color, int size, String image, int category, String price) {
        Product p = (Product) em.createNamedQuery("Product.findById").setParameter("id", id).getSingleResult();
        Brand b = (Brand) em.createNamedQuery("Brand.findByBrandId").setParameter("brandId", brand).getSingleResult();
        Color c = (Color) em.createNamedQuery("Color.findByColorId").setParameter("colorId", color).getSingleResult();
        Size1 s = (Size1) em.createNamedQuery("Size1.findBySizeId").setParameter("sizeId", size).getSingleResult();
        Category cat = (Category) em.createNamedQuery("Category.findByCatId").setParameter("catId", category).getSingleResult();
        p.setName(name);
        p.setBrandId(b);
        p.setImage(image);
        p.setPrice(Double.parseDouble(price));
        p.setColorId(c);
        p.setSizeId(s);
        p.setCatId(cat);
        em.merge(p);
    }

    //==============brand===============
    @Override
    public List<Brand> showAllBrand() {
        List<Brand> b = em.createNamedQuery("Brand.findAll").getResultList();
        return b;
    }

    @Override
    public void addBrand(String name) {
        Brand b = new Brand();
        b.setBrand(name);
        em.persist(b);
    }

    @Override
    public void deleteBrand(int id) {
        Brand b = (Brand) em.createNamedQuery("Brand.findByBrandId").setParameter("brandId", id).getSingleResult();
        em.remove(b);
    }

    @Override
    public Brand searchBrand(int id) {
        Brand b = (Brand) em.createNamedQuery("Brand.findByBrandId").setParameter("brandId", id).getSingleResult();

        return b;
    }

    @Override
    public void updateBrand(int id, String name) {
        Brand b = (Brand) em.createNamedQuery("Brand.findByBrandId").setParameter("brandId", id).getSingleResult();
        b.setBrand(name);
        em.merge(b);

    }
    //==============category===============

    @Override
    public List<Category> showAllCategory() {
        List<Category> c = em.createNamedQuery("Category.findAll").getResultList();
        return c;
    }

    @Override
    public void addCategory(String name, String image) {
        Category c = new Category();
        c.setCatName(name);
        c.setCatImage(image);
        em.persist(c);
    }

    @Override
    public void deleteCategory(int id) {
        Category c = (Category) em.createNamedQuery("Category.findByCatId").setParameter("catId", id).getSingleResult();
        em.remove(c);
    }

    @Override
    public Category searchCategory(int id) {
        Category c = (Category) em.createNamedQuery("Category.findByCatId").setParameter("catId", id).getSingleResult();

        return c;
    }

    @Override
    public void updateCategory(int id, String name, String image) {
        Category c = (Category) em.createNamedQuery("Category.findByCatId").setParameter("catId", id).getSingleResult();
        c.setCatName(name);
        c.setCatImage(image);
        em.merge(c);
    }
//==============color===============

    @Override
    public List<Color> getAllColors() {
        List<Color> co = em.createNamedQuery("Color.findAll").getResultList();
        return co;
    }

    @Override
    public void addColor(String name) {
        Color c = new Color();
        c.setColor(name);
        em.persist(c);
    }

    @Override
    public void deleteColor(int id) {
        Color co = (Color) em.createNamedQuery("Color.findByColorId").setParameter("colorId", id).getSingleResult();
        em.remove(co);
    }

    @Override
    public Color searchColor(int id) {
        Color co = (Color) em.createNamedQuery("Color.findByColorId").setParameter("colorId", id).getSingleResult();

        return co;
    }

    @Override
    public void updateColor(int id, String name) {
        Color co = (Color) em.createNamedQuery("Color.findByColorId").setParameter("colorId", id).getSingleResult();
        co.setColor(name);
        em.merge(co);
    }
    //==============image===============

    @Override
    public List<Image> showAllImage() {
        List<Image> i = em.createNamedQuery("Image.findAll").getResultList();
        return i;
    }

    @Override
    public void addImage(String image, int product_id, int color_id) {
        Product p = (Product) em.createNamedQuery("Product.findById").setParameter("id", product_id).getSingleResult();
        Color c = (Color) em.createNamedQuery("Color.findByColorId").setParameter("colorId", color_id).getSingleResult();
        Image i = new Image();
        i.setIImage(image);
        i.setCId(c);
        i.setPId(p);
        em.persist(i);

    }

    @Override
    public void deleteImage(int id) {
        Image i = (Image) em.createNamedQuery("Image.findByIId").setParameter("iId", id).getSingleResult();
        em.remove(i);
    }

    @Override
    public Image searchImage(int id) {
        Image i = (Image) em.createNamedQuery("Image.findByIId").setParameter("iId", id).getSingleResult();
        return i;
    }

    @Override
    public void updateImage(int id, String image, int product_id, int color_id) {
        Product p = (Product) em.createNamedQuery("Product.findById").setParameter("id", product_id).getSingleResult();
        Color c = (Color) em.createNamedQuery("Color.findByColorId").setParameter("colorId", color_id).getSingleResult();
        Image i = (Image) em.createNamedQuery("Image.findByIId").setParameter("iId", id).getSingleResult();
        i.setIImage(image);
        i.setCId(c);
        i.setPId(p);
        em.merge(i);
    }

    //==============review===============
    @Override
    public List<Review> showAllReview() {
        List<Review> r = em.createNamedQuery("Review.findAll").getResultList();
        return r;
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
    public void deleteReview(int id) {

        Review r = (Review) em.createNamedQuery("Review.findByRId").setParameter("rId", id).getSingleResult();
        em.remove(r);
    }

    @Override
    public Review searchReview(int id) {
        Review r = (Review) em.createNamedQuery("Review.findByRId").setParameter("rId", id).getSingleResult();
        return r;
    }

    @Override
    public void updateReview(int id, int user_id, String comment, int product_id) {
        User u = (User) em.createNamedQuery("User.findByUId").setParameter("uId", user_id).getSingleResult();
        Product p = (Product) em.createNamedQuery("Product.findById").setParameter("id", product_id).getSingleResult();
        Review r = (Review) em.createNamedQuery("Review.findByRId").setParameter("rId", id).getSingleResult();
        r.setUId(u);
        r.setRComment(comment);
        r.setPId(p);
        em.merge(r);
    }

    //==============size===============
    @Override
    public List<Size1> showAllSize() {
        List<Size1> s = em.createNamedQuery("Size1.findAll").getResultList();

        return s;
    }

    @Override
    public void addSize(String size) {
        Size1 s = new Size1();
        s.setSize(Integer.parseInt(size));
        em.persist(s);
    }

    @Override
    public void deleteSize(int id) {
        Size1 s = (Size1) em.createNamedQuery("Size1.findBySizeId").setParameter("sizeId", id).getSingleResult();
        em.remove(s);
    }

    @Override
    public Size1 searchSize(int id) {
        Size1 s = (Size1) em.createNamedQuery("Size1.findBySizeId").setParameter("sizeId", id).getSingleResult();
        return s;
    }

    @Override
    public void updateSize(int id, String size) {
        Size1 s = (Size1) em.createNamedQuery("Size1.findBySizeId").setParameter("sizeId", id).getSingleResult();
        s.setSize(Integer.parseInt(size));
        em.merge(s);

    }

    //==============subCategory===============
    @Override
    public List<Subcategory> getAllSubCategory() {
        List<Subcategory> s = em.createNamedQuery("Subcategory.findAll").getResultList();
        return s;
    }

    @Override
    public Subcategory searchSubCategory(int id) {
        Subcategory s = (Subcategory) em.createNamedQuery("Subcategory.findBySubcatId").setParameter("subcatId", id).getSingleResult();
        return s;
    }

    @Override
    public Groups getGroupByUserName(String name) {
        Groups g =(Groups) em.createNamedQuery("Groups.findByName").setParameter("name", name).getSingleResult();
        return g;
    }

}
