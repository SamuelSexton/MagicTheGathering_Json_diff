package com.mtgjson.app;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtgjson.app.ComparisonUtils;

public class App {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//String pathToNewFile = "src/main/resources/AllSetsNew/M3C.json";
		//String pathToOldFile = "src/main/resources/AllSetsOld/M3C.json";
		//File newFile = new File(pathToNewFile);
		//File oldFile = new File(pathToOldFile);
		 
		List<String> diffs = new ArrayList<String>();
		String pathToNewDir = "src/main/resources/AllSetsNew/";
		String pathToOldDir = "src/main/resources/AllSetsOld/";
		
		File newDir = new File(pathToNewDir);
		File oldDir = new File(pathToOldDir);
		
		diffs = ComparisonUtils.findNewSetFiles(newDir.list(), oldDir.list());
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Map<String, List<String>>> jsonDiff = new HashMap();
		for(String file : newDir.list()) {
			if(diffs.contains(file)) {
				continue;
			}
			
			try{
				File newFile = new File(pathToNewDir + file);
				File oldFile = new File(pathToOldDir + file);
				Set newSet = objectMapper.readValue(newFile, Set.class);
				Set oldSet = objectMapper.readValue(oldFile, Set.class);
				
				Map<String,List<String>> setDiffs = ComparisonUtils.returnDiscrepancies(newSet.getData(), oldSet.getData());
				jsonDiff.put(file, setDiffs);
			}catch(IOException e){
				System.out.println("An error occurred while reading the file: " + e.getMessage());
			}
		}
		File file = new File("output.json");
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,jsonDiff);
		System.out.println("File written to: " + file.getAbsolutePath());
	}
	
	
}
