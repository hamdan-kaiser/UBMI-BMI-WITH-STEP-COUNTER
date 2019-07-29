package com.example.hamdan.ubmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class testBMI extends AppCompatActivity {
    databaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bmi);
        databaseHelper = new databaseHelper(this);

       final EditText heightInfeet = (EditText)findViewById(R.id.heightFeet);
       final EditText heightInInches = (EditText)findViewById(R.id.heightInches);
       final EditText weightInKgs = (EditText)findViewById(R.id.weightKgs);
       final Button submit = (Button)findViewById(R.id.submit);
       final TextView result = (TextView)findViewById(R.id.textView5);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int heightFeet = Integer.parseInt(heightInfeet.getText().toString());
                int heightInches = Integer.parseInt(heightInInches.getText().toString());
                int weightKgs = Integer.parseInt(weightInKgs.getText().toString());

                int height = (int) ((heightFeet*12+ heightInches)/39.3701);
                int finalHeight = height^2;
                float finalBMI = (weightKgs/finalHeight)+1;


                if(heightInfeet.length()==0||heightInInches.length()==0||weightInKgs.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Fill Each of the Blanks with suitable information(s)",Toast.LENGTH_LONG).show();
                }
               else
                {


                    if(finalBMI<18.5)
                    {
                        float weight00 = (float) ((18.5*finalHeight)-weightKgs);
                        float weight01 = (float) ((24.9*finalHeight)-weightKgs);
                        result.setText("Your BMI = "+finalBMI+"\n"+"Status: Under Weight \nYou have to gain between " +weight00+
                        "kg and "+weight01+"kg\n");


                    }

                    else if(finalBMI>18.5 && finalBMI<24.9)
                    {
                        result.setText("Your BMI = "+finalBMI+"\n"+"Status: Normal Weight\nStay Healthy");
                    }

                    else if(finalBMI>=25 && finalBMI<=29.9)
                    {
                        float weight00 = (float) (weightKgs-(18.5*finalHeight));
                        float weight01 = (float) (weightKgs-(24.9*finalHeight));
                        result.setText("Your BMI = "+finalBMI+"\n"+"Status: Over Weight\nYou have to lose between " +weight00+
                                "kg and "+weight01+"kg\n");
                    }

                    else if(finalBMI<=30)
                    {
                        float weight00 = (float) (weightKgs-(18.5*finalHeight));
                        float weight01 = (float) (weightKgs-(24.9*finalHeight));
                        result.setText("Your BMI = "+finalBMI+"\n"+"Status: Obese\nYou have to lose between " +weight00+
                                "kg and "+weight01+"kg\n");
                    }

                    String currentDateandTime = DateFormat.getDateTimeInstance().format(new Date());

                    String heightWeight = "Height: "+heightInfeet.getText().toString()+"ft "+heightInInches.getText().toString()+" inches \n"+
                            "Weight: "+weightInKgs.getText().toString()+"kg's";

                    String newEntry = ""+currentDateandTime+"\n"+heightWeight+"\n"+"BMI: "+finalBMI+"\n";
                   // Toast.makeText(getApplicationContext(),"BMI = "+result.getText().toString(),Toast.LENGTH_LONG).show();
                    AddData(newEntry);

                }

            }
        });

    }
    public void AddData(String newEntry)
    {
        boolean insertData = databaseHelper.addData(newEntry);


        if(insertData)
        {
            Toast.makeText(getApplicationContext(),"Data Saved Successfully!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Something went Wrong",Toast.LENGTH_SHORT).show();
        }
    }

}
