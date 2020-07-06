package com.restapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployRepository extends JpaRepository<Employee, Long> {
}
