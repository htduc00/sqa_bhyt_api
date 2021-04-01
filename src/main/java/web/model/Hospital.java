// Generated with g9.

package web.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="hospital")
public class Hospital implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(length=255)
    private String name;
    @Column(length=255)
    private String address;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy="hospital")
    private Set<Bhyt> bhyt;
    
    @ManyToOne()
    @JoinColumn(name="quan_id", nullable=false)
    private Quan quan;
    
    @ManyToOne()
    @JoinColumn(name="thanhpho_id", nullable=false)
    private Thanhpho thanhpho;
    
    @ManyToOne()
    @JoinColumn(name="phuong_id", nullable=false)
    private Phuong phuong;

    /** Default constructor. */
    public Hospital() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for name.
     *
     * @return the current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     *
     * @param aName the new value for name
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Access method for address.
     *
     * @return the current value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for address.
     *
     * @param aAddress the new value for address
     */
    public void setAddress(String aAddress) {
        address = aAddress;
    }

    /**
     * Access method for bhyt.
     *
     * @return the current value of bhyt
     */
    public Set<Bhyt> getBhyt() {
        return bhyt;
    }

    /**
     * Setter method for bhyt.
     *
     * @param aBhyt the new value for bhyt
     */
    public void setBhyt(Set<Bhyt> aBhyt) {
        bhyt = aBhyt;
    }

    /**
     * Access method for quan.
     *
     * @return the current value of quan
     */
    public Quan getQuan() {
        return quan;
    }

    /**
     * Setter method for quan.
     *
     * @param aQuan the new value for quan
     */
    public void setQuan(Quan aQuan) {
        quan = aQuan;
    }

    /**
     * Access method for thanhpho.
     *
     * @return the current value of thanhpho
     */
    public Thanhpho getThanhpho() {
        return thanhpho;
    }

    /**
     * Setter method for thanhpho.
     *
     * @param aThanhpho the new value for thanhpho
     */
    public void setThanhpho(Thanhpho aThanhpho) {
        thanhpho = aThanhpho;
    }

    /**
     * Access method for phuong.
     *
     * @return the current value of phuong
     */
    public Phuong getPhuong() {
        return phuong;
    }

    /**
     * Setter method for phuong.
     *
     * @param aPhuong the new value for phuong
     */
    public void setPhuong(Phuong aPhuong) {
        phuong = aPhuong;
    }

    /**
     * Compares the key for this instance with another Hospital.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Hospital and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Hospital)) {
            return false;
        }
        Hospital that = (Hospital) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Hospital.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Hospital)) return false;
        return this.equalKeys(other) && ((Hospital)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Hospital |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
