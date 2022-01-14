import java.util.List;
import java.util.stream.Collectors;

public class Driver {

    public static void main(String[] args){
        String players = "./nhl-stats.csv";
        List<HockeyPlayer> nhlS2021 = FileInput.readNHLplayers(players);

        assignRanks(nhlS2021);

        System.out.println("name,\t team, position, games, goals,\t\t\t\t assists,\t\t\t Sog,\t\t\t\t PPP,\t\t\t\t Hits,\t\t\t\t BS, \t\t\t\t Rank");
        nhlS2021.stream().sorted((o1, o2) -> Double.compare(o2.getRank(), o1.getRank()))
            .forEach(h -> System.out.println(h.printPlayer()));
    }

    private static void assignRanks(List<HockeyPlayer> toBeRanked) {
        for (HockeyPlayer.Position pos : HockeyPlayer.Position.values()) {
            assignRank(toBeRanked, pos);
        }
    }

    private static void assignRank(List<HockeyPlayer> toBeRanked, HockeyPlayer.Position position) {
        List<HockeyPlayer> filtered =
            toBeRanked.stream().filter(p -> p.getPosition().equals(position)).collect(Collectors.toList());

        HockeyPlayer average = HockeyPlayer.createAvgPlayer(filtered, position);
        for (HockeyPlayer b : filtered){
            assignRank(b, average);
        }
    }

    private static void assignRank(HockeyPlayer toBeRanked, HockeyPlayer average) {
        double rk = ((toBeRanked.getGoals() - average.getGoals()) + (toBeRanked.getAssists() - average.getAssists()) + (toBeRanked.getSog() - average.getSog()) +
            (toBeRanked.getPpp() - average.getPpp()) + (toBeRanked.getHits() - average.getHits()) + (toBeRanked.getBs() - average.getBs()));
        toBeRanked.setRank(rk);
    }
}