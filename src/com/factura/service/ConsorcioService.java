/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.service;

import com.factura.bo.ConsorcioBo;
import com.factura.entities.Consorcio;
import com.factura.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class ConsorcioService {

    public Consorcio saveConsorcio(Consorcio consorcio) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            consorcio = new ConsorcioBo().saveConsorcio(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return consorcio;
    }
    
    public Consorcio updateConsorcio(Consorcio consorcio) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            consorcio = new ConsorcioBo().updateConsorcio(consorcio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return consorcio;
    }
    
    public Integer getCodigoSiguiente() throws Exception {
        Integer codigo;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            codigo = new ConsorcioBo().getCodigoSiguiente();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return codigo;
    }
    
    public List<Consorcio> getAllConsorciosActivasByPagina(Integer pagina, Integer limite) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Consorcio> consorcios = null;
        try {
            consorcios = new ConsorcioBo().getAllConsorciosActivasByPagina(pagina, limite);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return consorcios;
    }
    
    public List<Consorcio> getConsorciosByUltimaPagina(Integer pagina, Integer limite) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Consorcio> consorcios = null;
        try {
            consorcios = new ConsorcioBo().getConsorciosByUltimaPagina(pagina, limite);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return consorcios;
    }
}
