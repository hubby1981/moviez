package biitworx.sim.movie.moviez.engine.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by marce_000 on 15.08.2016.
 */
public abstract class Background extends View {
    private Drawer drawer;
    public Background(Context context){
        super(context);
        this.drawer = provideDrawer();

    }
    public Background(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.drawer = provideDrawer();
    }

    protected abstract Drawer provideDrawer();

    @Override
    public void onDraw(Canvas canvas) {

        if (drawer != null) {
            drawer.onDraw(canvas.getClipBounds(), canvas);
        }
    }


}
