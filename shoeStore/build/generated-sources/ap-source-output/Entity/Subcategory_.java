package Entity;

import Entity.Category;
import Entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-11-13T08:17:25")
@StaticMetamodel(Subcategory.class)
public class Subcategory_ { 

    public static volatile SingularAttribute<Subcategory, Category> catId;
    public static volatile SingularAttribute<Subcategory, Integer> subcatId;
    public static volatile ListAttribute<Subcategory, Product> productList;
    public static volatile SingularAttribute<Subcategory, String> subcatName;

}