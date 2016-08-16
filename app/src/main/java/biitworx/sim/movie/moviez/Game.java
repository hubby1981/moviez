package biitworx.sim.movie.moviez;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import biitworx.sim.movie.moviez.data.helper.DbHelper;
import biitworx.sim.movie.moviez.engine.view.Background;

public class Game extends AppCompatActivity {


    public static Resources res;
    public static DbHelper DATA;
    private Background background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();
        DATA = new DbHelper(this);

        background = (Background) findViewById(R.id.gameback);
        background.invalidate();

    }


}
