/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package com.factura.bo;

import com.factura.dao.AdministradorDao;
import com.factura.entities.Administrador;
import com.factura.entities.Domicilio;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class TextoLargoPredeterminadoBo {

    private final AdministradorDao dao = new AdministradorDao();

    private static final Logger logger = Logger.getLogger("AdministradorBO");

    public List<Administrador> getAllAdministradoresActivos() throws Exception {
        List<Administrador> administradores = null;
        try {
            administradores = dao.getAllAdministradoresActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return administradores;
    }

    public Integer getUltimoCodigoAdministrador() throws Exception {
        Integer cod = 0;
        try {
            cod = dao.getUltimoCodigoAdministrador();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cod;
    }

    public Administrador saveAdministrador(Administrador administrador) throws Exception {
        DomicilioBo domicilioBO = new DomicilioBo();
        Administrador adm1 = null;
        Domicilio domicilio = administrador.getDomicilio();
        try {
            domicilio = domicilioBO.saveDomicilio(domicilio);
        } catch (HibernateException ex1) {
            throw new Exception(ex1);
        }
        administrador.setDomicilio(domicilio);
        try {
            adm1 = (Administrador) dao.save(administrador);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return adm1;
    }
    
    public Administrador updateAdministrador(Administrador administrador) throws Exception {
        DomicilioBo domicilioBO = new DomicilioBo();
        Administrador adm1 = null;
        Domicilio domicilio = administrador.getDomicilio();
        try {
            domicilio = domicilioBO.updateDomicilio(domicilio);
        } catch (HibernateException ex1) {
            throw new Exception(ex1);
        }
        administrador.setDomicilio(domicilio);
        try {
            adm1 = (Administrador) dao.update(administrador);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return adm1;
    }

//    public List<Administrador> getAllAdministradoresInactivos() throws Exception {
//        List<Administrador> administradores = null;
//        try {
//            administradores = dao.getAllAdministradoresInactivos();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return administradores;
//    }
//    
//    public Integer getCodigoSiguiente() throws Exception {
//        Integer codigo;
//        try {
//            codigo = dao.getCodigoSiguiente();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return codigo;
//    }
//    
//    public Administrador updateAdministrador(Administrador administrador) throws Exception {
//        DomicilioBO domicilioBO = new DomicilioBO();
//        Domicilio domicilio = administrador.getDomicilio();
//        domicilio = domicilioBO.updateDomicilio(domicilio);
//        administrador.setDomicilio(domicilio);
//        try {
//            dao.update(administrador);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return administrador;
//    }
//
//    public List<Administrador> getAllAdministradoresActivosByFiltro(String filtro) throws Exception {
//        List<Administrador> administradores = null;
//        try {
//            administradores = dao.getAllAdministradoresActivosByFiltro(filtro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return administradores;
//    }
//    
//    public Administrador getAdministradorById(Long id) throws Exception {
//        Administrador administrador = null;
//        try {
//            administrador = dao.getAdministradorById(id);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return administrador;
//    }
}
