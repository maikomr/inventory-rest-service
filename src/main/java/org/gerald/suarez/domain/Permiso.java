package org.gerald.suarez.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Permiso.
 */
@Entity
@Table(name = "permiso")
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ver")
    private Boolean ver;

    @Column(name = "crear")
    private Boolean crear;

    @Column(name = "modificar")
    private Boolean modificar;

    @Column(name = "autorizar")
    private Boolean autorizar;

    @ManyToOne
    private Formulario formulario;

    @ManyToOne
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isVer() {
        return ver;
    }

    public void setVer(Boolean ver) {
        this.ver = ver;
    }

    public Boolean isCrear() {
        return crear;
    }

    public void setCrear(Boolean crear) {
        this.crear = crear;
    }

    public Boolean isModificar() {
        return modificar;
    }

    public void setModificar(Boolean modificar) {
        this.modificar = modificar;
    }

    public Boolean isAutorizar() {
        return autorizar;
    }

    public void setAutorizar(Boolean autorizar) {
        this.autorizar = autorizar;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Permiso permiso = (Permiso) o;
        if(permiso.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, permiso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Permiso{" +
            "id=" + id +
            ", ver='" + ver + "'" +
            ", crear='" + crear + "'" +
            ", modificar='" + modificar + "'" +
            ", autorizar='" + autorizar + "'" +
            '}';
    }
}
