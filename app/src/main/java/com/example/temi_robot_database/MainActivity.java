package com.example.temi_robot_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edit_Username =findViewById(R.id.edit_Username);
        final EditText edit_Password =findViewById(R.id.edit_Password);
        Button btn;
        btn = findViewById(R.id.btn_submit);
        Button btn_open = findViewById(R.id.btn_open);
        btn_open.setOnClickListener(v ->
        {
            Intent intent =new Intent(MainActivity.this,RVActivity.class);
            startActivity(intent);

        });

        DAOUser dao =new DAOUser();
        User emp_edit = (User)getIntent().getSerializableExtra("EDIT");
        if (emp_edit !=null)
        {
            btn.setText("UPDATE");
            edit_Username.setText(emp_edit.getUsername());
            edit_Password.setText(emp_edit.getPassword());
            btn_open.setVisibility(View.GONE);
        }
        else
        {
            btn.setText("SUBMIT");
            btn_open.setVisibility(View.VISIBLE);
        }
        btn.setOnClickListener(v ->
        {
            User emp = new User(edit_Username.getText().toString(),edit_Password.getText().toString());
            if(emp_edit==null) {
                dao.add(emp).addOnSuccessListener(suc ->
                        Toast.makeText(this, "Record data", Toast.LENGTH_SHORT).show()).addOnFailureListener(er ->
                        Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show());
            }
            else
                {
                      HashMap<String, Object> hashMap = new HashMap<>();
                      hashMap.put("username", edit_Username.getText().toString());
                      hashMap.put("password", edit_Password.getText().toString());
                     dao.update(emp_edit.getKey(), hashMap).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Record is update", Toast.LENGTH_SHORT).show();
                    finish();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
                 }
        });
//            HashMap<String,Object> hashMap =new HashMap<>();
//            hashMap.put("Username",edit_Username.getText().toString());
//            hashMap.put("postion",edit_Password.getText().toString());
//            dao.update("-MbgY9yOCnCLkuMVRYP4",hashMap).addOnSuccessListener(suc ->
//                    Toast.makeText(this, "Record updated", Toast.LENGTH_SHORT).show()).addOnFailureListener(er ->
//                    Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show());


//            dao.remove("-MbgY9yOCnCLkuMVRYP4").addOnSuccessListener(suc ->
//                    Toast.makeText(this, "Record removed", Toast.LENGTH_SHORT).show()).addOnFailureListener(er ->
//                    Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show());


        }

    }
