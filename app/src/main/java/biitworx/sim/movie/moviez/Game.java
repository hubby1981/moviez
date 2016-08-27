package biitworx.sim.movie.moviez;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import java.util.List;

import biitworx.sim.movie.moviez.data.game.PlayerData;
import biitworx.sim.movie.moviez.data.game.movie.Fokus;
import biitworx.sim.movie.moviez.data.game.movie.Genre;
import biitworx.sim.movie.moviez.data.game.movie.Movie;
import biitworx.sim.movie.moviez.data.game.setup.FokusFactory;
import biitworx.sim.movie.moviez.data.game.setup.GenreFactory;
import biitworx.sim.movie.moviez.data.helper.DbHelper;
import biitworx.sim.movie.moviez.engine.view.Background;

public class Game extends AppCompatActivity {


    public static Resources res;
    public static DbHelper DATA;
    private Background background;
    public static Runnable update;
    public static PlayerData playerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handleWnd();
        setContentView(R.layout.activity_main);
        res = getResources();
        DATA = new DbHelper(this);


        update = new Runnable() {
            @Override
            public void run() {
                background = (Background) findViewById(R.id.gameback);
                background.invalidate();
            }
        };

        runOnUiThread(update);

        checkSetup();
    }

    private void handleWnd() {
        Window w = this.getWindow();
        if(w!=null){
            w.setStatusBarColor(Color.argb(255,0,30,60));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP) {
            background = (Background) findViewById(R.id.gameback);
            background.checkHit((int) event.getX(), (int) event.getY());
        }
        update.run();

        return true;
    }


    private void checkSetup() {
        List<PlayerData> players = DATA.getData(PlayerData.class, DATA.get(), true);
        List<Genre> genreList = DATA.getData(Genre.class, DATA.get(), true);
        List<Fokus> fokusList = DATA.getData(Fokus.class, DATA.get(), true);

        if (players.size() == 0) {
            playerData = new PlayerData("");
            DATA.insert(playerData, true, DATA.get());
        } else {
            playerData = players.get(0).setMoney(750000);
            DATA.insert(playerData, false, DATA.get());
        }

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


        List<Movie> movies = DATA.getData(Movie.class, DATA.get(), true);

    }
}
