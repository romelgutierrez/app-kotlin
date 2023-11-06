package pe.edu.upeu.vacas_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "finca")
public class Finca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_finca", nullable = false)
    @Size(max = 100)
    private String nombreFinca;

    @Column(name = "area_finca", nullable = false)
    @Size(max = 10)
    private String are;

    @Column(name = "medida_finca", nullable = false)
    private String medida;

    @Column(name = "telefono", nullable = false)
    @Size(max = 10)
    private String telefono;

    private String latitud;
    @Size(max = 110)
    
    private String longitud;
    @Size(max = 110)

    @Column(name = "rol_finca", nullable = false)
    @Size(max = 10)
    private String rol;
}
