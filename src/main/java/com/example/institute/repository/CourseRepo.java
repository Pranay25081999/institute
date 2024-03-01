package com.example.institute.repository;

import com.example.institute.entity.CourseDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<CourseDetails,Integer> {
}
