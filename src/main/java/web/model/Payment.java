// Generated with g9.

package web.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="payment")
public class Payment implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(nullable=false, precision=12)
    private float cost;
    @Column(name="family_cost", length=255)
    private String familyCost;
    
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="group_detail_id", nullable=false)
    private GroupDetail groupDetail;

    public String getFamilyCost() {
		return familyCost;
	}

	public void setFamilyCost(String familyCost) {
		this.familyCost = familyCost;
	}

	/** Default constructor. */
    public Payment() {
        super();
    }
    

	public Payment(float cost, String familyCost) {
		super();
		this.cost = cost;
		this.familyCost = familyCost;
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
     * Access method for cost.
     *
     * @return the current value of cost
     */
    public float getCost() {
        return cost;
    }

    /**
     * Setter method for cost.
     *
     * @param aCost the new value for cost
     */
    public void setCost(float aCost) {
        cost = aCost;
    }


    	
    public GroupDetail getGroupDetail() {
		return groupDetail;
	}

	public void setGroupDetail(GroupDetail groupDetail) {
		this.groupDetail = groupDetail;
	}

	/**
     * Compares the key for this instance with another Payment.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Payment and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Payment)) {
            return false;
        }
        Payment that = (Payment) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Payment.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Payment)) return false;
        return this.equalKeys(other) && ((Payment)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Payment |");
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
