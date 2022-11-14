/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chirag
 */
@Entity
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCatId", query = "SELECT c FROM Category c WHERE c.catId = :catId"),
    @NamedQuery(name = "Category.findByCatName", query = "SELECT c FROM Category c WHERE c.catName = :catName"),
    @NamedQuery(name = "Category.findByCatImage", query = "SELECT c FROM Category c WHERE c.catImage = :catImage")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cat_id")
    private Integer catId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cat_name")
    private String catName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cat_image")
    private String catImage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catId")
    private List<Product> productList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catId")
    private List<Subcategory> subcategoryList;

    public Category() {
    }

    public Category(Integer catId) {
        this.catId = catId;
    }

    public Category(Integer catId, String catName, String catImage) {
        this.catId = catId;
        this.catName = catName;
        this.catImage = catImage;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @XmlTransient
    public List<Subcategory> getSubcategoryList() {
        return subcategoryList;
    }

    public void setSubcategoryList(List<Subcategory> subcategoryList) {
        this.subcategoryList = subcategoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Category[ catId=" + catId + " ]";
    }
    
}
