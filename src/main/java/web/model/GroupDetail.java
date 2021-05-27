package web.model;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "group_detail")
@Entity(name = "group_detail")
public class GroupDetail implements Serializable{
	protected static final String PK = "id";
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    
    @Column(length=1000)
    private String des;
    
    
    @Column(length = 2, nullable = true)
    private int support;
    
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy="groupDetail")
    private Set<User> user;
    
    @ManyToOne
    @JoinColumn(name="group_id", nullable=false)
    private Group group;
    
    @OneToOne(mappedBy="groupDetail")
    private Payment payment;

    
    
	public GroupDetail() {
		super();
	}

	public GroupDetail(int id) {
		super();
		this.id = id;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
    public int getSupport() {
		return support;
	}

	public void setSupport(int support) {
		this.support = support;
	}
    
}
