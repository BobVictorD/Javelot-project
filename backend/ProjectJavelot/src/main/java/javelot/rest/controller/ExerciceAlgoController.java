/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: ExerciceAlgoController.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.rest.controller;

import javelot.exception.JavelotException;
import javelot.rest.dto.ResponseDto;
import javelot.services.ExerciceAlgoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/exercice-algo", produces = "application/json")
public class ExerciceAlgoController
{
   private final ExerciceAlgoService exerciceAlgoService;

   public ExerciceAlgoController(final ExerciceAlgoService exerciceAlgoService)
   {
      this.exerciceAlgoService = exerciceAlgoService;
   }

   @GetMapping("encode/{value}")
   public Long encode(@PathVariable final String value) throws JavelotException
   {
      return this.exerciceAlgoService.hashString(value);
   }

   @GetMapping("decode/{hash}")
   public ResponseDto decode(@PathVariable final Long hash)
   {
      return new ResponseDto(this.exerciceAlgoService.unHashString(hash));
   }
}
