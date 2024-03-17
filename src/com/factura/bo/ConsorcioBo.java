/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.bo;

import com.factura.dao.ConsorcioDao;
import com.factura.entities.Consorcio;
import com.factura.entities.Domicilio;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class ConsorcioBo {

private final ConsorcioDao dao = new ConsorcioDao();

    private static final Logger logger = Logger.getLogger("ConsorcioBO");
    
    public Integer getCodigoSiguiente() throws Exception {
        Integer codigo;
        try {
            codigo = dao.getCodigoSiguiente();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return codigo;
    }
    
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
    
    public List<Consorcio> getAllConsorciosActivasByPagina(Integer pagina, Integer limite) throws Exception {
        List<Consorcio> consorcios = null;
        try {
            consorcios = dao.getAllConsorciosActivasByPagina(pagina, limite);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return consorcios;
    }
    
    
    public List<Consorcio> getConsorciosByUltimaPagina(Integer pagina, Integer limite) throws Exception {
        List<Consorcio> consorcios = null;
        try {
            consorcios = dao.getConsorciosByUltimaPagina(pagina, limite);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return consorcios;
    }
    
}
