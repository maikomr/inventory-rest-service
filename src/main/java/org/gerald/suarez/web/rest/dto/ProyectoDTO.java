package org.gerald.suarez.web.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.gerald.suarez.domain.Documento;
import org.gerald.suarez.domain.EntidadPublica;
import org.gerald.suarez.domain.Pedido;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class ProyectoDTO {

    private Long id;

    private String nombre;

    private Integer noControl;

    private String modalidad;

    private Long entidadPublicaId;

    public ProyectoDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNoControl() {
        return noControl;
    }

    public void setNoControl(Integer noControl) {
        this.noControl = noControl;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Long getEntidadPublicaId() {
        return entidadPublicaId;
    }

    public void setEntidadPublicaId(Long entidadPublicaId) {
        this.entidadPublicaId = entidadPublicaId;
    }
}
