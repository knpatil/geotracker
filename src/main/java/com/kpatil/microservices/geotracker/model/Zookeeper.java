package com.kpatil.microservices.geotracker.model;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.UriSpec;

public class Zookeeper {

  private String host;
  private int port;

  public Zookeeper(String host, int port) {
    this.host = host;
    this.port = port;
  }

  private String getIp() {
    try {
      return InetAddress.getLocalHost().getHostAddress();
    } catch (UnknownHostException e) {
      System.out.println("Error occurred " + e.getMessage());
      return "localhost";
    }
  }

  private int getPort() {
    try {
      return Integer.parseInt(System.getenv("GEOTRACKER_PORT"));
    } catch (Exception e) {
      System.out.println("Error while finding the port " + e.getMessage());
      return 8080;
    }
  }

  public void register() {
    CuratorFramework curator = CuratorFrameworkFactory
        .newClient(host + ":" + port, new RetryNTimes(3, 3000));
    curator.start();

    try {
      final ServiceInstance<Object> serviceInstance = ServiceInstance.builder().uriSpec(
          new UriSpec("{scheme}://{address}:{port}"))
          .address(getIp()).port(getPort())
          .name("geotracker")
          .build();

      final ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder
          .builder(Object.class)
          .basePath("com.kpatil.microservices.geotracker")
          .client(curator)
          .thisInstance(serviceInstance)
          .build();

      serviceDiscovery.start();

      Runtime.getRuntime().addShutdownHook(
          new Thread(() -> {
            try {
              serviceDiscovery.unregisterService(serviceInstance);
            } catch (Exception e) {
              System.out.println("Error in un-registering ...");
            }
          }));
    } catch (Exception e) {
      System.out.println("Error while registering service in Zookeeper. " + e.getMessage());
      e.printStackTrace();
    }

  }
}
