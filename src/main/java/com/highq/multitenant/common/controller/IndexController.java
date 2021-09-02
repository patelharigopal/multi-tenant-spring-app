package com.highq.multitenant.common.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The Class IndexController.
 */
@Controller
public class IndexController
{
	private static final String TENANT_HEADER = "X-TenantID";
	
	/** The Constant DEFAULT_TENANT_NAME. */
	private static final String DEFAULT_TENANT_NAME = "default";
	
	
	/**
	 * Welcome.
	 *
	 * @return the string
	 */
	@GetMapping({"/", "/home"})
	public String welcome(HttpServletRequest request, ModelMap model)
	{
		System.out.println("CAAAAA");
		request.getHeader(TENANT_HEADER);
		String tenantName = request.getHeader(TENANT_HEADER);
		if (tenantName == null || tenantName.isEmpty())
		{
			tenantName = DEFAULT_TENANT_NAME;
		}
		model.addAttribute("tenantDetails", tenantName);
		return "index";
	}
}
