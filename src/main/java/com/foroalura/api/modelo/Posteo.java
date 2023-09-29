package com.foroalura.api.modelo;

import com.foroalura.api.dto.DatosEditPosteo;
import com.foroalura.api.dto.DatosNuevoPosteo;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "posteos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Posteo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_posteo")
    private EstadoPosteo estadoPosteo;
    private String autor;
    private String curso;

    public Posteo(DatosNuevoPosteo datosNuevoPosteo) {
        this.titulo = datosNuevoPosteo.titulo();
        this.mensaje = datosNuevoPosteo.mensaje();
        this.autor = datosNuevoPosteo.autor();
        this.curso = datosNuevoPosteo.curso();
        this.fechaCreacion = new Date();
        this.estadoPosteo = EstadoPosteo.SIN_LEER;
    }

    public void actualizarDatos(DatosEditPosteo datosEditPosteo) {
        if (datosEditPosteo.titulo() != null) {
            this.titulo = datosEditPosteo.titulo();
        }
        if (datosEditPosteo.mensaje() != null) {
            this.mensaje = datosEditPosteo.mensaje();
        }
        if (datosEditPosteo.autor() != null) {
            this.autor = datosEditPosteo.autor();
        }
        if (datosEditPosteo.curso() != null) {
            this.curso = datosEditPosteo.curso();
        }
    }
}
