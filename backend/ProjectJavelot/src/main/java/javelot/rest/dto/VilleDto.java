/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: VilleDto.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.rest.dto;

import javelot.model.Ville;

import java.util.Collection;
import java.util.Comparator;

public class VilleDto
{
   private final String nom;
   private final Double latitude;
   private final Double longitude;
   private final Collection<ReleveMeteoDto> releveMeteos;

   public VilleDto(final Ville ville)
   {
      this.nom = ville.getNom();
      this.latitude = ville.getLatitude();
      this.longitude = ville.getLongitude();
      this.releveMeteos = ville.getReleveMeteos().stream()
                                .map(ReleveMeteoDto::new)
                                .sorted(Comparator.comparing(ReleveMeteoDto::getDate))
                                .toList();
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

   public Collection<ReleveMeteoDto> getReleveMeteos()
   {
      return releveMeteos;
   }
}
