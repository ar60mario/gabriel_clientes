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
public class TextoPredeterminado {

    private Long id;
    private Integer codigo;
    private String descripcion;
    private TextoLargoPredeterminado textoLargoPredeterminado;
    private Boolean activo;

    public TextoPredeterminado() {
    }

    public TextoPredeterminado(Long id, Integer codigo, String descripcion, TextoLargoPredeterminado textoLargoPredeterminado, Boolean activo) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.activo = activo;
        this.textoLargoPredeterminado = textoLargoPredeterminado;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TextoLargoPredeterminado getTextoLargoPredeterminado() {
        return textoLargoPredeterminado;
    }

    public void setTextoLargoPredeterminado(TextoLargoPredeterminado textoLargoPredeterminado) {
        this.textoLargoPredeterminado = textoLargoPredeterminado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}
