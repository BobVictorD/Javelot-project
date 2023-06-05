/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: DonnesMeteoService.java
 *    Création: 02 06 2023
 *--------------------------------------------------------
 */
package javelot.services;

import javelot.dao.entity.DbVille;
import javelot.dao.service.DbVilleDao;
import javelot.exception.JavelotException;
import javelot.model.Ville;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service()
public class DonneesMeteoService
{
   private static final Logger LOGGER = LoggerFactory.getLogger(DonneesMeteoService.class);

   private final DbVilleDao dbVilleDao;

   public DonneesMeteoService(final DbVilleDao dbVilleDao)
   {
      this.dbVilleDao = dbVilleDao;
   }

   public Ville getVilleByNom(final String nom) throws JavelotException
   {
      LOGGER.info(String.format("Demande des informations de la ville de nom : %s", nom));
      DbVille dbVille = this.dbVilleDao.getDbVilleByNom(nom);
      return new Ville(dbVille);
   }
}
