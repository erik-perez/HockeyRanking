import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Driver {
    public static void main(String[] args){
        String players = "/Users/erik/JavaProjects/HockeyRanking/nhl-stats.csv";
        ArrayList<hockeyPlayer> NHLS2021 = new fileInput().readNHLplayers(players);
        ArrayList<hockeyPlayer> NHLS2021C = new ArrayList<>();
        ArrayList<hockeyPlayer> NHLS2021LW = new ArrayList<>();
        ArrayList<hockeyPlayer> NHLS2021RW = new ArrayList<>();
        ArrayList<hockeyPlayer> NHLS2021D = new ArrayList<>();

        System.out.println("name,\t team, position, games, goals,\t\t\t\t assists,\t\t\t Sog,\t\t\t\t PPP,\t\t\t\t Hits,\t\t\t\t BS, \t\t\t\t Rank");

        for (hockeyPlayer b : NHLS2021){
            b.setAverage();
            if (b.getPosition().equals("C")){
                NHLS2021C.add(b);
            }if (b.getPosition().equals("RW")){
                NHLS2021RW.add(b);
            }if (b.getPosition().equals("LW")){
                NHLS2021LW.add(b);
            }if (b.getPosition().equals("D")){
                NHLS2021D.add(b);
            }
        }

        hockeyPlayer avgD = (fileInput.createAvgPlayer(NHLS2021D, "D"));
        hockeyPlayer avgC = (fileInput.createAvgPlayer(NHLS2021C, "C"));
        hockeyPlayer avgLW = (fileInput.createAvgPlayer(NHLS2021LW, "LW"));
        hockeyPlayer avgRW = (fileInput.createAvgPlayer(NHLS2021D, "RW"));
        NHLS2021D.add(avgD);
        NHLS2021RW.add(avgRW);
        NHLS2021LW.add(avgLW);
        NHLS2021C.add(avgC);

        for (hockeyPlayer b : NHLS2021C){
            double rk = ((b.getGoals() - avgC.getGoals()) + (b.getAssists() - avgC.getAssists()) + (b.getSog() - avgC.getSog()) +
                    (b.getPpp() - avgC.getPpp()) + (b.getHits() - avgC.getHits()) + (b.getBs() - avgC.getBs()));
            b.setRank(rk);
        } for (hockeyPlayer b : NHLS2021D){
            double rk = ((b.getGoals() - avgC.getGoals()) + (b.getAssists() - avgC.getAssists()) + (b.getSog() - avgC.getSog()) +
                    (b.getPpp() - avgC.getPpp()) + (b.getHits() - avgC.getHits()) + (b.getBs() - avgC.getBs()));
            b.setRank(rk);
        } for (hockeyPlayer b : NHLS2021LW){
            double rk = ((b.getGoals() - avgC.getGoals()) + (b.getAssists() - avgC.getAssists()) + (b.getSog() - avgC.getSog()) +
                    (b.getPpp() - avgC.getPpp()) + (b.getHits() - avgC.getHits()) + (b.getBs() - avgC.getBs()));
            b.setRank(rk);
        } for (hockeyPlayer b : NHLS2021RW){
            double rk = ((b.getGoals() - avgC.getGoals()) + (b.getAssists() - avgC.getAssists()) + (b.getSog() - avgC.getSog()) +
                    (b.getPpp() - avgC.getPpp()) + (b.getHits() - avgC.getHits()) + (b.getBs() - avgC.getBs()));
            b.setRank(rk);
        }

        Collections.sort(NHLS2021, new Comparator<hockeyPlayer>() {
            public int compare(hockeyPlayer o1, hockeyPlayer o2) {
                return Double.valueOf(o2.getRank()).compareTo(o1.getRank());
            }
        });

        for (hockeyPlayer b : NHLS2021) {

            System.out.println(b.printPlayer());
        }
    }
}