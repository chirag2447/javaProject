package Entity;

import Entity.Groups;
import Entity.Review;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-01T11:51:34")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> uId;
    public static volatile SingularAttribute<User, String> uEmail;
    public static volatile ListAttribute<User, Review> reviewList;
    public static volatile SingularAttribute<User, String> uName;
    public static volatile SingularAttribute<User, String> uAddress;
    public static volatile SingularAttribute<User, String> uPassword;
    public static volatile ListAttribute<User, Groups> groupsList;
    public static volatile SingularAttribute<User, String> uMobile;

}