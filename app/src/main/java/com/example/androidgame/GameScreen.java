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
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;



public class GameScreen extends View {
    static int dx,dy ;
    ArrayList<Images> prof;
    Bitmap bitmap_background;
    Rect rectangle;
    Handler handler;
    Runnable runnable;
    final long update = 30;
    Bitmap book,aimer;
    int bookx,booky = 0;

    public GameScreen(Context context) {
        super(context);
        bitmap_background = BitmapFactory.decodeResource(getResources(),R.drawable.lecturehall);

        // In order to adjust canvas size manually (Because it did not fit the whole screen,
        // I took the dimensions of the screen by x and y
        // and applied them into rectangle variable that is inside of the canvas.drawBitmap paramater.
        Display disp = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        Point dimension = new Point();
        disp.getSize(dimension);
        dx = dimension.x;
        dy = dimension.y;
        rectangle = new Rect(0, 0, dx, dy);




        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };

        prof = new ArrayList<>();
        // In order to use more than 1 different bitmap-gifs I opened an arraylist.
        // I use for loop in the GameScreen.java. I'm passing the context by adding objects in a list.
        for(int x = 0; x < 2; x++){
            Images prof1 = new Images(context);
            prof.add(prof1);
        }
        book = BitmapFactory.decodeResource(getResources(),R.drawable.book);
        aimer = BitmapFactory.decodeResource(getResources(),R.drawable.aim);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap_background,null,rectangle,null);
        for(int x=0; x < prof.size(); x++){ // prof.get(x) simply refers for the index in the for loop.
            canvas.drawBitmap(prof.get(x).tBitmap(), prof.get(x).gifx,prof.get(x).gify, null);
            // we are creating our new bitmaps with this for loop but we need to increase frame variable also
            prof.get(x).frame+=1;
            if(prof.get(x).frame > 11) { // resetting the frame after completing the animation of the gif-bitmap
                prof.get(x).frame = 0;
            }
            prof.get(x).gifx -= prof.get(x).speed; //decreasing the x cord. of the gif(bitmap)(or prof) by the speed of it.
            if (prof.get(x).gifx < -prof.get(x).tWidth()) { // if bitmap reaches the left side we should reset the position from beginning of the right side

                prof.get(x).positionReset();
            }
        }

        handler.postDelayed(runnable,update);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        return true;
    }
}
