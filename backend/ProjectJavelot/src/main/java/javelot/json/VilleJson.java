/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: VilleJson.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.json;

public class VilleJson
{
   private String name;
   private Double latitude;
   private Double longitude;

   public VilleJson()
   {
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Double getLatitude()
   {
      return latitude;
   }

   public void setLatitude(Double latitude)
   {
      this.latitude = latitude;
   }

   public Double getLongitude()
   {
      return longitude;
   }

   public void setLongitude(Double longitude)
   {
      this.longitude = longitude;
   }
}
