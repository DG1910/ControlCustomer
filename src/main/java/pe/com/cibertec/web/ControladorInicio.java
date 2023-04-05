/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.cibertec.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.cibertec.domain.Customer;
import pe.com.cibertec.servicio.CustomerService;
import javax.validation.Valid;


@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private CustomerService customerService;

    
    @GetMapping("/")
    public String inicio(Model model ){
 
        var customers = customerService.listarCustomers();
       
        log.info("ejecutando el controlador spring MVC");

        model.addAttribute("customers" , customers) ;

            return "index";
    }
       
    
    @GetMapping("/agregar")
    public String agregar(Customer customer){
    
    return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Customer customer, Errors errores){
        
        if (errores.hasErrors()) {
            return "modificar";
        }
        
        customerService.guardar(customer);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(Customer customer, Model model){
    
        customer = customerService.encontrarCustomer(customer);
        model.addAttribute("customer" , customer);
        
        return "modificar";
    }
    
    
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(Customer customer){
        customerService.eliminar(customer);
        return "redirect:/";
    }
    
     
}
