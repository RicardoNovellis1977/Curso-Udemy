package com.example.ricardo.projetofirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText email,password;
    Button registerButton, loginButtonGoogle, button_login;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText) findViewById(R.id.email_register);
        password = (EditText) findViewById(R.id.password_register);
        registerButton = (Button) findViewById(R.id.button_register);
        loginButtonGoogle = (Button) findViewById(R.id.account_google_login);
        button_login =(Button) findViewById(R.id.button_login);

        //ISSO É VIDA! INSTANCIA DO FIREBASE SEM ELE A GENTE FICA MUITO TRISTE!
        firebaseAuth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_value = email.getText().toString();
                String password_value = password.getText().toString();

                if(email_value.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please fill in the required fields",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password_value.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please fill in the required fields",Toast.LENGTH_SHORT).show();
                }

                if(password_value.length() < 6){
                    Toast.makeText(getApplicationContext(),"Password must be at least 6 characters",Toast.LENGTH_SHORT).show();
                }

//METODO DE CRIAR USUARIO COM EMAIL E PASSWORD
                firebaseAuth.createUserWithEmailAndPassword(email_value,password_value)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    finish();
                                }else {
                                    Toast.makeText(getApplicationContext(),task.getException()
                                            .getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });


        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_value = email.getText().toString();
                String password_value = password.getText().toString();

                //METODO PARA LOGAR COM EMAIL E PASSWORD

                firebaseAuth.signInWithEmailAndPassword(email_value,password_value)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    finish();
                                }else {
                                    Toast.makeText(getApplicationContext(),task.getException()
                                            .getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });




            }
        });

        loginButtonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });


        if(firebaseAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
    }
}