package org.pgr112.solutions.sol5;

import java.time.LocalDate;

public class Artist {
    private String artistName;
    private LocalDate dateOfBirth;
    private String city;
    private String country;
    private int id;

    public Artist(String artistName, LocalDate dateOfBirth, String city, String country){
        this.artistName = artistName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.country = country;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String displayData(){
        return "Name: " + this.artistName + ";\t " +
                "Id: " + this.getId() + ";\t " +
                "DateOfBirth: " + this.dateOfBirth.toString() + ";\t " +
                "City: " + this.city + ";\t " +
                "Country: " + this.country + ";\t ";
    }

    public void printData(){
        System.out.println(displayData());
    }
}
