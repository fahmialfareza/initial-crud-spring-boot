package com.fahmialfareza.initialDemo.Entity;

public class Address {

    private String Street;
    private int Number;

    public Address(String street, int number) {
        Street = street;
        Number = number;
    }

    public Address() {
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }
}
