package com.monir.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewsDetails extends AppCompatActivity {

    ImageView itemDetailsImage;
    TextView itemDetailsTitle, itemDetailsDescription;
    FloatingActionButton voiceButton;

    public static String TITLE = "";
    public  static String DESCRIPTION = "";
    public static Bitmap MY_BITMAP = null;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        itemDetailsImage = findViewById(R.id.itemDetailsImage);
        itemDetailsTitle = findViewById(R.id.itemDetailsTitle);
        itemDetailsDescription = findViewById(R.id.itemDetailsDescription);
        voiceButton = findViewById(R.id.voiceButton);

        itemDetailsTitle.setText(TITLE);
        itemDetailsDescription.setText(DESCRIPTION);
        if (MY_BITMAP != null) itemDetailsImage.setImageBitmap(MY_BITMAP);

        textToSpeech = new TextToSpeech(NewsDetails.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });

        voiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = itemDetailsDescription.getText().toString();
                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });
    }
}