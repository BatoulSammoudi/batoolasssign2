package com.example.batool_assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.batool_assignment_2.model.Information;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    private static final String INFORMATION = "INFORMATION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkStatus();
    }
    public void checkStatus(){
        SharedPreferences sharedPreferences=getSharedPreferences(INFORMATION, Context.MODE_PRIVATE);

        boolean logedIN=sharedPreferences.getBoolean("logedIN",false);
        if(logedIN){

            SharedPreferences  pref= PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson=new Gson();
            String str=pref.getString("information","");
            Information[] information=gson.fromJson(str,Information[].class);
            EditText firstName=(EditText)findViewById(R.id.firstName);
            firstName.setText(information[0].getFirstName());
            EditText lastName=(EditText)findViewById(R.id.lastName);
            lastName.setText(information[0].getLastName());
            EditText address=(EditText)findViewById(R.id.address);
            address.setText(information[0].getAddress());
            String gender=information[0].getGender();
            if (gender.equalsIgnoreCase("Male")){
                RadioButton r1=(RadioButton)findViewById(R.id.male);
                r1.setChecked(true);
            }else{
                RadioButton r2=(RadioButton)findViewById(R.id.female);
                r2.setChecked(true);
            }
            boolean isStudent=information[0].isStudent();
            if(isStudent){
                CheckBox checkBox=(CheckBox)findViewById(R.id.yes);
                checkBox.setChecked(true);
            }else{
                CheckBox checkBox=(CheckBox)findViewById(R.id.no);
                checkBox.setChecked(true);
            }

        }else{
            Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
        }
    }
     String city = null;

    public void nextPageBtn(View view) {
        try {
            //get fields
            EditText firstName = (EditText) findViewById(R.id.firstName);
            EditText lastName = (EditText) findViewById(R.id.lastName);
            EditText address = (EditText) findViewById(R.id.address);
            //get selected radio button
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton genderradioButton = (RadioButton) findViewById(selectedId);
            String gender = genderradioButton.getText().toString();
            //get check box answer
            CheckBox yes = (CheckBox) findViewById(R.id.yes);
            CheckBox no = (CheckBox) findViewById(R.id.no);
            String selectedCheckedBoxValue = "";
            if (yes.isChecked()) {
                selectedCheckedBoxValue = "yes";
            } else if (no.isChecked()) {
                selectedCheckedBoxValue = "no";
            }
            //spinner
            Spinner spinner = findViewById(R.id.spinner1);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.city, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
            city=spinner.getSelectedItem().toString();
            Bundle bundle = new Bundle();
            bundle.putString("firstName", firstName.getText().toString());
            bundle.putString("lastName", lastName.getText().toString());
            bundle.putString("address", address.getText().toString());
            bundle.putString("isStudent", selectedCheckedBoxValue);
            bundle.putString("gender", gender);
            bundle.putString("city", city);
            Toast.makeText(this, "" + city, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtras(bundle);
           startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        city = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}