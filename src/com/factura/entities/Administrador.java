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
public class Administrador {
    private Long id;
    private Integer codigo;
    private String cuit;
    private String nombre;
    private String telefono;
    private String mail;
    private String observaciones;
    private Boolean activo;
    private Boolean pagaMesCorriente;
    private Domicilio domicilio;

    public Administrador() {
    }

    public Administrador(Long id, Integer codigo, String cuit, String nombre, String telefono, String mail, String observaciones, Boolean activo, Boolean pagaMesCorriente, Domicilio domicilio) {
        this.id = id;
        this.codigo = codigo;
        this.cuit = cuit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.observaciones = observaciones;
        this.activo = activo;
        this.pagaMesCorriente = pagaMesCorriente;
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getPagaMesCorriente() {
        return pagaMesCorriente;
    }

    public void setPagaMesCorriente(Boolean pagaMesCorriente) {
        this.pagaMesCorriente = pagaMesCorriente;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    
    
}
