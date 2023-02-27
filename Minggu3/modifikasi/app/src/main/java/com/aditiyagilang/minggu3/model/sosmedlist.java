package com.aditiyagilang.minggu3.model;

public class sosmedlist {
    private final Integer medsos;
    private final String name;

    public sosmedlist(Integer medsos, String name) {
        this.medsos = medsos;
        this.name = name;
    }



    public Integer getMedsos() {
        return medsos;
    }

    public String getName() {
        return name;
    }
}
