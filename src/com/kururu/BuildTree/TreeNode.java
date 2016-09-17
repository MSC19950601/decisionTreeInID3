package com.kururu.BuildTree;

import java.util.HashMap;

/**
 * Created by Ellery Queen on 2016/9/17.
 */
public class TreeNode {

    private boolean isLeafNode;

    private String AttributeName;

    private String SituationName;

    private String ParentName;

    private Integer ChildCount;

    private HashMap<String, Boolean> SituationMap;

    private HashMap<String, TreeNode> ChildNodes;

    public TreeNode() {

        ChildCount = 0;
        SituationMap = new HashMap<>();
        ChildNodes = new HashMap<>();

    }

    public boolean isLeafNode() {
        return isLeafNode;
    }

    public HashMap<String, Boolean> getSituationMap() {
        return SituationMap;
    }

    public HashMap<String, TreeNode> getChildNodes() {
        return ChildNodes;
    }

    public Integer getChildCount() {
        return ChildCount;
    }

    public String getAttributeName() {
        return AttributeName;
    }

    public String getParentName() {
        return ParentName;
    }

    public String getSituationName() {
        return SituationName;
    }

    public void setAttributeName(String attributeName) {
        AttributeName = attributeName;
    }

    public void setChildCount(Integer childCount) {
        ChildCount = childCount;
    }

    public void setChildNodes(HashMap<String, TreeNode> childNodes) {
        ChildNodes = childNodes;
    }

    public void setLeafNode(boolean leafNode) {
        isLeafNode = leafNode;
    }

    public void setParentName(String parentName) {
        ParentName = parentName;
    }

    public void setSituationMap(HashMap<String, Boolean> situationMap) {
        SituationMap = situationMap;
    }

    public void setSituationName(String situationName) {
        SituationName = situationName;
    }
}
