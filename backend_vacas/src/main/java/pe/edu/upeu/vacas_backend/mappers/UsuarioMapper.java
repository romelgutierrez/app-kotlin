package pe.edu.upeu.vacas_backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.upeu.vacas_backend.dtos.UsuarioCrearDto;
import pe.edu.upeu.vacas_backend.dtos.UsuarioDto;
import pe.edu.upeu.vacas_backend.models.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDto toUserDto(Usuario user);

    @Mapping(target = "password", ignore = true)
    Usuario usuarioCrearDtoToUser(UsuarioCrearDto usuarioCrearDto);

}