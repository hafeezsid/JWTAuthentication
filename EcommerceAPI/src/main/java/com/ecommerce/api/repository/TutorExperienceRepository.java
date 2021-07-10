package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.entity.TutorExperience;

@Repository
public interface TutorExperienceRepository extends JpaRepository<TutorExperience, Long> {

}
