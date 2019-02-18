package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.UserCommand;
@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(UserCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
UserCommand cmd=(UserCommand) command;
if(cmd.getUsername()==null||cmd.getUsername().equals(""))
	errors.rejectValue("username", "username.required");
if(cmd.getPwd()==null||cmd.getPwd().equals(""))
	errors.rejectValue("pwd", "pwd.required");

	}

}
