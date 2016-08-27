package biitworx.sim.movie.moviez.data.game.movie;

import biitworx.sim.movie.moviez.data.BaseDataObject;
import biitworx.sim.movie.moviez.data.DbField;
import biitworx.sim.movie.moviez.data.DbTable;

/**
 * Created by marcel.weissgerber on 23.08.2016.
 */
@DbTable(name="fokus")
public class Fokus extends BaseDataObject {
    @DbField(name="n")
    private String name;
    @DbField(name="d")
    private int days;
    @DbField(name="f")
    private float factor;
    @DbField(name="t")
    private int internalFokuse;

    private Fokuse fokuse;

    public Fokus(){
        super();
    }
    public Fokus(Fokuse fokuse,int days,float factor){
        super();
        this.name=fokuse.name();
        this.days = days;
        this.factor = factor;
        this.fokuse = fokuse;
        this.internalFokuse = fokuse.ordinal();
    }

    @Override
    protected void imported() {
        fokuse = Fokuse.values()[internalFokuse];
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    public float getFactor() {
        return factor;
    }

    public enum Fokuse{
        Tension,
        Action,
        Drama,
        Feeling,
        Acting,
        Presentation,
        Character,
        Supporting,
        Directing,
        Animation,
        Effects,
        Music,
        Costume,
        Scenery,
        Erotic,
        Story,
        Camera,
        Ambient,
        Merchandising

    }
}
