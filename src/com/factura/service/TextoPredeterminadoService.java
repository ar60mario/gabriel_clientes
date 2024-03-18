package com.factura.service;

import com.factura.bo.TextoLargoPredeterminadoBo;
import com.factura.bo.TextoPredeterminadoBo;
import com.factura.entities.TextoLargoPredeterminado;
import com.factura.entities.TextoPredeterminado;
import com.factura.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TextoPredeterminadoService {

    
    public List<TextoPredeterminado> getAllTextoPredeterminadosActivos() throws Exception {
        List<TextoPredeterminado> textos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            textos = new TextoPredeterminadoBo().getAllTextoPredeterminadoActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return textos;
    }
    
    public List<TextoPredeterminado> getAllTextoPredeterminados() throws Exception {
        List<TextoPredeterminado> textos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            textos = new TextoPredeterminadoBo().getAllTextoPredeterminado();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return textos;
    }
    
    public Integer getUltimoCodigoTextoPredeterminado() throws Exception {
        Integer cod = 0;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            cod = new TextoPredeterminadoBo().getUltimoCodigoTextoPredeterminado();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cod;
    }
    
    public TextoPredeterminado saveTextoPredeterminado(TextoPredeterminado texto) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            texto = new TextoPredeterminadoBo().saveTextoPredeterminado(texto);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return texto;
    }
    
    public TextoPredeterminado updateTextoPredeterminado(TextoPredeterminado texto) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            texto = new TextoPredeterminadoBo().updateTextoPredeterminado(texto);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return texto;
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
