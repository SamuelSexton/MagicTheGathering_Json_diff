package com.mtgjson.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComparisonUtils {
	public static List<String> findNewSets(String[] newSets, String[] oldSets) {
		Set<String> setsNew = new HashSet<String>(Arrays.asList(newSets));
		Set<String> setsOld= new HashSet<String>(Arrays.asList(oldSets));
		
		setsNew.removeAll(setsOld);
		return new ArrayList<>(setsNew);
	}
	
	public static List<Card> findNewCards(List<Card> newCardList, List<Card> oldCardList) {
		Set<Card> newSetList = new HashSet<Card>(newCardList);
		Set<Card> oldSetList = new HashSet<Card>(oldCardList);
		
		newSetList.removeAll(oldCardList);
		return new ArrayList<>(newSetList);
	}
	
	public static List<String> findNewUuids(List<String> newUuids, List<String> oldUuids) {
		Set<String> newUuidsList = new HashSet<String>(newUuids);
		Set<String> oldUuidsList = new HashSet<String>(oldUuids);
		
		newUuidsList.removeAll(oldUuidsList);
		return new ArrayList<>(newUuidsList);
	}
}
