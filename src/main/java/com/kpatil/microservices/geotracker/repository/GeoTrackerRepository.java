package com.kpatil.microservices.geotracker.repository;

import com.kpatil.microservices.geotracker.model.GeoTracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class GeoTrackerRepository {

  private List<GeoTracker> geoTrackers = new ArrayList<>();

  public void addGeoLocation(GeoTracker geoTracker) {
    geoTrackers.add(geoTracker);
  }

  public List<GeoTracker> getGeoLocations() {
    return Collections.unmodifiableList(geoTrackers);
  }
}
