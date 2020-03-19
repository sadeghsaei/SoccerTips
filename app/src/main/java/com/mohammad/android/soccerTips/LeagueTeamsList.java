package com.mohammad.android.soccerTips;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LeagueTeamsList {
    League league;
    List<Team> teamListInLeague;

    public void loadLeagueTeamsList() throws IOException, JSONException {

        OkHttpClient client = new OkHttpClient();
        int league_id = league.getLeague_id();
        String fixturesLeague = "https://api-football-v1.p.rapidapi.com/v2/teams/league/" + league_id;
        String rapidApi = "1bfb255f64mshf05e31b90f683ecp19dd8ejsn8edd9e29e1f7";
        Request request = new Request.Builder()
                .url(fixturesLeague)
                .get()
                .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", rapidApi)
                .build();

        Response response = client.newCall(request).execute();

        String resStr = response.body().string();
//        JSONObject json = new JSONObject(resStr);
        JSONArray jsonArray = new JSONObject(resStr).getJSONArray("teams");
        int numberOfTeamsInLeague = jsonArray.length();

        for (int i = 0; i < numberOfTeamsInLeague; i++) {
            try {
                String teamIdString = jsonArray.getJSONObject(i).getString("team_id");
                int team_id = Integer.parseInt(teamIdString);
                String name = jsonArray.getJSONObject(i).getString("name");
                String code = jsonArray.getJSONObject(i).getString("code");
                String logo = jsonArray.getJSONObject(i).getString("logo");
                String country = jsonArray.getJSONObject(i).getString("country");
                String is_national = jsonArray.getJSONObject(i).getString("is_national");
                String foundedString = jsonArray.getJSONObject(i).getString("founded");
                int founded = Integer.parseInt(foundedString);
                String venue_name = jsonArray.getJSONObject(i).getString("venue_name");
                String venue_surface = jsonArray.getJSONObject(i).getString("venue_surface");
                String venue_address = jsonArray.getJSONObject(i).getString("venue_address");
                String venue_city = jsonArray.getJSONObject(i).getString("venue_city");
                String venueCapacityString = jsonArray.getJSONObject(i).getString("venue_capacity");
                int venue_capacity = Integer.parseInt(venueCapacityString);
                Team team = new Team(team_id, name, code, logo, country, is_national, founded, venue_name, venue_surface, venue_address, venue_city, venue_capacity);
                teamListInLeague.add(team);
            } catch (Exception e) {
                System.out.println("" + e.getMessage());
            }
        }
    }

}
