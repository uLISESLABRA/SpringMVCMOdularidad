/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulises.sistema.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.ulises.sistema.SysDataAccess;
import pe.edu.ulises.sistema.modelo.Persona;

/**
 *
 * @author ulises
 */
@Repository
public class PersonaDaoImpl extends SysDataAccess<Integer, Persona> implements PersonaDaoI{
    
    @SuppressWarnings("unchecked")
    
    @Override
    public List<Persona> listarEntidad(){ return getListAll();}   
    
    @Override
    public List<Persona> listarEntidadDato(String dato){
        return (List<Persona>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from Persona p WHERE p.nombres LIKE ? ")
                .setString(0, "%"+dato+"%")
                .list();                
                }
    
    @Override
    public Persona buscarEntidadId(int id){ return getById(id);}
    
    @Override
    public void guardarEntidad(Persona persona){savev(persona);}
    @Override
    public void eliminarEntidad(int id){delete(id);}
    @Override
    public void modificarEntidad(Persona persona){update(persona);}

}
