package web.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "family")
@Entity(name = "family")
public class Family implements Serializable{
	protected static final String PK = "id";
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy="family")
    private Set<Bhyt> bhyt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Bhyt> getBhyt() {
		return bhyt;
	}

	public void setBhyt(Set<Bhyt> bhyt) {
		this.bhyt = bhyt;
	}
    
    
}
