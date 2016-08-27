package biitworx.sim.movie.moviez.data.game.movie;

import biitworx.sim.movie.moviez.data.BaseDataObject;
import biitworx.sim.movie.moviez.data.DbField;
import biitworx.sim.movie.moviez.data.DbTable;

/**
 * Created by marcel.weissgerber on 23.08.2016.
 */
@DbTable(name="genre")
public class Genre extends BaseDataObject {
    @DbField(name="n")
    private String name;
    @DbField(name="c")
    private long cost;
    @DbField(name="p")
    private int productionDays;
    @DbField(name="v")
    private boolean valid=false;
    @DbField(name="ma")
    private int mainActors;
    @DbField(name="sa")
    private int subActors;
    @DbField(name="oa")
    private int otherActors;
    @DbField(name="g")
    private int genre;

    private Genres thatGenre;

    public Genre(){
super();
    }

    public Genre(Genre.Genres genre,long cost,int productionDays,int mainActors,int subActors,int otherActors,boolean valid){
        super();
        this.name= genre.name();
        this.productionDays = productionDays;
        this.cost = cost;
        this.valid = valid;
        this.mainActors = mainActors;
        this.subActors = subActors;
        this.otherActors = otherActors;
        this.genre = genre.ordinal();
        this.thatGenre = genre;
    }



    @Override
    protected void imported() {
        thatGenre = Genres.values()[genre];
    }

    public String getName() {
        return name;
    }

    public long getCost() {
        return cost;
    }

    public int getProductionDays() {
        return productionDays;
    }

    public int getMainActors() {
        return mainActors;
    }

    public int getSubActors() {
        return subActors;
    }

    public int getOtherActors() {
        return otherActors;
    }

    public boolean isValid() {
        return valid;
    }

    public Genres getGenre() {
        return thatGenre;
    }

    public  enum Genres{
        Love,
        Action,
        Adventure,
        Comedy,
        Drama,
        Dokumentary,
        Animals,
        Animation,
        SciFi,
        Fantasy,
        Horror,
        Episode,
        Erotic,
        Pirates,
        Western,
        Kids,
        Dance,
        Eastern

        }
}
