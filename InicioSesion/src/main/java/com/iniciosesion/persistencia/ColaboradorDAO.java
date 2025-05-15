/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iniciosesion.persistencia;

import com.iniciosesion.entidades.Colaborador;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author darkheaven
 */
public class ColaboradorDAO {
    
    private final SessionFactory sessionFactory;
    
    public ColaboradorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    // Crear un nuevo colaborador
    public Long crearColaborador(Colaborador colaborador) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Long colaboradorId = null;
        
        try {
            transaction = session.beginTransaction();
            colaboradorId = (Long) session.save(colaborador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return colaboradorId;
    }
    
    public Colaborador obtenerPorCorreo(String correo) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Colaborador> criteria = builder.createQuery(Colaborador.class);
            Root<Colaborador> root = criteria.from(Colaborador.class);
            criteria.select(root).where(builder.equal(root.get("correo"), correo));
            
            return session.createQuery(criteria).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
