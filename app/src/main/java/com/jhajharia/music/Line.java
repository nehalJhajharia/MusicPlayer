package com.jhajharia.music;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Line extends View {
    Paint paint;
    int sw = 3;
    int x;
    int y;

    public Line (Context context) {
        super(context);
    }
    public Line (Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint = new Paint();
        paint.setColor(0x55555555);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(sw);
        paint.setStyle(Paint.Style.STROKE);

        y = (canvas.getHeight() - sw) / 2;
        x = canvas.getWidth();

        canvas.drawLine(x / 20, y, 19 * x / 20, y, paint);
    }
}
