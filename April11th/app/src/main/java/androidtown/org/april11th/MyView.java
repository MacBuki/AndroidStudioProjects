package androidtown.org.april11th; // Use your actual package name

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
        // Initialize your view and paint objects here
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Your custom drawing code here
        Paint paint = new Paint();
        paint.setColor(Color.BLUE); // Set the paint to blue color
        canvas.drawColor(Color.RED); // Fill the canvas with red color
        canvas.drawCircle(200, 200, 50, paint); // Draw a blue circle
    }
}
