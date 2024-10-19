package com.mtgjson.app;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.Duration;
import java.time.Instant;


import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Instant start = Instant.now();
		List<String> diffs = new ArrayList<String>();
		String pathToNewDir = "src/main/resources/AllSetsNew/";
		String pathToOldDir = "src/main/resources/AllSetsOld/";
		
		File newDir = new File(pathToNewDir);
		File oldDir = new File(pathToOldDir);
		
		diffs = ComparisonUtils.findNewSetFiles(newDir.list(), oldDir.list());
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Map<String, List<String>>> jsonDiff = new HashMap<String,Map<String,List<String>>>();
		CardDiffs jsonDiffs = new CardDiffs();
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
				List<String> newCards = ComparisonUtils.findNewUuids(newSet.getData().getUuids(), oldSet.getData().getUuids());
				List<String> removeCards = ComparisonUtils.removeSetCards(newSet.getData().getUuids(),oldSet.getData().getUuids());
				if(!newCards.isEmpty()) {
					jsonDiffs.addAdditions(file, newCards);
				}
				if(!removeCards.isEmpty()) {
					jsonDiffs.addRemovals(file, removeCards);
				}
				if(setDiffs.isEmpty()) {
					continue;
				}
				jsonDiff.put(file + " / " +oldSet.meta.getDate() + "->" + newSet.meta.getDate(), setDiffs);
				jsonDiffs.addChanges(file, setDiffs);
			}catch(FileNotFoundException e){
				System.out.println("This file doesn't exist: " + e.getMessage());
			}catch(IOException e) {
				System.out.println("An error occurred while reading the file: " + e.getMessage());
			}
		}
		
		File file = new File("output.json");
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,jsonDiffs);
		Instant end = Instant.now();
		Duration time = Duration.between(start, end);
		System.out.println("File written to: " + file.getAbsolutePath());
		System.out.println("Time for program execution: "+ time.toMillis());
	}
	
	
}
