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

@Entity(name="phuong")
public class Phuong implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(length=255)
    private String name;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy="phuong")
    private Set<Hospital> hospital;
    
    @ManyToOne()
    @JoinColumn(name="quan_id", nullable=false)
    private Quan quan;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy="phuong")
    private Set<User> user;

    /** Default constructor. */
    public Phuong() {
        super();
    }
    
    
    public Phuong(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
     * Access method for hospital.
     *
     * @return the current value of hospital
     */
    public Set<Hospital> getHospital() {
        return hospital;
    }

    /**
     * Setter method for hospital.
     *
     * @param aHospital the new value for hospital
     */
    public void setHospital(Set<Hospital> aHospital) {
        hospital = aHospital;
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
     * Access method for user.
     *
     * @return the current value of user
     */
    public Set<User> getUser() {
        return user;
    }

    /**
     * Setter method for user.
     *
     * @param aUser the new value for user
     */
    public void setUser(Set<User> aUser) {
        user = aUser;
    }

    /**
     * Compares the key for this instance with another Phuong.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Phuong and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Phuong)) {
            return false;
        }
        Phuong that = (Phuong) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Phuong.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Phuong)) return false;
        return this.equalKeys(other) && ((Phuong)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Phuong |");
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
