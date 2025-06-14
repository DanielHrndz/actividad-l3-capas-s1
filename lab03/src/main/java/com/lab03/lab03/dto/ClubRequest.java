package com.lab03.lab03.dto;

public class ClubRequest {
    private Integer id;
    private String name;
    private String country;
    private String coach;
    private int titles;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCoach() {
        return coach;
    }
    public void setCoach(String coach) {
        this.coach = coach;
    }
    public int getTitles() {
        return titles;
    }
    public void setTitles(int titles) {
        this.titles = titles;
    }
}
