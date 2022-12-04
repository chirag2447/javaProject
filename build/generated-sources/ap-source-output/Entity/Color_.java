package Entity;

import Entity.Image;
import Entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-04T10:08:00")
@StaticMetamodel(Color.class)
public class Color_ { 

    public static volatile SingularAttribute<Color, String> color;
    public static volatile SingularAttribute<Color, Integer> colorId;
    public static volatile ListAttribute<Color, Image> imageList;
    public static volatile ListAttribute<Color, Product> productList;

}