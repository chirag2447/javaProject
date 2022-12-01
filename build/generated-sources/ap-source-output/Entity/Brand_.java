package Entity;

import Entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-01T11:51:34")
@StaticMetamodel(Brand.class)
public class Brand_ { 

    public static volatile SingularAttribute<Brand, Integer> brandId;
    public static volatile SingularAttribute<Brand, String> brand;
    public static volatile ListAttribute<Brand, Product> productList;

}