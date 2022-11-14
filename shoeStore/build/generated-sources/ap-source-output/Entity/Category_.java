package Entity;

import Entity.Product;
import Entity.Subcategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-11-13T08:17:25")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, Integer> catId;
    public static volatile ListAttribute<Category, Subcategory> subcategoryList;
    public static volatile SingularAttribute<Category, String> catName;
    public static volatile ListAttribute<Category, Product> productList;
    public static volatile SingularAttribute<Category, String> catImage;

}