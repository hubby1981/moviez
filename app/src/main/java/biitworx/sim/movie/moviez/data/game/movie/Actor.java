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
    @DbField(name = "rp")
    private float rolePlaying;
    @DbField(name = "mo")
    private long moneyPerDay;
    @DbField(name = "df")
    private float divaFactor;
    @DbField(name = "gd")
    private int gender;

    public Actor() {
        super();
    }

    public Actor(String name, int age, long moneyPerDay, int gender) {
        super();
        this.name = name;
        this.age = age;
        this.moneyPerDay = moneyPerDay;
        this.gender = gender;
    }

    public Actor diva(float divaFactor) {
        this.divaFactor = divaFactor;
        return this;
    }

    public Actor role(float rolePlaying) {
        this.rolePlaying = rolePlaying;
        return this;
    }

    public Actor act(float actFactor) {
        this.acting = actFactor;
        return this;
    }

    @Override
    protected void imported() {

    }


}
