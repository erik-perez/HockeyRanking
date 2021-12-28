public class hockeyPlayer {
    String name;
    String team;
    String position;
    double games;
    double goals;
    double assists;
    double sog;
    double ppp;
    double hits;
    double bs;
    double rank;

    public hockeyPlayer(String name, String team, String position, double games, double goals, double assists, double sog, double ppp, double hits, double bs, double rank) {
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
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
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
    public hockeyPlayer setAverage(){
        setGoals(getGoals()/getGames());
        setAssists(getAssists()/getGames());
        setSog(getSog()/getGames());
        setPpp(getPpp()/getGames());
        setHits(getHits()/getGames());
        setBs(getBs()/getGames());
        return null;
    }


}