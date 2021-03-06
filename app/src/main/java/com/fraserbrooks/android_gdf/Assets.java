package com.fraserbrooks.android_gdf;

import java.io.IOException;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by Fraser on 19/12/2017.
 */

public class Assets {

    private static SoundPool soundPool;
    public static Bitmap welcome_lan, welcome_por;

    public static void load(){
        welcome_lan = loadBitmap("welcome.png", false);
        welcome_por = loadBitmap("welcome_portrait.png", false);
    }

    private static Bitmap loadBitmap(String filename, boolean transparency){
        InputStream inputStream = null;
        try{
            inputStream = GameMainActivity.assets.open(filename);
        } catch (IOException e){
            e.printStackTrace();
        }
        Options options = new Options();
        if (transparency){
            options.inPreferredConfig = Config.ARGB_8888;
        } else {
            options.inPreferredConfig = Config.RGB_565;
        }
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options);
        return bitmap;
    }

    private static int loadSound(String filename){
        int soundID = 0;
        if (soundPool == null){
            soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC, 0);
        }
        try{
            soundID = soundPool.load(GameMainActivity.assets.openFd(filename),1);
        } catch (IOException e){
            e.printStackTrace();
        }
        return soundID;
    }

    public static void playSound(int soundID){
        soundPool.play(soundID, 1,1,1,0,1);
    }

}
