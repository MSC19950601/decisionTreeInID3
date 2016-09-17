package com.kururu.TextProcessing;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ellery Queen on 2016/9/13.
 */
public class TextProcessing {


    private Result objResult;

    private ArrayList<Attribute>  objAttributeList;

    private String headers[];

    private List<String> textList;

    public TextProcessing() {

        objResult = new Result();
        objAttributeList = new ArrayList<>();
        textList = new ArrayList<>();

    }

    public void setObjResult(Result objResult) {
        this.objResult = objResult;
    }

    public void setObjAttributeList(ArrayList<Attribute> objAttributeList) {
        this.objAttributeList = objAttributeList;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public void setTextList(List<String> textList) {
        this.textList = textList;
    }

    public Result getObjResult() {
        return objResult;
    }

    public ArrayList<Attribute> getObjAttributeList() {
        return objAttributeList;
    }

    public String[] getHeaders() {
        return headers;
    }

    public List<String> getTextList() {
        return textList;
    }

    public void readText(File file) {

        try {
            List<String> textListTmp = FileUtils.readLines(file);
            textProcess(textListTmp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void textProcess( List<String> textListInput ) {

//        for (String l:textList
//             ) {
//            System.out.println(l);
//        }

        for(String textLine : textListInput) {
            this.textList.add(textLine);
        }

//        System.out.println(textList.remove(0));

        headers = textListInput.remove(0).split(",");


//        System.out.println("=====================================");
//        for (String l:textList
//                ) {
//            System.out.println(l);
//        }

//        for (String l:headers
//             ) {
//            System.out.println(l);
//        }

        for(int i = 0; i < headers.length - 1; i++) {
            Attribute objAttr = new Attribute();
            objAttr.setAttributeName(headers[i]);
            objAttributeList.add(objAttr);
        }

        objResult.setResultName(headers[headers.length - 1]);
//        System.out.println(objResult.getResultName());

        for (String textLine : textListInput) {

            String[] textArray = textLine.split(",");

//            System.out.println(textArray[0] + " " + textArray[1] + " " + textArray[2] + " " + textArray[3]+ " " + textArray[4]);

//            for (String l:textArray) {
//                System.out.println(l);
//            }
            int lastIndex = textArray.length - 1;

            for (int i = 0; i < lastIndex; i++) {

                Attribute objAttr = objAttributeList.get(i);

//                System.out.println(objAttr.toString());

                if( !objAttr.getSituationCount().containsKey(textArray[i])) {
                    objAttr.getSituationCount().put(textArray[i], 1);
                    Situation objSitu = new Situation();
                    objSitu.setSituationName(textArray[i]);

                    if( !objSitu.getResultCount().containsKey(textArray[lastIndex])) {
                        objSitu.getResultCount().put(textArray[lastIndex], 1);
                    }else {
                        objSitu.getResultCount().put(textArray[lastIndex],
                                objSitu.getResultCount().get(textArray[lastIndex]) + 1);
                    }
                    objAttr.getSituationMap().put(textArray[i], objSitu);
                }
                else {
                    objAttr.getSituationCount().put(textArray[i], objAttr.getSituationCount().get(textArray[i]) + 1);
                    Situation objSitu = objAttr.getSituationMap().get(textArray[i]);
                    if(!objSitu.getResultCount().containsKey(textArray[lastIndex])) {
                        objSitu.getResultCount().put(textArray[lastIndex], 1);
                    }else {
                        objSitu.getResultCount().put(textArray[lastIndex], objSitu.getResultCount().get(textArray[lastIndex]) + 1);
                    }
                }

//                System.out.println(objAttr.toString());
            }
            if(!objResult.getResultCount().containsKey(textArray[lastIndex])) {
                objResult.getResultCount().put(textArray[lastIndex], 1);
                objResult.getResultList().add(textArray[lastIndex]);
            }else
            {
                objResult.getResultCount().put(textArray[lastIndex], objResult.getResultCount().get(textArray[lastIndex]) + 1);
            }
        }
//        for (Attribute a : this.objAttributeList
//             ) {
//            System.out.println(a.toString());
//        }
    }

    public List<String> getChildTable( String AttributeNameInput, String SituationNameInput) {

        List<String> newTextList = new ArrayList<>();

        String headers[] = this.textList.get(0).split(",");



        return newTextList;
    }


}
