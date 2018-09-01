package com.rzm.ffmpegframe;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rzm.ffmpeglibrary.FFmpegUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private String input;
    private String output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = new File(Environment.getExternalStorageDirectory(),"input.mp4").getAbsolutePath();
        output = new File(Environment.getExternalStorageDirectory(),"output.mp4").getAbsolutePath();
    }

    public void decode(View view) {
        System.out.println(FFmpegUtils.decode(input,output));
    }
}
