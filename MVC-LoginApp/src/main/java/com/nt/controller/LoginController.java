package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;
import com.nt.validator.LoginValidator;

@Controller
public class LoginController {
@Autowired
private LoginService service;
@Autowired
private LoginValidator validator;
@RequestMapping(value="/login.htm",method=RequestMethod.GET)
public String showForm(Model model){
	//create command object kkep in as model attribute
	UserCommand user=new UserCommand();
	model.addAttribute("userCmd",user);
	//return lvn
	return "login";
}
@RequestMapping(value="/login.htm",method=RequestMethod.POST)
public String process(Model model,@ModelAttribute("userCmd")UserCommand cmd,BindingResult errors){
	UserDTO dto=new UserDTO();
	//convert command obj to dto obj
	dto.setUsername(cmd.getUsername());
	dto.setUsername(cmd.getPwd());
	
	//user validator
	if(validator.supports(UserCommand.class)){
		validator.validate(cmd, errors);
		if(errors.hasErrors()){
			return "login";
		}
	}
	//use service class
	String result=service.authenticate(dto);
	model.addAttribute("result",result);
	//return lvn
	return "login";
}
@ModelAttribute("domains")
public List<String> populateDomains(){
	List<String> domainList=new ArrayList<String>();
	domainList.add("Gmail.com");
	domainList.add("yahool.com");
	domainList.add("rediff.com");
	return domainList;
}
@InitBinder
public void myInitBinder(WebDataBinder binder){
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
}
}
