package com.example.institute.repository;

import com.example.institute.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepo extends JpaRepository<Institute,String> {
}
