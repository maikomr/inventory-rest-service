package org.gerald.suarez.web.rest.dto;

import org.gerald.suarez.domain.Permiso;
import org.gerald.suarez.domain.Usuario;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class UsuarioDTO extends BaseUsuarioDTO {

    @Pattern(regexp = "^[a-z0-9]*$")
    @NotNull
    @Size(min = 1, max = 50)
    private String login;

    @NotNull
    private String rol;


    @NotNull
    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String sexo;

    private String nacionalidad;

    private String profesion;

    private String fechaAlta;

    private Integer ci;

    private Set<Permiso> permisos;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this(usuario.getLogin(), usuario.getRol().getNombre(), usuario.getEmpleado().getNombre(),
                usuario.getEmpleado().getApellidoPaterno(), usuario.getEmpleado().getApellidoMaterno(),
                usuario.getEmpleado().getSexo(), usuario.getEmpleado().getNacionalidad(),
                usuario.getEmpleado().getProfesion(), DateTimeFormatter.ISO_DATE.format(usuario.getEmpleado().getFechaAlta()),
                usuario.getEmpleado().getCi(), usuario.getPermisos());
    }

    public UsuarioDTO(String login, String rol, String nombre, String apellidoPaterno,
                      String apellidoMaterno, String sexo, String nacionalidad,
                      String profesion, String fechaAlta, Integer ci, Set<Permiso> permisos) {
        super(login, nombre, apellidoPaterno, apellidoMaterno, sexo, nacionalidad, profesion, fechaAlta, ci);
        this.rol = rol;
        this.permisos = permisos;
    }

    public String getLogin() {
        return login;
    }

    public String getRol() {
        return rol;
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

    public Set<Permiso> getPermisos() {
        return permisos;
    }
}
