package webservice.irina.task3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import webservice.irina.task3.model.Canvasdata;
import webservice.irina.task3.model.StudentIts;
import webservice.irina.task3.repo.CanvasRepo;
import webservice.irina.task3.repo.StudentItsRepo;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.IntStream;

@SpringBootApplication
public class Task3Application {

	public static void main(String[] args) {

		SpringApplication.run(Task3Application.class, args);
		}


	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization", "Access-Control-Allow-Origin",
				"Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));


		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);



	}

	@Configuration
	class DateTimeConfig {
		@Bean
		public FormattingConversionService conversionService() {
			DefaultFormattingConversionService conversionService =
					new DefaultFormattingConversionService(false);

			DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
			registrar.setDateFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
			registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
			registrar.registerFormatters(conversionService);

			// other desired formatters

			return conversionService;
		}
	}
}
