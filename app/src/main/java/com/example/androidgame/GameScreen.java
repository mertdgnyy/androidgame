package com.example.androidgame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import android.os.Handler;
import android.view.Display;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;



public class GameScreen extends View {
    static int x,y ;
    ArrayList<Images> prof;
    Bitmap bitmap_background;
    Rect rectangle;
    Handler handler;
    Runnable runnable;
    final long update = 30;

    public GameScreen(Context context) {
        super(context);
        bitmap_background = BitmapFactory.decodeResource(getResources(),R.drawable.lecturehall);

        // In order to adjust canvas size manually (Because it did not fit the whole screen,
        // I took the dimensions of the screen by x and y
        // and applied them into rectangle variable that is inside of the canvas.drawBitmap paramater.
        Display disp = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        Point dimension = new Point();
        disp.getSize(dimension);
        x = dimension.x;
        y = dimension.y;
        rectangle = new Rect(0, 0, x, y);

        prof = new ArrayList<>();
        // In order to use more than 1 different bitmap-gifs I opened an arraylist.
        // I use for loop in the GameScreen.java. I'm passing the context by adding objects in a list.
        for(int x = 0; x < 2; x++){
            Images prof1 = new Images(context);
            prof.add(prof1);
        }


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int x=0; x < prof.size(); x++){ // prof.get(x) simply refers for the index in the for loop.
            canvas.drawBitmap(prof.get(x).tBitmap(), prof.get(x).gifx,prof.get(x).gify, null);
            // we are creating our new bitmaps with this for loop but we need to increase frame variable also
            prof.get(x).frame+=1;
            if(prof.get(x).frame > 12) { // resetting the frame after completing the animation of the gif-bitmap
                prof.get(x).frame = 0;
            }
        }
        canvas.drawBitmap(bitmap_background,null,rectangle,null);
//        canvas.drawBitmap(gif[frame],gifx,gify,null);
//        frame++;
//
//        if (frame > 11 ) {
//            frame = 0;
//        }
//
//        gifx -= speed;
//
//        //random positions
//        if(gifx < -gifwitdh){
//
//        }

        handler.postDelayed(runnable,update);
    }
}
