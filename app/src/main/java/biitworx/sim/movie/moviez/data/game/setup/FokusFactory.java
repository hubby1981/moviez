package biitworx.sim.movie.moviez.data.game.setup;

import biitworx.sim.movie.moviez.data.game.movie.Fokus;

/**
 * Created by marcel.weissgerber on 24.08.2016.
 */
public class FokusFactory {


    public static Fokus getFokuse(Fokus.Fokuse fokuse){
        switch(fokuse) {
            case Tension      :return new Fokus(fokuse  , 1, 0.3f);
            case Action       :return new Fokus(fokuse  , 1, 0.2f);
            case Drama        :return new Fokus(fokuse  , 2, 0.4f);
            case Feeling      :return new Fokus(fokuse  , 2, 0.5f);
            case Acting       :return new Fokus(fokuse  , 3, 0.5f);
            case Presentation :return new Fokus(fokuse  , 2, 0.3f);
            case Character    :return new Fokus(fokuse  , 2, 0.2f);
            case Supporting   :return new Fokus(fokuse  , 1, 0.2f);
            case Directing    :return new Fokus(fokuse  , 3, 0.8f);
            case Animation    :return new Fokus(fokuse  , 2, 0.6f);
            case Effects      :return new Fokus(fokuse  , 2, 0.7f);
            case Music        :return new Fokus(fokuse  , 2, 0.2f);
            case Costume      :return new Fokus(fokuse  , 2, 0.3f);
            case Scenery      :return new Fokus(fokuse  , 2, 0.3f);
            case Erotic       :return new Fokus(fokuse  , 1, 0.1f);
            case Story        :return new Fokus(fokuse  , 2, 0.3f);
            case Camera       :return new Fokus(fokuse  , 1, 0.2f);
            case Ambient      :return new Fokus(fokuse  , 2, 0.4f);
            case Merchandising:return new Fokus(fokuse  , 1, 0.6f);
        }
        return null;
    }
}
