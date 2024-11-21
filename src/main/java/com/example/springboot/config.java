import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configura las rutas a las que se les permitirá solicitudes desde otros orígenes
        registry.addMapping("/**")  // Asegura que todas las rutas estén habilitadas para CORS
                .allowedOrigins("https://tfg-futbol.vercel.app")  // Reemplaza con la URL de tu frontend en Vercel
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")  // Métodos permitidos
                .allowedHeaders("*")  // Permite cualquier tipo de encabezado
                .allowCredentials(true);  // Permite credenciales (cookies, autenticación)
    }
}
