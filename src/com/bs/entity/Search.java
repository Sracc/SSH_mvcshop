package com.bs.entity;

public class Search {
	private int id=0;
	private String type="backend";
	private String string="";
	private String authorityName="";
	private String authorityValue="";
	private String namesearch="";
	private String goodsClassifysearch="";
	private String membersearch="";
	private String goodssearch="";
	private String settimesearch="";
	private String statesearch="";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public String getAuthorityValue() {
		return authorityValue;
	}
	public void setAuthorityValue(String authorityValue) {
		this.authorityValue = authorityValue;
	}
	public String getNamesearch() {
		return namesearch;
	}
	public void setNamesearch(String namesearch) {
		this.namesearch = namesearch;
	}
	public String getGoodsClassifysearch() {
		return goodsClassifysearch;
	}
	public void setGoodsClassifysearch(String goodsClassifysearch) {
		this.goodsClassifysearch = goodsClassifysearch;
	}
	public String getMembersearch() {
		return membersearch;
	}
	public void setMembersearch(String membersearch) {
		this.membersearch = membersearch;
	}
	public String getGoodssearch() {
		return goodssearch;
	}
	public void setGoodssearch(String goodssearch) {
		this.goodssearch = goodssearch;
	}
	public String getSettimesearch() {
		return settimesearch;
	}
	public void setSettimesearch(String settimesearch) {
		this.settimesearch = settimesearch;
	}
	public String getStatesearch() {
		return statesearch;
	}
	public void setStatesearch(String statesearch) {
		this.statesearch = statesearch;
	}
	@Override
	public String toString() {
		return "Search [ id=" + id + ",type=" + type + ", string=" + string
				+ ", authorityName=" + authorityName + ", authorityValue="
				+ authorityValue + ", namesearch=" + namesearch + ", goodsClassifysearch=" + goodsClassifysearch + ", membersearch=" + membersearch + ", goodssearch=" + goodssearch + ", settimesearch=" + settimesearch + ", statesearch=" + statesearch + "]";
	}
	
} 
