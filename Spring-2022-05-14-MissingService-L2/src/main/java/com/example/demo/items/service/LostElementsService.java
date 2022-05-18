package com.example.demo.items.service;

import java.util.List;

public interface LostElementsService
{
	List getSelectedElements();
	
	List<String> getCurrentKeywords();
	void setCurrentKeywords(String stringKeywords);
	void setAtLeastOneCurrentKeywords(boolean _atLeastOneCurrentKeywords);
	
	Boolean getMineOnly();
	void changeMineOnly();

	
	public void addNewItem(	String addItemName, String stringAddItemKeywords);
	
	public void deleteItem(String deleteIndex);
	
}
