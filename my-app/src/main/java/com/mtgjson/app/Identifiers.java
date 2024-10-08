package com.mtgjson.app;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Identifiers {
	@JsonProperty("cardKingdomEtchedId")
	String cardKingdomEtchedId;
	
	@JsonProperty("cardKingdomFoilId")
	String cardKingdomFoilId;
	
	@Override
	public int hashCode() {
		return Objects.hash(cardKingdomEtchedId, cardKingdomFoilId, cardKingdomId, cardsphereId, mcmId, mcmMetaId,
				mtgArenaId, mtgjsonFoilVersionId, mtgjsonNonFoilVersionId, mtgjsonV4Id, mtgoFoilId, mtgoId,
				multiverseId, scryfallCardBackId, scryfallId, scryfallIllustrationId, scryfallOracleId,
				tcgplayerEtchedProductId, tcgplayerProductId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Identifiers other = (Identifiers) obj;
		return Objects.equals(cardKingdomEtchedId, other.cardKingdomEtchedId)
				&& Objects.equals(cardKingdomFoilId, other.cardKingdomFoilId)
				&& Objects.equals(cardKingdomId, other.cardKingdomId)
				&& Objects.equals(cardsphereId, other.cardsphereId) && Objects.equals(mcmId, other.mcmId)
				&& Objects.equals(mcmMetaId, other.mcmMetaId) && Objects.equals(mtgArenaId, other.mtgArenaId)
				&& Objects.equals(mtgjsonFoilVersionId, other.mtgjsonFoilVersionId)
				&& Objects.equals(mtgjsonNonFoilVersionId, other.mtgjsonNonFoilVersionId)
				&& Objects.equals(mtgjsonV4Id, other.mtgjsonV4Id) && Objects.equals(mtgoFoilId, other.mtgoFoilId)
				&& Objects.equals(mtgoId, other.mtgoId) && Objects.equals(multiverseId, other.multiverseId)
				&& Objects.equals(scryfallCardBackId, other.scryfallCardBackId)
				&& Objects.equals(scryfallId, other.scryfallId)
				&& Objects.equals(scryfallIllustrationId, other.scryfallIllustrationId)
				&& Objects.equals(scryfallOracleId, other.scryfallOracleId)
				&& Objects.equals(tcgplayerEtchedProductId, other.tcgplayerEtchedProductId)
				&& Objects.equals(tcgplayerProductId, other.tcgplayerProductId);
	}

	public String getCardKingdomEtchedId() {
		return cardKingdomEtchedId;
	}

	public void setCardKingdomEtchedId(String cardKingdomEtchedId) {
		this.cardKingdomEtchedId = cardKingdomEtchedId;
	}

	public String getCardKingdomFoilId() {
		return cardKingdomFoilId;
	}

	public void setCardKingdomFoilId(String cardKingdomFoilId) {
		this.cardKingdomFoilId = cardKingdomFoilId;
	}

	public String getCardKingdomId() {
		return cardKingdomId;
	}

	public void setCardKingdomId(String cardKingdomId) {
		this.cardKingdomId = cardKingdomId;
	}

	public String getCardsphereId() {
		return cardsphereId;
	}

	public void setCardsphereId(String cardsphereId) {
		this.cardsphereId = cardsphereId;
	}

	public String getMcmId() {
		return mcmId;
	}

	public void setMcmId(String mcmId) {
		this.mcmId = mcmId;
	}

	public String getMcmMetaId() {
		return mcmMetaId;
	}

	public void setMcmMetaId(String mcmMetaId) {
		this.mcmMetaId = mcmMetaId;
	}

	public String getMtgArenaId() {
		return mtgArenaId;
	}

	public void setMtgArenaId(String mtgArenaId) {
		this.mtgArenaId = mtgArenaId;
	}

	public String getMtgjsonFoilVersionId() {
		return mtgjsonFoilVersionId;
	}

	public void setMtgjsonFoilVersionId(String mtgjsonFoilVersionId) {
		this.mtgjsonFoilVersionId = mtgjsonFoilVersionId;
	}

	public String getMtgjsonNonFoilVersionId() {
		return mtgjsonNonFoilVersionId;
	}

	public void setMtgjsonNonFoilVersionId(String mtgjsonNonFoilVersionId) {
		this.mtgjsonNonFoilVersionId = mtgjsonNonFoilVersionId;
	}

	public String getMtgjsonV4Id() {
		return mtgjsonV4Id;
	}

	public void setMtgjsonV4Id(String mtgjsonV4Id) {
		this.mtgjsonV4Id = mtgjsonV4Id;
	}

	public String getMtgoFoilId() {
		return mtgoFoilId;
	}

	public void setMtgoFoilId(String mtgoFoilId) {
		this.mtgoFoilId = mtgoFoilId;
	}

	public String getMtgoId() {
		return mtgoId;
	}

	public void setMtgoId(String mtgoId) {
		this.mtgoId = mtgoId;
	}

	public String getMultiverseId() {
		return multiverseId;
	}

	public void setMultiverseId(String multiverseId) {
		this.multiverseId = multiverseId;
	}

	public String getScryfallId() {
		return scryfallId;
	}

	public void setScryfallId(String scryfallId) {
		this.scryfallId = scryfallId;
	}

	public String getScryfallCardBackId() {
		return scryfallCardBackId;
	}

	public void setScryfallCardBackId(String scryfallCardBackId) {
		this.scryfallCardBackId = scryfallCardBackId;
	}

	public String getScryfallOracleId() {
		return scryfallOracleId;
	}

	public void setScryfallOracleId(String scryfallOracleId) {
		this.scryfallOracleId = scryfallOracleId;
	}

	public String getScryfallIllustrationId() {
		return scryfallIllustrationId;
	}

	public void setScryfallIllustrationId(String scryfallIllustrationId) {
		this.scryfallIllustrationId = scryfallIllustrationId;
	}

	public String getTcgplayerProductId() {
		return tcgplayerProductId;
	}

	public void setTcgplayerProductId(String tcgplayerProductId) {
		this.tcgplayerProductId = tcgplayerProductId;
	}

	public String getTcgplayerEtchedProductId() {
		return tcgplayerEtchedProductId;
	}

	public void setTcgplayerEtchedProductId(String tcgplayerEtchedProductId) {
		this.tcgplayerEtchedProductId = tcgplayerEtchedProductId;
	}

	@JsonProperty("cardKingdomId")
	String cardKingdomId;
	
	@JsonProperty("cardsphereId")
	String cardsphereId;
	
	@JsonProperty("mcmId")
	String mcmId;
	
	@JsonProperty("mcmMetaId")
	String mcmMetaId;
	
	@JsonProperty("mtgArenaId")
	String mtgArenaId;
	
	@JsonProperty("mtgjsonFoilVersionId")
	String mtgjsonFoilVersionId;
	
	@JsonProperty("mtgjsonNonFoilVersionId")
	String mtgjsonNonFoilVersionId;
	
	@JsonProperty("mtgjsonV4Id")
	String mtgjsonV4Id;
	
	@JsonProperty("mtgoFoilId")
	String mtgoFoilId;
	
	@JsonProperty("mtgoId")
	String mtgoId;
	
	@JsonProperty("multiverseId")
	String multiverseId;
	
	@JsonProperty("scryfallId")
	String scryfallId;
	
	@JsonProperty("scryfallCardBackId")
	String scryfallCardBackId;
	
	@JsonProperty("scryfallOracleId")
	String scryfallOracleId;
	
	@JsonProperty("scryfallIllustrationId")
	String scryfallIllustrationId;
	
	@JsonProperty("tcgplayerProductId")
	String tcgplayerProductId;
	
	@JsonProperty("tcgplayerEtchedProductId")
	String tcgplayerEtchedProductId;
}
