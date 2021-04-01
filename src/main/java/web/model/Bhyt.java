// Generated with g9.

package web.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="bhyt")
public class Bhyt implements Serializable {

    /** Primary key. */
    protected static final String PK = "code";

    @Id
    @Column(unique=true, nullable=false, length=255)
    private String code;
    private Date date;
    @Column(name="join_date")
    private Date joinDate;
    
    @ManyToOne()
    @JoinColumn(name="hospital_id", nullable=false)
    private Hospital hospital;
    
    @JsonIgnore
    @OneToOne(mappedBy="bhyt")
    private User user;

    /** Default constructor. */
    public Bhyt() {
        super();
    }

    /**
     * Access method for code.
     *
     * @return the current value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for code.
     *
     * @param aCode the new value for code
     */
    public void setCode(String aCode) {
        code = aCode;
    }

    /**
     * Access method for date.
     *
     * @return the current value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter method for date.
     *
     * @param aDate the new value for date
     */
    public void setDate(Date aDate) {
        date = aDate;
    }

    /**
     * Access method for joinDate.
     *
     * @return the current value of joinDate
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * Setter method for joinDate.
     *
     * @param aJoinDate the new value for joinDate
     */
    public void setJoinDate(Date aJoinDate) {
        joinDate = aJoinDate;
    }

    /**
     * Access method for hospital.
     *
     * @return the current value of hospital
     */
    public Hospital getHospital() {
        return hospital;
    }

    /**
     * Setter method for hospital.
     *
     * @param aHospital the new value for hospital
     */
    public void setHospital(Hospital aHospital) {
        hospital = aHospital;
    }

    /**
     * Access method for user.
     *
     * @return the current value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter method for user.
     *
     * @param aUser the new value for user
     */
    public void setUser(User aUser) {
        user = aUser;
    }

    /**
     * Compares the key for this instance with another Bhyt.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Bhyt and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Bhyt)) {
            return false;
        }
        Bhyt that = (Bhyt) other;
        Object myCode = this.getCode();
        Object yourCode = that.getCode();
        if (myCode==null ? yourCode!=null : !myCode.equals(yourCode)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Bhyt.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Bhyt)) return false;
        return this.equalKeys(other) && ((Bhyt)other).equalKeys(this);
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
        if (getCode() == null) {
            i = 0;
        } else {
            i = getCode().hashCode();
        }
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
        StringBuffer sb = new StringBuffer("[Bhyt |");
        sb.append(" code=").append(getCode());
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
        ret.put("code", getCode());
        return ret;
    }

}
