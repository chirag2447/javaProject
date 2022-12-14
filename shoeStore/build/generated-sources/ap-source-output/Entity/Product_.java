package Entity;

import Entity.Category;
import Entity.Color;
import Entity.Image;
import Entity.Review;
import Entity.Size1;
import Entity.Subcategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-11-13T08:17:25")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> image;
    public static volatile SingularAttribute<Product, Size1> sizeId;
    public static volatile SingularAttribute<Product, Category> catId;
    public static volatile ListAttribute<Product, Review> reviewList;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, Color> colorId;
    public static volatile SingularAttribute<Product, Integer> brandId;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile ListAttribute<Product, Image> imageList;
    public static volatile SingularAttribute<Product, Subcategory> subcatId;

}