/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.dao;

import com.factura.entities.TitularCuit;
import com.factura.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author argia
 */
public class TitularCuitDao extends GenericDao {
    
    public Integer getCodigoSiguiente() {
        Integer codigo = 0;
        List<TitularCuit> titulares = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(TitularCuit.class);
        criteria.addOrder(Order.desc("codigo"));
        titulares = (List<TitularCuit>) criteria.list();
        if (titulares != null && !titulares.isEmpty()) {
            TitularCuit titu = titulares.get(0);
            codigo = titu.getCodigo();
        }
        return codigo;
    }

    public List<TitularCuit> getAllTitularCuitActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(TitularCuit.class);
//        Criteria criteria1 = criteria.createCriteria("domicilio");
        criteria.add(Restrictions.eq("activo", true));
//        criteria1.addOrder(Order.asc("calle"));
//        criteria1.addOrder(Order.asc("numero"));
//        criteria.setFirstResult(pagina);
//        criteria.setMaxResults(limite);
        List<TitularCuit> titulares = (List<TitularCuit>) criteria.list();
        return titulares;
    }
    
}
