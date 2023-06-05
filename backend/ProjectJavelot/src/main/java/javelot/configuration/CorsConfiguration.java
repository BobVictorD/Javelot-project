/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: CorsConfiguration.java
 *    Création: 02 06 2023
 *--------------------------------------------------------
 */
package javelot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer
{

   @Override
   public void addCorsMappings(CorsRegistry registry)
   {
      registry
            .addMapping("/api/**")
            .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
            .exposedHeaders("Authorization");
   }
}
