package biitworx.sim.movie.moviez.data.game;


import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import biitworx.sim.movie.moviez.data.BaseDataObject;
import biitworx.sim.movie.moviez.data.DbField;
import biitworx.sim.movie.moviez.data.DbTable;

/**
 * Created by marce_000 on 29.05.2016.
 */
@DbTable(name = "players")
public class PlayerData extends BaseDataObject {
    @DbField(name = "n")
    private String name;
    @DbField(name = "d")
    private int day;
    @DbField(name = "m")
    private int month;
    @DbField(name = "y")
    private int year;
    @DbField(name = "w")
    private int week;
    @DbField(name = "mo")
    private long money;
    @DbField(name = "cr")
    private long credit;

    public PlayerData() {
        super();
    }

    public PlayerData(String name) {
        super();
        this.name = name;
        this.money = 500000;
        this.credit = 500000;

        week = 1;
        day = 1;
        month = 1;
        year = 2012;
    }


    @Override
    protected void imported() {

    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public int getWeek() {
        return week;
    }

    public long getCredit() {
        return credit;
    }

    public long getMoney() {
        return money;
    }

    public PlayerData setMoney(long money) {
        this.money = money;
        return this;
    }

    public String getMoneyFormat() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(money).replace("$", "").replace(".00", "");
    }

    public String getCreditFormat() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(credit).replace("$", "").replace(".00", "");
    }
}
