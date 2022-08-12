package com.jhajharia.music;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Shuffle extends View {
    boolean shuffle = false;

    Paint paint;
    int sw = 5;
    int h;
    int w;

    public Shuffle (Context context) {
        super(context);
    }
    public Shuffle (Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        sw = 5;
        if (!shuffle) {
            sw /= 2;
        }

        paint = new Paint();
        paint.setColor(0xff000000);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(sw);

        h = canvas.getHeight();
        w = canvas.getWidth();

        int t = (w - h) / 2;

        // cross
        canvas.drawLine(w - h - sw - t, sw, w - sw - t, h - sw, paint); // Top-left to bottom-right
        canvas.drawLine(w - h - sw - t, h - sw, w - sw - t, sw, paint); // Bottom-left to top-right

        // top arrow
        canvas.drawLine(w - 2 * h / 5 - t, sw, w - t - sw / 2, sw, paint); // Upper
        canvas.drawLine(w - sw - t, sw, w - sw - t, 2 * h / 5, paint); // Lower

        // bottom arrow
        canvas.drawLine(w - sw - t, 3 * h / 5, w - sw - t, h - sw, paint); // Upper
        canvas.drawLine(w - 2 * h / 5 - t, h - sw, w - sw / 2 - t, h - sw, paint); // Lower
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        shuffle = !shuffle;
        invalidate();
        return super.onTouchEvent(event);
    }
}
