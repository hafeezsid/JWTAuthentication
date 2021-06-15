package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
