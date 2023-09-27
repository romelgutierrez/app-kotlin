package pe.edu.upeu.asistencia.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.asistencia.models.Periodo;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class EventoDto {
    Long id;
    String nombreEvento;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate fecha;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate horai;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate minToler;

    String latitud;
    String longitud;
    String estado;
    String evaluar;
    String perfilEvento;
    String userCreate;
    String mater;
    String asisSubact;
    String entsal;
    String offlinex;

    @JsonIgnoreProperties({"periodo", "subactasis", "materiales", "asistencia"})
    Periodo periodoId; 

    public record EventoCrearDto(Long id, String nombreEvento, LocalDate fecha, LocalDate horai,   LocalDate minToler,
            String latitud,  String longitud, String estado, String evaluar,String perfilEvento, String userCreate, String mater,String asisSubact, String entsal, String offlinex, Long periodoId) {

    }

}
