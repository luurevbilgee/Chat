package com.biedaalt.familyChat.Repository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.biedaalt.familyChat.Model.Register;
@Repository
public interface RegisterRepository extends JpaRepository<Register,Long> {

	Register findByEmail(String email);

	
//	Register findByEmail(String email);
////	
////	  @Query("SELECT e FROM YourEntity e WHERE e.propertyName = :value")
////	    List<Register> findByUserName(@Param("value") String value);
//	
//	@Query(value = "SELECT * FROM register WHERE email like %:email%", nativeQuery = true)
//    Register findByUseremail(@Param("email") String email);
//
//	Register findByUseremail(String email);
}
