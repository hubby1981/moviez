package biitworx.sim.movie.moviez.engine.view.stripe;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcel.weissgerber on 16.08.2016.
 */
public class MovieStripeMenu {

    private List<MovieStripe> stripes = new ArrayList<>();


    public void add(MovieStripe stripe) {
        stripes.add(stripe);
    }

    public boolean isCreated() {
        return stripes.size() == 0;
    }

    public void draw(Canvas canvas) {



        if(money!=null){
            money.draw(canvas);
        }
        if(credit!=null){
            credit.draw(canvas);
        }
        if(week!=null){
            week.draw(canvas);
        }

        for (MovieStripe s : stripes)
            s.draw(canvas);
    }

    public void checkHit(int x, int y) {
        for (MovieStripe s : stripes)
            s.isHit = false;
        for (MovieStripe s : stripes) {
            if (s.checkHit(x, y)) {
                break;
            }
        }


    }

    private MovieStripe money;
    private MovieStripe credit;
    private MovieStripe week;

    public MovieStripeMenu money(MovieStripe money){
        this.money = money;
        return this;
    }

    public MovieStripeMenu credit(MovieStripe credit){
        this.credit = credit;
        return this;
    }

    public MovieStripeMenu week(MovieStripe week){
        this.week = week;
        return this;
    }
}
