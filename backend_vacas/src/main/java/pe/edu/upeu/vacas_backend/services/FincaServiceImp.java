package pe.edu.upeu.vacas_backend.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import pe.edu.upeu.vacas_backend.exceptions.AppException;
import pe.edu.upeu.vacas_backend.exceptions.ResourceNotFoundException;
import pe.edu.upeu.vacas_backend.models.Finca;
import pe.edu.upeu.vacas_backend.repositories.FincaRepository;

@RequiredArgsConstructor
@Service
@Transactional

public class FincaServiceImp implements FincaService {
        @Autowired
    private FincaRepository fincaRepo;

    @Override
    public Finca save(Finca finca) {

        try {
            return fincaRepo.save(finca);
        } catch (Exception e) {
            System.out.println(finca+"asdf");
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Finca> findAll() {
        return fincaRepo.findAll();
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Finca fincax = fincaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Finca not exist with id :" + id));
        fincaRepo.delete(fincax);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Finca getFincaById(Long id) {
        Finca findFinca = fincaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona not exist with id :" + id));
        return findFinca;
    }

    @Override
    public Finca update(Finca finca, Long id) {
        Finca fincax = fincaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona not exist with id :" + id));
        fincax.setTelefono(finca.getTelefono());
        return fincaRepo.save(fincax);
    }
}
