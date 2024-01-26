package com.javaproject.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ShoeCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response);
	
}
