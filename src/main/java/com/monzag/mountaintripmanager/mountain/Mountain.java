package com.monzag.mountaintripmanager.mountain;

public class Mountain {
    public Mountain(Integer id, String name, Integer height, String mountainRange) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.mountainRange = mountainRange;
    }

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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getMountainRange() {
        return mountainRange;
    }

    public void setMountainRange(String mountainRange) {
        this.mountainRange = mountainRange;
    }

    private Integer id;
    private String name;
    private Integer height;
    private String mountainRange;

}
