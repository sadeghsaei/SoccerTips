package com.mohammad.android.soccerTips;

class Model {

    private String id, team1, team2, matchType, matchStatus, date;

    Model(String id, String team1, String team2, String matchType, String matchStatus, String date) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.matchType = matchType;
        this.matchStatus = matchStatus;
        this.date = date;
    }

    String getId() {
        return id;
    }

    String getTeam1() {
        return team1;
    }

    String getTeam2() {
        return team2;
    }

    String getMatchType() {
        return matchType;
    }

    String getMatchStatus() {
        return matchStatus;
    }

    String getDate() {
        return date;
    }
}
//model class for recycler view
