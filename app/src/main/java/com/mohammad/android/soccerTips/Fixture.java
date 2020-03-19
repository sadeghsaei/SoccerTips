package com.mohammad.android.soccerTips;

public class Fixture {
    int fixture_id;
    int league_id;
    String league_name;
    String league_country;
    String league_logo;
    String league_flag;
    String event_date;
    int event_timestamp;
    String status;
    String statusShort;
    int elapsed;
    String venue;
    String referee;
    int home_team_id;
    String home_team_name;
    String home_team_logo;
    int away_team_id;
    String away_team_name;
    String away_team_logo;
    int goalsHomeTeam;
    int goalsAwayTeam;

    public int getFixture_id() {
        return fixture_id;
    }

    public int getLeague_id() {
        return league_id;
    }

    public String getLeague_name() {
        return league_name;
    }

    public String getLeague_country() {
        return league_country;
    }

    public String getLeague_logo() {
        return league_logo;
    }

    public String getLeague_flag() {
        return league_flag;
    }

    public String getEvent_date() {
        return event_date;
    }

    public int getEvent_timestamp() {
        return event_timestamp;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusShort() {
        return statusShort;
    }

    public String getElapsed() {
        return String.valueOf(elapsed);
    }

    public String getVenue() {
        return venue;
    }

    public String getReferee() {
        return referee;
    }

    public int getHome_team_id() {
        return home_team_id;
    }

    public String getHome_team_name() {
        return home_team_name;
    }

    public String getHome_team_logo() {
        return home_team_logo;
    }

    public int getAway_team_id() {
        return away_team_id;
    }

    public String getAway_team_name() {
        return away_team_name;
    }

    public String getAway_team_logo() {
        return away_team_logo;
    }

    public String getGoalsHomeTeam() {
        return String.valueOf(goalsHomeTeam);
    }

    public String getGoalsAwayTeam() {
        return String.valueOf(goalsAwayTeam);
    }

    public Fixture() {
    }

    public Fixture(int fixture_id, int league_id, String league_name, String league_country,
                   String league_logo, String league_flag, String event_date,
                   int event_timestamp, String status, String statusShort,
                   int elapsed, String venue, String referee, int home_team_id,
                   String home_team_name, String home_team_logo, int away_team_id,
                   String away_team_name, String away_team_logo, int goalsHomeTeam,
                   int goalsAwayTeam) {
        this.fixture_id = fixture_id;
        this.league_id = league_id;
        this.league_name = league_name;
        this.league_country = league_country;
        this.league_logo = league_logo;
        this.league_flag = league_flag;
        this.event_date = event_date;
        this.event_timestamp = event_timestamp;
        this.status = status;
        this.statusShort = statusShort;
        this.elapsed = elapsed;
        this.venue = venue;
        this.referee = referee;
        this.home_team_id = home_team_id;
        this.home_team_name = home_team_name;
        this.home_team_logo = home_team_logo;
        this.away_team_id = away_team_id;
        this.away_team_name = away_team_name;
        this.away_team_logo = away_team_logo;
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
    }
}
