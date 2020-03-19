package com.mohammad.android.soccerTips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LiveScore extends AppCompatActivity {

    private List<Fixture> fixtureList;
    private List<FixturesByCountry> fixturesByCountryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_score);
        //remove shadow from action bar

//        ActionBar actionBar = getSupportActionBar();
//        assert actionBar != null;
//        actionBar.setElevation(0);
//        actionBar.setTitle("Live Scores");

        RecyclerView mRecyclerView = findViewById(R.id.recyclerview);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fixtureList = new ArrayList<>();

        try {
            createFixtureByCountryList();
            loadUrlData();//method to call get/show data from website
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

//        int countryCount = fixturesByCountryList.size();
//        for (int i = 0; i < countryCount; i++) {
//            System.out.println(fixturesByCountryList.get(i));
//        }


        RecyclerView.Adapter mAdapter = new RecyclerViewAdapter(fixtureList, getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadUrlData() throws IOException, JSONException {

        OkHttpClient client = new OkHttpClient();
        String rapidApi = "1bfb255f64mshf05e31b90f683ecp19dd8ejsn8edd9e29e1f7";

        String fixturesToday = "https://api-football-v1.p.rapidapi.com/v2/fixtures/date/" + todaysDate();
        Request requestFixturesToday = new Request.Builder()
                .url(fixturesToday)
                .get()
                .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", rapidApi)
                .build();
        Response responseFixturesToday = client.newCall(requestFixturesToday).execute();

        String resultFixturesToday = Objects.requireNonNull(responseFixturesToday.body()).string();
        JSONObject jsonObjectFixtures = new JSONObject(resultFixturesToday).getJSONObject("api");
        JSONArray jsonArrayFixtures = jsonObjectFixtures.getJSONArray("fixtures");
        int numberOfFixturesToday = jsonArrayFixtures.length();
        for (int i = 0; i < numberOfFixturesToday; i++) {
            try {
                int fixture_id = (jsonArrayFixtures.getJSONObject(i).isNull("fixture_id")) ? -1 : jsonArrayFixtures.getJSONObject(i).getInt("fixture_id");
                int league_id = (jsonArrayFixtures.getJSONObject(i).isNull("league_id")) ? -1 : jsonArrayFixtures.getJSONObject(i).getInt("league_id");

                JSONObject jsonObjectLeague = jsonArrayFixtures.getJSONObject(i).getJSONObject("league");
                String league_name = (jsonObjectLeague.isNull("league_name")) ? "null" : jsonObjectLeague.getString("league_name");
                String league_country = (jsonObjectLeague.isNull("country")) ? "null" : jsonObjectLeague.getString("country");
                String league_logo = (jsonObjectLeague.isNull("logo")) ? "null" : jsonObjectLeague.getString("logo");
                String league_flag = (jsonObjectLeague.isNull("flag")) ? "null" : jsonObjectLeague.getString("flag");

                String event_date = (jsonArrayFixtures.getJSONObject(i).isNull("event_date")) ? "null" : jsonArrayFixtures.getJSONObject(i).getString("event_date");
                int event_timestamp = (jsonArrayFixtures.getJSONObject(i).isNull("event_timestamp")) ? -1 : jsonArrayFixtures.getJSONObject(i).getInt("event_timestamp");
                String status = (jsonArrayFixtures.getJSONObject(i).isNull("status")) ? "null" : jsonArrayFixtures.getJSONObject(i).getString("status");
                String statusShort = (jsonArrayFixtures.getJSONObject(i).isNull("statusShort")) ? "null" : jsonArrayFixtures.getJSONObject(i).getString("statusShort");
                int elapsed = (jsonArrayFixtures.getJSONObject(i).isNull("elapsed")) ? -1 : jsonArrayFixtures.getJSONObject(i).getInt("elapsed");
                String venue = (jsonArrayFixtures.getJSONObject(i).isNull("venue")) ? "null" : jsonArrayFixtures.getJSONObject(i).getString("venue");
                String referee = (jsonArrayFixtures.getJSONObject(i).isNull("referee")) ? "null" : jsonArrayFixtures.getJSONObject(i).getString("referee");

                JSONObject jsonObjectHomeTeam = jsonArrayFixtures.getJSONObject(i).getJSONObject("homeTeam");
                int home_team_id = (jsonObjectHomeTeam.isNull("team_id")) ? -1 : jsonObjectHomeTeam.getInt("team_id");
                String home_team_name = (jsonObjectHomeTeam.isNull("team_name")) ? "null" : jsonObjectHomeTeam.getString("team_name");
                String home_team_logo = (jsonObjectHomeTeam.isNull("logo")) ? "null" : jsonObjectHomeTeam.getString("logo");

                JSONObject jsonObjectAwayTeam = jsonArrayFixtures.getJSONObject(i).getJSONObject("awayTeam");
                int away_team_id = (jsonObjectAwayTeam.isNull("team_id")) ? -1 : jsonObjectAwayTeam.getInt("team_id");
                String away_team_name = (jsonObjectAwayTeam.isNull("team_name")) ? "null" : jsonObjectAwayTeam.getString("team_name");
                String away_team_logo = (jsonObjectAwayTeam.isNull("logo")) ? "null" : jsonObjectAwayTeam.getString("logo");

                int goalsHomeTeam = (jsonArrayFixtures.getJSONObject(i).isNull("goalsHomeTeam")) ? -1 : jsonArrayFixtures.getJSONObject(i).getInt("goalsHomeTeam");
                int goalsAwayTeam = (jsonArrayFixtures.getJSONObject(i).isNull("goalsAwayTeam")) ? -1 : jsonArrayFixtures.getJSONObject(i).getInt("goalsAwayTeam");

                Fixture fixture = new Fixture(fixture_id, league_id, league_name, league_country,
                        league_logo, league_flag, event_date, event_timestamp, status, statusShort,
                        elapsed, venue, referee, home_team_id, home_team_name, home_team_logo,
                        away_team_id, away_team_name, away_team_logo, goalsHomeTeam, goalsAwayTeam);
                fixtureList.add(fixture);
//                addFixtureToCountry(fixture);

            } catch (Exception e) {
                System.out.println("" + e.getMessage());
            }
        }
    }

    private void createFixtureByCountryList() throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();
        String rapidApi = "1bfb255f64mshf05e31b90f683ecp19dd8ejsn8edd9e29e1f7";
        String countries = "https://api-football-v1.p.rapidapi.com/v2/countries";
        Request requestCountries = new Request.Builder()
                .url(countries)
                .get()
                .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", rapidApi)
                .build();
        Response responseCountries = client.newCall(requestCountries).execute();
        String resultCountries = Objects.requireNonNull(responseCountries.body()).string();
        JSONObject jsonObjectCountries = new JSONObject(resultCountries).getJSONObject("api");
        JSONArray jsonArrayCountries = jsonObjectCountries.getJSONArray("countries");
        int numberOfCountries = jsonArrayCountries.length();

//        for (int i = 0; i < numberOfCountries; i++) {
//            try {
//                String country = (jsonArrayCountries.getJSONObject(i).isNull("country")) ? "null" : jsonArrayCountries.getJSONObject(i).getString("country");
//                String code = (jsonArrayCountries.getJSONObject(i).isNull("code")) ? "null" : jsonArrayCountries.getJSONObject(i).getString("code");
//                String flag = (jsonArrayCountries.getJSONObject(i).isNull("flag")) ? "null" : jsonArrayCountries.getJSONObject(i).getString("flag");
//                FixturesByCountry newCountry = new FixturesByCountry(country, code, flag);
//                fixturesByCountryList.add(newCountry);
//            } catch (Exception e) {
//                System.out.println("" + e.getMessage());
//            }
//        }
    }


    private void addFixtureToCountry(Fixture fixture) {
        int countryCount = fixturesByCountryList.size();
        for (int i = 0; i < countryCount; i++) {
            if (fixture.getLeague_country().equals(fixturesByCountryList.get(i).country)) {
                fixturesByCountryList.get(i).addFixtureToList(fixture);
                break;
            }
        }
    }

    String todaysDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime today = LocalDateTime.now();
        return formatter.format(today);
    }

}