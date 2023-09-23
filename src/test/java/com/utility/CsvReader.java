package com.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
	 public static String[][] readCSV(String csvFile) {
	        List<String[]> rows = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(",");
	                rows.add(data);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        int numRows = rows.size();
	        int numCols = rows.get(0).length;
	        String[][] dataArray = new String[numRows][numCols];
	        for (int i = 0; i < numRows; i++) {
	            dataArray[i] = rows.get(i);
	        }
	        return dataArray;
	    }
}
