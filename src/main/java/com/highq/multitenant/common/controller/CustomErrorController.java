package com.highq.multitenant.common.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class ErrorController.
 */
@Controller
public class CustomErrorController implements ErrorController  {
	
	/**
	 * Handle error.
	 *
	 * @return the string
	 */
	@RequestMapping("/error")
	public String handleError() {
		return "error";
	}
 
	/**
	 * Gets the error path.
	 *
	 * @return the error path
	 */
	@Override
	public String getErrorPath() {
		return "/error";
	}
}
