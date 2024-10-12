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
	/*
	 * Returns a list of file differences, essentially new Sets that have been added
	 * Used for excluding files when looping through the directory
	*/
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
	
	//Return a List of properties of a Card object
	//Used for the purpose of checking property values of a Card from the new set against the Old set
	public static List<String> getPropertyNames(Class<?> clazz) {
        List<String> propertyNames = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            propertyNames.add(field.getName()); 
        }
        
        return propertyNames;
    }
	
	/*
	 *This method returns a hash map containing a card uuid and a list of properties that changed from the old set
	 *to the new set 
	 */
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
	
	
	/*
	 * Returns True or False against the value of a Card property from the new set is equal to the value of a
	 * Card property from the old set
	*/ 
	public static boolean hasPropChanged(Card newCard, Card oldCard, String prop) {
	    boolean propBool;

	    switch (prop) {
	        case "colors":
	            propBool = nullEqualsCheck(newCard.colors, oldCard.colors);
	            break;
	        case "defense":
	            propBool = nullEqualsCheck(newCard.defense, oldCard.defense);
	            break;
	        case "identifiers":
	            propBool = nullEqualsCheck(newCard.identifiers, oldCard.identifiers);
	            break;
	        case "keywords":
	            propBool = nullEqualsCheck(newCard.keywords, oldCard.keywords);
	            break;
	        case "leadershipSkills":
	            propBool = nullEqualsCheck(newCard.leadershipSkills, oldCard.leadershipSkills);
	            break;
	        case "legalities":
	            propBool = nullEqualsCheck(newCard.legalities, oldCard.legalities);
	            break;
	        case "loyalty":
	            propBool = nullEqualsCheck(newCard.loyalty, oldCard.loyalty);
	            break;
	        case "manaCost":
	            propBool = nullEqualsCheck(newCard.manaCost, oldCard.manaCost);
	            break;
	        case "manaValue":
	            propBool = newCard.manaValue == oldCard.manaValue;
	            break;
	        case "name":
	            propBool = nullEqualsCheck(newCard.name, oldCard.name);
	            break;
	        case "originalText":
	            propBool = nullEqualsCheck(newCard.originalText, oldCard.originalText);
	            break;
	        case "originalType":
	            propBool = nullEqualsCheck(newCard.originalType, oldCard.originalType);
	            break;
	        case "power":
	            propBool = nullEqualsCheck(newCard.power, oldCard.power);
	            break;
	        case "purchaseUrls":
	            propBool = nullEqualsCheck(newCard.purchaseUrls, oldCard.purchaseUrls);
	            break;
	        case "rarity":
	            propBool = nullEqualsCheck(newCard.rarity, oldCard.rarity);
	            break;
	        case "rulings":
	            propBool = nullEqualsCheck(newCard.rulings, oldCard.rulings);
	            break;
	        case "setCode":
	            propBool = nullEqualsCheck(newCard.setCode, oldCard.setCode);
	            break;
	        case "side":
	            propBool = nullEqualsCheck(newCard.side, oldCard.side);
	            break;
	        case "subTypes":
	            propBool = nullEqualsCheck(newCard.subTypes, oldCard.subTypes);
	            break;
	        case "superTypes":
	            propBool = nullEqualsCheck(newCard.superTypes, oldCard.superTypes);
	            break;
	        case "text":
	            propBool = nullEqualsCheck(newCard.text, oldCard.text);
	            break;
	        case "toughness":
	            propBool = nullEqualsCheck(newCard.toughness, oldCard.toughness);
	            break;
	        case "type":
	            propBool = nullEqualsCheck(newCard.type, oldCard.type);
	            break;
	        case "types":
	            propBool = nullEqualsCheck(newCard.type, oldCard.type);
	            break;
	        case "uuid":
	            propBool = nullEqualsCheck(newCard.uuid, oldCard.uuid);
	            break;
	        default: 
	            throw new IllegalArgumentException("Invalid property name: " + prop);
	    }
	    
	    return propBool;
	}
	
	//Checks for null values and checks for equality when not null
	private static boolean nullEqualsCheck(Object a, Object b) {
	    return (a == null) ? (b == null) : a.equals(b);
	}
}
