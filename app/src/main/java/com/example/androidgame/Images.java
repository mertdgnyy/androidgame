package com.example.androidgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

//Ali Mert Doganay
public class Images {

    Bitmap gif[] = new Bitmap[12];
    int gifx,gify;
    int speed, frame;
    Random number;

    public Images(Context context){

        gif[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.profgif1);
        gif[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.profgif2);
        gif[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.profgif3);
        gif[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.profgif4);
        gif[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.profgif5);
        gif[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.profgif6);
        gif[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.profgif7);
        gif[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.profgif8);
        gif[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.profgif9);
        gif[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.profgif10);
        gif[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.profgif11);


        number = new Random();

        frame = 0;
        positionReset();
    }

    public void positionReset(){

        gifx = GameScreen.dx + number.nextInt(500);
        gify = number.nextInt(400);
        speed = 10 + number.nextInt(5);
    }

    public Bitmap tBitmap(){
        return gif[frame]; //Method for getting the bitmap according to frame size
    }

    public int tWidth(){
        return gif[0].getWidth(); // It was in the GameScreen.java class that simply used for getting width of the bitmap
    }

    public int tHeight(){
        return gif[0].getHeight(); //It was in the GameScreen.java class that simply used for getting height of the bitmap
    }

}
