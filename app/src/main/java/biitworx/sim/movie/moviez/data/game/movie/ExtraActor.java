package biitworx.sim.movie.moviez.data.game.movie;

import biitworx.sim.movie.moviez.data.BaseDataObject;
import biitworx.sim.movie.moviez.data.DbField;
import biitworx.sim.movie.moviez.data.DbTable;

/**
 * Created by marce_000 on 27.08.2016.
 */
@DbTable(name="extra_actors")
public class ExtraActor extends BaseDataObject {

    @DbField(name="n")
    private String name;
    @DbField(name="r")
    private int rating;

    public ExtraActor(){
        super();
    }

    public ExtraActor(String name,int rating){
        super();
        this.name = name;
        this.rating = rating;
        
    }


    @Override
    protected void imported() {

    }
}
