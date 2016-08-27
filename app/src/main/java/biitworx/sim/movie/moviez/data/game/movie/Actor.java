package biitworx.sim.movie.moviez.data.game.movie;

import biitworx.sim.movie.moviez.data.BaseDataObject;
import biitworx.sim.movie.moviez.data.DbField;
import biitworx.sim.movie.moviez.data.DbTable;

/**
 * Created by marcel.weissgerber on 24.08.2016.
 */
@DbTable(name = "actors")
public class Actor extends BaseDataObject {
    @DbField(name = "n")
    private String name;
    @DbField(name = "a")
    private int age;
    @DbField(name = "ac")
    private float acting;
    @DbField(name = "mo")
    private long moneyPerDay;
    @DbField(name="df")
    private float divaFactor;

    public Actor() {
        super();
    }

    public Actor(String name, int age, float acting, long moneyPerDay,float divaFactor) {
        super();
        this.name = name;
        this.age = age;
        this.acting = acting;
        this.moneyPerDay = moneyPerDay;
        this.divaFactor = divaFactor;
    }

    @Override
    protected void imported() {

    }


}
