package com.monzag.mountaintripmanager.trip;

import com.monzag.mountaintripmanager.mountain.Mountain;

public class Trip {

    private Integer id;
    private String data;
    private String distance;
    private String time;
    private Mountain mountain;

    public Trip(Integer id, String data, String distance, String time, Mountain mountain) {
        this.id = id;
        this.data = data;
        this.distance = distance;
        this.time = time;
        this.mountain = mountain;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }
}
