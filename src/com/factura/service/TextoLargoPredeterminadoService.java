package com.factura.service;

import com.factura.bo.TextoLargoPredeterminadoBo;
import com.factura.entities.TextoLargoPredeterminado;
import com.factura.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TextoLargoPredeterminadoService {

    public TextoLargoPredeterminado saveTextoLargoPredeterminado(TextoLargoPredeterminado texto) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            texto = new TextoLargoPredeterminadoBo().saveTextoLargoPredeterminado(texto);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return texto;
    }

    public TextoLargoPredeterminado updateTextoPredeterminado(TextoLargoPredeterminado texto) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            texto = new TextoLargoPredeterminadoBo().updateTextoLargoPredeterminado(texto);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return texto;
    }

}
