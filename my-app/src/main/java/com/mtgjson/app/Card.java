package com.mtgjson.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
	@JsonProperty("artist")
	String artist;
	
	@JsonProperty("artistIds")
	List<String> artistIds = new ArrayList<String>();
	
	@JsonProperty("asciiName")
	String asciiName;
	
	@JsonProperty("availability")
	List<String> availability = new ArrayList<String>();;
	
	@JsonProperty("colors")
	List<String> colors = new ArrayList<String>();
	
	@JsonProperty("defense")
	String defense;
	
	@JsonProperty("faceManaValue")
	double faceManaValue;
	
	@JsonProperty("faceName")
	String faceName;
	
	@JsonProperty("frameVersion")
	String frameVersion;
	
	@JsonProperty("hand")
	String hand;
	
	@JsonProperty("hasAlternativeDeckLimit")
	boolean hasAlternativeDeckLimit;
	
	@JsonProperty("hasContentWarning")
	boolean hasContentWarning;

	@JsonProperty("identifiers")
	Identifiers identifiers = new Identifiers();
	
	@JsonProperty("isAlternative")
	boolean isAlternative;
	
	@JsonProperty("isFullArt")
	boolean isFullArt;
	
	@JsonProperty("isFunny")
	boolean isFunny;
	
	@JsonProperty("isOnlineOnly")
	boolean isOnlineOnly;
	
	@JsonProperty("isOversized")
	boolean isOversized;
	
	@JsonProperty("isPromo")
	boolean isPromo;
	
	@JsonProperty("isRebalanced")
	boolean isRebalanced;
	
	@JsonProperty("isReprint")
	boolean isReprint;
	
	@JsonProperty("isReserved")
	boolean isReserved;
	
	@JsonProperty("isStorySpotlightd")
	boolean isStorySpotlight;
	
	@JsonProperty("isTextless")
	boolean isTextless;
	
	@JsonProperty("isTimeshifted")
	boolean isTimeshifted;
	
	@JsonProperty("keywords")
	List<String> keywords = new ArrayList<String>();
	
	@JsonProperty("layout")
	String layout;
	
	@JsonProperty("leadershipSkills")
	LeadershipSkills leadershipSkills = new LeadershipSkills();
	
	@JsonProperty("legalities")
	Legalities legalities = new Legalities();
	
	@JsonProperty("life")
	String life;
	
	@JsonProperty("loyalty")
	String loyalty;
	
	@JsonProperty("manaCost")
	String manaCost;
	
	@JsonProperty("manaValue")
	double manaValue;
	
	@JsonProperty("name")
	String name;
	
	@JsonProperty("number")
	String number;
	
	@JsonProperty("originalPrintings")
	List<String> originalPrintings = new ArrayList<String>();
	
	@JsonProperty("originalReleaseDate")
	String originalReleaseDate;
	
	@JsonProperty("originalText")
	String originalText;
	
	@JsonProperty("originalType")
	String originalType;
	
	@JsonProperty("otherFaceIds")
	List<String> otherFaceIds = new ArrayList<String>();
	
	@JsonProperty("power")
	String power;
	
	@JsonProperty("printings")
	List<String> printings = new ArrayList<String>();
	
	@JsonProperty("promoTypes")
	List<String> promoTypes = new ArrayList<String>();
	
	@JsonProperty("purchaseUrls")
	PurchaseUrls purchaseUrls = new PurchaseUrls();
	
	@JsonProperty("rarity")
	String rarity;
	
	@JsonProperty("rulings")
	List<Rulings> rulings = new ArrayList<Rulings>();
	
	@JsonProperty("securityStamp")
	String securityStamp;
	
	@JsonProperty("setCode")
	String setCode;
	
	@JsonProperty("side")
	String side;
	
	@JsonProperty("signature")
	String signature;
	
	@JsonProperty("subTypes")
	List<String> subTypes = new ArrayList<String>();
	
	@JsonProperty("superTypes")
	List<String> superTypes = new ArrayList<String>();
	
	@JsonProperty("text")
	String text;
	
	@JsonProperty("toughness")
	String toughness;
	
	@JsonProperty("type")
	String type;
	
	@JsonProperty("types")
	List<String> types = new ArrayList<String>();
	
	@JsonProperty("uuid")
	String uuid;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public List<String> getArtistIds() {
		return artistIds;
	}

	public void setArtistIds(List<String> artistIds) {
		this.artistIds = artistIds;
	}

	public String getAsciiName() {
		return asciiName;
	}

	public void setAsciiName(String asciiName) {
		this.asciiName = asciiName;
	}

	public List<String> getAvailability() {
		return availability;
	}

	public void setAvailability(List<String> availability) {
		this.availability = availability;
	}

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public String getDefense() {
		return defense;
	}

	public void setDefense(String defense) {
		this.defense = defense;
	}

	public double getFaceManaValue() {
		return faceManaValue;
	}

	public void setFaceManaValue(double faceManaValue) {
		this.faceManaValue = faceManaValue;
	}

	public String getFaceName() {
		return faceName;
	}

	public void setFaceName(String faceName) {
		this.faceName = faceName;
	}

	public String getFrameVersion() {
		return frameVersion;
	}

	public void setFrameVersion(String frameVersion) {
		this.frameVersion = frameVersion;
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public boolean isHasAlternativeDeckLimit() {
		return hasAlternativeDeckLimit;
	}

	public void setHasAlternativeDeckLimit(boolean hasAlternativeDeckLimit) {
		this.hasAlternativeDeckLimit = hasAlternativeDeckLimit;
	}

	public boolean isHasContentWarning() {
		return hasContentWarning;
	}

	public void setHasContentWarning(boolean hasContentWarning) {
		this.hasContentWarning = hasContentWarning;
	}

	public Identifiers getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(Identifiers identifiers) {
		this.identifiers = identifiers;
	}

	public boolean isAlternative() {
		return isAlternative;
	}

	public void setAlternative(boolean isAlternative) {
		this.isAlternative = isAlternative;
	}

	public boolean isFullArt() {
		return isFullArt;
	}

	public void setFullArt(boolean isFullArt) {
		this.isFullArt = isFullArt;
	}

	public boolean isFunny() {
		return isFunny;
	}

	public void setFunny(boolean isFunny) {
		this.isFunny = isFunny;
	}

	public boolean isOnlineOnly() {
		return isOnlineOnly;
	}

	public void setOnlineOnly(boolean isOnlineOnly) {
		this.isOnlineOnly = isOnlineOnly;
	}

	public boolean isOversized() {
		return isOversized;
	}

	public void setOversized(boolean isOversized) {
		this.isOversized = isOversized;
	}

	public boolean isPromo() {
		return isPromo;
	}

	public void setPromo(boolean isPromo) {
		this.isPromo = isPromo;
	}

	public boolean isRebalanced() {
		return isRebalanced;
	}

	public void setRebalanced(boolean isRebalanced) {
		this.isRebalanced = isRebalanced;
	}

	public boolean isReprint() {
		return isReprint;
	}

	public void setReprint(boolean isReprint) {
		this.isReprint = isReprint;
	}

	public boolean isReserved() {
		return isReserved;
	}

	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	public boolean isStorySpotlight() {
		return isStorySpotlight;
	}

	public void setStorySpotlight(boolean isStorySpotlight) {
		this.isStorySpotlight = isStorySpotlight;
	}

	public boolean isTextless() {
		return isTextless;
	}

	public void setTextless(boolean isTextless) {
		this.isTextless = isTextless;
	}

	public boolean isTimeshifted() {
		return isTimeshifted;
	}

	public void setTimeshifted(boolean isTimeshifted) {
		this.isTimeshifted = isTimeshifted;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public LeadershipSkills getLeadershipSkills() {
		return leadershipSkills;
	}

	public void setLeadershipSkills(LeadershipSkills leadershipSkills) {
		this.leadershipSkills = leadershipSkills;
	}

	public Legalities getLegalities() {
		return legalities;
	}

	public void setLegalities(Legalities legalities) {
		this.legalities = legalities;
	}

	public String getLife() {
		return life;
	}

	public void setLife(String life) {
		this.life = life;
	}

	public String getLoyalty() {
		return loyalty;
	}

	public void setLoyalty(String loyalty) {
		this.loyalty = loyalty;
	}

	public String getManaCost() {
		return manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	public double getManaValue() {
		return manaValue;
	}

	public void setManaValue(double manaValue) {
		this.manaValue = manaValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<String> getOriginalPrintings() {
		return originalPrintings;
	}

	public void setOriginalPrintings(List<String> originalPrintings) {
		this.originalPrintings = originalPrintings;
	}

	public String getOriginalReleaseDate() {
		return originalReleaseDate;
	}

	public void setOriginalReleaseDate(String originalReleaseDate) {
		this.originalReleaseDate = originalReleaseDate;
	}

	public String getOriginalText() {
		return originalText;
	}

	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}

	public String getOriginalType() {
		return originalType;
	}

	public void setOriginalType(String originalType) {
		this.originalType = originalType;
	}

	public List<String> getOtherFaceIds() {
		return otherFaceIds;
	}

	public void setOtherFaceIds(List<String> otherFaceIds) {
		this.otherFaceIds = otherFaceIds;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public List<String> getPrintings() {
		return printings;
	}

	public void setPrintings(List<String> printings) {
		this.printings = printings;
	}

	public List<String> getPromoTypes() {
		return promoTypes;
	}

	public void setPromoTypes(List<String> promoTypes) {
		this.promoTypes = promoTypes;
	}

	public PurchaseUrls getPurchaseUrls() {
		return purchaseUrls;
	}

	public void setPurchaseUrls(PurchaseUrls purchaseUrls) {
		this.purchaseUrls = purchaseUrls;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public List<Rulings> getRulings() {
		return rulings;
	}

	public void setRulings(List<Rulings> rulings) {
		this.rulings = rulings;
	}

	public String getSecurityStamp() {
		return securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public String getSetCode() {
		return setCode;
	}

	public void setSetCode(String setCode) {
		this.setCode = setCode;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public List<String> getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(List<String> subTypes) {
		this.subTypes = subTypes;
	}

	public List<String> getSuperTypes() {
		return superTypes;
	}

	public void setSuperTypes(List<String> superTypes) {
		this.superTypes = superTypes;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getToughness() {
		return toughness;
	}

	public void setToughness(String toughness) {
		this.toughness = toughness;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artist, artistIds, asciiName, availability, colors, defense, faceManaValue, faceName,
				frameVersion, hand, hasAlternativeDeckLimit, hasContentWarning, identifiers, isAlternative, isFullArt,
				isFunny, isOnlineOnly, isOversized, isPromo, isRebalanced, isReprint, isReserved, isStorySpotlight,
				isTextless, isTimeshifted, keywords, layout, leadershipSkills, legalities, life, loyalty, manaCost,
				manaValue, name, number, originalPrintings, originalReleaseDate, originalText, originalType,
				otherFaceIds, power, printings, promoTypes, purchaseUrls, rarity, rulings, securityStamp, setCode, side,
				signature, subTypes, superTypes, text, toughness, type, types, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(artist, other.artist) && Objects.equals(artistIds, other.artistIds)
				&& Objects.equals(asciiName, other.asciiName) && Objects.equals(availability, other.availability)
				&& Objects.equals(colors, other.colors) && Objects.equals(defense, other.defense)
				&& Double.doubleToLongBits(faceManaValue) == Double.doubleToLongBits(other.faceManaValue)
				&& Objects.equals(faceName, other.faceName) && Objects.equals(frameVersion, other.frameVersion)
				&& Objects.equals(hand, other.hand) && hasAlternativeDeckLimit == other.hasAlternativeDeckLimit
				&& hasContentWarning == other.hasContentWarning && Objects.equals(identifiers, other.identifiers)
				&& isAlternative == other.isAlternative && isFullArt == other.isFullArt && isFunny == other.isFunny
				&& isOnlineOnly == other.isOnlineOnly && isOversized == other.isOversized && isPromo == other.isPromo
				&& isRebalanced == other.isRebalanced && isReprint == other.isReprint && isReserved == other.isReserved
				&& isStorySpotlight == other.isStorySpotlight && isTextless == other.isTextless
				&& isTimeshifted == other.isTimeshifted && Objects.equals(keywords, other.keywords)
				&& Objects.equals(layout, other.layout) && Objects.equals(leadershipSkills, other.leadershipSkills)
				&& Objects.equals(legalities, other.legalities) && Objects.equals(life, other.life)
				&& Objects.equals(loyalty, other.loyalty) && Objects.equals(manaCost, other.manaCost)
				&& Double.doubleToLongBits(manaValue) == Double.doubleToLongBits(other.manaValue)
				&& Objects.equals(name, other.name) && Objects.equals(number, other.number)
				&& Objects.equals(originalPrintings, other.originalPrintings)
				&& Objects.equals(originalReleaseDate, other.originalReleaseDate)
				&& Objects.equals(originalText, other.originalText) && Objects.equals(originalType, other.originalType)
				&& Objects.equals(otherFaceIds, other.otherFaceIds) && Objects.equals(power, other.power)
				&& Objects.equals(printings, other.printings) && Objects.equals(promoTypes, other.promoTypes)
				&& Objects.equals(purchaseUrls, other.purchaseUrls) && Objects.equals(rarity, other.rarity)
				&& Objects.equals(rulings, other.rulings) && Objects.equals(securityStamp, other.securityStamp)
				&& Objects.equals(setCode, other.setCode) && Objects.equals(side, other.side)
				&& Objects.equals(signature, other.signature) && Objects.equals(subTypes, other.subTypes)
				&& Objects.equals(superTypes, other.superTypes) && Objects.equals(text, other.text)
				&& Objects.equals(toughness, other.toughness) && Objects.equals(type, other.type)
				&& Objects.equals(types, other.types) && Objects.equals(uuid, other.uuid);
	}
	
	
	
}
	
	
