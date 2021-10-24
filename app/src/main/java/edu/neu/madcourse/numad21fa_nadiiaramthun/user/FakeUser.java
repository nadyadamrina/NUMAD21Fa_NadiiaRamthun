package edu.neu.madcourse.numad21fa_nadiiaramthun.user;

import edu.neu.madcourse.numad21fa_nadiiaramthun.user.location.Location;

public class FakeUser {
    private Name name;
    private Location location;
    private String email;
    private String username;
    private int age;
    private String phoneNumber;
    private String cellNumber;

    public FakeUser(Name name, Location location, String email, String username, int age, String phoneNumber, String cellNumber) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.username = username;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cellNumber = cellNumber;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }
}
