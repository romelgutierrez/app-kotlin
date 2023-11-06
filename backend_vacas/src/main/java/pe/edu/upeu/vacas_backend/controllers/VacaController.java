package pe.edu.upeu.vacas_backend.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.RequiredArgsConstructor;

import pe.edu.upeu.vacas_backend.models.Vaca;
import pe.edu.upeu.vacas_backend.services.VacaService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/asis/vaca")
public class VacaController {
    
    Logger logger = LoggerFactory.getLogger(VacaController.class);

    @Autowired
    private VacaService vacaService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Vaca>> listVaca() {
        List<Vaca> actDto = vacaService.findAll();
        return ResponseEntity.ok(actDto);
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Vaca> createVaca(@RequestBody Vaca vaca) {
        logger.info("hola " + vaca);
        Vaca data = vacaService.save(vaca);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Vaca> getVacaById(@PathVariable Long id) {
        Vaca vaca = vacaService.getVacaById(id);
        return ResponseEntity.ok(vaca);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVaca(@PathVariable Long id) {
        Vaca vaca = vacaService.getVacaById(id);
        return ResponseEntity.ok(vacaService.delete(vaca.getId()));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Vaca> updateVaca(@PathVariable Long id, @RequestBody Vaca vacaDetails) {
        Vaca updateVaca = vacaService.update(vacaDetails, id);
        return ResponseEntity.ok(updateVaca);
    }

}
