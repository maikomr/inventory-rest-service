package org.gerald.suarez.web.rest.dto;

import org.gerald.suarez.domain.Permiso;
import org.gerald.suarez.domain.Usuario;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

public class ManagedUsuarioDTO extends UsuarioDTO {

    public static final int PASSWORD_MIN_LENGTH = 4;
    public static final int PASSWORD_MAX_LENGTH = 100;

    private Long id;

    @NotNull
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    public ManagedUsuarioDTO() {}

    public ManagedUsuarioDTO(Usuario usuario) {
        super(usuario);
        this.id = usuario.getId();
        this.password = usuario.getPassword();
    }

    public ManagedUsuarioDTO(Long id, String password, Set<Permiso> permisos, String login,
                             String rol, String nombre, String apellidoPaterno,
                             String apellidoMaterno, String sexo, String nacionalidad,
                             String profesion, String fechaAlta, Integer ci) {
        super(login, rol, permisos, nombre, apellidoPaterno, apellidoMaterno, sexo, nacionalidad, profesion, fechaAlta, ci);
        this.id = id;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ManagedUserDTO{" +
                "id=" + id +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }
}
