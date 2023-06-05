/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: DateDeserializer.java
 *    Création: 02 06 2023
 *
 *
 *--------------------------------------------------------
 */
package javelot.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserializer extends JsonDeserializer<Date>
{
   @Override
   public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException
   {
      String dateString = jsonParser.getValueAsString();
      Date date;
      try
      {
         date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
      }
      catch (ParseException e)
      {
         throw new RuntimeException(e);
      }
      return date;
   }
}
