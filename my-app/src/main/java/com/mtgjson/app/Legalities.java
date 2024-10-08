package com.mtgjson.app;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class Legalities {
	@JsonProperty("alchemy")
     String alchemy;
	
    @JsonProperty("brawl")
     String brawl;
    
    @JsonProperty("commander")
     String commander;
    
    @JsonProperty("duel")
     String duel;
    
    @JsonProperty("explorer")
     String explorer;
    
    @JsonProperty("future")
     String future;
    
    @JsonProperty("gladiator")
     String gladiator;
    
    @JsonProperty("historic")
     String historic;
    
    @JsonProperty("historicbrawl")
     String historicbrawl;
    
    @JsonProperty("legacy")
     String legacy;
    
    @JsonProperty("modern")
     String modern;
    
    @JsonProperty("oathbreaker")
     String oathbreaker;
    
    @JsonProperty("oldschool")
     String oldschool;
    
    @JsonProperty("pauper")
     String pauper;
    @JsonProperty("paupercommander")
     String paupercommander;
    
    @JsonProperty("penny")
     String penny;
    
    @JsonProperty("pioneer")
     String pioneer;
    
    @JsonProperty("predh")
     String predh;
    
    @JsonProperty("premodern")
     String premodern;
    
    @JsonProperty("standard")
     String standard;
    
    @JsonProperty("stabdardbrawl")
     String standardbrawl;
    
    @JsonProperty("timeless")
     String timeless;
    
    @JsonProperty("vintage")
     String vintage;

	public String getAlchemy() {
		return alchemy;
	}

	public void setAlchemy(String alchemy) {
		this.alchemy = alchemy;
	}

	public String getBrawl() {
		return brawl;
	}

	public void setBrawl(String brawl) {
		this.brawl = brawl;
	}

	public String getCommander() {
		return commander;
	}

	public void setCommander(String commander) {
		this.commander = commander;
	}

	public String getDuel() {
		return duel;
	}

	public void setDuel(String duel) {
		this.duel = duel;
	}

	public String getExplorer() {
		return explorer;
	}

	public void setExplorer(String explorer) {
		this.explorer = explorer;
	}

	public String getFuture() {
		return future;
	}

	public void setFuture(String future) {
		this.future = future;
	}

	public String getGladiator() {
		return gladiator;
	}

	public void setGladiator(String gladiator) {
		this.gladiator = gladiator;
	}

	public String getHistoric() {
		return historic;
	}

	public void setHistoric(String historic) {
		this.historic = historic;
	}

	public String getHistoricbrawl() {
		return historicbrawl;
	}

	public void setHistoricbrawl(String historicbrawl) {
		this.historicbrawl = historicbrawl;
	}

	public String getLegacy() {
		return legacy;
	}

	public void setLegacy(String legacy) {
		this.legacy = legacy;
	}

	public String getModern() {
		return modern;
	}

	public void setModern(String modern) {
		this.modern = modern;
	}

	public String getOathbreaker() {
		return oathbreaker;
	}

	public void setOathbreaker(String oathbreaker) {
		this.oathbreaker = oathbreaker;
	}

	public String getOldschool() {
		return oldschool;
	}

	public void setOldschool(String oldschool) {
		this.oldschool = oldschool;
	}

	public String getPauper() {
		return pauper;
	}

	public void setPauper(String pauper) {
		this.pauper = pauper;
	}

	public String getPaupercommander() {
		return paupercommander;
	}

	public void setPaupercommander(String paupercommander) {
		this.paupercommander = paupercommander;
	}

	public String getPenny() {
		return penny;
	}

	public void setPenny(String penny) {
		this.penny = penny;
	}

	public String getPioneer() {
		return pioneer;
	}

	public void setPioneer(String pioneer) {
		this.pioneer = pioneer;
	}

	public String getPredh() {
		return predh;
	}

	public void setPredh(String predh) {
		this.predh = predh;
	}

	public String getPremodern() {
		return premodern;
	}

	public void setPremodern(String premodern) {
		this.premodern = premodern;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getStandardbrawl() {
		return standardbrawl;
	}

	public void setStandardbrawl(String standardbrawl) {
		this.standardbrawl = standardbrawl;
	}

	public String getTimeless() {
		return timeless;
	}

	public void setTimeless(String timeless) {
		this.timeless = timeless;
	}

	public String getVintage() {
		return vintage;
	}

	public void setVintage(String vintage) {
		this.vintage = vintage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alchemy, brawl, commander, duel, explorer, future, gladiator, historic, historicbrawl,
				legacy, modern, oathbreaker, oldschool, pauper, paupercommander, penny, pioneer, predh, premodern,
				standard, standardbrawl, timeless, vintage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Legalities other = (Legalities) obj;
		return Objects.equals(alchemy, other.alchemy) && Objects.equals(brawl, other.brawl)
				&& Objects.equals(commander, other.commander) && Objects.equals(duel, other.duel)
				&& Objects.equals(explorer, other.explorer) && Objects.equals(future, other.future)
				&& Objects.equals(gladiator, other.gladiator) && Objects.equals(historic, other.historic)
				&& Objects.equals(historicbrawl, other.historicbrawl) && Objects.equals(legacy, other.legacy)
				&& Objects.equals(modern, other.modern) && Objects.equals(oathbreaker, other.oathbreaker)
				&& Objects.equals(oldschool, other.oldschool) && Objects.equals(pauper, other.pauper)
				&& Objects.equals(paupercommander, other.paupercommander) && Objects.equals(penny, other.penny)
				&& Objects.equals(pioneer, other.pioneer) && Objects.equals(predh, other.predh)
				&& Objects.equals(premodern, other.premodern) && Objects.equals(standard, other.standard)
				&& Objects.equals(standardbrawl, other.standardbrawl) && Objects.equals(timeless, other.timeless)
				&& Objects.equals(vintage, other.vintage);
	}
    
    
}
