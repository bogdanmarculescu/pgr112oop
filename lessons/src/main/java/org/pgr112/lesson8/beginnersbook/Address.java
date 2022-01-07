package org.pgr112.lesson8.beginnersbook;

public class Address {
    String street;
    int postal;
    String city;
    String state;
    String country;
    Address(String street, int postal, String city, String state, String country)
    {
        this.street=street;
        this.postal = postal;
        this.city =city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", postal=" + postal +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
