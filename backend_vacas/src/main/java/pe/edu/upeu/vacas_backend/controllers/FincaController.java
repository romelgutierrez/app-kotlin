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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

import pe.edu.upeu.vacas_backend.models.Finca;
import pe.edu.upeu.vacas_backend.services.FincaService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/finca")
public class FincaController {

    Logger logger = LoggerFactory.getLogger(FincaController.class);

    @Autowired
    private FincaService fincaService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Finca>> listFinca() {
        List<Finca> actDto = fincaService.findAll();
        return ResponseEntity.ok(actDto);

    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Finca> createFinca(@RequestBody Finca finca) {
        logger.info("hola " + finca);
        Finca data = fincaService.save(finca);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Finca> getFincaById(@PathVariable Long id) {
        Finca finca = fincaService.getFincaById(id);
        return ResponseEntity.ok(finca);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFinca(@PathVariable Long id) {
        Finca finca = fincaService.getFincaById(id);
        return ResponseEntity.ok(fincaService.delete(finca.getId()));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Finca> updateActividad(@PathVariable Long id, @RequestBody Finca actividadDetails) {
        Finca updatedActividad = fincaService.update(actividadDetails, id);
        return ResponseEntity.ok(updatedActividad);
    }

}