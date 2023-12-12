package com.FamilyTree.sectionOne.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FamilyTree.sectionOne.Model.Messege;


@Repository
public interface MessegeRepository extends JpaRepository<Messege,Long> {

}
