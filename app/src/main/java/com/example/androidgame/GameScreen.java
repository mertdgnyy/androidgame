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

import java.util.Random;



public class GameScreen extends View {
    int x,y ;
    Bitmap bitmap_background;
    Rect rectangle;
    Bitmap gif[] = new Bitmap[12]; // For testing I determined 13 frame for animating bitmap
    int gifx,gify;
    int speed, frame;
    int gifwitdh;
    Random number;
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
        gif[0] = BitmapFactory.decodeResource(getResources(),R.drawable.a1);
        gif[1] = BitmapFactory.decodeResource(getResources(),R.drawable.a2);
        gif[2] = BitmapFactory.decodeResource(getResources(),R.drawable.a3);
        gif[3] = BitmapFactory.decodeResource(getResources(),R.drawable.a4);
        gif[4] = BitmapFactory.decodeResource(getResources(),R.drawable.a5);
        gif[5] = BitmapFactory.decodeResource(getResources(),R.drawable.a6);
        gif[6] = BitmapFactory.decodeResource(getResources(),R.drawable.a7);
        gif[7] = BitmapFactory.decodeResource(getResources(),R.drawable.a8);
        gif[8] = BitmapFactory.decodeResource(getResources(),R.drawable.a9);
        gif[9] = BitmapFactory.decodeResource(getResources(),R.drawable.a10);
        gif[10] = BitmapFactory.decodeResource(getResources(),R.drawable.a11);
        gif[11] = BitmapFactory.decodeResource(getResources(),R.drawable.a12);

        gifx = x + 250;
        gify = 50;
        speed = 20;
        frame = 0;
        gifwitdh = gif[0].getWidth();
        number = new Random();
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
        canvas.drawBitmap(bitmap_background,null,rectangle,null);
        canvas.drawBitmap(gif[frame],gifx,gify,null);
        frame++;

        if (frame > 11 ) {
            frame = 0;
        }

        gifx -= speed;

        //random positions
        if(gifx < -gifwitdh){
            gifx = x + number.nextInt(600);
            gify = number.nextInt(400);
            speed = 10 + number.nextInt(17);
        }

        handler.postDelayed(runnable,update);
    }
}
