import java.util.List;

public class HockeyPlayer {

    enum Position {
        C,
        D,
        LW,
        RW;
    }

    String name;
    String team;
    Position position;
    double games;
    double goals;
    double assists;
    double sog;
    double ppp;
    double hits;
    double bs;
    double rank;

    public static HockeyPlayer createPlayer(String[] data) {
        String name = data[0];
        String team = data[1];
        Position position = Position.valueOf(data[2]);
        int games = Integer.parseInt(data[3]);
        double goals = Integer.parseInt(data[4]);
        double assists = Integer.parseInt(data[5]);
        double sog = Integer.parseInt(data[9]);
        double ppp = Integer.parseInt(data[11]) + Integer.parseInt(data[12]);
        double hits = Integer.parseInt(data[15]);
        double bs = Integer.parseInt(data[16]);
        double rk = 0;

        return new HockeyPlayer(name, team, position, games, goals, assists, sog, ppp, hits, bs, rk);
    }

    public static HockeyPlayer createAvgPlayer(List<HockeyPlayer> NHL, Position position) {
        double avgGames = 0;
        double avgGoals = 0;
        double avgAssists = 0;
        double avgSog = 0;
        double avgPPP = 0;
        double avgHits = 0;
        double avgBs = 0;
        int count = 0;
        for (HockeyPlayer b : NHL){
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
        double games = (avgGames/count);
        double goals = (avgGoals/count);
        double assists = (avgAssists/count);
        double sog = (avgSog/count);
        double ppp = (avgPPP/count);
        double hits = (avgHits/count);
        double bs = (avgBs/count);
        double rk = 0;

        return new HockeyPlayer(AverageName, teamName, position, games, goals, assists, sog, ppp, hits, bs, rk);
    }

    public HockeyPlayer(String name, String team, Position position, double games, double goals, double assists, double sog, double ppp, double hits, double bs, double rank) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.games = games;
        this.goals = goals;
        this.assists = assists;
        this.sog = sog;
        this.ppp = ppp;
        this.hits = hits;
        this.bs = bs;
        this. rank = rank;
    }

    public double getRank() {
        return rank;
    }
    public void setRank(double rank) {
        this.rank = rank;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public double getGames() {
        return games;
    }
    public void setGames(double games) {
        this.games = games;
    }
    public double getGoals() {
        return goals;
    }
    public void setGoals(double goals) {
        this.goals = goals;
    }
    public double getAssists() {
        return assists;
    }
    public void setAssists(double assists) {
        this.assists = assists;
    }
    public double getSog() {
        return sog;
    }
    public void setSog(double sog) {
        this.sog = sog;
    }
    public double getPpp() {
        return ppp;
    }
    public void setPpp(double ppp) {
        this.ppp = ppp;
    }
    public double getHits() {
        return hits;
    }
    public void setHits(double hits) {
        this.hits = hits;
    }
    public double getBs() {
        return bs;
    }
    public void setBs(double bs) {
        this.bs = bs;
    }
    public String printPlayer(){
        return getName() + ", " + getTeam() + ", " +getPosition() + ",\t " + getGames() + ", " + getGoals() + ", " + getAssists()
                + ", " +getSog() + ", " + getPpp() + ", " + getHits() + ", " + getBs() + ", " + getRank();
    }
    public HockeyPlayer setAverage(){
        setGoals(getGoals()/getGames());
        setAssists(getAssists()/getGames());
        setSog(getSog()/getGames());
        setPpp(getPpp()/getGames());
        setHits(getHits()/getGames());
        setBs(getBs()/getGames());
        return null;
    }


}