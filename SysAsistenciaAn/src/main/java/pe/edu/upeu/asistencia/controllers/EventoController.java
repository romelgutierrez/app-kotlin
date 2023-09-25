package pe.edu.upeu.asistencia.controllers;

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

import pe.edu.upeu.asistencia.models.Evento;
import pe.edu.upeu.asistencia.services.EventoService;

@RestController
@RequestMapping("/asis/evento")
public class EventoController {
    
    @Autowired
    private EventoService eventoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Evento>> listEvento(){
        List<Evento> evenDto = eventoService.findAll();

        return ResponseEntity.ok(evenDto);
    }


     
    @PostMapping("/crear")
    public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
        Evento data = eventoService.save(evento);
        return ResponseEntity.ok(data);
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        Evento evento = eventoService.getEventoById(id);
        return ResponseEntity.ok(evento);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEvento(@PathVariable Long id) {
        Evento evento = eventoService.getEventoById(id);
        return ResponseEntity.ok(eventoService.delete(evento.getId()));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Long id, @RequestBody Evento eventoDetails) {        
        Evento updatedEvento = eventoService.update(eventoDetails, id);
        return ResponseEntity.ok(updatedEvento);
    }      
}

