/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.dao;

import com.factura.entities.Administrador;
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
public class TextoLargoPredeterminadoDao extends GenericDao {

    public List<Administrador> getAllAdministradoresActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Administrador.class);
        criteria.add(Restrictions.eq("activo", true));
        List<Administrador> administradores = (List<Administrador>) criteria.list();
        return administradores;
    }

    public Integer getUltimoCodigoAdministrador() {
        Integer cod = 0;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Administrador.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.desc("codigo"));
        criteria.setMaxResults(3);
        List<Administrador> tds = (List<Administrador>) criteria.list();
        if (!tds.isEmpty()) {
            cod = tds.get(0).getCodigo();
            for (Administrador os : tds) {
                System.out.println(os.getId());
            }
        }
        return cod;
    }

//    public List<Cliente> getAllClientesInactivos() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.add(Restrictions.eq("activo", false));
//        criteria.addOrder(Order.asc("razonSocial"));
//        //Criteria criteria1 = criteria.createCriteria("direccion");
//        //criteria.addOrder(Order.asc("direccion"));
//        criteria.addOrder(Order.asc("codigoMauro"));
//        List<Cliente> clientes = (List<Cliente>) criteria.list();
//        return clientes;
//    }
//
//    public List<Cliente> getClientesByFiltro(String filtro) {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        StringBuffer sb = new StringBuffer();
//        sb.append("from Cliente clie ");
//        sb.append("where clie.razonSocial like :filtro ");
//        sb.append("order by clie.razonSocial asc");
//        Query query = session.createQuery(sb.toString());
//        query.setParameter("filtro", "%" + filtro + "%");
//        clientes = (List<Cliente>) query.list();
//        return clientes;
//    }
//
//    public List<Cliente> getClientesByFiltroCalle(String filtro) {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        Criteria criteria1 = criteria.createCriteria("direccion");
//        criteria1.add(Restrictions.like("calle", "%" + filtro + "%"));
//        clientes = (List<Cliente>) criteria.list();
//        return clientes;
//    }
//
//    public Cliente getByCodigo(Integer codigo) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.add(Restrictions.eq("codigo", codigo));
//        Cliente cliente = (Cliente) criteria.uniqueResult();
//        return cliente;
//    }
//
//    public Cliente getByCuit(String cuit) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.add(Restrictions.eq("cuit", cuit));
//        Cliente cliente = (Cliente) criteria.uniqueResult();
//        return cliente;
//    }
//
//    public Cliente getUltimo() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.addOrder(Order.desc("codigo"));
//        List<Cliente> c = (List<Cliente>) criteria.list();
//        if (c != null && !c.isEmpty()) {
//            Cliente cliente = c.get(0);
//            return cliente;
//        } else {
//            return null;
//        }
//    }
//
//    public List<Cliente> getClientesByAbono(Abono abono) {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("abono", abono));
//        clientes = (List<Cliente>) criteria.list();
//        return clientes;
//    }
//
//    public List<Cliente> getAllClientesHabilitadosByRubro(Rubro rubro) {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.add(Restrictions.eq("rubro", rubro));
//        clientes = (List<Cliente>) criteria.list();
//        return clientes;
//    }
}
