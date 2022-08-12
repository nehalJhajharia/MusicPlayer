package com.jhajharia.music;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Play extends View {
    boolean play = true;
    Paint paint;
    int r;
    int sw = 5;

    public Play (Context context) {
        super(context);
    }
    public Play (Context context, AttributeSet attributeSet) {
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
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        r = canvas.getHeight() - 2 * sw;
        r /= 2;

        canvas.drawCircle(r + sw, r + sw, r, paint);
        if (!play) {
            canvas.drawLine(2*r/3 + sw , r/2 + sw, 2*r/3 + sw , 2*r + sw - r/2, paint); // Vertical left
            canvas.drawLine(4*r/3 + sw , r/2 + sw, 4*r/3 + sw , 2*r + sw - r/2, paint); // Vertical right
        } else { // triangle
            int x1 = 3 * r / 4 + sw;
            int x2 = r / 2;
            int l = canvas.getHeight() - 2*x2;

            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            Path path = new Path();
            path.moveTo(x1, x2);
            path.lineTo(x1, x2+l);
            path.lineTo(2*x1, x2+l/2);
            path.lineTo(x1, x2);
            path.close();

            canvas.drawPath(path, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        play = !play;
        invalidate();
        return super.onTouchEvent(event);
    }
}
