package com.erik.animon2.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pets")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Please provide a pet name!")
	@Size(min = 3, max=15, message="Pet name must be at least 3 and 15 characters")
	private String petName;
	
	private Integer health;
	
	private Integer happiness;
	
	private Integer energy;
	
	private Integer cleanliness;
	
	private String type;
	
	

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	//M:1
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User owner;
	
	public Pet() {
		this.health = 100;
		
		this.happiness = 100;
		
		this.energy = 100;
		
		this.cleanliness = 10;
	}

	   // PET ACTIONS
    public void play() {
        if (this.getEnergy() <= 0 || this.getHealth() <= 20) {
            System.out.println("no more energy to spare!");

        } else {
            setEnergy(this.getEnergy() - 10);
            if (this.getHappiness() < 100 ) {
                setHappiness(this.getHappiness() + 10);
            }
            setHealth(this.getHealth() - 5);
        }
    }
    
    // pet Sleep
    public void sleep() {
    	if(this.getEnergy() +30 <= 100) {
    	setEnergy(this.getEnergy()+30);
    	
    	}
    }
	
    
  //Feed
    public void feed() {
        if (this.getHealth() + 20 <= 100) {
            setHealth(this.getHealth() + 20);
        }
    }
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getHappiness() {
		return happiness;
	}

	public void setHappiness(Integer happiness) {
		this.happiness = happiness;
	}

	public Integer getEnergy() {
		return energy;
	}

	public void setEnergy(Integer energy) {
		this.energy = energy;
	}

	public Integer getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(Integer cleanliness) {
		this.cleanliness = cleanliness;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
}
