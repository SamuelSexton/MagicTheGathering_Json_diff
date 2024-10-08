package com.mtgjson.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
	@JsonProperty("colors")
	List<String> colors = new ArrayList<String>();
	
	@JsonProperty("defense")
	String defense = null;
	
	@JsonProperty("identifiers")
	Identifiers identifiers = new Identifiers();
	
	@JsonProperty("keywords")
	List<String> keywords = new ArrayList<String>();
	
	@JsonProperty("leadershipSkills")
	LeadershipSkills LeadershipSkills = new LeadershipSkills();
	
	@JsonProperty("legalities")
	Legalities Legalities = new Legalities();
	
	@JsonProperty("loyalty")
	String loyalty;
	
	@JsonProperty("manaCost")
	String manaCost;
	
	@JsonProperty("manaValue")
	double manaValue;
	
	@JsonProperty("name")
	String name;
	
	@JsonProperty("originalText")
	String originalText;
	
	@JsonProperty("originalType")
	String originalType;
	
	@JsonProperty("power")
	String power;
	
	@JsonProperty("purchaseUrls")
	PurchaseUrls purchaseUrls = new PurchaseUrls();
	
	@JsonProperty("rarity")
	String rarity;
	
	@JsonProperty("rulings")
	List<Rulings> rulings = new ArrayList<Rulings>();
	
	@JsonProperty("setCode")
	String setCode;
	
	@JsonProperty("side")
	String side;
	
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

	public Identifiers getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(Identifiers identifiers) {
		this.identifiers = identifiers;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public LeadershipSkills getLeadershipSkills() {
		return LeadershipSkills;
	}

	public void setLeadershipSkills(LeadershipSkills leadershipSkills) {
		LeadershipSkills = leadershipSkills;
	}

	public Legalities getLegalities() {
		return Legalities;
	}

	public void setLegalities(Legalities legalities) {
		Legalities = legalities;
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

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
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
		return Objects.hash(LeadershipSkills, Legalities, colors, defense, identifiers, keywords, loyalty, manaCost,
				manaValue, name, originalText, originalType, power, purchaseUrls, rarity, rulings, setCode, side,
				subTypes, superTypes, text, toughness, type, types, uuid);
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
		return Objects.equals(LeadershipSkills, other.LeadershipSkills) && Objects.equals(Legalities, other.Legalities)
				&& Objects.equals(colors, other.colors) && Objects.equals(defense, other.defense)
				&& Objects.equals(identifiers, other.identifiers) && Objects.equals(keywords, other.keywords)
				&& Objects.equals(loyalty, other.loyalty) && Objects.equals(manaCost, other.manaCost)
				&& Double.doubleToLongBits(manaValue) == Double.doubleToLongBits(other.manaValue)
				&& Objects.equals(name, other.name) && Objects.equals(originalText, other.originalText)
				&& Objects.equals(originalType, other.originalType) && Objects.equals(power, other.power)
				&& Objects.equals(purchaseUrls, other.purchaseUrls) && Objects.equals(rarity, other.rarity)
				&& Objects.equals(rulings, other.rulings) && Objects.equals(setCode, other.setCode)
				&& Objects.equals(side, other.side) && Objects.equals(subTypes, other.subTypes)
				&& Objects.equals(superTypes, other.superTypes) && Objects.equals(text, other.text)
				&& Objects.equals(toughness, other.toughness) && Objects.equals(type, other.type)
				&& Objects.equals(types, other.types) && Objects.equals(uuid, other.uuid);
	}
	
	
}
	
	
