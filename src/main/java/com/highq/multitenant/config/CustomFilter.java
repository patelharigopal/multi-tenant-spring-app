package com.highq.multitenant.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class CustomFilter.
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class CustomFilter implements Filter
{
	/**
	 * Inits the.
	 *
	 * @param filterConfig the filter config
	 * @throws ServletException the servlet exception
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		log.info("########## Initiating Custom filter ##########");
	}

	/**
	 * Do filter.
	 *
	 * @param servletRequest the servlet request
	 * @param servletResponse the servlet response
	 * @param filterChain the filter chain
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		log.info("Logging Request  " + request.getMethod() + " : " + request.getRequestURI());
		filterChain.doFilter(request, response);
		log.info("Logging Response :" + response.getContentType());
	}

	/**
	 * Destroy.
	 */
	@Override
	public void destroy()
	{
		log.info("########## Destroy Custom filter ##########");
	}
}
