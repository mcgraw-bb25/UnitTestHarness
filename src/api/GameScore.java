public class GameScore {
    
    private String team1;
    private String team2;
    private int score1;
    private int score2;

    public GameScore(String team1, String team2) {

        this.team1 = team1;
        this.team2 = team2;
        this.score1 = 0;
        this.score2 = 0;

    }

    public void addPoint(String team) {

        if (this.team1.equals(team))
            this.score1 = this.score1 + 1;
        else if (this.team2.equals(team))
            this.score2 = this.score2 + 1;

    }

    public int getScoreByTeam(String team) {

        int score;

        if (this.team1.equals(team))
            score = this.score1;
        else if (this.team2.equals(team))
            score = this.score2;
        else
            score = 0;

        return score;

    }

    public String getScore() {
        
        String score;

        score = String.format("%s - %d vs %s - %d",
                        this.team1, this.getScoreByTeam(this.team1),
                        this.team2, this.getScoreByTeam(this.team2));

        return score;

    }

}