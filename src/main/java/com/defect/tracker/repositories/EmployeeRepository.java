package com.defect.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.defect.tracker.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
