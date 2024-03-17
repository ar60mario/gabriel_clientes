/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.dao;

import com.factura.entities.Categoria;
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
public class CategoriaDao extends GenericDao {
    
    public List<Categoria> getAllCategoriasActivas() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Categoria.class);
//        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("codigo"));
        List<Categoria> categorias = (List<Categoria>) criteria.list();
        return categorias;
    }
    
    public Integer getCodigoSiguiente() {
        Integer codigo = 0;
        List<Categoria> titulares = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Categoria.class);
        criteria.addOrder(Order.desc("codigo"));
        titulares = (List<Categoria>) criteria.list();
        if (titulares != null && !titulares.isEmpty()) {
            Categoria titu = titulares.get(0);
            codigo = titu.getCodigo();
        }
        return codigo;
    }

    
    
}
