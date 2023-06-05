/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: ExerciceAlgoService.java
 *    Création: 02 06 2023
 *--------------------------------------------------------
 */
package javelot.services;

import javelot.exception.JavelotException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExerciceAlgoService
{
   private static final Logger LOGGER = LoggerFactory.getLogger(ExerciceAlgoService.class);

   private final static String letters = "abcdefghijklmnopqrstuvwxyz";
   private final static Long baseHash = 26L;
   private final static int multiplicateur = 37;

   //parallelepipede
   //parallele

   public ExerciceAlgoService()
   {
   }

   public Long hashString(final String toEncode) throws JavelotException
   {
      LOGGER.info(String.format("hashString : %s", toEncode));
      Long hash = baseHash;
      for (int i = 0; i < toEncode.length(); i++)
      {
         Long tmphash = (hash * multiplicateur + letters.indexOf(toEncode.charAt(i)));
         if (hash < tmphash)
         {
            hash = tmphash;
         }
         else
         {
            throw new JavelotException("Le type Long est arrivé a sont maximum");
         }
      }
      return hash;
   }

   public String unHashString(Long todecode)
   {
      LOGGER.info(String.format("unHashString : %s", todecode.toString()));
      StringBuilder sbValue = new StringBuilder();
      while (todecode > baseHash)
      {
         int reste = (int) (todecode % multiplicateur);
         todecode = todecode / multiplicateur;
         sbValue.append(letters.charAt(reste));
      }
      return sbValue.reverse().toString();
   }
}
