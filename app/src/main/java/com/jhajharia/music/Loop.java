package com.jhajharia.music;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Loop extends View {
    int loop = 2;
    Paint paint;
    int sw = 5;
    int h;
    int w;

    public Loop (Context context) {
        super(context);
    }
    public Loop (Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        sw = 5;
        if (loop == 2) {
            sw /= 2;
        }
        paint = new Paint();
        paint.setColor(0xff000000);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(sw);

        h = canvas.getHeight();
        w = canvas.getWidth();


        canvas.drawLine(w / 5 - 3 * sw / 4, h / 5, 4 * w / 5 - sw / 2, h / 5, paint); // Horizontal top
        canvas.drawLine(w / 5, 4 * h / 5, 4 * w / 5 + 3 * sw / 4, 4 * h / 5, paint); // Horizontal bottom

        canvas.drawLine(w / 5, h / 5, w / 5, 3 * h / 5, paint); // Vertical left
        canvas.drawLine(4 * w / 5, 2 * h / 5, 4 * w / 5, 4 * h / 5, paint); // Vertical right

        // top arrow
        canvas.drawLine(3 * w / 5, 0, 4 * w / 5, h / 5 + sw / 3, paint); // Upper
        canvas.drawLine(3 * w / 5, 2 * h / 5, 4 * w / 5, h / 5 - sw / 3, paint); // Lower

        // bottom arrow
        canvas.drawLine(w / 5, 4 * h / 5 + sw / 3, 2 * w / 5, 3 * h / 5, paint); // Upper
        canvas.drawLine(w / 5, 4 * h / 5 - sw / 3, 2 * w / 5, h, paint); // Lower

        if (loop == 1) { // One
            int y = 69 * h / 100;
            canvas.drawLine(w / 2 + sw, h - y, w / 2 + sw, y, paint); // vertical
            canvas.drawLine(w / 2 + sw, h - y, w / 2 - 3 * sw / 4, h - 4 * y / 5, paint); // slant
            canvas.drawLine(w / 2 - sw, y, w / 2 + 3 * sw, y, paint); // base
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        loop++;
        loop %= 3;
        invalidate();
        return super.onTouchEvent(event);
    }
}
