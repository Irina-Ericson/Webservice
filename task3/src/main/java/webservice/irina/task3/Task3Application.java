package webservice.irina.task3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import webservice.irina.task3.model.Canvasdata;
import webservice.irina.task3.model.StudentIts;
import webservice.irina.task3.repo.CanvasRepo;
import webservice.irina.task3.repo.StudentItsRepo;

import java.util.Arrays;
import java.util.stream.IntStream;

@SpringBootApplication
public class Task3Application {

	public static void main(String[] args) {

		SpringApplication.run(Task3Application.class, args);
		}

			/**@Bean

			CommandLineRunner run(StudentItsRepo studentItsRepo, CanvasRepo canvasRepo) {
			return args ->IntStream.rangeClosed(1, 2).forEach(i ->{
			Canvasdata canvasdata = new Canvasdata();

			canvasdata.setStudentnamn("canvasdata" + i);
			canvasdata.setEpostadress("canvasdata" + i + "@mail.com");
			canvasdata.setKurskod("DAT67");
			canvasRepo.save(canvasdata);



			IntStream.rangeClosed(1, 3).forEach(j -> {
			StudentIts studentIts = new StudentIts();
			studentIts.setStudentID("studentID" + j);
			studentIts.setCanvasdata(canvasdata);
			studentItsRepo.save(studentIts);
		});

	});**/

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization", "Access-Control-Allow-Origin",
				"Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));


		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);



	}
}
