package com.pluto.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

public class Main {

  @Value(
      "https://snowplow-hosted-assets.s3.amazonaws.com/third-party/ua-parser/regexes-latest.yaml")
  private Resource regexYaml;

  public void main(String[] args) {

    //    regexYaml.getInputStream()
    System.out.println("testtt.......");

    if (true) {




      System.out.println(" HELLLLOOOOOO...")



      ;
    }
  }
}
