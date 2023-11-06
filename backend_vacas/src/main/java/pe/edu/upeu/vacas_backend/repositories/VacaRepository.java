package pe.edu.upeu.vacas_backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.vacas_backend.models.Vaca;

public interface VacaRepository  extends JpaRepository<Vaca, Long>{
    Optional<Vaca> findByNombreVaca(String nombreVaca); 
}
