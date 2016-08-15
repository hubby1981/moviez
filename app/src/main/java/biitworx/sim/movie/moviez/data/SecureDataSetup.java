package biitworx.sim.movie.moviez.data;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import biitworx.sim.movie.moviez.Game;


/**
 * Created by marce_000 on 28.05.2016.
 */
public class SecureDataSetup {


    List<Class> secureDataList = new ArrayList<>();


    public SecureDataSetup() {

       ///TODO: tables to add

    }

    public HashMap<String, List<Object>> getAll(SQLiteDatabase db) {
        HashMap<String, List<Object>> all = new HashMap<>();
        for (Class c : secureDataList) {
            all.put(c.getSimpleName(), Game.DATA.getData(c, db,true));
        }
        return all;
    }

    public void reInsertData(HashMap<String, List<Object>> all,SQLiteDatabase db) {
            for(Map.Entry<String,List<Object>> e:all.entrySet()){
                for(Object o: e.getValue()){
                    Game.DATA.insert(o,true,db);
                }
            }
    }
}
