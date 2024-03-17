/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.bo;

import com.factura.dao.CategoriaDao;
import com.factura.entities.Categoria;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author argia
 */
public class CategoriaBo {

    private CategoriaDao dao = new CategoriaDao();

    public List<Categoria> getAllCategoriasActivas() throws Exception {
        List<Categoria> categorias = null;
        try {
            categorias = dao.getAllCategoriasActivas();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return categorias;
    }

    public Integer getCodigoSiguiente() throws Exception {
        Integer codigo;
        try {
            codigo = dao.getCodigoSiguiente();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return codigo;
    }

    public Categoria saveCategoria(Categoria consorcio) throws Exception {

        try {
            dao.save(consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return consorcio;
    }

    public Categoria updateCategoria(Categoria consorcio) throws Exception {

        try {
            dao.update(consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return consorcio;
    }

}
