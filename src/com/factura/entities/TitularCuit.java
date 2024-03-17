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
public class TitularCuit {
    private Long id;
    private Integer codigo;
    private String nombreFantasia;
    private String razonSocial;
    private Domicilio domicilio;
    private String cuit;
    private String iibb;
    private Integer categoria;
    private String telefono;
    private Boolean activo;

    public TitularCuit() {
    }

    public TitularCuit(Long id, Integer codigo, String nombreFantasia, String razonSocial, 
            Domicilio domicilio, String cuit, String iibb, Integer categoria, 
            String telefono, Boolean activo) {
        this.id = id;
        this.codigo = codigo;
        this.nombreFantasia = nombreFantasia;
        this.razonSocial = razonSocial;
        this.domicilio = domicilio;
        this.cuit = cuit;
        this.iibb = iibb;
        this.categoria = categoria;
        this.telefono = telefono;
        this.activo = activo;
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

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocail) {
        this.razonSocial = razonSocial;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getIibb() {
        return iibb;
    }

    public void setIibb(String iibb) {
        this.iibb = iibb;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    
}
