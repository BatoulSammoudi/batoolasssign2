package com.example.batool_assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.batool_assignment_2.model.Information;
import com.google.gson.Gson;

public class MainActivity2 extends AppCompatActivity {
    private static final String INFORMATION = "INFORMATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void fillFields() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String str = pref.getString("information", "");
        Information[] information = gson.fromJson(str, Information[].class);
        EditText edu = (EditText) findViewById(R.id.educatiom);
        edu.setText(information[0].getEducation());
        EditText work = (EditText) findViewById(R.id.work_exp);
        work.setText(information[0].getWorkExp());
        EditText skill = (EditText) findViewById(R.id.skills);
        skill.setText(information[0].getSkills());
        Toast.makeText(this, information[0].toString(), Toast.LENGTH_SHORT).show();
    }

    public void saveBtn(View view) {
        try {
            Bundle bundle = getIntent().getExtras();
            String firstName = bundle.getString("firstName", null);
            String lastName = bundle.getString("lastName", null);
            String address = bundle.getString("address", null);
            String gender = bundle.getString("gender", null);
            String student = bundle.getString("isStudent", null);
            boolean isStudent = false;
            if (student.equalsIgnoreCase("yes"))
                isStudent = true;
            String city = bundle.getString("city", null);
            EditText edu = (EditText) findViewById(R.id.educatiom);
            EditText workExp = (EditText) findViewById(R.id.work_exp);
            EditText skills = (EditText) findViewById(R.id.skills);
            boolean logedIn = false;
            Information[] informationArr = new Information[1];
            informationArr[0] = new Information(firstName, lastName, address, gender, isStudent, city, edu.getText().toString(), workExp.getText().toString(), skills.getText().toString());
            Gson gson = new Gson();
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String info = gson.toJson(informationArr);
            editor.putString("information", info);
            editor.putBoolean("logedIN", true);
            editor.commit();
            Toast.makeText(this, informationArr[0].toString(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        }
    }
}