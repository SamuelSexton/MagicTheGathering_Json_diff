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
	 * All methods inside this class are with the purpose of determining the differences in the
	 * field name values of the MTGJSON JSON files.  Specifically the comparisons are done from the
	 * JSON files inside the AllSetFiles. This program is essentially
	 */
	
	 //Returns a list of file differences, essentially new Sets that have been added
	 //Used for excluding files when looping through the directory
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
		Map<String, List<String>> setDiffs = new HashMap<String, List<String>>();
		List<Card> cardDiff = findCardDiffs(newCardData, oldCardData);
		List<Card> oldCards = oldCardData.getCards();
		List<String> oldCardsUuids = oldCardData.getUuids();
		for(Card card : cardDiff) {
			List<String> cardProps;
			List<String> propChanges = new ArrayList<String>();
			int index = oldCardsUuids.lastIndexOf(card.uuid);
			if(index == -1) {
				System.out.println("This code is jacked");
			}else {
				Card oldCard = oldCards.get(index);
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
	    	case "artist":
	    		propBool = nullEqualsCheck(newCard.artist, oldCard.artist);
	    		break;
	    	case "artistIds":
	    		propBool = nullEqualsCheck(newCard.artistIds, oldCard.artistIds);
	    		break;
	    	case "asciiName":
	    		propBool = nullEqualsCheck(newCard.asciiName, oldCard.asciiName);
	    		break;
	    	case "availability":
	    		propBool = nullEqualsCheck(newCard.availability, oldCard.availability);
	    		break;
	        case "colors":
	            propBool = nullEqualsCheck(newCard.colors, oldCard.colors);
	            break;
	        case "defense":
	            propBool = nullEqualsCheck(newCard.defense, oldCard.defense);
	            break;
	        case "faceManaValue":
	        	propBool = newCard.faceManaValue == oldCard.faceManaValue;
	            break;
	        case "faceName":
	        	propBool = nullEqualsCheck(newCard.faceName, oldCard.faceName);
	            break;
	        case "frameVersion":
	        	propBool = nullEqualsCheck(newCard.frameVersion, oldCard.frameVersion);
	            break;
	        case "hand":
	        	propBool = nullEqualsCheck(newCard.hand, oldCard.hand);
	            break;
	        case "hasAlternativeDeckLimit":
	        	propBool = nullEqualsCheck(newCard.hasAlternativeDeckLimit, oldCard.hasAlternativeDeckLimit);
	            break;
	        case "hasContentWarning":
	        	propBool = nullEqualsCheck(newCard.hasContentWarning, oldCard.hasContentWarning);
	            break;
	        case "identifiers":
	            propBool = nullEqualsCheck(newCard.identifiers, oldCard.identifiers);
	            break;
	        case "isAlternative":
	        	propBool = nullEqualsCheck(newCard.isAlternative, oldCard.isAlternative);
	            break;
	        case "isFullArt":
	        	propBool = nullEqualsCheck(newCard.isFullArt, oldCard.isFullArt);
	            break;
	        case "isFunny":
	        	propBool = nullEqualsCheck(newCard.isFunny, oldCard.isFunny);
	            break;
	        case "isOnlineOnly":
	        	propBool = nullEqualsCheck(newCard.isOnlineOnly, oldCard.isOnlineOnly);
	            break;
	        case "isOversized":
	        	propBool = nullEqualsCheck(newCard.isOversized, oldCard.isOversized);
	            break;
	        case "isPromo":
	        	propBool = nullEqualsCheck(newCard.isPromo, oldCard.isPromo);
	            break;
	        case "isRebalanced":
	        	propBool = nullEqualsCheck(newCard.isRebalanced, oldCard.isRebalanced);
	            break;
	        case "isReprint":
	        	propBool = nullEqualsCheck(newCard.isReprint, oldCard.isReprint);
	            break;
	        case "isReserved":
	        	propBool = nullEqualsCheck(newCard.isReserved, oldCard.isReserved);
	            break;
	        case "isStorySpotlight":
	        	propBool = nullEqualsCheck(newCard.isStorySpotlight, oldCard.isStorySpotlight);
	            break;
	        case "isTextless":
	        	propBool = nullEqualsCheck(newCard.isTextless, oldCard.isTextless);
	            break;
	        case "isTimeshifted":
	        	propBool = nullEqualsCheck(newCard.isTimeshifted, oldCard.isTimeshifted);
	            break;
	        case "keywords":
	            propBool = nullEqualsCheck(newCard.keywords, oldCard.keywords);
	            break;
	        case "layout":
	        	propBool = nullEqualsCheck(newCard.layout, oldCard.layout);
	            break;
	        case "leadershipSkills":
	            propBool = nullEqualsCheck(newCard.leadershipSkills, oldCard.leadershipSkills);
	            break;
	        case "legalities":
	            propBool = nullEqualsCheck(newCard.legalities, oldCard.legalities);
	            break;
	        case "life":
	        	propBool = nullEqualsCheck(newCard.life, oldCard.life);
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
	        case "number":
	        	propBool = nullEqualsCheck(newCard.number, oldCard.number);
	            break;
	        case "originalPrintings":
	        	propBool = nullEqualsCheck(newCard.originalPrintings, oldCard.originalPrintings);
	            break;
	        case "originalReleaseDate":
	        	propBool = nullEqualsCheck(newCard.originalReleaseDate, oldCard.originalReleaseDate);
	            break;
	        case "originalText":
	            propBool = nullEqualsCheck(newCard.originalText, oldCard.originalText);
	            break;
	        case "originalType":
	            propBool = nullEqualsCheck(newCard.originalType, oldCard.originalType);
	            break;
	        case "otherFaceIds":
	        	propBool = nullEqualsCheck(newCard.otherFaceIds, oldCard.otherFaceIds);
	            break;
	        case "power":
	            propBool = nullEqualsCheck(newCard.power, oldCard.power);
	            break;
	        case "printings":
	        	propBool = nullEqualsCheck(newCard.printings, oldCard.printings);
	            break;
	        case "promoTypes":
	        	propBool = nullEqualsCheck(newCard.promoTypes, oldCard.promoTypes);
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
	        case "securityStamp":
	        	propBool = nullEqualsCheck(newCard.securityStamp, oldCard.securityStamp);
	            break;
	        case "setCode":
	            propBool = nullEqualsCheck(newCard.setCode, oldCard.setCode);
	            break;
	        case "side":
	            propBool = nullEqualsCheck(newCard.side, oldCard.side);
	            break;
	        case "signature":
	        	propBool = nullEqualsCheck(newCard.signature, oldCard.signature);
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
	
	public static List<Card> findNewCards(Data newData, Data oldData) {
		List<String> newUuids = findNewUuids(newData.getUuids(), oldData.getUuids());
		List<Card> newCards = new ArrayList<Card>();
		for(Card card : newData.getCards()) {
			if(newUuids.contains(card.uuid)) {
				newCards.add(card);
			}
		}
		return newCards;
	}
	
	public static List<String> removeSetCards(List<String> newUuids, List<String> oldUuids){
		Set<String> newUuidsList = new HashSet<String>(newUuids);
		Set<String> oldUuidsList = new HashSet<String>(oldUuids);
		
		oldUuidsList.removeAll(newUuidsList);
		return new ArrayList<>(oldUuidsList);
		
	}
	
	public static List<String> createPrintings(String[] files) {
		List<String> printings = new ArrayList<String>();
		for(String printing : files) {
			printings.add(printing.replace(".json", ""));
		}
		return printings;
	}
	
}