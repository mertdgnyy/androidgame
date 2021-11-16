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


//Ali Mert Doganay
public class GameScreen extends View {
    static int dx,dy ;
    ArrayList<Images> prof;
    Bitmap bitmap_background;
    Rect rectangle;
    Handler handler;
    Runnable runnable;
    final long update = 30;
    Bitmap book,aimer;
    float tempPositionx, tempPositiony = 0; // will be used for the calculating temporary position of the bookPosition
    float bookx,booky = 0;
    float touchx,touchy = 0; // The first place of coordinates user touches the screen
    float dragx,dragy = 0; // coordinates of the aim button while dragging it to the below
    float bookPositionx, bookPositiony = 0;


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
        for(int x=0; x < prof.size(); x++) { // prof.get(x) simply refers for the index in the for loop.
            canvas.drawBitmap(prof.get(x).tBitmap(), prof.get(x).gifx, prof.get(x).gify, null);
            // we are creating our new bitmaps with this for loop but we need to increase frame variable also
            prof.get(x).frame += 1;
            if (prof.get(x).frame > 11) { // resetting the frame after completing the animation of the gif-bitmap
                prof.get(x).frame = 0;
            }
            prof.get(x).gifx -= prof.get(x).speed; //decreasing the x cord. of the gif(bitmap)(or prof) by the speed of it.
            if (prof.get(x).gifx < -prof.get(x).tWidth()) { // if bitmap reaches the left side we should reset the position from beginning of the right side

                prof.get(x).positionReset();
            }

            // In my game, if the book's left edge is less than prof's right edge ,
            // if the book's right edge is greater than prof's left edge,
            // If the book's y coordinate, is greater than prof's bottom edge,
            // If the book's y coordinate is less than prof's top edge,
            // If these 4 conditions satisfies, collision detection satisfies, that means
            // book is inside of the prof bitmap, and I will terminate the flying bitmaps like they are shooted by the aimer.
            if (booky <= (prof.get(x).gify + prof.get(x).tHeight()) &&
                    booky >= prof.get(x).gify &&
                    bookx <= (prof.get(x).gifx + prof.get(x).tWidth()) &&
                    bookx + book.getWidth() >= prof.get(x).gifx) {
                prof.get(x).positionReset();


            }
        }

        // When user started to drag the aimer on screen, draw aimer bitmap.
        if(dragx > 0){
            canvas.drawBitmap(aimer,dragx-aimer.getWidth()/2,dragy-aimer.getHeight()/2,null );
        }

        // when user stops to dragging with the value grater than 0 I draw bitmap.
        //In this case, I took the abs of the values since the value can be negative or positive.
        // Because if user drags from left side to right side it will definitely a positive value.
        // But if drags from right to left it will be negative, so I take the abs of it.
        if(Math.abs(dragy - touchy) > 0 || Math.abs(dragx - touchx) > 0 ){
            canvas.drawBitmap(aimer,touchx-aimer.getWidth()/2,touchy-aimer.getHeight()/2,null );
        }


        //It was the most difficult part for me to implement.
        // Simply, if the bookposition is greater than a value that I determined
        // I increment tempPositions with the book positions that enables me
        // to move the aimer bitmap in a correct forward path.
        if(Math.abs(bookPositionx) > 2 || Math.abs(bookPositiony) < 2){
            bookx = dragx - book.getWidth()/2 - tempPositionx;
            booky = dragy - book.getHeight()/2 - tempPositiony;
            canvas.drawBitmap(book,bookx,booky,null);
            tempPositiony += bookPositiony;
            tempPositionx += bookPositionx;

        }

        handler.postDelayed(runnable,update);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) { //touching the aimer
        switch(event.getAction()){
            case MotionEvent.ACTION_UP: // when user stop the dragging point
                dragx = event.getX();
                dragy = event.getY();

                bookx = event.getX();   // the point where books started to be shooted from the point user stops dragging aim button
                booky = event.getY();

                bookPositionx = dragx - touchx;
                bookPositiony = dragy - touchy;

                break;
            case MotionEvent.ACTION_DOWN: //touch
                touchy = event.getY();
                touchx = event.getX();

                // Each time when user interacts with the aim button I reset the variables to the 0 in order to produce new bitmaps.
                dragx = dragy = tempPositionx = tempPositiony = bookPositiony = bookPositionx = 0;
                break;
            case MotionEvent.ACTION_MOVE: //drag
                dragx = event.getX();
                dragy = event.getY();
                break;


        }
        return true;
    }
}
