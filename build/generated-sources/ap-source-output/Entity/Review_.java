package Entity;

import Entity.Product;
import Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-04T10:08:00")
@StaticMetamodel(Review.class)
public class Review_ { 

    public static volatile SingularAttribute<Review, User> uId;
    public static volatile SingularAttribute<Review, String> rComment;
    public static volatile SingularAttribute<Review, Product> pId;
    public static volatile SingularAttribute<Review, Integer> rId;

}