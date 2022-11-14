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
@Table(name = "review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r"),
    @NamedQuery(name = "Review.findByRId", query = "SELECT r FROM Review r WHERE r.rId = :rId"),
    @NamedQuery(name = "Review.findByRComment", query = "SELECT r FROM Review r WHERE r.rComment = :rComment"),
    @NamedQuery(name = "Review.findByUEmail", query = "SELECT r FROM Review r WHERE r.uEmail = :uEmail")})
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "r_id")
    private Integer rId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "r_comment")
    private String rComment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "u_email")
    private String uEmail;
    @JoinColumn(name = "p_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product pId;
    @JoinColumn(name = "u_id", referencedColumnName = "u_id")
    @ManyToOne(optional = false)
    private User uId;

    public Review() {
    }

    public Review(Integer rId) {
        this.rId = rId;
    }

    public Review(Integer rId, String rComment, String uEmail) {
        this.rId = rId;
        this.rComment = rComment;
        this.uEmail = uEmail;
    }

    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public String getRComment() {
        return rComment;
    }

    public void setRComment(String rComment) {
        this.rComment = rComment;
    }

    public String getUEmail() {
        return uEmail;
    }

    public void setUEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public Product getPId() {
        return pId;
    }

    public void setPId(Product pId) {
        this.pId = pId;
    }

    public User getUId() {
        return uId;
    }

    public void setUId(User uId) {
        this.uId = uId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rId != null ? rId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Review[ rId=" + rId + " ]";
    }
    
}
