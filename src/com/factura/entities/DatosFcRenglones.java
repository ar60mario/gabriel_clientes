/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.entities;

/**
 *
 * @author argia
 */
public class DatosFcRenglones {
    private Long id;
    private String detalle;
    private Double importe;

    public DatosFcRenglones() {
    }

    public DatosFcRenglones(Long id, String detalle, Double importe) {
        this.id = id;
        this.detalle = detalle;
        this.importe = importe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
    
}
