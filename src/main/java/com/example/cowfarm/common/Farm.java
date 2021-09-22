package com.example.cowfarm.common;

public interface Farm {

    void giveBirth(long parentId, String name);
    void endLifeSpan(long id);
    void printFarmData();
}
