/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: ImportJsonService.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import javelot.dao.service.DbVilleDao;
import javelot.exception.JavelotException;
import javelot.json.GlobalJson;
import javelot.model.Ville;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@Service
public class ImportJsonService
{
   private static final Logger LOGGER = LoggerFactory.getLogger(ImportJsonService.class);
   private static final ObjectMapper mapper = new ObjectMapper();
   private static final String pathFile = "/json/data_test.json";
   private final DbVilleDao dbVilleDao;

   public ImportJsonService(final DbVilleDao dbVilleDao) throws JavelotException
   {
      this.dbVilleDao = dbVilleDao;
      this.importJson();
   }


   @Transactional
   private void importJson() throws JavelotException
   {
      LOGGER.info("Import des données du fichier Json des ressources");
      try (InputStream inputStream = getClass().getResourceAsStream(pathFile))
      {
         try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8))
         {
            final GlobalJson globalJson = this.readFile(reader);
            Ville ville = new Ville(globalJson);
            this.dbVilleDao.addDbVille(ville.mapToDbVille());
         }
         catch (IOException e)
         {
            LOGGER.error("Erreur lors de la création du Reader", e);
         }
      }
      catch (IOException e)
      {
         LOGGER.error("Erreur lors de la création de l'InputStream", e);
      }
   }

   private GlobalJson readFile(Reader reader) throws JavelotException
   {
      try
      {
         if (reader != null)
         {
            return mapper.readValue(reader, GlobalJson.class);
         }
         else
         {
            throw new JavelotException("Le fichier n'existe pas ou est introuvable.");
         }
      }
      catch (IOException ex)
      {
         LOGGER.error("Impossible de parser le fichier.", ex.getMessage());
         throw new JavelotException(ex.getMessage());
      }
   }


}
