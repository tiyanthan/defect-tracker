package com.defect.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.defect.tracker.entities.ProjectAllocation;

public interface ProjectAllocationRepository extends JpaRepository<ProjectAllocation, Long> {
  boolean existsByRoleId(Long roleId);
}
