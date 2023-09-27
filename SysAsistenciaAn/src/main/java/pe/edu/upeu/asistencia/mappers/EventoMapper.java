package pe.edu.upeu.asistencia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import pe.edu.upeu.asistencia.dtos.EventoDto;
import pe.edu.upeu.asistencia.models.Evento;


@Mapper(componentModel = "spring")
public interface EventoMapper {
    
    EventoDto toMEventoDto(Evento entidad);

   @Mapping(target = "periodoId", ignore = true)
    Evento eventoCrearDtoToEvento(EventoDto.EventoCrearDto eventoCrearDto);
}
