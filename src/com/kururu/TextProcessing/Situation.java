package com.kururu.TextProcessing;

import java.util.HashMap;

/**
 * Created by Ellery Queen on 2016/9/13.
 */
public class Situation {

    private String SituationName;

    private HashMap<String, Integer> ResultCount;

    public Situation() {
        ResultCount = new HashMap<>();
    }

    public void setSituationName(String situationName) {
        SituationName = situationName;
    }

    public String getSituationName() {
        return SituationName;
    }

    public void setResultCount(HashMap<String, Integer> resultCount) {
        ResultCount = resultCount;
    }

    public HashMap<String, Integer> getResultCount() {
        return ResultCount;
    }
}
