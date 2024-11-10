package com.mtgjson.app;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnumsCard {
	@JsonProperty("supertypes")
	public List<String> supertypes = new ArrayList<String>();
	@JsonProperty("subtypes")
	public List<String> subtypes = new ArrayList<String>();
	@JsonProperty("types")
	public List<String> types = new ArrayList<String>();
	
	public List<String> getSupertypes() {
		return supertypes;
	}
	public void setSupertypes(List<String> supertypes) {
		this.supertypes = supertypes;
	}
	public List<String> getSubtypes() {
		return subtypes;
	}
	public void setSubtypes(List<String> subtypes) {
		this.subtypes = subtypes;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}

    
}
