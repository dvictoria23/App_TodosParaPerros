package edu.ub.pis2324.authenticationexample.data.services;

import android.location.GnssAntennaInfo;

import edu.ub.pis2324.authenticationexample.domain.Client;
import edu.ub.pis2324.authenticationexample.data.services.mockdata.MockClientsHashMap;

/**
 * Cloud Firestore implementation of the data store.
 */
public class AuthenticationService {
  /* Attributes */
  private static MockClientsHashMap clients;
  static { clients = new MockClientsHashMap(); }

  /**
   * Empty constructor
   */
  @SuppressWarnings("unused")
  public AuthenticationService() { }

  public interface OnLogInListener {
    void OnLogInSuccess(Client client);
    void OnLogInError(Throwable throwable);
  }

  public interface OnSignUpListener {
    void OnSignUpSuccess();
    void OnSignUpError(Throwable throwable);
  }
  /**
   * Log in client with username and password.
   * @param username the username
   * @param enteredPassword the password
   */
  public void logIn(String username, String enteredPassword, OnLogInListener listener) throws Throwable {
    if (username.isEmpty())
      throw new Throwable("Username cannot be empty");
    if (enteredPassword.isEmpty())
      throw new Throwable("Password cannot be empty");
    if (!clients.containsKey(username))
      throw new Throwable("Username does not exist");

    Client client = clients.get(username);
    if (!client.getPassword().equals(enteredPassword))
      throw new Throwable("Incorrect password");

    listener.OnLogInSuccess(client);
  }

  /**
   * Sign up a new client.
   * @param username the username
   * @param password the password
   * @param passwordConfirmation the password confirmation
   */
  public void signUp(String username, String password, String passwordConfirmation, OnSignUpListener listener) throws Throwable {
    // EXERCICI 2
    if (username.isEmpty())
      throw new Throwable("Username cannot be empty");
    if (password.isEmpty())
      throw new Throwable("Password cannot be empty");
    if (!password.equalsIgnoreCase(passwordConfirmation))
      throw new Throwable("Password cannot be different from password confirmation");

    Client client = new Client(username, username, password);
    clients.put(password, client);
    listener.OnSignUpSuccess();
  }
}
