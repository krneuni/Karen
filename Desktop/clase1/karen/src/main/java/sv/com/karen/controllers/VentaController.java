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

import sv.com.karen.models.entities.Venta;
import sv.com.karen.models.services.IVentaService; 

@Controller
@SessionAttributes("venta")
@RequestMapping(value="/venta")
public class VentaController {

	@Autowired
	private IVentaService ventaService;

	@RequestMapping(value="/venta", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de venta");
		model.addAttribute("venta", ventaService.findAll());
		return "venta";
	}
	
	@RequestMapping(value="/agregarventa", method=RequestMethod.GET)
	public String form(Map<String, Object> model) {
		Venta venta = new Venta();
		model.put("venta", venta);
		model.put("titulo", "Formulario de venta");
		return "agregarventa";
	}
	
	@RequestMapping(value="/agregarventa", method=RequestMethod.POST)
	public String guardar(@Valid Venta venta, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "agregarventa";
		}
		ventaService.save(venta);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Venta creado con exito");
		return "redirect:/venta/venta";
	}
	
	@RequestMapping(value="/agregarventa/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Venta venta = null;
		if (id > 0) {
			venta = ventaService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id de la venta no puede ser cero");
			return "redirect:/venta/agregarventaa";
		}
		model.put("venta", venta);
		model.put("titulo", "Editar venta");
		
		return "agregarventa";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			ventaService.delete(id);
		}
		flash.addFlashAttribute("success","venta eliminado con exito");
		return "redirect:/venta/venta";
	}
	
}
