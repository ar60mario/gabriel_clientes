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
public class TextoLargoPredeterminado {
    private Long id;
    private String textoLargo;
    private TextoPredeterminado textoPredeterminado;

    public TextoLargoPredeterminado() {
    }

    public TextoLargoPredeterminado(Long id, String textoLargo, TextoPredeterminado textoPredeterminado) {
        this.id = id;
        this.textoLargo = textoLargo;
        this.textoPredeterminado = textoPredeterminado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoLargo() {
        return textoLargo;
    }

    public void setTextoLargo(String textoLargo) {
        this.textoLargo = textoLargo;
    }

    public TextoPredeterminado getTextoPredeterminado() {
        return textoPredeterminado;
    }

    public void setTextoPredeterminado(TextoPredeterminado textoPredeterminado) {
        this.textoPredeterminado = textoPredeterminado;
    }
    
    
}
