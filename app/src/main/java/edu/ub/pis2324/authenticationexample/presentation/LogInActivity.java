package edu.ub.pis2324.authenticationexample.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.ub.pis2324.authenticationexample.databinding.ActivityLogInBinding;
import edu.ub.pis2324.authenticationexample.domain.Client;
import edu.ub.pis2324.authenticationexample.data.services.AuthenticationService;

public class LogInActivity extends AppCompatActivity {
  /* Attributes */
  private AuthenticationService authenticationService;
  /* View binding */
  private ActivityLogInBinding binding;

  /**
   * Called when the activity is being created.
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    /* Set view binding */
    binding = ActivityLogInBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    /* Initializations */
    authenticationService = new AuthenticationService();
    initWidgetListeners();
  }

  /**
   * Initialize the listeners of the widgets.
   */
  private void initWidgetListeners() {
    binding.btnLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        /* Get the values of the widgets */
        String username = binding.etLoginUsername.getText().toString();
        String password = binding.etLoginPassword.getText().toString();

        try {
          authenticationService.logIn(username, password, new AuthenticationService.OnLogInListener() {
            @Override
            public void OnLogInSuccess(Client client) {
              Intent intent = new Intent(
                  LogInActivity.this,
                  LoggedInActivity.class
              );
              intent.putExtra("CLIENT_ID", client.getId());
              startActivity(intent);
              finish();
            }

            @Override
            public void OnLogInError(Throwable throwable) {
              String errorMessage = throwable.getMessage();
              Toast.makeText(
                  LogInActivity.this,
                  errorMessage,
                  Toast.LENGTH_SHORT
              ).show();
            }
          });
          Intent intent = new Intent(
              LogInActivity.this,
              LoggedInActivity.class
          );
          startActivity(intent);
          finish();
        } catch (Throwable throwable) {
          String errorMessage = throwable.getMessage();
          Toast.makeText(
              LogInActivity.this,
              errorMessage,
              Toast.LENGTH_SHORT
          ).show();
        }
      }

    });

    // EXERCICI 1
    // Afegeix el listener a un botó de sign-up que llenci una nova activitat
    // SignUpActivity.
    // ...
    binding.btnLoginSignUp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(
                LogInActivity.this,
                SignUpActivity.class);
        startActivity(intent);
        finish();
      }
    });



  }
}