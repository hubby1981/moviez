package biitworx.sim.movie.moviez.data.game;


import biitworx.sim.movie.moviez.data.BaseDataObject;
import biitworx.sim.movie.moviez.data.DbField;
import biitworx.sim.movie.moviez.data.DbTable;

/**
 * Created by marce_000 on 29.05.2016.
 */
@DbTable(name="players")
public class PlayerData extends BaseDataObject {
    @DbField(name="name")
    private String name;
    @DbField(name="day")
    private int day;
    @DbField(name="month")
    private int month;
    @DbField(name="year")
    private int year;
    @DbField(name="race")
    private int race;



    @Override
    protected void imported() {

    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
}
