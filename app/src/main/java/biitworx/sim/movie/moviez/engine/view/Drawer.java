package biitworx.sim.movie.moviez.engine.view;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by marce_000 on 15.08.2016.
 */
public abstract class Drawer {
    protected Rect bounds;
    protected Canvas canvas;
    protected abstract void onDraw();

    public void onDraw(Rect bounds,Canvas canvas){
        this.bounds = bounds;
        this.canvas = canvas;
        onDraw();
    }

    protected boolean canDraw(){
        return bounds !=null && canvas !=null;
    }
}
