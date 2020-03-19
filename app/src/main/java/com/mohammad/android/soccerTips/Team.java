package com.mohammad.android.soccerTips;

public class Team {
    int team_id;
    String name;
    String code;
    String logo;
    String country;
    String is_national;
    int founded;
    String venue_name;
    String venue_surface;
    String venue_address;
    String venue_city;
    int venue_capacity;

    public Team(int team_id, String name, String code, String logo, String country,
                String is_national, int founded, String venue_name, String venue_surface,
                String venue_address, String venue_city, int venue_capacity) {
        this.team_id = team_id;
        this.name = name;
        this.code = code;
        this.logo = logo;
        this.country = country;
        this.is_national = is_national;
        this.founded = founded;
        this.venue_name = venue_name;
        this.venue_surface = venue_surface;
        this.venue_address = venue_address;
        this.venue_city = venue_city;
        this.venue_capacity = venue_capacity;
    }

    public Team() {
    }

}
