/**------------------------------------------------------
 *   Projet:  JAVELOT
 *--------------------------------------------------------
 *    Fichier: DbVille.java
 *    Création: 02 06 2023
 *--------------------------------------------------------
 */
package javelot.dao.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ville")
public class DbVille
{
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ville_id_seq")
   @SequenceGenerator(name = "ville_id_seq", sequenceName = "ville_id_seq", allocationSize = 1)
   private Integer id;

   @Column(nullable = false)
   private String nom;

   @Column()
   private Double latitude;

   @Column()
   private Double longitude;

   @OneToMany(fetch = FetchType.EAGER, mappedBy = "ville", cascade = CascadeType.ALL)
   private Set<DbReleveMeteo> releveMeteos = new HashSet<>();

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

   public String getNom()
   {
      return nom;
   }

   public void setNom(String nom)
   {
      this.nom = nom;
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

   public Set<DbReleveMeteo> getReleveMeteos()
   {
      return releveMeteos;
   }

   public void setReleveMeteos(Set<DbReleveMeteo> releveMeteos)
   {
      this.releveMeteos = releveMeteos;
   }
}
