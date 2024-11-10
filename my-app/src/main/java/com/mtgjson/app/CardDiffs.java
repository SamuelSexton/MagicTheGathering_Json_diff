package com.mtgjson.app;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CardDiffs {
	
	public Map<String, Map<String, List<String>>> changes = new HashMap<String, Map<String, List<String>>>();
	
	public Map<String,List<String>> additions = new HashMap<String, List<String>>();
	
	public Map<String,List<String>> removals = new HashMap<String, List<String>>();
	
	public Map<String, Map<String, List<String>>> getChanges() {
		return changes;
	}

	public void setChanges(Map<String, Map<String, List<String>>> changes) {
		this.changes = changes;
	}
	
	public void addChanges(String file, Map<String, List<String>> diffs) {
		this.changes.put(file, diffs);
	}
	

	public Map<String,List<String>> getAdditions() {
		return additions;
	}

	public void setAdditions(Map<String,List<String>> additions) {
		this.additions = additions;
	}
	public void addAdditions(String file, List<String> adds) {
		this.additions.put(file, adds);
	}

	public Map<String,List<String>> getRemovals() {
		return removals;
	}

	public void setRemovals(Map<String,List<String>> removals) {
		this.removals = removals;
	}
	
	public void addRemovals(String file, List<String> remove) {
		this.removals.put(file,remove);
	}
	
	public String createInsert(Card card) {
		List<String> fields = ComparisonUtils.getPropertyNames(card.getClass());
		ObjectMapper mapper = new ObjectMapper();
		String insertStm = "INSERT INTO (";
		String values = "VALUES (";
		try {
			String jsonString = mapper.writeValueAsString(card);
			JsonNode rootNode = mapper.readTree(jsonString);
			for(String field : fields) {
				insertStm += field + ",";
				values += rootNode.findValues(field) + ",";
			}
			insertStm += ")";
			values += ")";
			insertStm += " " + values + ";\n";
		}catch(IOException e) {
			e.printStackTrace();;
		}
		
		return insertStm;
	}
	
}