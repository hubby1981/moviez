package biitworx.sim.movie.moviez.global;

import android.graphics.Rect;

import biitworx.sim.movie.moviez.R;
import biitworx.sim.movie.moviez.engine.view.stripe.MovieStripe;

/**
 * Created by marcel.weissgerber on 17.08.2016.
 */
public class MenuStripesFactory {


    public static MovieStripe getMenuStripe(int index, Rect bounds){
        if(index==0) return new MovieStripe(bounds, B.get(R.drawable.icon1),TE.getu(R.string.menu_0)).hit(true);
        if(index==1) return new MovieStripe(bounds, B.get(R.drawable.icon0),TE.getu(R.string.menu_1));
        if(index==2) return new MovieStripe(bounds, B.get(R.drawable.icon2),TE.getu(R.string.menu_2));
        if(index==3) return new MovieStripe(bounds, B.get(R.drawable.icon3),TE.getu(R.string.menu_3));
        if(index==4) return new MovieStripe(bounds, B.get(R.drawable.icon4),TE.getu(R.string.menu_4));
        if(index==5) return new MovieStripe(bounds, B.get(R.drawable.icon5),TE.getu(R.string.menu_5));
        if(index==6) return new MovieStripe(bounds, B.get(R.drawable.icon6),TE.getu(R.string.menu_6));
        if(index==7) return new MovieStripe(bounds, B.get(R.drawable.icon7),TE.getu(R.string.menu_7));
        if(index==8) return new MovieStripe(bounds, B.get(R.drawable.icon8),TE.getu(R.string.menu_8));
        if(index==9) return new MovieStripe(bounds, B.get(R.drawable.icon9),TE.getu(R.string.menu_9));

        //Right Side
        if(index==10) return new MovieStripe(bounds, B.get(R.drawable.icon10),"ROOMS");
        if(index==11) return new MovieStripe(bounds, B.get(R.drawable.icon11),"MEDIA");

        return new MovieStripe(bounds);
    }
}
