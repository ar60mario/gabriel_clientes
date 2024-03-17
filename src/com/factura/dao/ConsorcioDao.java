/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.dao;

import com.factura.entities.Consorcio;
import com.factura.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class ConsorcioDao extends GenericDao {

    public Integer getCodigoSiguiente() {
        Integer codigo = 0;
        List<Consorcio> consorcios = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Consorcio.class);
        criteria.addOrder(Order.desc("codigo"));
        consorcios = (List<Consorcio>) criteria.list();
        if (consorcios != null && !consorcios.isEmpty()) {
            Consorcio cons = consorcios.get(0);
            codigo = cons.getCodigo();
        }
        return codigo;
    }

    public List<Consorcio> getAllConsorciosActivasByPagina(Integer pagina, Integer limite) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Consorcio.class);
        Criteria criteria1 = criteria.createCriteria("domicilio");
        criteria.add(Restrictions.eq("activo", true));
        criteria1.addOrder(Order.asc("calle"));
        criteria1.addOrder(Order.asc("numero"));
        criteria.setFirstResult(pagina);
        criteria.setMaxResults(limite);
        List<Consorcio> consorcios = (List<Consorcio>) criteria.list();
        return consorcios;
    }
    
    public List<Consorcio> getConsorciosByUltimaPagina(Integer pagina, Integer limite) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Consorcio.class);
        Criteria criteria1 = criteria.createCriteria("domicilio");
        criteria.add(Restrictions.eq("activo", true));
        criteria1.addOrder(Order.desc("calle"));
        criteria1.addOrder(Order.desc("numero"));
        criteria.setFirstResult(pagina);
        criteria.setMaxResults(limite);
        List<Consorcio> consorcios = (List<Consorcio>) criteria.list();
        return consorcios;
    }

}
