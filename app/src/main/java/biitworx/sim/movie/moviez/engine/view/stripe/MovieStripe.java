package biitworx.sim.movie.moviez.engine.view.stripe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;

import biitworx.sim.movie.moviez.global.BitmapDrawer;

/**
 * Created by marcel.weissgerber on 16.08.2016.
 */
public class MovieStripe {

    protected static int back001 = Color.argb(255, 45, 55, 65);
    protected static int back002 = Color.argb(255, 180, 190, 200);
    protected static int back003 = Color.argb(255, 180, 220, 240);

    private String text;
    private String text2;

    private int colorText2 = Color.DKGRAY;

    private Paint backPainter;
    private Paint backPainter2;
    private Paint backPainter3;
    private Paint backPainter4;

    private Rect bounds = null;

    private int width = 0;

    private Bitmap icon = null;

    public boolean isHit = false;

    private RectF middle = null;

    private boolean loop = false;

    public boolean checkHit(int x, int y) {
        if (icon == null || text == null) return false;
        y -= (bounds.height() / 2);
        isHit = bounds.contains(x, y);
        return isHit;
    }

    public MovieStripe(Rect bounds) {
        this.bounds = bounds;

        backPainter = new Paint();
        backPainter.setStyle(Paint.Style.FILL);
        backPainter.setColor(back001);
        backPainter3 = new Paint();
        backPainter3.setStyle(Paint.Style.FILL);
        backPainter3.setColor(back002);


    }

    public MovieStripe(Rect bounds, Bitmap icon) {
        this(bounds);
        this.icon = icon;

    }

    public MovieStripe(Rect bounds, Bitmap icon, String text) {
        this(bounds, icon);
        this.text = text;
    }

    public MovieStripe hit(boolean hit) {
        isHit = hit;
        return this;
    }

    public MovieStripe loop(boolean loop) {
        this.loop = loop;
        return this;
    }

    public MovieStripe text(String text) {
        this.text = text;
        return this;
    }

    public MovieStripe text2(String text) {
        this.text2 = text;
        return this;
    }

    public MovieStripe color2(int color) {
        this.colorText2 = color;
        return this;
    }

    public void draw(Canvas canvas) {
        backPainter2 = new Paint();
        backPainter2.setStyle(Paint.Style.FILL);
        backPainter2.setColor(isHit ? back003 : back002);


        if (bounds == null && canvas == null) return;
        width = bounds.width() / 16;

        canvas.drawRect(bounds, backPainter);
        if (loop) {
            drawBoundedRectsLoop(canvas);
        } else {
            drawBoundedRects(canvas);

        }
        int x = bounds.centerX() - bounds.width() / 4;
        int y = bounds.centerY() - bounds.height() / 4;
        int xx = bounds.centerX() + bounds.width() / 4;
        int yy = bounds.centerY() + bounds.height() / 4;

        int bo = loop ? bounds.height() / 6 : bounds.height() / 8;
        if (icon != null) {


            Rect disp = new Rect(x, y - bo, xx, yy - bo);

            BitmapDrawer.drawImage(icon, canvas, disp, null, true);


        }

        if (text != null) {
            Paint t = new Paint();
            t.setColor(Color.DKGRAY);
            t.setTextSize(loop ? bo : (int) (bo * 1.25));
            t.setFakeBoldText(true);
            Rect tb = new Rect(x, yy, xx, loop ? yy - (int) (bo * 2f) : yy + bo);

            float size = t.measureText(text);

            canvas.drawText(text, tb.exactCenterX() - size / 2, tb.exactCenterY() + bo, t);

            if (text2 != null && loop) {
                tb = new Rect(x, yy, xx, yy - bo * 6);
                t.setTextSize(loop ? bo : (int) (bo * 1.25));
                t.setColor(colorText2);

                size = t.measureText(text2);

                canvas.drawText(text2, tb.exactCenterX() - size / 2, tb.exactCenterY() + bo, t);
            }
        }

    }

    private void drawBoundedRects(Canvas canvas) {

        RectF left1 = new RectF(bounds.left + width, bounds.top, bounds.left + width * 2, bounds.top + width);
        RectF right1 = new RectF(bounds.right - width * 2, bounds.top, bounds.right - width, bounds.top + width);
        RectF left2 = new RectF(bounds.left + width, bounds.bottom - width, bounds.left + width * 2, bounds.bottom);
        RectF right2 = new RectF(bounds.right - width * 2, bounds.bottom - width, bounds.right - width, bounds.bottom);

        int w = width / 2;

        middle = new RectF(left1.right + width, bounds.top + w, right1.left - width, bounds.bottom - w);

        canvas.drawRect(left1, backPainter2);
        canvas.drawRect(left2, backPainter2);
        canvas.drawRect(right1, backPainter2);
        canvas.drawRect(right2, backPainter2);

        canvas.drawRect(middle, backPainter2);


        RectF betweenLeft = new RectF(left1.left, left1.bottom + width, left1.right, left2.top - width);

        RectF betweenRight = new RectF(right1.left, left1.bottom + width, right1.right, left2.top - width);

        int r = (int) (betweenLeft.height() - width) / (width * 4);
        float y1 = betweenLeft.top + width;


        for (int i = 0; i <= r; i++) {

            float l = y1 + width * 2;


            RectF df = new RectF(betweenLeft.left, y1, betweenLeft.left + width, l);
            canvas.drawRect(df, backPainter2);

            df = new RectF(betweenRight.left, y1, betweenRight.left + width, l);

            canvas.drawRect(df, backPainter2);
            y1 += width * 4;
        }
    }

    private void drawBoundedRectsLoop(Canvas canvas) {

        RectF left1 = new RectF(bounds.left, bounds.top + width / 2, bounds.left + width, bounds.top + width * 1.15f);
        RectF right1 = new RectF(bounds.right - width, bounds.top + width / 2, bounds.right, bounds.top + width * 1.15f);

        RectF left2 = new RectF(bounds.left, bounds.bottom - width * 1.15f, bounds.left + width, bounds.bottom - width / 2);
        RectF right2 = new RectF(bounds.right - width, bounds.bottom - width * 1.15f, bounds.right, bounds.bottom - width / 2);

        int w = width / 2;

        middle = new RectF(left1.left + w, bounds.top + w * 4, right1.right - w, bounds.bottom - w * 4);

        canvas.drawRect(left1, backPainter2);
        canvas.drawRect(left2, backPainter2);
        canvas.drawRect(right1, backPainter2);
        canvas.drawRect(right2, backPainter2);

        canvas.drawRect(middle, backPainter2);


        RectF betweenLeft = new RectF(left1.right + width, left1.top, right1.left - width, left1.top + width);

        RectF betweenRight = new RectF(left2.left + width, left2.top, right2.left - width, left2.top + width);

        int r = (int) (betweenLeft.width() - width) / (width * 2);
        float y1 = betweenLeft.left + width;


        for (int i = 0; i <= r; i++) {

            float l = y1 + width * 1.5f;


            RectF df = new RectF(y1, betweenLeft.top, l, betweenLeft.top + width / 1.5f);
            canvas.drawRect(df, backPainter2);

            df = new RectF(y1, betweenRight.top, l, betweenRight.top + width / 1.5f);


            canvas.drawRect(df, backPainter2);
            y1 += width * 4;
        }
    }
}
