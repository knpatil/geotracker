package com.kpatil.microservices.geotracker;

import com.kpatil.microservices.geotracker.model.Zookeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeoTrackerApplication {

  public static void main(String[] args) {
    SpringApplication.run(GeoTrackerApplication.class, args);
    new Zookeeper("zookeeper", 2181).register();
  }

}
