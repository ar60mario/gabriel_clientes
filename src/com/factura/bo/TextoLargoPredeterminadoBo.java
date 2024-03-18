package com.factura.bo;

import com.factura.dao.TextoLargoPredeterminadoDao;
import com.factura.entities.TextoLargoPredeterminado;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class TextoLargoPredeterminadoBo {

    private final TextoLargoPredeterminadoDao dao = new TextoLargoPredeterminadoDao();

    public TextoLargoPredeterminado saveTextoLargoPredeterminado(TextoLargoPredeterminado texto) throws Exception {
        TextoLargoPredeterminado txt = null;
        try {
            txt = (TextoLargoPredeterminado) dao.save(texto);
        } catch (HibernateException ex1) {
            throw new Exception(ex1);
        }
        return txt;
    }

    public TextoLargoPredeterminado updateTextoLargoPredeterminado(TextoLargoPredeterminado texto) throws Exception {
        try {
            texto = (TextoLargoPredeterminado) dao.update(texto);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return texto;
    }

}
