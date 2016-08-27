package biitworx.sim.movie.moviez.data;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import biitworx.sim.movie.moviez.Game;
import biitworx.sim.movie.moviez.data.game.PlayerData;
import biitworx.sim.movie.moviez.data.game.movie.Fokus;
import biitworx.sim.movie.moviez.data.game.movie.Genre;


/**
 * Created by marce_000 on 28.05.2016.
 */
public class SecureDataSetup {


    List<Class> secureDataList = new ArrayList<>();


    public SecureDataSetup() {

        ///TODO: tables to add
        secureDataList.add(Genre.class);
        secureDataList.add(PlayerData.class);
        secureDataList.add(Fokus.class);

    }

    public HashMap<String, List<Object>> getAll(SQLiteDatabase db) {
        HashMap<String, List<Object>> all = new HashMap<>();
        for (Class c : secureDataList) {
            List data = Game.DATA.getData(c, db, true);
            if(data!=null&&data.size()>0)
                all.put(c.getSimpleName(), data);
        }
        return all;
    }

    public void reInsertData(HashMap<String, List<Object>> all, SQLiteDatabase db) {
        for (Map.Entry<String, List<Object>> e : all.entrySet()) {
            for (Object o : e.getValue()) {
                Game.DATA.insert(o, true, db);
            }
        }
    }
}
