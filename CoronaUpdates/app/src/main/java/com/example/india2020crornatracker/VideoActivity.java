package com.example.india2020crornatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.view.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
Button vid1,vid2;
    VideoView vidviw;
    MediaController mediaController;
    String path;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        vid1=findViewById(R.id.buttonvid1);
        vid2=findViewById(R.id.buttonvid2);

        vidviw=findViewById(R.id.videoView);

        mediaController=new MediaController(this);
        mediaController.setAnchorView(vidviw);
        vidviw.setMediaController(mediaController);
    }

    public void onClic1(View v)
    {
       path="android.resource://"+getPackageName()+"/"+R.raw.awarenessone;
       uri=Uri.parse(path);
       vidviw.setVideoURI(uri);
       vidviw.start();
    }
    public void onClic2(View v)
    {
        path="android.resource://"+getPackageName()+"/"+R.raw.awarenesstwo;
        uri=Uri.parse(path);
        vidviw.setVideoURI(uri);
        vidviw.start();
    }

}