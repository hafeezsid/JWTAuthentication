package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.entity.TutorEducation;

@Repository
public interface TutorEducationRepository extends JpaRepository<TutorEducation, Long> {

}
