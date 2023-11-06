package pe.edu.upeu.vacas_backend.services;

import pe.edu.upeu.vacas_backend.models.Vaca;
import java.util.List;
import java.util.Map;

public interface VacaService {
    Vaca save(Vaca vaca);

    List<Vaca> findAll();

    Map<String, Boolean> delete(Long id);

    Vaca getVacaById(Long id);

    Vaca update(Vaca vaca, Long id);
}
