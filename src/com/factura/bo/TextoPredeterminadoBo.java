/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package com.factura.bo;

import com.factura.dao.TextoPredeterminadoDao;
import com.factura.entities.TextoLargoPredeterminado;
import com.factura.entities.TextoPredeterminado;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class TextoPredeterminadoBo {

    private final TextoPredeterminadoDao dao = new TextoPredeterminadoDao();

//    private static final Logger logger = Logger.getLogger("AdministradorBO");
    public List<TextoPredeterminado> getAllTextoPredeterminadoActivos() throws Exception {
        List<TextoPredeterminado> textos = null;
        try {
            textos = dao.getAllTextoPredeterminadoActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return textos;
    }
    
    public List<TextoPredeterminado> getAllTextoPredeterminado() throws Exception {
        List<TextoPredeterminado> textos = null;
        try {
            textos = dao.getAllTextoPredeterminado();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return textos;
    }

    public Integer getUltimoCodigoTextoPredeterminado() throws Exception {
        Integer cod = 0;
        try {
            cod = dao.getUltimoCodigoTextoPredeterminado();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cod;
    }

    public TextoPredeterminado saveTextoPredeterminado(TextoPredeterminado texto) throws Exception {
        TextoLargoPredeterminado tlp = texto.getTextoLargoPredeterminado();
        tlp = new TextoLargoPredeterminadoBo().saveTextoLargoPredeterminado(tlp);
        texto.setTextoLargoPredeterminado(tlp);
        try {
            texto = (TextoPredeterminado) dao.save(texto);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return texto;
    }

    public TextoPredeterminado updateTextoPredeterminado(TextoPredeterminado texto) throws Exception {
        TextoLargoPredeterminado tlp = texto.getTextoLargoPredeterminado();
        tlp = new TextoLargoPredeterminadoBo().updateTextoLargoPredeterminado(tlp);
        texto.setTextoLargoPredeterminado(tlp);
        try {
            texto = (TextoPredeterminado) dao.update(texto);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return texto;
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
