package biitworx.sim.movie.moviez.global;

import biitworx.sim.movie.moviez.Game;

/**
 * Created by marcel.weissgerber on 28.04.2016.
 */
public class TE {

    public static String get(int id){
        return Game.res.getString(id);
    }

    public static String getu(int id){
        return get(id).toUpperCase();
    }
}
