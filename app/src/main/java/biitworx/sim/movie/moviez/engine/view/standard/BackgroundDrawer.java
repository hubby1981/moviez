package biitworx.sim.movie.moviez.engine.view.standard;

import biitworx.sim.movie.moviez.R;
import biitworx.sim.movie.moviez.engine.view.Drawer;
import biitworx.sim.movie.moviez.global.B;
import biitworx.sim.movie.moviez.global.BitmapDrawer;

/**
 * Created by marce_000 on 15.08.2016.
 */
public class BackgroundDrawer extends Drawer {
    @Override
    protected void onDraw() {
        if(!canDraw()) return;


        BitmapDrawer.drawImage(B.get(R.drawable.back),canvas,bounds,null,false);
    }
}
