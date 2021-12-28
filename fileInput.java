import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class fileInput {

    public static ArrayList <hockeyPlayer> readNHLplayers (String fileName){
        ArrayList <hockeyPlayer> NHLPlayers = new ArrayList<>();
        String testRow;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();

            while ((testRow = br.readLine()) != null) {

                String[] attributes = line.split(",");
                hockeyPlayer test = createPlayer(attributes);
                NHLPlayers.add(test);
                line = br.readLine();
            }

        } catch (Exception e) {
            System.out.println("Unable to find input file. Program is stopping.");
            System.exit(0);
        }
        return NHLPlayers;
    }

    private static hockeyPlayer createPlayer(String[] data) {
        String name = data[0];
        String team = data[1];
        String position = data[2];
        int games = Integer.parseInt(data[3]);
        double goals = Integer.parseInt(data[4]);
        double assists = Integer.parseInt(data[5]);
        double sog = Integer.parseInt(data[9]);
        double ppp = Integer.parseInt(data[11]) + Integer.parseInt(data[12]);
        double hits = Integer.parseInt(data[15]);
        double bs = Integer.parseInt(data[16]);
        double rk = 0;

        return new hockeyPlayer(name, team, position, games, goals, assists, sog, ppp, hits, bs, rk);
    }

    public static hockeyPlayer createAvgPlayer (ArrayList<hockeyPlayer> NHL, String position) {
        double avgGames = 0;
        double avgGoals = 0;
        double avgAssists = 0;
        double avgSog = 0;
        double avgPPP = 0;
        double avgHits = 0;
        double avgBs = 0;
        int count = 0;
        for (hockeyPlayer b : NHL){
            count ++;
            avgGames = avgGames + b.getGames();
            avgGoals = avgGoals + b.getGoals();
            avgAssists = avgAssists+ b.getAssists();
            avgSog = avgSog + b.getSog();
            avgPPP = avgPPP + b.getPpp();
            avgHits = avgHits + b.getHits();
            avgBs = avgBs + b.getBs();
        }
        String AverageName = "Average player";
        String teamName = "None";
        String pos = position;
        double games = (avgGames/count);
        double goals = (avgGoals/count);
        double assists = (avgAssists/count);
        double sog = (avgSog/count);
        double ppp = (avgPPP/count);
        double hits = (avgHits/count);
        double bs = (avgBs/count);
        double rk = 0;

        return new hockeyPlayer(AverageName, teamName, pos, games, goals, assists, sog, ppp, hits, bs, rk);
    }

}