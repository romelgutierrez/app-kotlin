package pe.edu.upeu.vacas_backend.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vaca")
public class Vaca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_vaca", nullable = false)
    @Size(max = 100)
    private String nombreVaca;

    @Column(name = "sexo", nullable = false)
    @Size(max = 100)
    private String sexo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Basic(optional = false)
    @Column(name = "fNacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fNacimiento;

    @Column(name = "nArete", nullable = false)
    @Size(max = 100)
    private String nArete;

    @Column(name = "raza", nullable = false)
    @Size(max = 100)
    private String raza;
}
