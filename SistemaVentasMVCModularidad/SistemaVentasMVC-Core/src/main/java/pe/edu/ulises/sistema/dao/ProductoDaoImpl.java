/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulises.sistema.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.ulises.sistema.SysDataAccess;
import pe.edu.ulises.sistema.modelo.Producto;

/**
 *
 * @author ulises
 */
@Repository
public class ProductoDaoImpl extends SysDataAccess<Integer, Producto> implements ProductoDaoI{
    
    @SuppressWarnings("unchecked")
    
    @Override
    public List<Producto> listarEntidad(){ return getListAll();}    
    
    @Override
    public Producto buscarEntidadId(int id){ return getById(id);}
    
    @Override
    public void guardarEntidad(Producto producto){savev(producto);}
    @Override
    public void eliminarEntidad(int id){delete(id);}
    @Override
    public void modificarEntidad(Producto producto){update(producto);}

}
