package pe.edu.upeu.vacas_backend.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.vacas_backend.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    Optional<Rol> findByRolNombre(Rol.RolNombre rolNombre);
}
