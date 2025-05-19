/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iniciosesion.persistencia;

import com.iniciosesion.entidades.Administrador;
import com.iniciosesion.utils.HibernateUtil;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Clase para el manejo de registros con la base de datos.
 * @author darkheaven
 */
public class AdministradorDAO {
    
   private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public AdministradorDAO() {
    }
    
    
    /**
     * Método para buscar un registro en una base de datos por medio del correo
     * designado.
     * @param correo el correo a buscar en la base de datos.
     * @return El correo o nulo.
     */
    public Administrador obtenerPorCorreo(String correo) {
         try (Session session = sessionFactory.openSession()) {
             CriteriaBuilder builder = session.getCriteriaBuilder();
             CriteriaQuery<Administrador> criteria = builder.createQuery(Administrador.class);
             Root<Administrador> root = criteria.from(Administrador.class);
             criteria.select(root).where(builder.equal(root.get("correo"), correo));

             return session.createQuery(criteria).getSingleResult();
         } catch (NoResultException e) {
             return null;
         }
     }
 }