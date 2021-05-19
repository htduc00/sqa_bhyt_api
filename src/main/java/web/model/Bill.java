package web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="bill")
public class Bill implements Serializable{
	protected static final String PK = "id";
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    
    @Column
    private int year;
    
    @Column
    private int value;
    
    
	@ManyToOne
    @JoinColumn(name="user_cccd", nullable=false)
    private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
    
}
