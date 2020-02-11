package com.nsa.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User,Integer>{
	
	//@Query("Select password User u where u.username =:username")	
	User findByuserName (String userName);
	 
	 User findByLastName (String username);
	 
	 boolean existsById (int id);
	 
	 

}