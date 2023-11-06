package pe.edu.upeu.vacas_backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.vacas_backend.models.Finca;

@Repository
public interface FincaRepository extends JpaRepository<Finca, Long> {
    Optional<Finca> findByNombreFinca(String nombreFinca); 
}

