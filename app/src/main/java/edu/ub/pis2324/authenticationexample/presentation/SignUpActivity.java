package edu.ub.pis2324.authenticationexample.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import edu.ub.pis2324.authenticationexample.R;
import edu.ub.pis2324.authenticationexample.data.services.AuthenticationService;
import edu.ub.pis2324.authenticationexample.databinding.ActivitySignUpBinding;
import edu.ub.pis2324.authenticationexample.domain.Client;

public class SignUpActivity extends AppCompatActivity {
    /* Attributes */
    private AuthenticationService authenticationService;
    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Set view binding */
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /* Initializations */
        authenticationService = new AuthenticationService();
        initWidgetListeners();
    }

    private void initWidgetListeners(){
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Get the values of the widgets */
                String username = binding.etSignUpUsername.getText().toString();
                String password = binding.etSignUpPassword.getText().toString();
                String rpassword = binding.etRepeatPassword.getText().toString();

                try {
                    authenticationService.signUp(username, password, rpassword);
                    Intent intent = new Intent(
                            SignUpActivity.this,
                            ActivitySignUpBinding.class
                    );
                    intent.putExtra("CLIENT_USERNAME", username);
                    startActivity(intent);
                    finish();
                    } catch (Throwable throwable) {
                    String errorMessage = throwable.getMessage();
                    Toast.makeText(
                            SignUpActivity.this,
                            errorMessage,
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }
}