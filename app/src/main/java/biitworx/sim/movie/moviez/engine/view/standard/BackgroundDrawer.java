package biitworx.sim.movie.moviez.engine.view.standard;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import biitworx.sim.movie.moviez.Game;
import biitworx.sim.movie.moviez.R;
import biitworx.sim.movie.moviez.engine.view.Drawer;
import biitworx.sim.movie.moviez.engine.view.Static;
import biitworx.sim.movie.moviez.engine.view.stripe.MovieStripe;
import biitworx.sim.movie.moviez.engine.view.stripe.MovieStripeMenu;
import biitworx.sim.movie.moviez.engine.view.visuals.Button;
import biitworx.sim.movie.moviez.global.B;
import biitworx.sim.movie.moviez.global.BitmapDrawer;
import biitworx.sim.movie.moviez.global.MenuStripesFactory;

/**
 * Created by marce_000 on 15.08.2016.
 */
public class BackgroundDrawer extends Drawer {

    private MovieStripeMenu menu = new MovieStripeMenu();


    @Override
    protected void onDraw() {
        if (!canDraw()) return;


        BitmapDrawer.drawImage(B.get(R.drawable.back), canvas, bounds, null, false);

        Paint back = new Paint();
        back.setStyle(Paint.Style.FILL);
        back.setColor(Static.getBack());
        int top = 18;

        canvas.drawRect(new Rect(bounds.left, bounds.top, bounds.right, bounds.top + top), back);
        canvas.drawRect(new Rect(bounds.left, (int) (bounds.bottom - top * 1.3), bounds.right, bounds.bottom), back);
        int max = (bounds.height() - top * 2) / 10;
        int width = (int) (bounds.width() / 6);
        //canvas.drawRect(new Rect(bounds.left, bounds.top+max+top, bounds.right, (bounds.top+max+top + top/2)-top/10), back);
        Rect rcMiddle = new Rect(bounds.left + width, bounds.top + max, bounds.right - width, bounds.bottom);


        if (menu.isCreated()) {


            Rect rc = new Rect(bounds.left + width, bounds.top, bounds.right - width, bounds.top + max);

            int w2 = rc.width() / 3;
            menu.money(new MovieStripe(new Rect(rc.left, rc.top, rc.left + w2, rc.bottom)).text("MONEY ($)").text2(Game.playerData.getMoneyFormat()).loop(true));
            menu.credit(new MovieStripe(new Rect(rc.left + w2, rc.top, rc.left + w2 * 2, rc.bottom)).text("CREDIT ($)").text2(Game.playerData.getCreditFormat()).loop(true));
            menu.week(new MovieStripe(new Rect(rc.left + w2 * 2, rc.top, rc.left + w2 * 3, rc.bottom)).text("WEEK (2)").text2("10/1/2016").loop(true));

            for (int x = 0; x < 10; x++) {
                menu.add(MenuStripesFactory.getMenuStripe(x, new Rect(0, top, width, top + max)));
                menu.add(MenuStripesFactory.getMenuStripe(x + 10, new Rect(bounds.right - width, top, bounds.right, top + max)));

                top += max;
            }


        }

        int padding = rcMiddle.width()/20;

        Button b = new Button(new Rect(rcMiddle.left+padding,rcMiddle.top+padding,rcMiddle.left+padding+rcMiddle.width()/3,rcMiddle.top+padding+rcMiddle.height()/20), "Add Actor");
        b.draw(canvas);
        menu.draw(canvas);



    }

    @Override
    public void checkHit(int x, int y) {
        menu.checkHit(x, y);
    }


}
