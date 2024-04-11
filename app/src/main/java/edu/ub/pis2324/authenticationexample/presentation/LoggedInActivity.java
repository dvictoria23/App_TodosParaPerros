package edu.ub.pis2324.authenticationexample.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.ub.pis2324.authenticationexample.databinding.ActivityLoggedInBinding;

public class LoggedInActivity extends AppCompatActivity {

  private ActivityLoggedInBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityLoggedInBinding
        .inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    String clientId = getIntent().getStringExtra("CLIENT_ID");

    binding.tvClientId.setText(clientId);
  }
}