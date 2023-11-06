package pe.edu.upeu.vacas_backend.services;

import pe.edu.upeu.vacas_backend.models.Finca;
import java.util.List;
import java.util.Map;

public interface FincaService {
    Finca save(Finca finca);

    List<Finca> findAll();

    Map<String, Boolean> delete(Long id);

    Finca getFincaById(Long id);

    Finca update(Finca finca, Long id);
}
