package com.kpatil.microservices.geotracker.service;

import com.kpatil.microservices.geotracker.model.GeoTracker;
import com.kpatil.microservices.geotracker.repository.GeoTrackerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeoTrackerServiceImpl implements GeoTrackerService {

  private final GeoTrackerRepository geoTrackerRepository;

  @Autowired
  public GeoTrackerServiceImpl(GeoTrackerRepository geoTrackerRepository) {
    this.geoTrackerRepository = geoTrackerRepository;
  }

  @Override
  public GeoTracker create(GeoTracker geoTracker) {
    geoTrackerRepository.addGeoLocation(geoTracker);
    return geoTracker;
  }

  @Override
  public List<GeoTracker> findAll() {
    return geoTrackerRepository.getGeoLocations();
  }
}
