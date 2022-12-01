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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chpan
 */
@Entity
@Table(name = "size")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Size1.findAll", query = "SELECT s FROM Size1 s"),
    @NamedQuery(name = "Size1.findBySizeId", query = "SELECT s FROM Size1 s WHERE s.sizeId = :sizeId"),
    @NamedQuery(name = "Size1.findBySize", query = "SELECT s FROM Size1 s WHERE s.size = :size")})
public class Size1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "size_id")
    private Integer sizeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "size")
    private int size;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sizeId")
    private List<Product> productList;

    public Size1() {
    }

    public Size1(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Size1(Integer sizeId, int size) {
        this.sizeId = sizeId;
        this.size = size;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sizeId != null ? sizeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Size1)) {
            return false;
        }
        Size1 other = (Size1) object;
        if ((this.sizeId == null && other.sizeId != null) || (this.sizeId != null && !this.sizeId.equals(other.sizeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Size1[ sizeId=" + sizeId + " ]";
    }
    
}
