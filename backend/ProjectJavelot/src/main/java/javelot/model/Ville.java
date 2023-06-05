/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: Ville.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.model;

import javelot.dao.entity.DbVille;
import javelot.json.GlobalJson;

import java.util.Collection;
import java.util.stream.Collectors;

public class Ville
{
   private final Integer id;
   private final String nom;
   private final Double latitude;
   private final Double longitude;
   private final Collection<ReleveMeteo> releveMeteos;

   public Ville(final DbVille dbVille)
   {
      this.id = dbVille.getId();
      this.nom = dbVille.getNom();
      this.latitude = dbVille.getLatitude();
      this.longitude = dbVille.getLongitude();
      this.releveMeteos = dbVille.getReleveMeteos().stream().map(ReleveMeteo::new).collect(Collectors.toList());
   }

   public Ville(final GlobalJson globalJson)
   {
      this.id = null;
      this.nom = globalJson.getCityInfo().getName();
      this.latitude = globalJson.getCityInfo().getLatitude();
      this.longitude = globalJson.getCityInfo().getLongitude();
      this.releveMeteos = globalJson.getData().stream().map(ReleveMeteo::new).collect(Collectors.toList());
   }

   public Integer getId()
   {
      return id;
   }

   public String getNom()
   {
      return nom;
   }

   public Double getLatitude()
   {
      return latitude;
   }

   public Double getLongitude()
   {
      return longitude;
   }

   public Collection<ReleveMeteo> getReleveMeteos()
   {
      return releveMeteos;
   }

   public DbVille mapToDbVille()
   {
      DbVille dbVille = new DbVille();
      dbVille.setNom(nom);
      dbVille.setLatitude(this.latitude);
      dbVille.setLongitude(this.longitude);
      dbVille.setReleveMeteos(this.releveMeteos.stream()
                                    .map(releveMeteo -> releveMeteo.mapToDbReleveMeteo(dbVille))
                                    .collect(Collectors.toSet()));
      return dbVille;
   }
}
