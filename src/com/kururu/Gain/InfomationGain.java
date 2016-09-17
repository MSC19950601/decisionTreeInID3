package com.kururu.Gain;

import com.kururu.TextProcessing.TextProcessing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ellery Queen on 2016/9/17.
 */
public class InfomationGain {

    public InfomationGain() {}

    //计算熵
    public double getInfomationEntroy(HashMap<String, Integer> CalcuParam) {

        int TotalCount = 0;
        double TotalEntroy = 0;

        return TotalEntroy;
    }

    //计算信息增益
    public double getInfomationGain(double Entropy_S, ArrayList<Integer> CalcuParamInt, ArrayList<double> CalcuParamDou) {

        int TotalCount = 0;
        double TotalGain = 0;


        return TotalGain;
    }

    public double getInfomationSplit(ArrayList<double> CalcuParam) {

        int TotalCount = 0;
        double TotalSplit = 0;

        return TotalSplit;
    }

    public double getInfomationGainRatio(double Gain, double Split) {
        return (Gain/Split);
    }

    public String getMaxGainName(TextProcessing textProcessingInput) {

    }



}
