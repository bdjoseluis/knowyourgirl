package knowyourgirl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class JoseLuisBotellaDevesaActividad5Application {

	public static void main(String[] args) {
		SpringApplication.run(JoseLuisBotellaDevesaActividad5Application.class, args);
	}

	// --- NUEVO BLOQUE: CONFIGURACIÓN DE CORS ---
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("https://knowyourgirl.vercel.app") // Tu URL de Vercel
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedHeaders("*")
						.allowCredentials(true);
			}
		};
	}
	// ------------------------------------------

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info().title("API ACTIVIDAD5")
						.description("Proyecto de API REST")
						.contact(new Contact()
								.name("Jose Luis Botella Devesa")
								.email("josbotdev@gmail.com")
								.url("https://knowyourgirl.onrender.com/swagger-ui/index.html")) // Actualizado a la URL de producción
						.version("1.0"));
	}
}