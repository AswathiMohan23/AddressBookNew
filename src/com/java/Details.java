package com.java;

import java.time.LocalDate;

public class Details {
    private String firstName;
    private String address;
    private String zipCode;
    private String mobileNumber;
    private String lastName;

    public Details(String firstName, String lastName,String address, String zipCode, String mobileNumber) {
        this.firstName = firstName;
        this.address = address;
        this.zipCode = zipCode;
        this.mobileNumber = mobileNumber;
        this.lastName = lastName;
    }
    public Details() {}


        public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Details{" +
                " firstName ='" + firstName + '\'' +
                ", lastName ='" + lastName + '\'' +
                ", address ='" + address + '\'' +
                ", zipCode ='" + zipCode + '\'' +
                ", mobileNumber ='" + mobileNumber + '\'' +" "+
                '}';
    }


}
