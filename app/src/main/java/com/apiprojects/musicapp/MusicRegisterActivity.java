package com.apiprojects.musicapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MusicRegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText etUsername,etPassword,etConfirmPassword,etname,etemail,etPhoneno;
    Button btnSignUp;
    ProgressDialog loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_register);
        mAuth = FirebaseAuth.getInstance();
        getSupportActionBar().setTitle("SignUp");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etPassword=(EditText)findViewById(R.id.etPassword);

        etname=(EditText)findViewById(R.id.etname);
        etemail=(EditText)findViewById(R.id.etemail);

        loadingBar = new ProgressDialog(MusicRegisterActivity.this);


        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingBar.setTitle("Login Account");
                loadingBar.setMessage("checking  credentials");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();
                User user=new User();
                user.setUser_email(etemail.getText().toString());
                user.setUser_username( etname.getText().toString());

                mAuth.createUserWithEmailAndPassword(etemail.getText().toString(), etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(MusicRegisterActivity.this,"user registered sucessfully",Toast.LENGTH_LONG).show();
                            FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        loadingBar.dismiss();
                                        finish();
                                        Toast.makeText(MusicRegisterActivity.this,"user registered sucessfully",Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(MusicRegisterActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                    }

                                }
                            });

                        }else{
                            Toast.makeText(MusicRegisterActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }
        });
        loadingBar.dismiss();
    }
}