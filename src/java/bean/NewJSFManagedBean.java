/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import Ejb.AdminSessionBeanLocal;
import Entity.Brand;
import Entity.Category;
import Entity.Color;
import Entity.Image;
import Entity.Product;
import Entity.Size1;
import Entity.User;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

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
    @EJB
    AdminSessionBeanLocal ejb;
      
    
    String aloggedUser;
    String name, email, password, address, mobile;
    int uid,bid,coid,sid;
    String bname,coname,sname;
    List<User> users;
    List<Product> products;
    String p_name,p_brand,p_color,p_size,p_image,p_cat,p_price;
    int p_id;
    List<Category> categories;
    int cat_id;
    String cat_name,cat_image;
    List<Brand> brands;
    List<Color> color;
    List<Size1> size;
    List<Image> image;
    int image_id;
    String image_pId,image_cId;
    String imageI;

    public String getAloggedUser() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       return (String) session.getAttribute("username");
//        return aloggedUser;
    }

    public void setAloggedUser(String aloggedUser) {
        this.aloggedUser = aloggedUser;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
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

 

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getImage_pId() {
        return image_pId;
    }

    public void setImage_pId(String image_pId) {
        this.image_pId = image_pId;
    }

    public String getImage_cId() {
        return image_cId;
    }

    public void setImage_cId(String image_cId) {
        this.image_cId = image_cId;
    }

    public String getImageI() {
        return imageI;
    }

    public void setImageI(String imageI) {
        this.imageI = imageI;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_brand() {
        return p_brand;
    }

    public void setP_brand(String p_brand) {
        this.p_brand = p_brand;
    }

    public String getP_color() {
        return p_color;
    }

    public void setP_color(String p_color) {
        this.p_color = p_color;
    }

    public String getP_size() {
        return p_size;
    }

    public void setP_size(String p_size) {
        this.p_size = p_size;
    }

    public String getP_image() {
        return p_image;
    }

    public void setP_image(String p_image) {
        this.p_image = p_image;
    }

    public String getP_cat() {
        return p_cat;
    }

    public void setP_cat(String p_cat) {
        this.p_cat = p_cat;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getsname() {
        return sname;
    }

    public void setsname(String sname) {
        this.sname = sname;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String goLogin() {
        return "login.jsf";
    }

    public List<Brand> getBrands() {
        return ejb.showAllBrand();
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public List<Color> getColor() {
        return ejb.getAllColors();
    }

    public void setColor(List<Color> color) {
        this.color = color;
    }

    public List<Size1> getSize() {
        return ejb.showAllSize();
    }

    public void setSize(List<Size1> size) {
        this.size = size;
    }

    public List<Image> getImage() {
        return ejb.showAllImage();
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    
    
   private String folder="C:\\Users\\chpan\\OneDrive\\Desktop\\shoeStore\\web\\images\\";
    private Part uploadedFile;
    private File savedFile;
    
    public void addImage(){
         int product = Integer.parseInt(image_pId);
         int color = Integer.parseInt(image_cId);
         imageI = getFileName(uploadedFile);
         savedFile = new File(folder,imageI);
         try(InputStream input = uploadedFile.getInputStream()){
             Files.copy(input, savedFile.toPath());
         }catch(Exception e){
             System.out.println(e);
         }
//         try{
//         uploadedFile.write(folder+imageI);
//         }catch(Exception e){
//             System.out.println(e);
//         }
        ejb.addImage(imageI,product,color);
//         try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("image.jsf");
//        } catch (IOException ex) {
//            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public String getFileName(Part part){
         for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
            
    public void deleteImage(int id){
        ejb.deleteImage(id);
    }
    
    public void searchImage(int id){
        Image i = ejb.searchImage(id);
        image_id = i.getIId();
        imageI = i.getIImage();
        
                try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("updateImage.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    public void updateImage(){
        int product = Integer.parseInt(image_pId);
         int color = Integer.parseInt(image_cId);
                 imageI = getFileName(uploadedFile);
         savedFile = new File(folder,imageI);
         try(InputStream input = uploadedFile.getInputStream()){
             Files.copy(input, savedFile.toPath());
         }catch(Exception e){
             System.out.println(e);
         }
        ejb.updateImage(image_id,imageI,product,color);
          try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("image.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    public void setImage(List<Image> image) {
        this.image = image;
    }

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }
    

    public List<Category> getCategories() {
        return ejb.showAllCategory();
    }
    
    public void addCategory(){
         cat_image = getFileName(uploadedFile);
         savedFile = new File(folder,cat_image);
         try(InputStream input = uploadedFile.getInputStream()){
             Files.copy(input, savedFile.toPath());
         }catch(Exception e){
             System.out.println(e);
         }
        ejb.addCategory(cat_name, cat_image);
         try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("category.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void deleteCategory(int id){
        ejb.deleteCategory(id);
    }
    public void searchCategory(int id){
        Category c = ejb.searchCategory(id);
        cat_id = c.getCatId();
        cat_name = c.getCatName();
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("updateCategory.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateCategory(){
         cat_image = getFileName(uploadedFile);
         savedFile = new File(folder,cat_image);
         try(InputStream input = uploadedFile.getInputStream()){
             Files.copy(input, savedFile.toPath());
         }catch(Exception e){
             System.out.println(e);
         }
        ejb.updateCategory(cat_id, cat_name, cat_image);
          try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("category.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<User> getUsers() {

        return ejb.showAllUsers();
    }

    public void addUser() {
         Pbkdf2PasswordHashImpl pb;
             pb = new Pbkdf2PasswordHashImpl();
            String enc = pb.generate(password.toCharArray());


        ejb.addUser(name, email, enc, address, mobile);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("users.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeUser(int id) {
        ejb.DeleteUser(id);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("users.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchUser(int id) {
        User u = ejb.searchUser(id);
        uid = u.getUId();
        name = u.getUName();
        email = u.getUEmail();
        password = u.getUPassword();
        address = u.getUAddress();
        mobile = u.getUMobile();
         try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("updateUser.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateUser(){
        ejb.updateUser(uid, name, email, password, address, mobile);
         try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("users.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addBrand(){
        
        ejb.addBrand(bname);
        bname="";
        
    }
    public void removeBrand(int id){
        ejb.deleteBrand(id);
        
    }
    public void searchBrand(int id){
        Brand b = ejb.searchBrand(id);
        bid=b.getBrandId();
        bname= b.getBrand();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("updateBrand.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateBrand(){
        ejb.updateBrand(bid, bname);
        bname="";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("brand.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addColor(){
        ejb.addColor(coname);
        coname="";
    }
    public void removeColor(int id){
        ejb.deleteColor(id);
    }
    public void searchColor(int id){
        Color c =ejb.searchColor(id);
        coid = c.getColorId();
        coname =c.getColor();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("updateColor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateColor(){
        ejb.updateColor(coid, coname);
        coname="";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("color.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addSize(){
        ejb.addSize(sname);
        sname="";
    }
    public void removeSize(int id){
        ejb.deleteSize(id);
    }
    public void searchSize(int id){
        Size1 c =ejb.searchSize(id);
        sid = c.getSizeId();
        int s = c.getSize();
        sname = String.valueOf(s);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("updateSize.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateSize(){
        ejb.updateSize(sid, sname);
        sname="";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("size.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Product> getProducts() {

        return ejb.getAllProducts();
    }
    public void addProduct(){
         p_image = getFileName(uploadedFile);
         savedFile = new File(folder,p_image);
         try(InputStream input = uploadedFile.getInputStream()){
             Files.copy(input, savedFile.toPath());
         }catch(Exception e){
             System.out.println(e);
         }
        int b=Integer.parseInt(p_brand);
        int c=Integer.parseInt(p_color);
        int s=Integer.parseInt(p_size);
        int cat =Integer.parseInt(p_cat);
        ejb.addProduct(p_name,b,p_image,p_price,c,s,cat);
        p_name = "";
        p_image="";
        p_price="";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("products.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteProduct(int id){
        ejb.deleteProduct(id);
    }
    public void searchProduct(int id){
        Product p = ejb.searchProduct(id);
        p_id = p.getId();
        p_name=p.getName();
        p_image=p.getImage();
        p_price = String.valueOf(p.getPrice()) ;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("updateProduct.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateProduct(){
          p_image = getFileName(uploadedFile);
         savedFile = new File(folder,p_image);
         try(InputStream input = uploadedFile.getInputStream()){
             Files.copy(input, savedFile.toPath());
         }catch(Exception e){
             System.out.println(e);
         }
         int b=Integer.parseInt(p_brand);
        int c=Integer.parseInt(p_color);
        int s=Integer.parseInt(p_size);
        int cat =Integer.parseInt(p_cat);
        ejb.updateProduct(p_id, p_name, b, c, s, p_image, cat, p_price);
         p_name = "";
        p_image="";
        p_price="";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("products.jsf");
        } catch (IOException ex) {
            Logger.getLogger(NewJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public NewJSFManagedBean() {
    }

}
