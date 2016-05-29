package org.gerald.suarez.web.rest.dto;

import org.gerald.suarez.domain.Usuario;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ManagedUsuarioDTO extends BaseUsuarioDTO {

    public static final int PASSWORD_MIN_LENGTH = 4;
    public static final int PASSWORD_MAX_LENGTH = 100;

    private Long id;

    @NotNull
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    private Long rolId;

    public ManagedUsuarioDTO() {
    }

    public ManagedUsuarioDTO(Usuario usuario) {
        super(usuario);
        this.id = usuario.getId();
        this.password = usuario.getPassword();
    }

    public ManagedUsuarioDTO(Long id, String password, String login,
                             Long rolId, String nombre, String apellidoPaterno,
                             String apellidoMaterno, String sexo, String nacionalidad,
                             String profesion, String fechaAlta, Integer ci) {
        super(login, nombre, apellidoPaterno, apellidoMaterno, sexo, nacionalidad, profesion, fechaAlta, ci);
        this.id = id;
        this.password = password;
        this.rolId = rolId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public Long getRolId() {
        return rolId;
    }
}
