package biitworx.sim.movie.moviez.data.game;

import java.util.List;

import biitworx.sim.movie.moviez.data.game.movie.Fokus;
import biitworx.sim.movie.moviez.data.game.movie.Genre;
import biitworx.sim.movie.moviez.data.game.movie.Movie;
import biitworx.sim.movie.moviez.data.game.setup.FokusFactory;
import biitworx.sim.movie.moviez.data.game.setup.GenreFactory;
import biitworx.sim.movie.moviez.data.helper.DbHelper;

/**
 * Created by marce_000 on 11.09.2016.
 */
public class BaseSetup {

    private static DbHelper DATA;
    public static PlayerData playerData;
    public static void checkSetup(DbHelper data) {
        DATA = data;
        List<PlayerData> players = DATA.getData(PlayerData.class, DATA.get(), true);
        List<Genre> genreList = DATA.getData(Genre.class, DATA.get(), true);
        List<Fokus> fokusList = DATA.getData(Fokus.class, DATA.get(), true);

        generatePlayer(players);

        generateGenre(genreList);


        generateFokuse(fokusList);


        List<Movie> movies = DATA.getData(Movie.class, DATA.get(), true);

    }

    private static void generatePlayer(List<PlayerData> players) {
        if (players.size() == 0) {
            playerData = new PlayerData("");
            DATA.insert(playerData, true, DATA.get());
        } else {
            playerData = players.get(0).setMoney(750000);
            DATA.insert(playerData, false, DATA.get());
        }
    }

    private static void generateGenre(List<Genre> genreList) {
        if (genreList.size() == 0) {
            genreList.add(GenreFactory.getGenre(Genre.Genres.Love));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Action));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Adventure));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Comedy));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Drama));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Dokumentary));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Animals));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Animation));
            genreList.add(GenreFactory.getGenre(Genre.Genres.SciFi));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Fantasy));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Horror));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Episode));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Erotic));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Pirates));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Western));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Eastern));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Kids));
            genreList.add(GenreFactory.getGenre(Genre.Genres.Dance));


            for (Genre g : genreList)
                DATA.insert(g, true, DATA.get());

        }
    }

    private static void generateFokuse(List<Fokus> fokusList) {
        if (fokusList.size() == 0) {
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Tension));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Action));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Drama));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Feeling));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Acting));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Presentation));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Character));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Supporting));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Directing));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Animation));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Effects));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Music));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Costume));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Scenery));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Erotic));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Story));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Camera));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Ambient));
            fokusList.add(FokusFactory.getFokuse(Fokus.Fokuse.Merchandising));
            for (Fokus f : fokusList)
                DATA.insert(f, true, DATA.get());
        }
    }
}
