package edu.ub.pis2324.authenticationexample.data.services.mockdata;

import java.util.HashMap;

import edu.ub.pis2324.authenticationexample.domain.Client;

public class MockClientsHashMap extends HashMap<String, Client> {
  /**
   * Empty constructor
   */
  public MockClientsHashMap() {
    super();
    mockInit();
  }

  /**
   * Initializes the mock data
   */
  private void mockInit() {
    put("admin", new Client("admin", "admin", "admin"));
    put("jcena65@gmail.com", new Client("jcena65@gmail.com", "jcena", "password"));
  }
}
