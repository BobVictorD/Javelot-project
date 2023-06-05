/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: WebConfig.java
 *    Création: 02 06 2023
 *--------------------------------------------------------
 */
package javelot.configuration;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

@Configuration
public class WebConfig
{
   @Bean
   public FilterRegistrationBean sessionManagement()
   {
      final OpenEntityManagerInViewFilter opsVf = new OpenEntityManagerInViewFilter();
      opsVf.setEntityManagerFactoryBeanName("entityManagerFactory");
      final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
      registrationBean.setFilter(opsVf);
      registrationBean.setOrder(SecurityProperties.DEFAULT_FILTER_ORDER - 1);
      return registrationBean;

   }

}
