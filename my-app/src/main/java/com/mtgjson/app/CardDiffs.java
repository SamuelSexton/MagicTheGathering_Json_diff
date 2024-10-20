package com.mtgjson.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
}