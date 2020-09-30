package com.yetkinyurtsever.kermit_tips;

public class BetCard {

    private String homeTeam;
    private String awayTeam;
    private String matchCode;
    private String prediction;

    public BetCard() {
    }

    public BetCard(String homeTeam, String awayTeam, String matchCode, String prediction) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchCode = matchCode;
        this.prediction = prediction;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getMatchCode() {
        return "Maç Kodu: " + matchCode;
    }

    public void setMatchCode(String matchCode) {
        this.matchCode = matchCode;
    }

    public String getPrediction() {
        return "Bahis: " + prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}
