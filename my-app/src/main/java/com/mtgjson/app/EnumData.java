package com.mtgjson.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnumData {
	@JsonProperty("data")
	public Card card;

    public Card getCard() {
        return card;
    }
}
