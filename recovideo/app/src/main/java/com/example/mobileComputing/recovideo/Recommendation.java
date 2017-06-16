package com.example.mobileComputing.recovideo;

/**
 * Created by mj on 28/05/2017.
 */

public class Recommendation {
    private String name, age, occupation, timestamp;

    public Recommendation() {
    }

    public Recommendation(String name, String age, String occupation, String timestamp) {
        if (name.length() >= 23){
            String tmp = name.substring(0, 20);
            tmp = tmp.concat("...");
            this.name = tmp;
        } else {
            this.name = name;
        }
        this.age = age;
        this.occupation = occupation;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}