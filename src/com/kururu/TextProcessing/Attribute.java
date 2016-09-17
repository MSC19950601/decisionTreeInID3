package com.kururu.TextProcessing;

import java.util.HashMap;

/**
 * Created by Ellery Queen on 2016/9/13.
 */
public class Attribute {

    private String AttributeName;

    private HashMap<String, Situation> SituationMap;

    private HashMap<String, Integer> SituationCount;

    public Attribute() {
        SituationMap = new HashMap<>();
        SituationCount = new HashMap<>();
    }

    public void setAttributeName(String attributeName) {
        AttributeName = attributeName;
    }

    public String getAttributeName() {
        return AttributeName;
    }

    public void setSituationMap(HashMap<String, Situation> situationMap) {
        SituationMap = situationMap;
    }

    public HashMap<String, Situation> getSituationMap() {
        return SituationMap;
    }

    public void setSituationCount(HashMap<String, Integer> situationCount) {
        SituationCount = situationCount;
    }

    public HashMap<String, Integer> getSituationCount() {
        return SituationCount;
    }

    @Override
    public String toString() {

        return this.getAttributeName() + this.getSituationMap().toString() + this.getSituationCount().toString();

    }
}
