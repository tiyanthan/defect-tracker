package com.defect.tracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.defect.tracker.repositories.ProjectAllocationRepository;
import com.defect.tracker.service.ProjectAllocationService;

@Service
public class ProjectAllocationServiceImpl implements ProjectAllocationService {
  @Autowired
  private ProjectAllocationRepository projectAllocationRepository;

  @Override
  public boolean existsByRole(Long roleId) {
    return projectAllocationRepository.existsByRoleId(roleId);
  }
}
