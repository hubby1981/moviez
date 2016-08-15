package biitworx.sim.movie.moviez.engine.view.standard;

import android.content.Context;
import android.util.AttributeSet;

import biitworx.sim.movie.moviez.engine.view.Background;
import biitworx.sim.movie.moviez.engine.view.Drawer;

/**
 * Created by marce_000 on 15.08.2016.
 */
public class MainBackground extends Background {
    public MainBackground(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected Drawer provideDrawer() {
        return new BackgroundDrawer();
    }
}
