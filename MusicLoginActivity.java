package com.apiprojects.musicapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MusicLoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    FirebaseUser user;
    EditText etUsername, etPassword;
    TextView tvRegHere, tvForgotPass;
    Button bt_login;
    ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_login);
        getSupportActionBar().setTitle("Login");
        mAuth = FirebaseAuth.getInstance();
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        loadingBar = new ProgressDialog(MusicLoginActivity.this);


        tvRegHere = (TextView) findViewById(R.id.tvRegHere);

        bt_login = (Button) findViewById(R.id.bt_login);


        tvRegHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicLoginActivity.this, MusicRegisterActivity.class);
                startActivity(intent);
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingBar.setTitle("Login Account");
                loadingBar.setMessage("checking  credentials");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();

                mAuth.signInWithEmailAndPassword(etUsername.getText().toString(), etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        mAuth.signInWithEmailAndPassword(etUsername.getText().toString(),  etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MusicLoginActivity.this, "user Login  success", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(MusicLoginActivity.this, MainActivity.class);
                                    user = FirebaseAuth.getInstance().getCurrentUser();
                                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
                                    String uId = user.getUid();
                                    reference.child(uId).addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            User customerPojo = snapshot.getValue(User.class);

                                            if (customerPojo != null) {
                                                String uname = customerPojo.getUser_name();
                                                SharedPreferences sp = getSharedPreferences("AA", 0);
                                                SharedPreferences.Editor et = sp.edit();
                                                et.putString("uname", uname);
                                                et.commit();
                                                startActivity(intent);
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {
                                            Toast.makeText(MusicLoginActivity.this, "failed", Toast.LENGTH_LONG).show();
                                        }
                                    });

                                } else {
                                    Toast.makeText(MusicLoginActivity.this, "user Login  failed", Toast.LENGTH_LONG).show();
                                }

                            }
                        });
                    }
                });

            }
        });
        loadingBar.dismiss();
    }
}