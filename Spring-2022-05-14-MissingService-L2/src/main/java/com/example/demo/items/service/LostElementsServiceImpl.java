package com.example.demo.items.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.items.repository.LostElementsDAO;
import com.example.demo.logIn.service.LogIn;

@Service
public class LostElementsServiceImpl implements LostElementsService {

	boolean mineOnly = false;
	List<String> currentKeywords = new ArrayList<String>();
	boolean atLeastOneCurrentKeywords = false;
	
	//@Autowired
	ArrayList<LostElement> selectedElements;
	@Autowired
	LostElementsDAO lostElementsDAO;
	
	@Autowired
	LogIn logIn;
	
	//public LostElementsServiceImpl() {
		//super();
		//boolean mineOnly = false;
		//List<String> currentKeywords = new ArrayList<>();
		
		//List<LostElement> selectedElements = new ArrayList<>();
		
		//LostElementsDAO LostElementsDAO = new LostElementsDAO();
	//}


	@Override
	public List getSelectedElements()
	{
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
	
		// getselectedelemnts from dao
		

		
		
		// if selectedelements = null {}
		
		
		//System.out.println("currentKeywords.size()" + currentKeywords.size() + "currentKeywords.get(0)" + currentKeywords.get(0));
		
		///ArrayList<LostElement> NEWselectedElements = new ArrayList<LostElement>();
		
		if((mineOnly == false)&&(atLeastOneCurrentKeywords == false)) {System.out.println("case 1"); selectedElements = lostElementsDAO.itemGetAll();}
		else if((mineOnly == false)&&(atLeastOneCurrentKeywords == true)) {System.out.println("case 2"); selectedElements = lostElementsDAO.itemSearchByKeywords(currentKeywords);}
		//else if((mineOnly == false)&&(currentKeywords.size() != 0)) {System.out.println("2"); lostElementsDAO.itemSearchByKeywords(currentKeywords);}
		else if((mineOnly == true)&&(atLeastOneCurrentKeywords == false)) {System.out.println("case 3"); lostElementsDAO.itemSearchByOwner(logIn.getCurrentUserUsername());}
		else if((mineOnly == true)&&(atLeastOneCurrentKeywords == true)) {System.out.println("case 4"); lostElementsDAO.itemSearchByKeywordsAndOwner(currentKeywords, logIn.getCurrentUserUsername());}
		
		
		//if((mineOnly == false)&&(currentKeywords.size() == 0)) {System.out.println("1"); lostElementsDAO.itemGetAll();}
		//else if((mineOnly == false)&&(currentKeywords.size() != 0)) {System.out.println("2"); lostElementsDAO.itemSearchByKeywords(currentKeywords);}
		//else if((mineOnly == true)&&(currentKeywords.size() == 0)) {System.out.println("3"); lostElementsDAO.itemSearchByOwner(logIn.getCurrentUserUsername());}
		//else if((mineOnly == true)&&(currentKeywords.size() != 0)) {System.out.println("4"); lostElementsDAO.itemSearchByKeywordsAndOwner(currentKeywords, logIn.getCurrentUserUsername());}
		
		
		//if((mineOnly == false)&&(selectedElements.size() == 0)) {;}
		//else if((mineOnly == false)&&(selectedElements.size() != 0)) {;}
		//else if((mineOnly == true)&&(selectedElements.size() == 0)) {;}
		//else if((mineOnly == true)&&(selectedElements.size() != 0)) {;}
		

		
		//selectedElements = NEWselectedElements;
		
		System.out.println("selectedElements.size() " + selectedElements.size());
		
		return selectedElements;
	}

	
	@Override
	public List<String> getCurrentKeywords() {
		// TODO Auto-generated method stub
		return currentKeywords;
	}

	@Override
	public void setCurrentKeywords(String stringKeywords)
	{
		currentKeywords = Arrays.asList(stringKeywords.split(" "));
		//currentKeywords = Arrays.asList(stringKeywords.split("\\s*,\\s*"));
	}
	
	@Override
	public void setAtLeastOneCurrentKeywords(boolean _atLeastOneCurrentKeywords) {atLeastOneCurrentKeywords = _atLeastOneCurrentKeywords;}
	

	@Override
	public Boolean getMineOnly() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void changeMineOnly() 
	{
		if(mineOnly == false) {mineOnly = true;}
		else if(mineOnly == true) {mineOnly = false;}
	}
	
	
	



	@Override
	public void addNewItem(	String addItemName, String stringAddItemKeywords) 
	{
		lostElementsDAO.addNewItem(addItemName, (logIn.getCurrentUser()).getName(), Arrays.asList(stringAddItemKeywords.split(" ")));
	}
	
	@Override
	public void deleteItem(String deleteIndex) 
	{
		lostElementsDAO.deleteItem(Integer.parseInt(deleteIndex));
	}
	

}
