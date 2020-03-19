package com.mohammad.android.soccerTips;

import java.util.List;

public class FixturesByCountry {
    private List<Fixture> listFixturesByCountry;
    String country;
    String code;
    String flag;

    public FixturesByCountry() {
    }

    public FixturesByCountry(List<Fixture> listFixturesByCountry, String country, String code, String flag) {
        this.listFixturesByCountry = listFixturesByCountry;
        this.country = country;
        this.code = code;
        this.flag = flag;
    }

    public FixturesByCountry(String country, String code, String flag) {
        this.country = country;
        this.code = code;
        this.flag = flag;
    }

    public List<Fixture> getListFixturesByCountry() {
        return listFixturesByCountry;
    }

    public String getCountry() {
        return country;
    }

    public void setListFixturesByCountry(List<Fixture> listFixturesByCountry) {
        this.listFixturesByCountry = listFixturesByCountry;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void addFixtureToList(Fixture fixture){
        listFixturesByCountry.add(fixture);
    }
}
