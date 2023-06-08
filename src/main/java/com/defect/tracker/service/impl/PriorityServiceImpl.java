package com.defect.tracker.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.defect.tracker.entities.Priority;
import com.defect.tracker.repositories.PriorityRepository;
import com.defect.tracker.response.dto.PriorityResponse;
import com.defect.tracker.resquest.dto.PriorityRequest;
import com.defect.tracker.service.PriorityService;

@Service
public class PriorityServiceImpl implements PriorityService {
  @Autowired
  private PriorityRepository priorityRepository;

  @Transactional
  public void savePriority(PriorityRequest priorityRequest) {
    Priority priority = new Priority();
    BeanUtils.copyProperties(priorityRequest, priority);
    priorityRepository.save(priority);
  }

  @Override
  public boolean isPriorityExists(String name) {
    return priorityRepository.existsByNameIgnoreCase(name);
  }

  @Transactional
  public List<PriorityResponse> getAllPriority() {
    List<PriorityResponse> priorityResponses = new ArrayList<>();
    List<Priority> priorities = priorityRepository.findAll();
    for (Priority priority : priorities) {
      PriorityResponse priorityResponse = new PriorityResponse();
      BeanUtils.copyProperties(priority, priorityResponse);
      priorityResponses.add(priorityResponse);
    }
    return priorityResponses;
  }

  @Transactional
  public PriorityResponse getPriorityById(Long id) {
    Priority priority = priorityRepository.findById(id).get();
    PriorityResponse priorityResponse = new PriorityResponse();
    BeanUtils.copyProperties(priority, priorityResponse);
    return priorityResponse;
  }

  @Override
  public boolean existsByPriority(Long id) {
    return priorityRepository.existsById(id);
  }

  @Override
  public boolean isUpdatedPriorityNameExist(Long id, String name) {
    return priorityRepository.existsByNameIgnoreCaseAndIdNot(name, id);
  }

  @Override
  public void deletePriority(Long id) {
    priorityRepository.deleteById(id);
  }
}
