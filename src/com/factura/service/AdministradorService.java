package com.factura.service;

import com.factura.bo.AdministradorBo;
import com.factura.entities.Administrador;
import com.factura.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdministradorService {

    
    public List<Administrador> getAllAdministradoresActivos() throws Exception {
        List<Administrador> administradores = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            administradores = new AdministradorBo().getAllAdministradoresActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return administradores;
    }
    
    public List<Administrador> getAllAdministradoresInactivos() throws Exception {
        List<Administrador> administradores = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            administradores = new AdministradorBo().getAllAdministradoresInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return administradores;
    }
    
    public Integer getUltimoCodigoAdministrador() throws Exception {
        Integer cod = 0;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            cod = new AdministradorBo().getUltimoCodigoAdministrador();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cod;
    }
    
    public Administrador saveAdministrador(Administrador administrador) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            administrador = new AdministradorBo().saveAdministrador(administrador);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return administrador;
    }
    
    public Administrador updateAdministrador(Administrador administrador) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            administrador = new AdministradorBo().updateAdministrador(administrador);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return administrador;
    }
    
//    public List<Administrador> getAllAdministradoresInactivos() throws Exception {
//        List<Administrador> administradores = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            administradores = new AdministradorBO().getAllAdministradoresInactivos();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return administradores;
//    }
//
//    public Integer getCodigoSiguiente() throws Exception {
//        Integer codigo;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            codigo = new AdministradorBO().getCodigoSiguiente();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return codigo;
//    }
//    
//    public List<Administrador> getAllAdministradoresActivosByFiltro(String filtro) throws Exception {
//        List<Administrador> administradores = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            administradores = new AdministradorBO().getAllAdministradoresActivosByFiltro(filtro);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return administradores;
//    }
//    
//    public Administrador getAdministradorById(Long id) throws Exception {
//        Administrador administrador = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            administrador = new AdministradorBO().getAdministradorById(id);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return administrador;
//    }
//    
}
