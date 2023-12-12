package com.biedaalt.familyChat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biedaalt.familyChat.Model.Messege;
import com.biedaalt.familyChat.Model.Register;

@Repository
public interface MessegeRepository extends JpaRepository<Messege,Long> {

}
