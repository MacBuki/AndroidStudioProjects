package androidtown.org.april11th;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(this);
        setContentView(myView);
    }

    protected class MyView extends View {
        public MyView(Context context){
            super(context);
        }
        /*@Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint pnt = new Paint();
            pnt.setColor(Color.BLUE);
            canvas.drawColor(Color.RED);
            canvas.drawCircle(200, 200, 50, pnt);
        }

         */
        /*
        @Override
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            // Initialize Paint with anti-aliasing
            Paint Pnt = new Paint(Paint.ANTI_ALIAS_FLAG);
            Pnt.setStrokeWidth(8); // Set the stroke width to 8 pixels
            Pnt.setColor(Color.RED); // Set the paint color to red

            // Draw a circle filled with red color
            Pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50, 50, 40, Pnt);

            // Draw a circle with a red outline
            Pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150, 50, 40, Pnt);

            // Draw a circle filled and stroked with red color
            Pnt.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(250, 50, 40, Pnt);

            // Draw a circle filled with blue and stroked with red
            Pnt.setColor(Color.BLUE);
            Pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50, 150, 40, Pnt);
            Pnt.setColor(Color.RED);
            Pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(50, 150, 40, Pnt);

            // Draw a circle stroked with red and filled with blue
            Pnt.setColor(Color.RED);
            Pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150, 150, 40, Pnt);
            Pnt.setColor(Color.BLUE);
            Pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(150, 150, 40, Pnt);
        }

         */
        /*
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint Pnt = new Paint(Paint.ANTI_ALIAS_FLAG);

            // Test stroke cap shapes
            Pnt.setColor(Color.BLUE);
            Pnt.setStrokeWidth(16);

            // Default stroke cap (BUTT)
            canvas.drawLine(50, 30, 240, 30, Pnt);

            // ROUND stroke cap
            Pnt.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(50, 60, 240, 60, Pnt);

            // SQUARE stroke cap
            Pnt.setStrokeCap(Paint.Cap.SQUARE);
            canvas.drawLine(50, 90, 240, 90, Pnt);

            // Test stroke join shapes
            Pnt.setColor(Color.BLACK);
            Pnt.setStrokeWidth(20);
            Pnt.setStyle(Paint.Style.STROKE);

            // MITER stroke join
            Pnt.setStrokeJoin(Paint.Join.MITER);
            canvas.drawRect(50, 150, 90, 200, Pnt);

            // BEVEL stroke join
            Pnt.setStrokeJoin(Paint.Join.BEVEL);
            canvas.drawRect(120, 150, 160, 200, Pnt);

            // ROUND stroke join
            Pnt.setStrokeJoin(Paint.Join.ROUND);
            canvas.drawRect(190, 150, 230, 200, Pnt);
        }
         */
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Path path = new Path();
            canvas.drawColor(Color.WHITE); // Set the background color of the canvas to white

            Paint Pnt = new Paint();
            Pnt.setStrokeWidth(5); // Set the stroke width
            Pnt.setColor(Color.RED); // Set the paint color to red
            Pnt.setStyle(Paint.Style.STROKE); // Set the style to stroke to draw outlines

            // Define a rectangle and circle in the path and draw them
            path.addRect(100, 100, 150, 190, Path.Direction.CW); // corrected coordinates for visibility
            path.addCircle(50, 50, 40, Path.Direction.CW); // Add a circle to the path
            canvas.drawPath(path, Pnt); // Draw the path with the paint settings

            // Reset the path and define new lines
            path.reset(); // Clears the path
            path.moveTo(10, 110); // Move to the starting point
            path.lineTo(50, 150); // Draw a line
            path.lineTo(400, 10); // Draw another line

            // Change paint settings for the new path
            Pnt.setStrokeWidth(3); // Set a thinner stroke width
            Pnt.setColor(Color.BLUE); // Change the color to blue
            canvas.drawPath(path, Pnt); // Draw the new path

            // Draw text along the path
            Pnt.setTextSize(20); // Set text size for the paint
            Pnt.setStyle(Paint.Style.FILL); // Change style to fill for the text
            canvas.drawTextOnPath("Text on Path.", path, 0, 0, Pnt); // Draw text along the path
        }



    }
}