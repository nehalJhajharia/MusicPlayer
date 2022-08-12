package com.jhajharia.music;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SeekFor extends View {
    Paint paint;
    int sw = 5;

    public SeekFor (Context context) {
        super(context);
    }
    public SeekFor (Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint = new Paint();
        paint.setColor(0xff000000);
        paint.setStrokeWidth(sw);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);


        int x = canvas.getHeight();

        // left arrow
        canvas.drawLine(0, 0, x / 2, x / 2 + sw / 3, paint); // Slant top
        canvas.drawLine(0, x, x / 2, x / 2 - sw / 3, paint); // Slant bottom

        int gap = x / 5;
        // right arrow
        canvas.drawLine(0 + gap, 0, x / 2 + gap, x / 2 + sw / 3, paint); // Slant top
        canvas.drawLine(0 + gap, x, x / 2 + gap, x / 2 - sw / 3, paint); // Slant bottom
    }
}
