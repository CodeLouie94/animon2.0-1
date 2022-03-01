package com.erik.animon2.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erik.animon2.models.Pet;
import com.erik.animon2.repositories.PetRepo;

@Service
public class PetService {
	@Autowired
	private PetRepo petRepo;
	
	public List<Pet> allPets() {
		return petRepo.findAll();
	}
	
	public Pet createPet(Pet p) {
		return petRepo.save(p);
	}
	
	
	public Pet findPet(Long id) {
		Optional<Pet> optionalPet = petRepo.findById(id);
		if(optionalPet.isPresent()) {
			return optionalPet.get();
		}else {
			return null;
		}
	}
	
	public Pet updatePet(Pet p) {
		return petRepo.save(p);
	}
	
	public void deletePet(Long id) {
		petRepo.deleteById(id);
	}
	
    
    // Random Contest Winner
    
   public Pet contest(Pet p) {
	  int min = 1;
	  int max = 3;
	  
	  Random random = new Random();
	  
	  int value = random.nextInt(max + min) +min;
	  System.out.println(p.getOwner().getGold());
	  if(value == 1) {
		  p.getOwner().setGold(p.getOwner().getGold()+200);
		  
	  }else if(value == 2) {
		  p.getOwner().setGold(p.getOwner().getGold()+100);
	  }else {
		  p.getOwner().setGold(p.getOwner().getGold()+50);
	  }System.out.println(p.getOwner().getGold());
	  return petRepo.save(p);
   }
	
	
}