/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: DbVilleDao.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.dao.service;

import javelot.dao.entity.DbVille;
import javelot.dao.repository.DbVilleRepository;
import javelot.exception.JavelotException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DbVilleDao
{

   private static final Logger LOGGER = LoggerFactory.getLogger(DbVilleDao.class);

   private final DbVilleRepository dbVilleRepository;

   public DbVilleDao(final DbVilleRepository dbVilleRepository)
   {
      this.dbVilleRepository = dbVilleRepository;
   }

   public DbVille getDbVilleByNom(final String nom) throws JavelotException
   {
      Optional<DbVille> optDbVille = this.dbVilleRepository.getDbVilleByNom(nom);
      if (optDbVille.isPresent())
      {
         return optDbVille.get();
      }
      else
      {
         throw new JavelotException(String.format("Le ville de nom : %s n'a pas été trouvée en base", nom));
      }
   }

   public void addDbVille(final DbVille dbVille)
   {
      Optional<DbVille> optDbVille = this.dbVilleRepository.getDbVilleByNom(dbVille.getNom());
      if (optDbVille.isPresent())
      {
         LOGGER.warn(String.format("Pas d'ajout de la ville %s car déjà présente en base", dbVille.getNom()));
      }
      else
      {
         this.dbVilleRepository.save(dbVille);
      }
   }
}
