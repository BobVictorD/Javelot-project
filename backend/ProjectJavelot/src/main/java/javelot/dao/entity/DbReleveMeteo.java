/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: DbReleveMeteo.java
 *    Création: 02 06 2023
 *--------------------------------------------------------
 */
package javelot.dao.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "releve_meteo")
public class DbReleveMeteo
{
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "releve_meteo_id_seq")
   @SequenceGenerator(name = "releve_meteo_id_seq", sequenceName = "releve_meteo_id_seq", allocationSize = 1)
   private Integer id;

   @Column(nullable = false)
   private Date dateReleve;

   @Column()
   private Double temperature;


   @ManyToOne(fetch = FetchType.EAGER, optional = false)
   @JoinColumn(name = "ville_id")
   private DbVille ville;

   @CreationTimestamp
   @Column(updatable = false, nullable = false)
   private Timestamp dateCreation;

   @UpdateTimestamp
   @Column(nullable = false)
   private Timestamp dateModification;

   public Integer getId()
   {
      return id;
   }

   public Date getDateReleve()
   {
      return dateReleve;
   }

   public void setDateReleve(Date dateReleve)
   {
      this.dateReleve = dateReleve;
   }

   public Double getTemperature()
   {
      return temperature;
   }

   public void setTemperature(Double temperature)
   {
      this.temperature = temperature;
   }

   public void setVille(DbVille ville)
   {
      this.ville = ville;
   }
}
