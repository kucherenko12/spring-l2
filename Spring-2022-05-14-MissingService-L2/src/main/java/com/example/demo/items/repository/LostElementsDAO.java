package com.example.demo.items.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.items.service.LostElement;

public interface LostElementsDAO
{
	public ArrayList<LostElement> itemGetAll();
	
	public ArrayList<LostElement> itemSearchByKeywords(List<String> keywords);
	
	public List<LostElement> itemSearchByOwner(String founder);
	
	public List<LostElement> itemSearchByKeywordsAndOwner(List<String> keywords, String founder);
	
	void addNewItem(String Name, String founder, List<String> keywords);
	
	void deleteItem(int itemID);
}
