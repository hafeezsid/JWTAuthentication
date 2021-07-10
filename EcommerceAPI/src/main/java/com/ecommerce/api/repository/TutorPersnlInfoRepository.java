package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.entity.TutorPersonalInfo;


@Repository
public interface TutorPersnlInfoRepository extends JpaRepository<TutorPersonalInfo, Long> {

}
