package com.mtgjson.app;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtgjson.app.ComparisonUtils;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathToNewFile = "src/main/resources/AllSetsNew/M3C.json";
		String pathToOldFile = "src/main/resources/AllSetsOld/M3C.json";
		File newFile = new File(pathToNewFile);
		File oldFile = new File(pathToOldFile);
		 
		List<String> diffs = new ArrayList<String>();
		String pathToNewDir = "src/main/resources/AllSetsNew";
		String pathToOldDir = "src/main/resources/AllSetsOld";
		
		File newDir = new File(pathToNewDir);
		File oldDir = new File(pathToOldDir);
		
		diffs = ComparisonUtils.findNewSets(newDir.list(), oldDir.list());
		ObjectMapper objectMapper = new ObjectMapper();
		
		try{
			Set newSet = objectMapper.readValue(newFile, Set.class);
			Set oldSet = objectMapper.readValue(oldFile, Set.class);
			
			List<Card> cardDiffs = ComparisonUtils.findNewCards(newSet.getData().getCards(), oldSet.getData().getCards());
			List<String> uuidDiffs = ComparisonUtils.findNewUuids(newSet.getData().getUuids(), oldSet.getData().getUuids());
			System.out.println(cardDiffs.size());
			System.out.println(newSet.getData().getCards().size());
			System.out.println(oldSet.getData().getCards().size());
			System.out.println(uuidDiffs.size());
			for(String uuid : uuidDiffs) {
				System.out.println(uuid);
			}
		}catch(IOException e){
			System.out.println("An error occurred while reading the file: " + e.getMessage());
		}
		
		
	}
	
	
}
