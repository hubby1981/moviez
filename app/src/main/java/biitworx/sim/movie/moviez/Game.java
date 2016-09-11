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

import biitworx.sim.movie.moviez.data.game.BaseSetup;
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

        BaseSetup.checkSetup(DATA);
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



}
