package com.example.pr14_0103;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText firstname;
    EditText lastname;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    EditText weight;
    EditText height;
    RadioButton m;
    RadioButton w;
    FrameLayout training1;
    FrameLayout training2;
    FrameLayout training3;
    FrameLayout training4;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void AlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title).setMessage(message).setCancelable(false).setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void onClickReg(View view){
        setContentView(R.layout.step_1);
    }

    public void onClickStep1(View view){
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        if(firstname.getText().toString().equals("")) AlertDialog("Уведомление", "Введите ваше имя!");
        else if(lastname.getText().toString().equals("")) AlertDialog("Уведомление", "Введите вашу фамилию!");
        else{
            setContentView(R.layout.step_2);
            text = findViewById(R.id.nice);
            text.setText("Отлично, " + firstname.getText() + " " + lastname.getText());
            rb1 = findViewById(R.id.rb1);
            rb2 = findViewById(R.id.rb2);
            rb3 = findViewById(R.id.rb3);
            rb4 = findViewById(R.id.rb4);
        }
    }

    public void onClickStep2(View view){
        if(!rb1.isChecked() && !rb2.isChecked() && !rb3.isChecked() && !rb4.isChecked()) AlertDialog("Уведомление", "Выберите, как часто вы хотите тренероваться!");
        else {
            setContentView(R.layout.step_3);
            cb1 = findViewById(R.id.cb1);
            cb2 = findViewById(R.id.cb2);
            cb3 = findViewById(R.id.cb3);
            cb4 = findViewById(R.id.cb4);
        }
    }

    public void onClickStep3(View view){
        if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) AlertDialog("Уведомление", "Выберите тип тренеровки!");
        else {
            setContentView(R.layout.step_4);
            weight = findViewById(R.id.weight);
            height = findViewById(R.id.height);
        }
    }

    public void onClickStep4(View view){
        if(weight.getText().toString().equals("")) AlertDialog("Уведомление", "Укажите ваш вес!");
        else if(height.getText().toString().equals("")) AlertDialog("Уведомление", "Укажите ваш рост!");
        else {
            setContentView(R.layout.step_5);
            m = findViewById(R.id.m);
            w = findViewById(R.id.w);
        }
    }

    boolean tr1 = false;
    boolean tr2 = false;
    boolean tr3 = false;
    boolean tr4 = false;
    public void onClickStep5(View view){
        if(!m.isChecked() && !w.isChecked()) AlertDialog("Уведомление", "Выберите ваш пол!");
        else {
            setContentView(R.layout.main);
            training1 = findViewById(R.id.training1);
            training2 = findViewById(R.id.training2);
            training3 = findViewById(R.id.training3);
            training4 = findViewById(R.id.training4);
            if(cb1.isChecked()) {training1.setVisibility(View.VISIBLE); tr1 = true;}
            if(cb2.isChecked()) {training2.setVisibility(View.VISIBLE); tr2 = true;}
            if(cb3.isChecked()) {training3.setVisibility(View.VISIBLE); tr3 = true;}
            if(cb4.isChecked()) {training4.setVisibility(View.VISIBLE); tr4 = true;}
            editor.putBoolean("training1", tr1);
            editor.putBoolean("training2", tr2);
            editor.putBoolean("training3", tr3);
            editor.putBoolean("training4", tr4);
            editor.commit();
        }
    }

    public void onClickTraining1(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=-tZk6m_5beQ"));
        startActivity(browserIntent);
    }

    public void onClickTraining2(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=zXLwlRGfCMQ"));
        startActivity(browserIntent);
    }

    public void onClickTraining3(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=1EC2qWiQDXg"));
        startActivity(browserIntent);
    }

    public void onClickTraining4(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=H21pTB9nJ7I"));
        startActivity(browserIntent);
    }

    public void onClickAut(View view){
        setContentView(R.layout.main);
        training1 = findViewById(R.id.training1);
        training2 = findViewById(R.id.training2);
        training3 = findViewById(R.id.training3);
        training4 = findViewById(R.id.training4);
        if(sharedPreferences.getBoolean("training1", true)) training1.setVisibility(View.VISIBLE);
        if(sharedPreferences.getBoolean("training2", true)) training2.setVisibility(View.VISIBLE);
        if(sharedPreferences.getBoolean("training3", true)) training3.setVisibility(View.VISIBLE);
        if(sharedPreferences.getBoolean("training4", true)) training4.setVisibility(View.VISIBLE);
    }
}