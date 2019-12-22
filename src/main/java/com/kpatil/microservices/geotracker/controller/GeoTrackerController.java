package com.kpatil.microservices.geotracker.controller;

import com.kpatil.microservices.geotracker.model.GeoTracker;
import com.kpatil.microservices.geotracker.service.GeoTrackerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geotracker")
public class GeoTrackerController {

  private GeoTrackerService service;

  @Autowired
  public GeoTrackerController(GeoTrackerService service) {
    this.service = service;
  }

  @PostMapping
  public GeoTracker create(@RequestBody GeoTracker geoTracker) {
    return service.create(geoTracker);
  }

  @GetMapping
  public List<GeoTracker> findAll() {
    return service.findAll();
  }
}
