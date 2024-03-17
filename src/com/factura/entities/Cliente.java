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
public class Cliente {
    private Long id;
    private Integer codigo;
    private String razonSocial;
    private String cuit;
    private Integer tipoDocumento;
    private Integer categoria;
    private String telefono;
    private String observaciones;
    private Boolean activo;
    private Domicilio domicilio;
}
