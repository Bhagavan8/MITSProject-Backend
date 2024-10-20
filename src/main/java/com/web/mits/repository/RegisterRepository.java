package com.web.mits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.mits.model.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
   
   
 
}

