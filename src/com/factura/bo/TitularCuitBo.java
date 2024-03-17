/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.bo;

import com.factura.dao.TitularCuitDao;
import com.factura.entities.TitularCuit;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author argia
 */
public class TitularCuitBo {
    private TitularCuitDao dao = new TitularCuitDao();
    public Integer getCodigoSiguiente() throws Exception {
        Integer codigo;
        try {
            codigo = dao.getCodigoSiguiente();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return codigo;
    }
    /*
    public Consorcio saveConsorcio(Consorcio consorcio) throws Exception {
        DomicilioBo domicilioBO = new DomicilioBo();
        Domicilio domicilio = consorcio.getDomicilio();
        domicilio = domicilioBO.saveDomicilio(domicilio);
        consorcio.setDomicilio(domicilio);
        try {
            dao.save(consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return consorcio;
    }
    
    public Consorcio updateConsorcio(Consorcio consorcio) throws Exception {
        DomicilioBo domicilioBO = new DomicilioBo();
        Domicilio domicilio = consorcio.getDomicilio();
        domicilio = domicilioBO.updateDomicilio(domicilio);
        consorcio.setDomicilio(domicilio);
        try {
            dao.update(consorcio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return consorcio;
    }
    */
    public List<TitularCuit> getAllTitularCuitActivos() throws Exception {
        List<TitularCuit> titulares = null;
        try {
            titulares = dao.getAllTitularCuitActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return titulares;
    }
    
}
