/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: GlobalJson.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public class GlobalJson
{
   @JsonProperty("city_info")
   private VilleJson cityInfo;
   private Collection<ReleveMeteoJson> data;

   public GlobalJson()
   {
   }

   public VilleJson getCityInfo()
   {
      return cityInfo;
   }

   public void setCityInfo(VilleJson cityInfo)
   {
      this.cityInfo = cityInfo;
   }

   public Collection<ReleveMeteoJson> getData()
   {
      return data;
   }

   public void setData(Collection<ReleveMeteoJson> data)
   {
      this.data = data;
   }
}
