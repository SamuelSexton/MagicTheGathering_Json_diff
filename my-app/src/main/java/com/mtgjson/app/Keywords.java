package com.mtgjson.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Keywords {
	@JsonProperty("abilityWords")
    public List<String> abilityWords = new ArrayList<String>();
	@JsonProperty("keywordAbilities")
    public List<String> keywordAbilities = new ArrayList<String>();;
	@JsonProperty("keywordActions")
    public List<String> keywordActions = new ArrayList<String>();;

    // Getters and setters
    public List<String> getAbilityWords() {
        return abilityWords;
    }

    public void setAbilityWords(List<String> abilityWords) {
        this.abilityWords = abilityWords;
    }

    public List<String> getKeywordAbilities() {
        return keywordAbilities;
    }

    public void setKeywordAbilities(List<String> keywordAbilities) {
        this.keywordAbilities = keywordAbilities;
    }

    public List<String> getKeywordActions() {
        return keywordActions;
    }

    public void setKeywordActions(List<String> keywordActions) {
        this.keywordActions = keywordActions;
    }
    
    
	@Override
	public int hashCode() {
		return Objects.hash(abilityWords, keywordAbilities, keywordActions);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Keywords other = (Keywords) obj;
		return Objects.equals(abilityWords, other.abilityWords)
				&& Objects.equals(keywordAbilities, other.keywordAbilities)
				&& Objects.equals(keywordActions, other.keywordActions);
	}
    
    
    
}