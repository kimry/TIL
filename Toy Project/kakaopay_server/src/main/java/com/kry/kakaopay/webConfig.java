import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {

    public void addCrosMappings(CorsRegistry registry){

        WebMvcConfigurer.super.addCorsMappings(registry);

        registry.addMapping("/**").allowedOrigins("*");
    }

}
