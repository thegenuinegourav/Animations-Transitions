package com.example.sourabh.animations;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.Wrapper;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout redLayout,greenLayout;
    private ImageView image;
    private TextView text,typingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redLayout = (RelativeLayout)findViewById(R.id.redLayout);
        greenLayout = (RelativeLayout) findViewById(R.id.greenLayout);
        image = (ImageView) findViewById(R.id.imageView);
        text = (TextView) findViewById(R.id.text);
        typingText = (TextView) findViewById(R.id.typingText);

        //When red Surface gets touched, this method will be called
        redLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                animationOnText();  //User-defined Method Calling
                return true;   //to say we have handled this event
            }
        });

        //When green surface gets touched, this method will be called
        greenLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                animationOnImage();   //Another User-defined Calling Method
                return true;
            }
        });


    }

    public void animationOnText()  //User-defined Method to create animation in redLayout
    {
        TransitionManager.beginDelayedTransition(redLayout);   //set Default Transition on redLayout Surface

        //Change the size of the textView so refer to ViewGroup(TextView)
        ViewGroup.LayoutParams textViewRules = text.getLayoutParams();
        textViewRules.width = ViewGroup.LayoutParams.MATCH_PARENT;
        textViewRules.height = 20;
        text.setLayoutParams(textViewRules);  //Setting the rules on TextView
        text.setBackgroundColor(Color.BLACK);

        //Animating the text which will be appearing as a typing text
        typingText.setText("Gourav's Image will be moving when you click on Green Surface!");


    }

    public void animationOnImage()
    {
        TransitionManager.beginDelayedTransition(greenLayout);  //set Deafult Transition on greenLayout Surface

        //Change the position of Image so give reference to RelativeLayout
        RelativeLayout.LayoutParams positionRules =new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        image.setLayoutParams(positionRules);  //Setting the rules on ImageView

        //Change the size of the image so refer to ViewGroup(Image)
        ViewGroup.LayoutParams sizeRules = image.getLayoutParams();
        sizeRules.width = 480;
        sizeRules.height = 480;
        image.setLayoutParams(sizeRules);  //Setting the rules on ImageView
    }
}
