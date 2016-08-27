package biitworx.sim.movie.moviez.data.game.movie;

import java.util.ArrayList;
import java.util.List;

import biitworx.sim.movie.moviez.data.BaseDataObject;
import biitworx.sim.movie.moviez.data.DbField;
import biitworx.sim.movie.moviez.data.DbReference;
import biitworx.sim.movie.moviez.data.DbTable;

/**
 * Created by marcel.weissgerber on 23.08.2016.
 */
@DbTable(name = "movies")
public class Movie extends BaseDataObject {
    @DbField(name = "t")
    private String title;
    @DbReference(items = Actor.class)
    List<Actor> movieActors = new ArrayList<>();
    @DbReference(items = Actor.class)
    List<Actor> movieSubActors = new ArrayList<>();
    @DbField(name = "s")
    private int internalStatus;
    private Making status;
    @DbField(name = "b")
    private int internalBudget;
    private Budget budget;
    @DbReference(items = Fokus.class)
    private List<Fokus> movieFokus = new ArrayList<>();

    @DbReference(items = Genre.class)
    private List<Genre> movieGenre = new ArrayList<>();

    public Movie() {
        super();

    }

    public Movie(String title) {
        this();
        this.title = title;
    }


    @Override
    protected void imported() {
        this.status =Making.values()[internalStatus];
        this.budget = Budget.values()[internalBudget];
    }

    public List<Genre> getGenre() {
        return movieGenre;
    }


    public Making getStatus() {
        return status;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
        this.internalBudget = budget.ordinal();

    }

    public void setStatus(Making status) {
        this.status = status;
        this.internalStatus = status.ordinal();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Actor> getActors() {
        return movieActors;
    }

    public List<Actor> getSubActors() {
        return movieSubActors;
    }

    public List<Fokus> getFokus() {
        return movieFokus;
    }


    public enum Making {
        Planning,
        Produktion,
        Processing,
        Released
    }

    public enum Budget {
        Low,                //1 Element wie Studio
        Medium,             //2 Elemente wie Studio
        Blockbuster         //4 Studios, etc.
    }
}
