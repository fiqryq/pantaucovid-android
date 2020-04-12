package com.sunflower.pantaucovid19.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.sunflower.pantaucovid19.R;

public class AboutActivity extends AppCompatActivity {
    private ImageView mFiqry ,mAmir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        mFiqry = findViewById(R.id.imageViewFiqry);
        mAmir = findViewById(R.id.imageViewAmir);
        getProfileImage();
    }

    private void getProfileImage(){
        String gambarFiqry = "http://pantaucovid.fiqrychoerudin.space/image/25787603.jpg";
        String gambarAmir = "http://pantaucovid.fiqrychoerudin.space/image/24654871.jpg";
        Picasso.get().load(gambarFiqry).into(mFiqry);
        Picasso.get().load(gambarAmir).into(mAmir);
    }
}
