package com.kururu.TextProcessing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ellery Queen on 2016/9/13.
 */
public class Result {

    private String ResultName;

    private ArrayList<String> ResultList;

    private HashMap<String, Integer> ResultCount;

    public Result() {
        ResultList = new ArrayList<>();
        ResultCount = new HashMap<>();
    }

    public void setResultName(String ResultName) {
        this.ResultName = ResultName;
    }

    public String getResultName() {
        return ResultName;
    }

    public void setResultList(ArrayList<String> resultList) {
        ResultList = resultList;
    }

    public ArrayList<String> getResultList() {
        return ResultList;
    }

    public void setResultCount(HashMap<String, Integer> resultCount) {
        ResultCount = resultCount;
    }

    public HashMap<String, Integer> getResultCount() {
        return ResultCount;
    }
}
