package javelot.dao.repository;

import javelot.dao.entity.DbVille;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DbVilleRepository extends JpaRepository<DbVille, Integer>
{
   Optional<DbVille> getDbVilleByNom(final String nom);
}
