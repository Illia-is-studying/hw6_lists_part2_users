package com.example.hw6_lists_part2_users.Models;

public class UserModel {
    private int profileResourceId;
    private long ageUTC;
    private String firstName;
    private String lastName;
    private String countryName;
    private String cityName;

    public UserModel(String countryName, String cityName, String firstName, String lastName,
                     long ageUTC, int profileResourceId) {
        this.countryName = countryName;
        this.cityName = cityName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ageUTC = ageUTC;
        this.profileResourceId = profileResourceId;
    }

    public long getAgeUTC() {
        return ageUTC;
    }

    public void setAgeUTC(long ageUTC) {
        this.ageUTC = ageUTC;
    }

    public int getProfileResourceId() {
        return profileResourceId;
    }

    public void setProfileResourceId(int profileResourceId) {
        this.profileResourceId = profileResourceId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
