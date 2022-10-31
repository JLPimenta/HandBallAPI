import java.util.ArrayList;
import java.util.List;

public class Championship {
    private String name;
    private List<Match> match = new ArrayList<>();


    public Championship(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMatch(Match match) {
        this.match.add(match);
    }

    public Match getMatch(int ref) {
        return this.getAllMatch().get(ref);
    }

    public List<Match> getAllMatch() {
        return match;
    }
    public void setMatch(List<Match> match) {
        this.match = match;
    }
}
