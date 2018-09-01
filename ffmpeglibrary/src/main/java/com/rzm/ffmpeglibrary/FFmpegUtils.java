package com.rzm.ffmpeglibrary;

public class FFmpegUtils {

    static{
        System.loadLibrary("newffmpeg");
    }

    public native static String decode(String input,String output);
}
