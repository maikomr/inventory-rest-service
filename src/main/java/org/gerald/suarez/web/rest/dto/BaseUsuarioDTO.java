package org.gerald.suarez.web.rest.dto;

import org.gerald.suarez.domain.Permiso;
import org.gerald.suarez.domain.Usuario;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * A base class for Usuario dto's
 */
public class BaseUsuarioDTO {
    @Pattern(regexp = "^[a-z0-9]*$")
    @NotNull
    @Size(min = 1, max = 50)
    private String login;

    @NotNull
    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String sexo;

    private String nacionalidad;

    private String profesion;

    private String fechaAlta;

    private Integer ci;

    public BaseUsuarioDTO() {
    }

    public BaseUsuarioDTO(Usuario usuario) {
        this(usuario.getLogin(), usuario.getEmpleado().getNombre(),
                usuario.getEmpleado().getApellidoPaterno(), usuario.getEmpleado().getApellidoMaterno(),
                usuario.getEmpleado().getSexo(), usuario.getEmpleado().getNacionalidad(),
                usuario.getEmpleado().getProfesion(), DateTimeFormatter.ISO_DATE.format(usuario.getEmpleado().getFechaAlta()),
                usuario.getEmpleado().getCi());
    }

    public BaseUsuarioDTO(String login, String nombre, String apellidoPaterno,
                          String apellidoMaterno, String sexo, String nacionalidad,
                          String profesion, String fechaAlta, Integer ci) {
        this.login = login;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.profesion = profesion;
        this.fechaAlta = fechaAlta;
        this.ci = ci;
    }

    public String getLogin() {
        return login;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getProfesion() {
        return profesion;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public Integer getCi() {
        return ci;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "login='" + login + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", sexo='" + sexo + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", profesion='" + profesion + '\'' +
                ", fechaAlta=" + fechaAlta + '\'' +
                ", ci=" + ci + '\'' +
                "}";
    }
}
