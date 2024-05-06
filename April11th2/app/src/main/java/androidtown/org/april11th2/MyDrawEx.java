package org.android.customview.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class MyDrawEx extends View {

    // Constructor used when creating the view programmatically.
    public MyDrawEx(Context context) {
        super(context);
    }

    // Constructor used when inflating the view from XML.
    public MyDrawEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Initialize a Paint object with red color and stroke style
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5); // Set stroke width

        // Set the canvas background color
        canvas.drawColor(Color.WHITE);

        // Draw lines to create a pattern
        for (int x = 0; x <= 200; x += 5) {
            canvas.drawLine(x, 0, 200 - x, 100, paint);
        }
    }
}
