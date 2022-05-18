package com.example.demo.logIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.items.service.LostElementsService;
import com.example.demo.logIn.service.LogIn;
import com.example.demo.logIn.service.User;

@Controller
public class RootController
{
	@Autowired
	LogIn logIn;
	
	@Autowired
	LostElementsService lostElementsService;
	
	@GetMapping("/")
	public String root(
		Model model)
	{
		return("index");
	}
	
	@GetMapping("/view")
	public String view(
		@RequestParam(name = "usernameToDB", required = true, defaultValue = "0") String usernameToDB,
		@RequestParam(name = "passwordToDB", required = true, defaultValue = "0") String passwordToDB,
		//@RequestParam(name = "addItemName", required = false, defaultValue = "null") String addItemName,
		//@RequestParam(name = "stringAddNewItemKeywords", required = false, defaultValue = "nothing") String stringAddNewItemKeywords,
		@RequestParam(name = "stringSearchByKeywords", required = false, defaultValue = "nothing") String stringSearchByKeywords,
		@RequestParam(name = "mineOnly", required = false, defaultValue = "0") Boolean changeMineOnly,
		//@RequestParam(name = "deleteindex", required = false, defaultValue = "-1") int deleteIndex,
		Model model)
	{
		User user = logIn.tryLogIn(usernameToDB, passwordToDB);

		//System.out.println("stringAddItemKeywords = " + stringAddNewItemKeywords);
		System.out.println("stringSearchKeywords = " + stringSearchByKeywords);
		
		
		
		//if ((addItemName != null)&&(addItemName != null)) {lostElementsService.addNewItem(addItemName, stringAddItemKeywords);}
		if(stringSearchByKeywords.equals("nothing"))
		{
			lostElementsService.setAtLeastOneCurrentKeywords(false);
			System.out.println("right");
		}
		else
		{
			lostElementsService.setCurrentKeywords(stringSearchByKeywords); 
			lostElementsService.setAtLeastOneCurrentKeywords(true);
			System.out.println("wrong");
		}
		
		//if(changeMineOnly == true) {lostElementsService.changeMineOnly();}
		
		//if (deleteIndex != -1) {lostElementsService.deleteItem(deleteIndex);}
		
		
		
		
		
		model.addAttribute("keywords", lostElementsService.getCurrentKeywords());
		model.addAttribute("username", user.getName());
		model.addAttribute("lostElements", lostElementsService.getSelectedElements());
		//model.addAttribute("keywords", lostElementsService.getCurrentKeywords());
		//model.addAttribute("mineOnly", lostElementsService.getMineOnly());
		
		return("view");
	}
	
	
	@PostMapping("/add")
	public String add(
		@RequestParam(name = "addNewItemName", required = true, defaultValue = "null") String addNewItemName,
		@RequestParam(name = "stringAddNewItemKeywords", required = true, defaultValue = "nothing") String stringAddNewItemKeywords,
		Model model)
	{
		System.out.println("addNewItemName = " + addNewItemName);
		System.out.println("stringAddNewItemKeywords = " + stringAddNewItemKeywords);
		
		lostElementsService.addNewItem(addNewItemName, stringAddNewItemKeywords);
		
		User user = logIn.getCurrentUser();
		
		model.addAttribute("username", user.getName());
		
		return("add");
	}
	
	@PostMapping("/delete")
	public String delete(
		@RequestParam(name = "deleteItemID", required = true, defaultValue = "null") String deleteItemID,
		Model model)
	{
		System.out.println("deleteItemID = " + deleteItemID);
		
		lostElementsService.deleteItem(deleteItemID);
		
		User user = logIn.getCurrentUser();
		
		model.addAttribute("username", user.getName());
		
		return("delete");
	}
	
}


