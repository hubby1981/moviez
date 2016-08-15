package biitworx.sim.movie.moviez.global;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import biitworx.sim.movie.moviez.Game;

/**
 * Created by marce_000 on 26.04.2016.
 */
public class B {

    public static Bitmap get(int id){
        return BitmapFactory.decodeResource(Game.res,id);
    }

    public static Bitmap get2(int id){
        return null;
    }

}
