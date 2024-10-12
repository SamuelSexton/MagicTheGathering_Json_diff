package com.mtgjson.app;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtgjson.app.ComparisonUtils;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathToNewFile = "src/main/resources/AllSetsNew/10E.json";
		String pathToOldFile = "src/main/resources/AllSetsOld/10E.json";
		File newFile = new File(pathToNewFile);
		File oldFile = new File(pathToOldFile);
		 
		List<String> diffs = new ArrayList<String>();
		String pathToNewDir = "src/main/resources/AllSetsNew";
		String pathToOldDir = "src/main/resources/AllSetsOld";
		
		File newDir = new File(pathToNewDir);
		File oldDir = new File(pathToOldDir);
		
		diffs = ComparisonUtils.findNewSetFiles(newDir.list(), oldDir.list());
		ObjectMapper objectMapper = new ObjectMapper();
		
		try{
			Set newSet = objectMapper.readValue(newFile, Set.class);
			Set oldSet = objectMapper.readValue(oldFile, Set.class);
			
			Map<String,List<String>> setDiffs = ComparisonUtils.returnDiscrepancies(newSet.getData(), oldSet.getData());
			System.out.println(setDiffs);
			System.out.println(setDiffs.size());
		}catch(IOException e){
			System.out.println("An error occurred while reading the file: " + e.getMessage());
		}
	}
	
	
}
