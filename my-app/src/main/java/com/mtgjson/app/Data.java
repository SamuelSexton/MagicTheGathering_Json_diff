package com.mtgjson.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	@JsonProperty("cards")
	List<Card> cards = new ArrayList<Card>();
	List<String> uuids = new ArrayList<String>();
	
	public Data() {
		setUuids();
	}
	
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
		setUuids();
	}
	

	public List<String> getUuids() {
		return uuids;
	}

	public void setUuids() {
		for(Card card : getCards()) {
			this.uuids.add(card.uuid);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(cards, uuids);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		return Objects.equals(cards, other.cards) && Objects.equals(uuids, other.uuids);
	}
}
