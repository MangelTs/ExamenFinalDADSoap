package com.torres.salazar.infraccionservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet>
			messageDispatcherServlet(ApplicationContext applicationContext){
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}
	@Bean
	public XsdSchema asticulosSchema() {
		return new SimpleXsdSchema(new ClassPathResource("infraccion-detalle.xsd"));
	}
	
	//localhost:8081/ws/infraccionservie.wsdl
	@Bean(name = "infracciones")
	public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema infraccionesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("InfraccionesPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://uss.com/infraccionservice");
		wsdl11Definition.setSchema(infraccionesSchema);
		return wsdl11Definition;
	}
}
