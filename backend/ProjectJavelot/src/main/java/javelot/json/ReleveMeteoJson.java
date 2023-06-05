/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: ReleveMeteoJson.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.json;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

public class ReleveMeteoJson
{
   @JsonDeserialize(using = DateDeserializer.class)
   private Date date;
   private Double temperature;

   public ReleveMeteoJson()
   {
   }

   public Date getDate()
   {
      return date;
   }

   public void setDate(Date date)
   {
      this.date = date;
   }

   public Double getTemperature()
   {
      return temperature;
   }

   public void setTemperature(Double temperature)
   {
      this.temperature = temperature;
   }
}
