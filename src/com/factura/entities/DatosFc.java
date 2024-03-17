/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.entities;

import java.util.Date;

/**
 *
 * @author argia
 */
public class DatosFc {
    private Long id;
    private Date fecha;
    private Date vencimCae;
    private Integer cae;
    private Integer numero;
    private String cliente;
    private String domicilio;
    private String cuit;
    private String condicion;
    private Double total;

    public DatosFc() {
    }

    public DatosFc(Long id, Date fecha, Date vencimCae, Integer cae, Integer numero, String cliente, String domicilio, String cuit, String condicion, Double total) {
        this.id = id;
        this.fecha = fecha;
        this.vencimCae = vencimCae;
        this.cae = cae;
        this.numero = numero;
        this.cliente = cliente;
        this.domicilio = domicilio;
        this.cuit = cuit;
        this.condicion = condicion;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getVencimCae() {
        return vencimCae;
    }

    public void setVencimCae(Date vencimCae) {
        this.vencimCae = vencimCae;
    }

    public Integer getCae() {
        return cae;
    }

    public void setCae(Integer cae) {
        this.cae = cae;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
}
