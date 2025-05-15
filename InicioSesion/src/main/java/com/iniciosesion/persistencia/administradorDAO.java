/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iniciosesion.persistencia;

import com.iniciosesion.entidades.administrador;
import com.iniciosesion.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class administradorDAO {
    
    public static administrador getById(int id) {
    administrador admin = null;
    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        admin = session.get(administrador.class, id);
    } catch (Exception ex) {
        System.out.println("Ocurrió un error: " + ex.getMessage());
    }
    return admin;
}
    
    /*public static List<administrador> getBtId(int id) {
        List<administrador> administradores = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            administrador admin = session.get(administrador.class, id);
            if (admin != null) {
                administradores.add(admin);
            }
        } catch (Exception ex) {
            System.out.println("Ocurrió un error: " + ex.getMessage());
        }
        return administradores;
    }*/
}