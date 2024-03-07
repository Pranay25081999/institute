package com.example.institute.repository;

import com.example.institute.entity.Stundents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends JpaRepository<Stundents,String> {
}
