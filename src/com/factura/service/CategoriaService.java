/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.service;

import com.factura.bo.CategoriaBo;
import com.factura.bo.TitularCuitBo;
import com.factura.entities.Categoria;
import com.factura.entities.TitularCuit;
import com.factura.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author argia
 */
public class CategoriaService {
    
    public List<Categoria> getAllCategoriasActivas() throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Categoria> categorias = null;
        try {
            categorias = new CategoriaBo().getAllCategoriasActivas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return categorias;
    }
    
    
    public Categoria saveCategoria(Categoria categoria) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            categoria = new CategoriaBo().saveCategoria(categoria);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return categoria;
    }
    
    public Categoria updateCategoria(Categoria categoria) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            categoria = new CategoriaBo().updateCategoria(categoria);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return categoria;
    }
    
    public Integer getCodigoSiguiente() throws Exception {
        Integer codigo;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            codigo = new CategoriaBo().getCodigoSiguiente();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return codigo;
    }
    

    
}
