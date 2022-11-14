/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chirag
 */
@Entity
@Table(name = "image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i"),
    @NamedQuery(name = "Image.findByIId", query = "SELECT i FROM Image i WHERE i.iId = :iId"),
    @NamedQuery(name = "Image.findByIImage", query = "SELECT i FROM Image i WHERE i.iImage = :iImage")})
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "i_id")
    private Integer iId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "i_image")
    private String iImage;
    @JoinColumn(name = "p_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product pId;
    @JoinColumn(name = "c_id", referencedColumnName = "color_id")
    @ManyToOne(optional = false)
    private Color cId;

    public Image() {
    }

    public Image(Integer iId) {
        this.iId = iId;
    }

    public Image(Integer iId, String iImage) {
        this.iId = iId;
        this.iImage = iImage;
    }

    public Integer getIId() {
        return iId;
    }

    public void setIId(Integer iId) {
        this.iId = iId;
    }

    public String getIImage() {
        return iImage;
    }

    public void setIImage(String iImage) {
        this.iImage = iImage;
    }

    public Product getPId() {
        return pId;
    }

    public void setPId(Product pId) {
        this.pId = pId;
    }

    public Color getCId() {
        return cId;
    }

    public void setCId(Color cId) {
        this.cId = cId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iId != null ? iId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Image)) {
            return false;
        }
        Image other = (Image) object;
        if ((this.iId == null && other.iId != null) || (this.iId != null && !this.iId.equals(other.iId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Image[ iId=" + iId + " ]";
    }
    
}
