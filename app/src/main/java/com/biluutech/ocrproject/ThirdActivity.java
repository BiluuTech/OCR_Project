package com.biluutech.ocrproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

import java.util.Locale;

public class ThirdActivity extends AppCompatActivity {

    private Button translateBtn, urduLangBtn, chineseLangBtn, chineseSimplifiedLangBtn, chineseTraditionalLangBtn, againTranslateBtn;
    private TextView translatedTV, translationTV, selectLangaugeTV;
    private EditText sourceET;
    private String nn, translatedString;
    private CardView translatedCardview;
    private FloatingActionButton voiceBtn;
    private TextToSpeech textToSpeech;
    private String langStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("Click + button to insert image");
        actionBar.hide();

        nn = getIntent().getStringExtra("nn");

//        translateBtn = findViewById(R.id.translate);
        urduLangBtn = findViewById(R.id.urduLangBtn);
        chineseLangBtn = findViewById(R.id.chineseLangBtn);
        chineseSimplifiedLangBtn = findViewById(R.id.chineseSimplifiedLangBtn);
        chineseTraditionalLangBtn = findViewById(R.id.chineseTraditionalLangBtn);
        againTranslateBtn = findViewById(R.id.againTranslationBtn);
        voiceBtn = findViewById(R.id.voice_btn);
        translatedCardview = findViewById(R.id.translatedTextCardView);
        translatedTV = findViewById(R.id.translatedText);
        translationTV = findViewById(R.id.translationTV);
        selectLangaugeTV = findViewById(R.id.selectLanguageTV);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS){

                    if (langStatus=="u"){
                        int lang = textToSpeech.setLanguage(new Locale("ur"));
                    }
                    else if (langStatus=="c"){
                        int lang = textToSpeech.setLanguage(Locale.CHINESE);
                    }
                    else if (langStatus=="cs"){
                        int lang = textToSpeech.setLanguage(Locale.SIMPLIFIED_CHINESE);
                    }
                    else if (langStatus=="ct"){
                        int lang = textToSpeech.setLanguage(Locale.TRADITIONAL_CHINESE);
                    }



                }

            }
        });

//        sourceET = findViewById(R.id.sourceText);

//        sourceET.setText(nn);

//        translateBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TranslateAPI translateAPI = new TranslateAPI(Language.AUTO_DETECT,Language.URDU,nn);
//
//                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
//                    @Override
//                    public void onSuccess(String s) {
//                        translatedTV.setText(s);
//                    }
//
//                    @Override
//                    public void onFailure(String s) {
//
//                    }
//                });
//            }
//        });
//
        urduLangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TranslateAPI translateAPI = new TranslateAPI(Language.AUTO_DETECT,Language.URDU,nn);

                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String s) {
                        translatedTV.setText(s);
                        translatedString = s;

                        langStatus = "u";

                        selectLangaugeTV.setVisibility(View.GONE);
                        translationTV.setVisibility(View.VISIBLE);
                        urduLangBtn.setVisibility(View.GONE);
                        chineseLangBtn.setVisibility(View.GONE);
                        chineseSimplifiedLangBtn.setVisibility(View.GONE);
                        chineseTraditionalLangBtn.setVisibility(View.GONE);
                        translatedCardview.setVisibility(View.VISIBLE);
                        voiceBtn.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onFailure(String s) {

                    }
                });

            }
        });

        chineseLangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TranslateAPI translateAPI = new TranslateAPI(Language.AUTO_DETECT,Language.CHINESE,nn);

                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String s) {
                        translatedTV.setText(s);
                        translatedString = s;

                        langStatus = "c";

                        selectLangaugeTV.setVisibility(View.GONE);
                        translationTV.setVisibility(View.VISIBLE);
                        urduLangBtn.setVisibility(View.GONE);
                        chineseSimplifiedLangBtn.setVisibility(View.GONE);
                        chineseTraditionalLangBtn.setVisibility(View.GONE);
                        chineseLangBtn.setVisibility(View.GONE);
                        translatedCardview.setVisibility(View.VISIBLE);
                        voiceBtn.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onFailure(String s) {

                    }
                });

            }
        });

        chineseSimplifiedLangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TranslateAPI translateAPI = new TranslateAPI(Language.AUTO_DETECT,Language.CHINESE_SIMPLIFIED,nn);

                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String s) {
                        translatedTV.setText(s);
                        translatedString = s;

                        langStatus = "cs";

                        selectLangaugeTV.setVisibility(View.GONE);
                        translationTV.setVisibility(View.VISIBLE);
                        urduLangBtn.setVisibility(View.GONE);
                        chineseSimplifiedLangBtn.setVisibility(View.GONE);
                        chineseTraditionalLangBtn.setVisibility(View.GONE);
                        chineseLangBtn.setVisibility(View.GONE);
                        translatedCardview.setVisibility(View.VISIBLE);
                        voiceBtn.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onFailure(String s) {

                    }
                });

            }
        });

        chineseTraditionalLangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TranslateAPI translateAPI = new TranslateAPI(Language.AUTO_DETECT,Language.CHINESE_TRADITIONAL,nn);

                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String s) {
                        translatedTV.setText(s);

                        translatedString = s;

                        langStatus = "ct";

                        selectLangaugeTV.setVisibility(View.GONE);
                        translationTV.setVisibility(View.VISIBLE);
                        urduLangBtn.setVisibility(View.GONE);
                        chineseSimplifiedLangBtn.setVisibility(View.GONE);
                        chineseTraditionalLangBtn.setVisibility(View.GONE);
                        chineseLangBtn.setVisibility(View.GONE);
                        translatedCardview.setVisibility(View.VISIBLE);
                        voiceBtn.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onFailure(String s) {

                    }
                });

            }
        });

        againTranslateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textToSpeech.stop();
                startActivity(new Intent(ThirdActivity.this,SecondActivity.class));
                finish();

            }
        });


        voiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int speech = textToSpeech.speak(translatedString,TextToSpeech.QUEUE_FLUSH, null);

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        textToSpeech.stop();
    }
}