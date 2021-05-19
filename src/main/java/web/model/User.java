// Generated with g9.

package web.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="user")
public class User implements Serializable {

    /** Primary key. */
    protected static final String PK = "cccd";

    @Id
    @Column(unique=true, nullable=false, length=255)
    private String cccd;
    @Column(length=255)
    private String name;
    @Column(name="date_of_birth")
    private Date dateOfBirth;
    @Column(length=255)
    private String email;
    @Column(length=255)
    private String phone;
    @Column(length=255)
    private String sex;
    @Column(length=255)
    private String address;
    @Column()
    private int income;
    
    public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	@JsonIgnore
    @OneToOne(mappedBy="user")
    private Account account;
    
    @ManyToOne()
    @JoinColumn(name="quan_id", nullable=false)
    private Quan quan;
    
    @ManyToOne()
    @JoinColumn(name="group_detail_id", nullable=false)
    private GroupDetail groupDetail;
    
    @ManyToOne()
    @JoinColumn(name="phuong_id", nullable=false)
    private Phuong phuong;
    
    @ManyToOne()
    @JoinColumn(name="thanhpho_id", nullable=false)
    private Thanhpho thanhpho;
    
    @OneToOne()
    @JoinColumn(name="bhyt_code", nullable=false)
    private Bhyt bhyt;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy="user")
    private Set<Bill> bill;

    /** Default constructor. */
    public User() {
        super();
    }
    
    
    public Set<Bill> getBill() {
		return bill;
	}

	public void setBill(Set<Bill> bill) {
		this.bill = bill;
	}

	/**
     * Access method for cccd.
     *
     * @return the current value of cccd
     */
    public String getCccd() {
        return cccd;
    }

    /**
     * Setter method for cccd.
     *
     * @param aCccd the new value for cccd
     */
    public void setCccd(String aCccd) {
        cccd = aCccd;
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
     * Access method for dateOfBirth.
     *
     * @return the current value of dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Setter method for dateOfBirth.
     *
     * @param aDateOfBirth the new value for dateOfBirth
     */
    public void setDateOfBirth(Date aDateOfBirth) {
        dateOfBirth = aDateOfBirth;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for phone.
     *
     * @return the current value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter method for phone.
     *
     * @param aPhone the new value for phone
     */
    public void setPhone(String aPhone) {
        phone = aPhone;
    }

    /**
     * Access method for sex.
     *
     * @return the current value of sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Setter method for sex.
     *
     * @param aSex the new value for sex
     */
    public void setSex(String aSex) {
        sex = aSex;
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
     * Access method for account.
     *
     * @return the current value of account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Setter method for account.
     *
     * @param aAccount the new value for account
     */
    public void setAccount(Account aAccount) {
        account = aAccount;
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
     * Access method for group.
     *
     * @return the current value of group
     */

    /**
     * Access method for phuong.
     *
     * @return the current value of phuong
     */
    public Phuong getPhuong() {
        return phuong;
    }

    public GroupDetail getGroupDetail() {
		return groupDetail;
	}

	public void setGroupDetail(GroupDetail groupDetail) {
		this.groupDetail = groupDetail;
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
     * Access method for bhyt.
     *
     * @return the current value of bhyt
     */
    public Bhyt getBhyt() {
        return bhyt;
    }

    /**
     * Setter method for bhyt.
     *
     * @param aBhyt the new value for bhyt
     */
    public void setBhyt(Bhyt aBhyt) {
        bhyt = aBhyt;
    }

    /**
     * Compares the key for this instance with another User.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class User and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User that = (User) other;
        Object myCccd = this.getCccd();
        Object yourCccd = that.getCccd();
        if (myCccd==null ? yourCccd!=null : !myCccd.equals(yourCccd)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another User.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof User)) return false;
        return this.equalKeys(other) && ((User)other).equalKeys(this);
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
        if (getCccd() == null) {
            i = 0;
        } else {
            i = getCccd().hashCode();
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
        StringBuffer sb = new StringBuffer("[User |");
        sb.append(" cccd=").append(getCccd());
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
        ret.put("cccd", getCccd());
        return ret;
    }

}
