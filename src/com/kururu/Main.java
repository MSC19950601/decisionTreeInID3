package com.kururu;

import com.kururu.BuildTree.BuildTree;
import com.kururu.BuildTree.TreeNode;
import com.kururu.TextProcessing.TextProcessing;

import java.io.File;

public class Main {

    public static void main(String[] args) {
	// write your code here

        TextProcessing textProcessing = new TextProcessing();
        textProcessing.readText(new File("test_case\\test1.csv"));


        BuildTree DCtree = new BuildTree();
        TreeNode root = DCtree.create(textProcessing, null, null);


    }
}
