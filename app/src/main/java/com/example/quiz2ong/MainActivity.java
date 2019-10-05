package com.example.quiz2ong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    CheckBox Box1;
    CheckBox Box2;
    CheckBox Box3;
    CheckBox Box4;
    CheckBox Box5;
    CheckBox Box6;
    CheckBox Box7;
    CheckBox Box8;
    EditText commentBox;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Box1 = findViewById(R.id.Check1);
        Box2 = findViewById(R.id.Check2);
        Box3 = findViewById(R.id.Check3);
        Box4 = findViewById(R.id.Check4);
        Box5 = findViewById(R.id.Check5);
        Box6 = findViewById(R.id.Check6);
        Box7 = findViewById(R.id.Check7);
        Box8 = findViewById(R.id.Check8);
        commentBox = findViewById(R.id.Comment);

    }

    public void buttonSave(View v)
    {
        String subjectString = "";

        if(Box1.isChecked())
        {
            String text=Box1.getText().toString();
            subjectString = subjectString + "\n" + text + "\n";
        }
        if(Box2.isChecked())
        {
            String text=Box2.getText().toString();
            subjectString = subjectString + text + "\n";
        }
        if(Box3.isChecked())
        {
            String text=Box3.getText().toString();
            subjectString = subjectString + text + "\n";
        }
        if(Box4.isChecked())
        {
            String text=Box4.getText().toString();
            subjectString = subjectString + text + "\n";
        }
        if(Box5.isChecked())
        {
            String text=Box5.getText().toString();
            subjectString = subjectString + text + "\n";
        }
        if(Box6.isChecked())
        {
            String text=Box6.getText().toString();
            subjectString = subjectString + text + "\n";
        }
        if(Box7.isChecked())
        {
            String text=Box7.getText().toString();
            subjectString = subjectString + text + "\n";
        }
        if(Box8.isChecked())
        {
            String text=Box8.getText().toString();
            subjectString = subjectString + text;
        }

        String comment = commentBox.getText().toString();

        FileOutputStream fos;
        FileOutputStream fos2;
        try {
            fos = openFileOutput("subjects.txt", MODE_PRIVATE);
            OutputStreamWriter out = new OutputStreamWriter(fos);
            out.write(subjectString);
            out.close();
            fos.close();
            fos2 = openFileOutput("comment.txt", MODE_PRIVATE);
            OutputStreamWriter out2 = new OutputStreamWriter(fos2);
            out2.write(comment);
            out2.close();
            fos2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Data Saved... " , Toast.LENGTH_LONG).show();



    }
    public void buttonNext(View view)
    {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
