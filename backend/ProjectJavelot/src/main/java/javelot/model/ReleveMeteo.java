/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: ReleveMeteo.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.model;

import javelot.dao.entity.DbReleveMeteo;
import javelot.dao.entity.DbVille;
import javelot.json.ReleveMeteoJson;

import java.util.Date;

public class ReleveMeteo
{
   private final Integer id;
   private final Date date;
   private final Double temperature;

   ReleveMeteo(final DbReleveMeteo dbReleveMeteo)
   {
      this.id = dbReleveMeteo.getId();
      this.date = dbReleveMeteo.getDateReleve();
      this.temperature = dbReleveMeteo.getTemperature();
   }

   ReleveMeteo(final ReleveMeteoJson releveMeteoJson)
   {
      this.id = null;
      this.date = releveMeteoJson.getDate();
      this.temperature = releveMeteoJson.getTemperature();
   }

   public Integer getId()
   {
      return id;
   }

   public Date getDate()
   {
      return date;
   }

   public Double getTemperature()
   {
      return temperature;
   }

   DbReleveMeteo mapToDbReleveMeteo(final DbVille dbVille)
   {
      DbReleveMeteo dbReleveMeteo = new DbReleveMeteo();
      dbReleveMeteo.setDateReleve(date);
      dbReleveMeteo.setTemperature(temperature);
      dbReleveMeteo.setVille(dbVille);
      return dbReleveMeteo;
   }
}
