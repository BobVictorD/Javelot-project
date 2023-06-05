/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: VilleController.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.rest.controller;

import javelot.exception.JavelotException;
import javelot.model.Ville;
import javelot.rest.dto.VilleDto;
import javelot.services.DonneesMeteoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/ville", produces = "application/json")
public class VilleController
{

   private final DonneesMeteoService donneesMeteoService;

   public VilleController(final DonneesMeteoService donneesMeteoService)
   {
      this.donneesMeteoService = donneesMeteoService;
   }

   @GetMapping("/{nom}")
   public VilleDto getVilleByNom(@PathVariable String nom) throws JavelotException
   {
      Ville ville = this.donneesMeteoService.getVilleByNom(nom);
      return new VilleDto(ville);
   }
}
