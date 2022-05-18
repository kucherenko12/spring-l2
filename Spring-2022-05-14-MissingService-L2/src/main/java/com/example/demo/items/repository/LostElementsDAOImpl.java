package com.example.demo.items.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.items.service.LostElement;
import com.example.demo.logIn.service.User;

@Repository
public class LostElementsDAOImpl implements LostElementsDAO
{
	private final ArrayList<LostElement> elements = new ArrayList<LostElement>();
			{
		ArrayList<String> keywords = new ArrayList<String>();
		keywords.add("gold");
		LostElement lostElement = new LostElement(0, "clock", "admin", keywords);
		
	 	elements.add(lostElement);
			};

	private int nextNumber = 1;
			
	public LostElementsDAOImpl(List<LostElement> elements, LostElement oneElement)
	{
		super();
		//ArrayList<String> keywords = new ArrayList<String>();
		//keywords.add("gold");
		//LostElement lostElement = new LostElement("clock", "admin", keywords);
		
	 	//elements.add(lostElement);
	 	
		//System.out.println("СЩТЫЕКГСЕЩК УДУЬУТЕвфщ ");
		//this.oneElement = oneElement;
	}
	
	@Override
	public ArrayList<LostElement> itemGetAll()
	{
		System.out.println("elements.size() " + elements.size());
		return elements;
	}

	
	
	@Override
	public ArrayList<LostElement> itemSearchByKeywords(List<String> keywords)
	{
		System.out.println("DAOKeywords = " + keywords.get(0));

		
		ArrayList<LostElement> selectedElements = new ArrayList<LostElement>();
		
		int lookedFor = keywords.size();
		
		for (LostElement lostElement : elements)
		{
			int currentLookedFor = 0;
			
			for (String elementKeyword : lostElement.getKeywords())
			{
				for (String lokingForKeyword : keywords)
				{
					
				    if(elementKeyword.equals(lokingForKeyword)) {currentLookedFor++;}
				}
			}
			
		    if(currentLookedFor == lookedFor) {selectedElements.add(lostElement);}
		    
		}
		
		selectedElements.size();
		
		return selectedElements;
	}
	
	
	@Override
	public List<LostElement> itemSearchByOwner(String founder)
	{
		List<LostElement> selectedElements = new ArrayList<LostElement>();
		
		
		for (LostElement lostElement : elements)
		{
		    if(lostElement.getFounderUsername() == founder) {selectedElements.add(lostElement);}
		}
		return selectedElements;
	}

		
	@Override
	public List<LostElement> itemSearchByKeywordsAndOwner(List<String> keywords, String founder)
	{
		List<LostElement> selectedElements = new ArrayList<LostElement>();
			
		int lookedFor = keywords.size();
			
		for (LostElement lostElement : elements)
		{
			int currentLookedFor = 0;
				
			for (String elementKeyword : lostElement.getKeywords())
			{
				for (String lokingForKeyword : keywords)
				{
						
					if(elementKeyword == lokingForKeyword) {currentLookedFor++;}
				}
			}
				
			if((currentLookedFor == lookedFor)&&(lostElement.getFounderUsername() == founder)) {selectedElements.add(lostElement);}
			    
			selectedElements.add(lostElement);
		}
			
		return selectedElements;
	}
	
		
	@Override
	public void addNewItem(String Name, String founder, List<String> keywords) {
		LostElement lostElement = new LostElement(nextNumber, Name, founder, keywords);
	 	elements.add(lostElement);
	 	nextNumber++;
	}

	@Override
	public void deleteItem(int itemID) {
		elements.remove(itemID);

	}

}
