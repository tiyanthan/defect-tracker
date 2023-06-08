package com.defect.tracker.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.entities.ProjectStatus;
import com.defect.tracker.repositories.ProjectStatusRepository;
import com.defect.tracker.response.dto.ProjectStatusResponse;
import com.defect.tracker.resquest.dto.ProjectStatusRequest;
import com.defect.tracker.service.ProjectStatusService;

@Service
public class ProjectStatusServiceImpl implements ProjectStatusService {
  @Autowired
  private ProjectStatusRepository projectStatusRepository;

  @Transactional
  public void saveProjectStatus(ProjectStatusRequest projectStatusRequest) {
    ProjectStatus projectStatus = new ProjectStatus();
    BeanUtils.copyProperties(projectStatusRequest, projectStatus);
    projectStatusRepository.save(projectStatus);
  }

  @Transactional
  public List<ProjectStatusResponse> getAllProjectStatus() {
    List<ProjectStatusResponse> projectStatusResponses = new ArrayList<>();
    List<ProjectStatus> projectStatuses = projectStatusRepository.findAll();

    for (ProjectStatus projectStatus : projectStatuses) {
      ProjectStatusResponse projectStatusResponse = new ProjectStatusResponse();
      BeanUtils.copyProperties(projectStatus, projectStatusResponse);
      projectStatusResponses.add(projectStatusResponse);
    }
    return projectStatusResponses;
  }

  @Override
  public boolean isProjectStatusExists(String name) {
    return projectStatusRepository.existsByNameIgnoreCase(name);
  }

  @Transactional
  public ProjectStatusResponse getProjectStatusById(Long id) {
    ProjectStatus projectStatus = projectStatusRepository.findById(id).get();
    ProjectStatusResponse projectStatusResponse = new ProjectStatusResponse();
    BeanUtils.copyProperties(projectStatus, projectStatusResponse);
    return projectStatusResponse;
  }

  @Override
  public boolean existByProjectStatus(Long id) {
    return projectStatusRepository.existsById(id);
  }

  @Override
  public boolean isUpdatedProjectStatusNameExist(Long id, String name) {
    return projectStatusRepository.existsByNameIgnoreCaseAndIdNot(name, id);
  }

  @Override
  public boolean isUpdatedProjectStatusColorExist(Long id, String color) {
    return projectStatusRepository.existsByColorIgnoreCaseAndIdNot(color, id);
  }

  @Override
  public void deleteProjectStatus(Long id) {
    projectStatusRepository.deleteById(id);
  }
}
