package com.defect.tracker.service;

import java.util.List;
import com.defect.tracker.response.dto.PriorityResponse;
import com.defect.tracker.resquest.dto.PriorityRequest;

public interface PriorityService {
  public void savePriority(PriorityRequest priorityRequest);

  public boolean isPriorityExists(String name);

  public List<PriorityResponse> getAllPriority();

  public PriorityResponse getPriorityById(Long id);

  public boolean existsByPriority(Long id);

  public boolean isUpdatedPriorityNameExist(Long id, String name);

  public void deletePriority(Long id);
}
