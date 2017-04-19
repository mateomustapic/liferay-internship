package Model;

import com.football.Players;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateo on 3/20/2017.
 */
public class PlayersModel {
    public List<Players> findAll(){
        List<Players> result = new ArrayList<Players>();
        result.add(new Players("01", "Mesut Ozil", "Central Midfielder"));
        result.add(new Players("02", "Harry Kane", "Central Forward"));
        result.add(new Players("03", "Philip Lahm", "Right Back"));
        result.add(new Players("04", "Fernando Torres", "Central Forward"));
        result.add(new Players("05", "Eden Hazard", "Left Wing"));
        result.add(new Players("06", "Paulo Dybala", "Central Forward"));
        result.add(new Players("07", "Diego Costa", "Striker"));
        result.add(new Players("08", "Jamie Vardy", "Central Forward"));
        result.add(new Players("09", "Gonzalo Higuain", "Striker"));
        return result;
    }
}
