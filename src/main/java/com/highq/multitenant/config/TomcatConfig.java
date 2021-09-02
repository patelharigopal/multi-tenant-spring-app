package com.highq.multitenant.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Class TomcatConfig.
 */
@Configuration
public class TomcatConfig
{

	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "AJP/1.3";

	/** The ajp port. */
	@Value("${tomcat.ajp.port}") // Defined on application.properties
	private int ajpPort;

	@Value("${tomcat.ajp.enabled}")
	boolean tomcatAjpEnabled;

	/**
	 * Servlet container.
	 *
	 * @return the servlet web server factory
	 */
	@Bean
	public ServletWebServerFactory servletContainer()
	{
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		if (tomcatAjpEnabled)
		{
			tomcat.addAdditionalTomcatConnectors(ajpConnector());
		}
		return tomcat;
	}

	/**
	 * Redirect connector.
	 *
	 * @return the connector
	 */
	private Connector ajpConnector()
	{
		Connector ajpConnector = new Connector(PROTOCOL);
		ajpConnector.setPort(ajpPort);
		return ajpConnector;
	}
}
