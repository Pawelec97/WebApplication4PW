package pl.pawelec97.webApplication4PW.configuration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import pl.pawelec97.webApplication4PW.WebApplication4PwApplication;


public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebApplication4PwApplication.class);
	}

	@Bean
	public MessageSource messageSource() {
		final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	//	messageSource.setBasenames("classpath:/tss_pl");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("ISO-8859-2");
		messageSource.setCacheSeconds(5);
		return messageSource;
	}
}
