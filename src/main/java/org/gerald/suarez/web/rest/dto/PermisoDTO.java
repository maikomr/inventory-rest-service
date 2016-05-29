package org.gerald.suarez.web.rest.dto;

/**
 * Permiso dto.
 */
public class PermisoDTO {

    private Long id;

    private Boolean ver;

    private Boolean crear;

    private Boolean modificar;

    private Boolean autorizar;

    private Long formularioId;

    private Long usuarioId;

    public PermisoDTO() {
    }

    public Long getId() {
        return id;
    }

    public Boolean getVer() {
        return ver;
    }

    public Boolean getCrear() {
        return crear;
    }

    public Boolean getModificar() {
        return modificar;
    }

    public Boolean getAutorizar() {
        return autorizar;
    }

    public Long getFormularioId() {
        return formularioId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }
}
