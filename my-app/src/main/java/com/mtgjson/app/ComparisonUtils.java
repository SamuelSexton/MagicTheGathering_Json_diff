package com.mtgjson.app;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComparisonUtils {
	//Returns a list of file differences, essentially new Sets that have been added
	public static List<String> findNewSetFiles(String[] newSets, String[] oldSets) {
		Set<String> setsNew = new HashSet<String>(Arrays.asList(newSets));
		Set<String> setsOld= new HashSet<String>(Arrays.asList(oldSets));
		
		setsNew.removeAll(setsOld);
		return new ArrayList<>(setsNew);
	}
	
	//Returns a difference between two Lists of Card objects
	public static List<Card> findCardChanges(List<Card> newCardList, List<Card> oldCardList) {
		Set<Card> newSetList = new HashSet<Card>(newCardList);
		Set<Card> oldSetList = new HashSet<Card>(oldCardList);
		
		newSetList.removeAll(oldCardList);
		return new ArrayList<>(newSetList);
	}
	
	//Returns a difference between two Lists of Card object uuid properties
	public static List<String> findNewUuids(List<String> newUuids, List<String> oldUuids) {
		Set<String> newUuidsList = new HashSet<String>(newUuids);
		Set<String> oldUuidsList = new HashSet<String>(oldUuids);
		
		newUuidsList.removeAll(oldUuidsList);
		return new ArrayList<>(newUuidsList);
	}
	
	//Returns a Hash Map of mutual cards between two sets based on uuid
	public static Map<String,Card> retainSameCards(Data newCardData, Data oldCardData) {
		Map<String,Card> mutualCards = new HashMap<String,Card>();
		List<String> uuidDiffs = findNewUuids(newCardData.getUuids(), oldCardData.getUuids());
		Set<String> uuidSet = new HashSet<String>(uuidDiffs);
		
		for(Card card: newCardData.getCards()) {
			if(!uuidSet.contains(card.uuid)) {
				mutualCards.put(card.uuid,card); //mapping uuid to corresponding card
			}
		}
		
		return mutualCards;
	}
	
	//Returns a List of Cards that detects whether there was a change in any property from the old
	// set to the new set
	public static List<Card> findCardDiffs(Data newCardData, Data oldCardData) {
		List<Card> mutualCards = new ArrayList<Card>();
		List<String> uuidDiffs = findNewUuids(newCardData.getUuids(), oldCardData.getUuids());
		Set<String> uuidSet = new HashSet<String>(uuidDiffs);
		
		for(Card card: newCardData.getCards()) {
			if(!uuidSet.contains(card.uuid)) {
				mutualCards.add(card); 
			}
		}
		
		return findCardChanges(mutualCards, oldCardData.getCards());
	}
	
	public static List<String> getPropertyNames(Class<?> clazz) {
        List<String> propertyNames = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields(); // Get declared fields

        for (Field field : fields) {
            propertyNames.add(field.getName()); // Add field name to the list
        }
        
        return propertyNames;
    }
	
	public static Map<String, List<String>> returnDiscrepancies(Data newCardData, Data oldCardData) {
		Map<String, List<String>> setDiffs = new HashMap();
		List<Card> cardDiff = findCardDiffs(newCardData, oldCardData);
		List<Card> oldCards = oldCardData.getCards();
		List<String> oldCardsUuids = oldCardData.getUuids();
		for(Card card : cardDiff) {
			List<String> cardProps;
			List<String> propChanges = new ArrayList<String>();
			int foo = oldCardsUuids.lastIndexOf(card.uuid);
			if(foo == -1) {
				System.out.println("This code is jacked");
			}else {
				Card oldCard = oldCards.get(foo);
				cardProps = getPropertyNames(card.getClass());
				for(String prop : cardProps) {
					if(!hasPropChanged(card,oldCard,prop)) {
						propChanges.add(prop);
					}
				}
			}
			setDiffs.put(card.uuid, propChanges);
		}
		return setDiffs;
	}
	
	public static boolean hasPropChanged(Card newCard, Card oldCard, String prop) {
	    boolean propBool;

	    switch (prop) {
	        case "colors":
	            propBool = safeEquals(newCard.colors, oldCard.colors);
	            break;
	        case "defense":
	            propBool = safeEquals(newCard.defense, oldCard.defense);
	            break;
	        case "identifiers":
	            propBool = safeEquals(newCard.identifiers, oldCard.identifiers);
	            break;
	        case "keywords":
	            propBool = safeEquals(newCard.keywords, oldCard.keywords);
	            break;
	        case "leadershipSkills":
	            propBool = safeEquals(newCard.leadershipSkills, oldCard.leadershipSkills);
	            break;
	        case "legalities":
	            propBool = safeEquals(newCard.legalities, oldCard.legalities);
	            break;
	        case "loyalty":
	            propBool = safeEquals(newCard.loyalty, oldCard.loyalty);
	            break;
	        case "manaCost":
	            propBool = safeEquals(newCard.manaCost, oldCard.manaCost);
	            break;
	        case "manaValue":
	            propBool = newCard.manaValue == oldCard.manaValue;
	            break;
	        case "name":
	            propBool = safeEquals(newCard.name, oldCard.name);
	            break;
	        case "originalText":
	            propBool = safeEquals(newCard.originalText, oldCard.originalText);
	            break;
	        case "originalType":
	            propBool = safeEquals(newCard.originalType, oldCard.originalType);
	            break;
	        case "power":
	            propBool = safeEquals(newCard.power, oldCard.power);
	            break;
	        case "purchaseUrls":
	            propBool = safeEquals(newCard.purchaseUrls, oldCard.purchaseUrls);
	            break;
	        case "rarity":
	            propBool = safeEquals(newCard.rarity, oldCard.rarity);
	            break;
	        case "rulings":
	            propBool = safeEquals(newCard.rulings, oldCard.rulings);
	            break;
	        case "setCode":
	            propBool = safeEquals(newCard.setCode, oldCard.setCode);
	            break;
	        case "side":
	            propBool = safeEquals(newCard.side, oldCard.side);
	            break;
	        case "subTypes":
	            propBool = safeEquals(newCard.subTypes, oldCard.subTypes);
	            break;
	        case "superTypes":
	            propBool = safeEquals(newCard.superTypes, oldCard.superTypes);
	            break;
	        case "text":
	            propBool = safeEquals(newCard.text, oldCard.text);
	            break;
	        case "toughness":
	            propBool = safeEquals(newCard.toughness, oldCard.toughness);
	            break;
	        case "type":
	            propBool = safeEquals(newCard.type, oldCard.type);
	            break;
	        case "types":
	            propBool = safeEquals(newCard.type, oldCard.type);
	            break;
	        case "uuid":
	            propBool = safeEquals(newCard.uuid, oldCard.uuid);
	            break;
	        default: 
	            throw new IllegalArgumentException("Invalid property name: " + prop);
	    }
	    
	    return propBool;
	}
	
	private static boolean safeEquals(Object a, Object b) {
	    return (a == null) ? (b == null) : a.equals(b);
	}
}
