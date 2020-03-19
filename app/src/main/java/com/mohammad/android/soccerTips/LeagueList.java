package com.mohammad.android.soccerTips;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LeagueList {
    private List<League> leagueList;

    public LeagueList() {
    }

    public LeagueList(List<League> leagueList) {
        this.leagueList = leagueList;
    }

    public List<League> getLeagueList() {
        return leagueList;
    }

    public void setLeagueList(List<League> leagueList) {
        this.leagueList = leagueList;
    }

    public void add(League league) {
        leagueList.add(league);
    }

    public void loadLeagueId() throws IOException, JSONException {

        OkHttpClient client = new OkHttpClient();

        String fixturesLeague = "https://api-football-v1.p.rapidapi.com/v2/leagues";
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
        JSONArray jsonArray = new JSONObject(resStr).getJSONArray("leagues");
        int numberOfLeagues = jsonArray.length();

        for (int i = 0; i < numberOfLeagues; i++) {
            try {
                String leagueIdString = jsonArray.getJSONObject(i).getString("league_id");
                int league_id = Integer.parseInt(leagueIdString);
                String name = jsonArray.getJSONObject(i).getString("name");
                String type = jsonArray.getJSONObject(i).getString("type");
                String country_code = jsonArray.getJSONObject(i).getString("country_code");
                String country = jsonArray.getJSONObject(i).getString("country");
                String seasonString = jsonArray.getJSONObject(i).getString("season");
                int season = Integer.parseInt(seasonString);
                String logo = jsonArray.getJSONObject(i).getString("logo");
                String isCurrentString = jsonArray.getJSONObject(i).getString("is_current");
                int is_current = Integer.parseInt(isCurrentString);
                League league = new League(league_id, name, type, country_code, country, season, logo, is_current);
                this.add(league);
            } catch (Exception e) {
                System.out.println("" + e.getMessage());
            }
        }
    }
}
