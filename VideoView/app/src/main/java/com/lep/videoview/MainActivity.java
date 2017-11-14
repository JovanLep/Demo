package com.lep.videoview;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    String path= Environment.getExternalStorageDirectory().getAbsolutePath()+"";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        videoView= (VideoView) findViewById(R.id.main_vdv);
//        本地视频的播放
        videoView.setVideoPath("");

        videoView.setVideoURI(Uri.parse(""));

        MediaController mc=new MediaController(this);
        videoView.setMediaController(mc);

        mc.setMediaPlayer(videoView);

    }
}
