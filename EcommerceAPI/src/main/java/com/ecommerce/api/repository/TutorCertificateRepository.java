package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.entity.TutorCertificate;

@Repository
public interface TutorCertificateRepository extends JpaRepository<TutorCertificate, Long> {

}
