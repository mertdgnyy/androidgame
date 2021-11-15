package com.example.androidgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Images {

    Bitmap gif[] = new Bitmap[12];
    int gifx,gify;
    int speed, frame;
    Random number;

    public Images(Context context){

        gif[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.a1);
        gif[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.a2);
        gif[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.a3);
        gif[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.a4);
        gif[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.a5);
        gif[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.a6);
        gif[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.a7);
        gif[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.a8);
        gif[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.a9);
        gif[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.a10);
        gif[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.a11);
        gif[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.a12);

        number = new Random();
        gifx = GameScreen.x + number.nextInt(600);
        gify = number.nextInt(400);
        speed = 10 + number.nextInt(10);
        frame = 0;
    }
}
