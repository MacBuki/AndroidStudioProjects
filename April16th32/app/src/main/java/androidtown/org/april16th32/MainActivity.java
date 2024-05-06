package androidtown.org.april16th32;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyDrawEx(this));
    }

    public static class MyDrawEx extends View {
        private int currentFrameIndex = 0;
        private Bitmap fullImage;
        private int charWidth;
        private Paint paint;

        public MyDrawEx(Context c) {
            super(c);
            init();
        }

        public MyDrawEx(Context c, AttributeSet a) {
            super(c, a);
            init();
        }

        private void init() {
            fullImage = BitmapFactory.decodeResource(getResources(), R.drawable.human);
            charWidth = (fullImage.getWidth() -100) / 8; // Assuming there are 8 frames.
            paint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.WHITE);

            // Calculate the x-coordinate for the current frame.
            int xCoord = currentFrameIndex * charWidth;

            // Create a Bitmap for the current frame.
            Bitmap currentChar = Bitmap.createBitmap(fullImage, xCoord, 0, charWidth, fullImage.getHeight());

            // Draw the current frame on the canvas.
            canvas.drawBitmap(currentChar, 0, 0, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Increment the frame index and ensure it wraps around, assuming 8 frames.
                currentFrameIndex = (currentFrameIndex + 1) % 8;
                invalidate();
                return true;
            }
            return super.onTouchEvent(event);
        }
    }
}
