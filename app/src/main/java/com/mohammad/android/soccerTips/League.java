package com.mohammad.android.soccerTips;

public class League {
    private int league_id;
    private String name;
    private String type;
    private String country_code;
    private String country;
    private int season;
    private String logo;
    private int is_current;

    public League() {
    }

    public int getLeague_id() {
        return league_id;
    }

    League(int league_id, String name, String type, String country_code, String country, int season, String logo, int is_current) {
        this.league_id = league_id;
        this.name = name;
        this.type = type;
        this.country_code = country_code;
        this.country = country;
        this.season = season;
        this.logo = logo;
        this.is_current = is_current;
    }

}
