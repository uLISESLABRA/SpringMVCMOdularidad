/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulises.sistema.control;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pe.edu.ulises.sistema.modelo.Persona;
import pe.edu.ulises.sistema.modelo.Producto;
import pe.edu.ulises.sistema.modelo.Venta;
import pe.edu.ulises.servicio.PersonaServicioI;
import pe.edu.ulises.servicio.ProductoServicioI;
import pe.edu.ulises.servicio.VentaServicioI;

/**
 *
 * @author ulises
 */
@Controller
public class PersonaControl {
    
    @Autowired
    private MessageSource messageSource;
    @Autowired
    PersonaServicioI personaServicioI;
    @Autowired
    ProductoServicioI productoServicioI;
    @Autowired
    VentaServicioI ventaServicioI;
    @Autowired
    VentaServicioI detalleventaServicio;
    
    @RequestMapping(value = "/locate", method = RequestMethod.GET)
    public String getLocatePage(){
    return "my-locale";
    }
      
@RequestMapping(value = {"/" }, method = RequestMethod.GET)    
public ModelAndView inicio(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Ulises Labra"}, locale);
    List<Persona> lista=personaServicioI.listarEntidad();
    for (Persona persona : lista) {
        System.out.println("Nombres: "+persona.getNombres()+" "+persona.getApellidos());
    }
    model.put("ListaPersona", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("persona/mainPersona");
}
@RequestMapping(value = {"/pru1" }, method = RequestMethod.GET)    
public ModelAndView inicioUno(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Ulises Labra"}, locale);
    List<Producto> lista= productoServicioI.listarEntidad();
    for (Producto producto : lista) {
        System.out.println("Nombres: "+producto.getNombre()+" "+producto.getDescripcion());
    }
    model.put("ListaProducto", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("Prueba2");
}
@RequestMapping(value = {"/pru2" }, method = RequestMethod.GET)    
public ModelAndView inicioDos(Locale locale, Map<String,Object> model){
    
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Ulises Labra"}, locale);
    List<Venta> lista= ventaServicioI.listarEntidad();
    for (Venta venta : lista) {
        System.out.println("Nombres: "+venta.getFecha()+" "+venta.getPrecioTotal());
    }
    model.put("ListaVenta", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    return new ModelAndView("Prueba3");
}

@RequestMapping(value = {"/pru3" }, method = RequestMethod.GET)    
public ModelAndView inicioTres(){
    
   
    
    return new ModelAndView("Prueba4");
}

@RequestMapping(value = {"/pers" }, method = RequestMethod.GET)    
public ModelAndView mainPersona(){    
    return new ModelAndView("persona/mainPersona");
}
@RequestMapping(value = {"/report" }, method = RequestMethod.GET)    
public ModelAndView mainPersonaReport(){    
    return new ModelAndView("persona/reporte/reportePersona");
}






//FUNCIONALIDADES ELIMINAR Y BUSCAR

@RequestMapping(value = {"/elim" }, method = RequestMethod.GET)
public ModelAndView eliminarPersona(HttpServletRequest r){
    int idEntidad=Integer.parseInt(r.getParameter("id"));
    personaServicioI.eliminarEntidad(idEntidad);
return new ModelAndView(new RedirectView(r.getContextPath()+"/"));
}
  
@RequestMapping(value = {"/buscar"}, method = RequestMethod.POST)
public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Ulises Labra"}, locale);
    String dato=r.getParameter("dato");
    List<Persona> lista=personaServicioI.listarEntidadDato(dato);
    model.put("ListaPersona", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");    
return new ModelAndView("persona/mainPersona");


}

//GUARDAR FORMULARIO 

@RequestMapping(value = "/formPersona", method = RequestMethod.GET)
public ModelAndView irFormulario(@ModelAttribute("modeloPersona")Persona persona,
        BindingResult result){
    
return new ModelAndView("persona/formPersona");
}

@RequestMapping(value = "/guardarPersona", method = RequestMethod.POST)
public ModelAndView guardarEntidad(@ModelAttribute("modeloPersona")Persona persona,
        BindingResult result, HttpServletRequest r){
        persona.setIdPersona(8);
        personaServicioI.guardarEntidad(persona);
    return new ModelAndView(new RedirectView(r.getContextPath()+"/"));
}

}