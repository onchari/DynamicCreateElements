package com.example.user2.dynamiccreateelements;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout mainLinearLayout = (LinearLayout) findViewById(R.id.linearMain);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);

        String[] students = {"Jacob", "Abel", "Ambrose", "Agnes", "Nyaboke", "Abnah"};

        for(int j =0; j < students.length; j++){
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            //create View
            TextView product = new TextView(this);
            product.setText(students[j]);
            linearLayout.addView(product);

            //create button
            final Button btn = new Button(this);
            //give button and Id
            btn.setId(j+1);
            btn.setText("Add to cart");
            // set the layoutparams on the button
            btn.setLayoutParams(params);

            final int index = j;
            // set click listener for button
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("TAG","index : " + index);
                    Toast.makeText(getApplicationContext(), "Clicked button : " + index, Toast.LENGTH_LONG).show();
                }
            });

            //add button to linear layout
            linearLayout.addView(btn);
            mainLinearLayout.addView(linearLayout);
        }
    }
}
