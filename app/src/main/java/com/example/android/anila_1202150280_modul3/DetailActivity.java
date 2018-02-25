package com.example.android.anila_1202150280_modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Set;

public class DetailActivity extends AppCompatActivity {
    private ImageButton btnPlus,btnMinus;
    private ImageView kapasitasgalon;
    private TextView skor;
    private int level =0;
    private int mScore1;
    private TextView mScoreText1;
    static final String STATE_SCORE_1 = "Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initialize the views
        TextView aquaTitle = (TextView) findViewById(R.id.titleDetail);
        ImageView aquaImage = (ImageView) findViewById(R.id.aquaImageDetail);
        TextView aquaDetail = (TextView) findViewById(R.id.subTitleDetail);
        //Get the drawable
        Drawable drawable = ContextCompat.getDrawable
                (this, getIntent().getIntExtra(Aqua.IMAGE_KEY, 0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Make it the same size as the image
        if (drawable != null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        //Set the text from the Intent extra
        aquaTitle.setText(getIntent().getStringExtra(Aqua.TITLE_KEY));
        Toast.makeText(DetailActivity.this,"Berikut detail dari air mineral merk " + aquaTitle.getText(), Toast.LENGTH_LONG).show();

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra(Aqua.IMAGE_KEY, 0)).placeholder(gradientDrawable).into(aquaImage);

        //Set the text from the Intent extra
        aquaDetail.setText(getIntent().getStringExtra(Aqua.DETAIL_KEY));

            btnPlus=(ImageButton) findViewById(R.id.increase);
            btnMinus=(ImageButton) findViewById(R.id.decrease);
            kapasitasgalon=(ImageView)findViewById(R.id.liter);
            skor=(TextView) findViewById(R.id.score);

            mScoreText1 = (TextView) findViewById(R.id.score);

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScoreText1.setText(String.valueOf(mScore1));
        }

    }

    public void decreaseScore(View view) {
        status();
        if (level==0){
            Toast.makeText(this,"Air Terisi Sedikit,Silahkan Isi Ulang", Toast.LENGTH_SHORT).show();
            return;
        }
        kapasitasgalon.setImageLevel(--level);
    }

    public void increaseScore(View view) {
        status();
        if (level==5){
            Toast.makeText(this,"Air Full", Toast.LENGTH_SHORT).show();
            return;
        }
        kapasitasgalon.setImageLevel(++level);
        }
    private void status(){
        int i=level+1;
        skor.setText(""+i+"L");
    }
}