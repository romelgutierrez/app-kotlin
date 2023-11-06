package pe.edu.upeu.vacas_backend.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.vacas_backend.models.Rol;
import pe.edu.upeu.vacas_backend.repositories.RolRepository;

/**
 *
 * @author EP-Ing_Sist.-CALIDAD
 */
@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(Rol.RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }    
}
