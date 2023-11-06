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
import pe.edu.upeu.vacas_backend.models.Vaca;
import pe.edu.upeu.vacas_backend.repositories.VacaRepository;


@RequiredArgsConstructor
@Service
@Transactional

public class VacaServiceImp implements VacaService {
    
    @Autowired
    private VacaRepository vacaRepo;

    @Override
    public Vaca save(Vaca vaca) {

        try {
            return vacaRepo.save(vaca);
        } catch (Exception e) {
            System.out.println(vaca+"asdf");
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

     @Override
    public List<Vaca> findAll() {
        return vacaRepo.findAll();
    }

     @Override
    public Map<String, Boolean> delete(Long id) {
        Vaca vacax = vacaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Finca not exist with id :" + id));
        vacaRepo.delete(vacax);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Vaca getVacaById(Long id) {
        Vaca findVaca = vacaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona not exist with id :" + id));
        return findVaca;
    }

    @Override
    public Vaca update(Vaca vaca, Long id) {
        Vaca vacax = vacaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona not exist with id :" + id));
        vacax.setSexo(vaca.getSexo());
        return vacaRepo.save(vacax);
    }
}
