package com.erik.animon2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.erik.animon2.models.Item;
import com.erik.animon2.models.User;
import com.erik.animon2.services.GoldService;
import com.erik.animon2.services.ItemService;
import com.erik.animon2.services.UserService;


@Controller
public class ItemController {

	@Autowired
	private ItemService itemServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private GoldService goldServ;
	
	@GetMapping("/store")
	public String store(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}else {
			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			return "store.jsp";
		}
	}
	
	
	@GetMapping("/buylfeed")
	public String lFeed(HttpSession session, Model model) {
		try {
		    Thread.sleep(1 * 1300);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}else {
			User thisUser = userServ.findOne(userId);
			if(thisUser.getGold().getGold() >= 50) {
				Item lfeed = new Item("Low quality feed", "food", "feed this to your dog decrease hunger by 20",
										50, 1, thisUser);
				itemServ.createItem(lfeed);
				thisUser.getGold().setGold(thisUser.getGold().getGold() - 50);
				goldServ.updateGold(thisUser.getGold());

			}else {
				return "redirect:/store";
			}
		}
		return "redirect:/store";
	}
	
	@GetMapping("/buyhfeed")
	public String hFeed(HttpSession session, Model model) {
		try {
		    Thread.sleep(1 * 1300);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}else {
			User thisUser = userServ.findOne(userId);
			if(thisUser.getGold().getGold() >= 150) {
				Item hfeed = new Item("High quality feed", "food", "feed this to your dog and decrease hunger by 35", 150, 1, thisUser);
				itemServ.createItem(hfeed);
				thisUser.getGold().setGold(thisUser.getGold().getGold() - 150);
				goldServ.updateGold(thisUser.getGold());
			}else {
				return "redirect:/store";
			}
		}
		return "redirect:/store";
	}
	
}

