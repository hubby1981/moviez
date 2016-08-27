package biitworx.sim.movie.moviez.engine.view.visuals;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by marce_000 on 27.08.2016.
 */
public class Button {
    private Rect bounds;
    private String title;
    private int backColor = Color.argb(255, 210,210,210);
    private int lineColor = Color.argb(255, 0, 30, 60);

    public Button(Rect bounds, String title) {
        this.bounds = bounds;
        this.title = title;
    }

    public void draw(Canvas canvas) {

        Paint painterBack = new Paint();
        painterBack.setColor(backColor);
        painterBack.setStyle(Paint.Style.FILL);


        Paint painterLine = new Paint();
        painterLine.setColor(lineColor);
        painterLine.setStyle(Paint.Style.STROKE);

        RectF bo = new RectF(bounds.left, bounds.top, bounds.right, bounds.bottom);
        float r = bo.width() / 20;
        if(r<8)
            r=8;

        canvas.drawRoundRect(bo, r, r, painterBack);
        canvas.drawRoundRect(bo, r, r, painterLine);
        painterLine.setTextSize(bounds.height()/2);

        float tx = painterLine.measureText(title);




        canvas.drawText(title,bounds.exactCenterX()-tx/2,bounds.exactCenterY()+tx/16,painterLine);

    }
}
