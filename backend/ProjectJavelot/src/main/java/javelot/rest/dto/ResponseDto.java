/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: ResponseDto.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.rest.dto;

public class ResponseDto
{
   private final String response;

   public ResponseDto(final String response)
   {
      this.response = response;
   }

   public String getResponse()
   {
      return response;
   }
}
