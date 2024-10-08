package com.mtgjson.app;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class PurchaseUrls {
	@JsonProperty("cardKingdom")
     String cardKingdom;
	
    @JsonProperty("cardKingdomEtched")
     String cardKingdomEtched;
    
    @JsonProperty("cardKingdomFoil")
     String cardKingdomFoil;
    
    @JsonProperty("cardmarket")
     String cardmarket;
    
    @JsonProperty("tgcplayer")
     String tcgplayer;
    
    @JsonProperty("tgcplayerEtched")
     String tcgplayerEtched;

	public String getCardKingdom() {
		return cardKingdom;
	}

	public void setCardKingdom(String cardKingdom) {
		this.cardKingdom = cardKingdom;
	}

	public String getCardKingdomEtched() {
		return cardKingdomEtched;
	}

	public void setCardKingdomEtched(String cardKingdomEtched) {
		this.cardKingdomEtched = cardKingdomEtched;
	}

	public String getCardKingdomFoil() {
		return cardKingdomFoil;
	}

	public void setCardKingdomFoil(String cardKingdomFoil) {
		this.cardKingdomFoil = cardKingdomFoil;
	}

	public String getCardmarket() {
		return cardmarket;
	}

	public void setCardmarket(String cardmarket) {
		this.cardmarket = cardmarket;
	}

	public String getTcgplayer() {
		return tcgplayer;
	}

	public void setTcgplayer(String tcgplayer) {
		this.tcgplayer = tcgplayer;
	}

	public String getTcgplayerEtched() {
		return tcgplayerEtched;
	}

	public void setTcgplayerEtched(String tcgplayerEtched) {
		this.tcgplayerEtched = tcgplayerEtched;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardKingdom, cardKingdomEtched, cardKingdomFoil, cardmarket, tcgplayer, tcgplayerEtched);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseUrls other = (PurchaseUrls) obj;
		return Objects.equals(cardKingdom, other.cardKingdom)
				&& Objects.equals(cardKingdomEtched, other.cardKingdomEtched)
				&& Objects.equals(cardKingdomFoil, other.cardKingdomFoil)
				&& Objects.equals(cardmarket, other.cardmarket) && Objects.equals(tcgplayer, other.tcgplayer)
				&& Objects.equals(tcgplayerEtched, other.tcgplayerEtched);
	}
    
    
}
