package sv.com.karen.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.com.karen.models.entities.DetalleVenta;
import sv.com.karen.models.services.IDetalleVentaService; 

@Controller
@SessionAttributes("detalleventa")
@RequestMapping(value="/detalleventa")
public class DetalleVentaController {

	@Autowired
	private IDetalleVentaService DetalleVentaService;

	@RequestMapping(value="/detalleventa", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","Detalle de Ventas");
		model.addAttribute("detalleventas", DetalleVentaService.findAll());
		return "detalleventa";
	}
	
	@RequestMapping(value="/agregardv", method=RequestMethod.GET)
	public String form(Map<String, Object> model) {
		DetalleVenta detalleventa = new DetalleVenta();
		model.put("detalleventa", detalleventa);
		model.put("titulo", "Formulario de Detalles de Venta");
		return "agregardv";
	}
	
	@RequestMapping(value="/agregardv", method=RequestMethod.POST)
	public String guardar(@Valid DetalleVenta detalleventa, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {

		DetalleVentaService.save(detalleventa);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Detalle creado con exito");
		return "redirect:/detalleventa/detalleventa";
	}
	
	@RequestMapping(value="/agregardv/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		DetalleVenta detalleventa  = null;
		detalleventa = DetalleVentaService.findOne(id);
		System.out.println(id);
		model.put("detalleventa", detalleventa);
		model.put("titulo", "Editar Detalle");
		
		return "agregardv";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			DetalleVentaService.delete(id);
		}
		flash.addFlashAttribute("success","Detalle eliminado con exito");
		return "redirect:/detalleventa/detalleventa";
	}
	
}
