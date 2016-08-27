package biitworx.sim.movie.moviez.data.game.setup;

import biitworx.sim.movie.moviez.data.game.movie.Genre;

/**
 * Created by marcel.weissgerber on 23.08.2016.
 */
public class GenreFactory {


    public static Genre getGenre(Genre.Genres genre){
        switch (genre){
            case Love:          return new Genre(genre,15000,25,2,2,20,true);
            case Action:        return new Genre(genre,40000,45,2,4,100,false);
            case Adventure:     return new Genre(genre,35000,40,3,3,200,true);
            case Comedy:        return new Genre(genre,20000,30,1,2,30,true);
            case Drama:         return new Genre(genre,25000,35,1,4,50,true);
            case Dokumentary:   return new Genre(genre,10000,25,1,2,20,true);
            case Animals:       return new Genre(genre,15000,30,1,1,10,false);
            case Animation:     return new Genre(genre,15000,25,2,4,250,false);
            case SciFi:         return new Genre(genre,50000,50,4,6,200,false);
            case Fantasy:       return new Genre(genre,45000,45,4,4,500,false);
            case Horror:        return new Genre(genre,30000,35,2,2,40,true);
            case Episode:       return new Genre(genre,25000,30,4,4,30,true);
            case Erotic:        return new Genre(genre,5000,10,4,8,100,false);
            case Pirates:       return new Genre(genre,35000,45,2,4,300,false);
            case Western:       return new Genre(genre,20000,25,2,2,100,true);
            case Eastern:       return new Genre(genre,30000,30,2,2,100,false);
            case Kids:          return new Genre(genre,15000,20,2,2,50,true);
            case Dance:         return new Genre(genre,25000,30,2,2,100,false);
        }
        return null;
    }
}

