package com.kururu.Gain;

import com.kururu.TextProcessing.Attribute;
import com.kururu.TextProcessing.TextProcessing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ellery Queen on 2016/9/17.
 */
public class InfomationGain {

    public InfomationGain() {}

    //计算每个分类指标的熵
    public double getInfomationEntroy(HashMap<String, Integer> CalcuParam) {

        int TotalCount = 0;
        double TotalEntroy = 0;

        for (String CalcuName : CalcuParam.keySet()
             ) {
//            System.out.println(CalcuName);
            int SingleCount = CalcuParam.get(CalcuName);
//            System.out.println(SingleCount);
            TotalCount += SingleCount;
        }

        for (String CalcuName : CalcuParam.keySet()
             ) {
            int SingleCount = CalcuParam.get(CalcuName);

            double Proportion = (double)SingleCount / (double) TotalCount;
//            System.out.println("Proportion " + Proportion);
            double Logarithmic = Math.log(Proportion) / Math.log(2);
//            System.out.println("Logarithmic " + Logarithmic);
            double SingleEntroy = -(Proportion) * (Logarithmic);
//            System.out.println("SingleEntroy " + SingleEntroy);
//            System.out.println();
            TotalEntroy += SingleEntroy;
        }

        return TotalEntroy;
    }

    //计算信息增益
    public double getInfomationGain(double Entropy_S, ArrayList<Integer> CalcuParamInt, ArrayList<Double> CalcuParamDou) {

        int TotalCount = 0;
        double TotalGain = 0;

        for (Integer SingelCount : CalcuParamInt
             ) {
            TotalCount += SingelCount;
        }

        for(int i = 0; i < CalcuParamInt.size(); i++) {
            int SingleCount =CalcuParamInt.get(i);
            double Proportion = (double)SingleCount / (double) TotalCount;
            double SingleEntroy = (Proportion)*(CalcuParamDou.get(i));
            TotalGain += SingleEntroy;
        }

        TotalGain = Entropy_S - TotalGain;

        return TotalGain;
    }

    public double getInfomationSplit(ArrayList<Integer> CalcuParam) {

        int TotalCount = 0;
        double TotalSplit = 0;

        for (Integer SingelCount : CalcuParam
                ) {
            TotalCount += SingelCount;
        }

        for (Integer SingleCount : CalcuParam
                ) {

            double Proportion = (double)SingleCount / (double) TotalCount;
            double Logarithmic = Math.log(Proportion) / Math.log(2);
            double SingleSplit = -(Proportion) * (Logarithmic);

            TotalSplit += SingleSplit;
        }

        TotalSplit = -TotalSplit;

        return TotalSplit;
    }

    public double getInfomationGainRatio(double Gain, double Split) {
        return (Gain/Split);
    }

    public String getMaxGainName(TextProcessing textProcessingInput) {

        double Entropy_S = getInfomationEntroy(textProcessingInput.getObjResult().getResultCount());

//        System.out.println(Entropy_S);

        HashMap<String, Double> GainMap = new HashMap<>();
//
        for( int i = 0; i < textProcessingInput.getObjAttributeList().size(); i++) {
            Attribute objAttr = textProcessingInput.getObjAttributeList().get(i);

            ArrayList<Integer> CalcuParamInt = new ArrayList<>();
            ArrayList<Double> CalcuParamDouble = new ArrayList<>();

            for (String SituName : objAttr.getSituationCount().keySet()
                 ) {
                CalcuParamInt.add(objAttr.getSituationCount().get(SituName));
                CalcuParamDouble.add
                        (
                            getInfomationEntroy
                                    (
                                        objAttr.getSituationMap().get(SituName).getResultCount()
                                    )
                         );
            }

            double Gain = getInfomationGain(Entropy_S, CalcuParamInt, CalcuParamDouble);
            double Split = getInfomationSplit(CalcuParamInt);
            double GainRatio = getInfomationGainRatio(Gain, Split);
            GainMap.put(objAttr.getAttributeName(), GainRatio);
        }
        Double MaxGain = null;
        String MaxGainName = null;

        return MaxGainName;
    }



}
