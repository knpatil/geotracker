package com.kpatil.microservices.geotracker.service;

import com.kpatil.microservices.geotracker.model.GeoTracker;
import java.util.List;

public interface GeoTrackerService {

  GeoTracker create(GeoTracker geoTracker);

  List<GeoTracker> findAll();
}

