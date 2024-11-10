package com.mtgjson.app;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeadershipSkills {
	@JsonProperty("brawl")
    boolean brawl;

	@JsonProperty("commander")
    boolean commander;
    
    @JsonProperty("oathbreaker")
    boolean oathbreaker;

   	public boolean isBrawl() {
   		return brawl;
   	}

   	public void setBrawl(boolean brawl) {
   		this.brawl = brawl;
   	}

   	public boolean isCommander() {
   		return commander;
   	}

   	public void setCommander(boolean commander) {
   		this.commander = commander;
   	}

   	public boolean isOathbreaker() {
   		return oathbreaker;
   	}

   	public void setOathbreaker(boolean oathbreaker) {
   		this.oathbreaker = oathbreaker;
   	}
   	
   	@Override
   	public int hashCode() {
   		return Objects.hash(brawl, commander, oathbreaker);
   	}

   	@Override
   	public boolean equals(Object obj) {
   		if (this == obj)
   			return true;
   		if (obj == null)
   			return false;
   		if (getClass() != obj.getClass())
   			return false;
   		LeadershipSkills other = (LeadershipSkills) obj;
   		return brawl == other.brawl && commander == other.commander && oathbreaker == other.oathbreaker;
   	}
}
