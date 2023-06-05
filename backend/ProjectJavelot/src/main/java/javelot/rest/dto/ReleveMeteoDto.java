/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: ReleveMeteoDto.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.rest.dto;

import javelot.model.ReleveMeteo;

import java.util.Date;

public class ReleveMeteoDto
{
   private final Date date;
   private final Double temperature;

   public ReleveMeteoDto(final ReleveMeteo releveMeteo)
   {
      this.date = releveMeteo.getDate();
      this.temperature = releveMeteo.getTemperature();
   }

   public Date getDate()
   {
      return date;
   }

   public Double getTemperature()
   {
      return temperature;
   }
}
