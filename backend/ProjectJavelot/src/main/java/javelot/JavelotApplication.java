/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: JavelotApplication.java
 *    Création: 02 06 2023
 *--------------------------------------------------------
 */
package javelot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "javelot")
@EnableAutoConfiguration
@EnableJpaRepositories
public class JavelotApplication
{

   private static final Logger LOGGER = LoggerFactory.getLogger(JavelotApplication.class);

   public static void main(String[] args)
   {
      LOGGER.info("Demarrage JAVELOT");
      LOGGER.debug("Debug Demarrage JAVELOT");
      LOGGER.warn("Warn Demarrage JAVELOT");
      LOGGER.error("Error Demarrage JAVELOT");

      SpringApplication.run(JavelotApplication.class, args);
   }

}
