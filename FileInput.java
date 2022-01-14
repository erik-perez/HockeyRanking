import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileInput {

    public static ArrayList <HockeyPlayer> readNHLplayers (String fileName) {
        ArrayList <HockeyPlayer> NHLPlayers = new ArrayList<>();
        String testRow;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();

            while ((testRow = br.readLine()) != null) {

                String[] attributes = line.split(",");
                HockeyPlayer test = HockeyPlayer.createPlayer(attributes);
                NHLPlayers.add(test);
                line = br.readLine();
            }

        } catch (Exception e) {
            System.out.println("Unable to find input file. Program is stopping.");
            System.exit(0);
        }
        return NHLPlayers;
    }
}