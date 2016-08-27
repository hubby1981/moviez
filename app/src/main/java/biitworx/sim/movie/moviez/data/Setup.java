package biitworx.sim.movie.moviez.data;

import java.util.ArrayList;
import java.util.List;

import biitworx.sim.movie.moviez.data.game.PlayerData;
import biitworx.sim.movie.moviez.data.game.movie.Actor;
import biitworx.sim.movie.moviez.data.game.movie.ExtraActor;
import biitworx.sim.movie.moviez.data.game.movie.Fokus;
import biitworx.sim.movie.moviez.data.game.movie.Genre;
import biitworx.sim.movie.moviez.data.game.movie.Movie;
import biitworx.sim.movie.moviez.data.helper.ObjectHelper;

/**
 * Created by marcel.weissgerber on 09.05.2016.
 */
public class Setup {
    private List<Class> tables;
    private SecureDataSetup secure;

    public Setup() {
        secure = new SecureDataSetup();
        tables = new ArrayList<>();

        ///TODO: tables to add
        tables.add(Genre.class);
        tables.add(PlayerData.class);
        tables.add(Fokus.class);
        tables.add(Actor.class);
        tables.add(ExtraActor.class);
        tables.add(Movie.class);
}

    public SecureDataSetup secure() {
        return secure;
    }

    public List<String> getCreateTables() {
        List<String> result = new ArrayList<>();
        for (Class c : tables) {
            String statement = ObjectHelper.createTableStatement(c);
            if (statement != null)
                result.add(statement);
            List<String> refs = ObjectHelper.createReferenceTableStatement(c);
            for (String s : refs)
                if (s != null)
                    result.add(s);
        }
        return result;
    }

    public List<String> getDropTables() {
        List<String> result = new ArrayList<>();
        for (Class c : tables) {
            String statement = ObjectHelper.createDropTableStatement(c);
            if (statement != null)
                result.add(statement);
            List<String> refs = ObjectHelper.createDropReferenceTableStatement(c);
            for (String s : refs)
                if (s != null)
                    result.add(s);
        }
        return result;
    }
}
