package com.example.androidgame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;

public class GameScreen extends View {
    int x,y ;
    Bitmap bitmap_background;
    Rect rectangle;

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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap_background,null,rectangle,null);
    }
}
