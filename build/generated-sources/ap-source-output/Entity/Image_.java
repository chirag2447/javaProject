package Entity;

import Entity.Color;
import Entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-04T10:08:00")
@StaticMetamodel(Image.class)
public class Image_ { 

    public static volatile SingularAttribute<Image, Integer> iId;
    public static volatile SingularAttribute<Image, String> iImage;
    public static volatile SingularAttribute<Image, Product> pId;
    public static volatile SingularAttribute<Image, Color> cId;

}