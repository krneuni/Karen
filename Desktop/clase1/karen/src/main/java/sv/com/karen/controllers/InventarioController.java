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

import sv.com.karen.models.entities.Inventario;
import sv.com.karen.models.services.IInventarioService;
import sv.com.karen.models.services.IProductoService; 

@Controller
@SessionAttributes("inventario")
@RequestMapping(value="/inventario")
public class InventarioController {

	@Autowired
	private IInventarioService InventarioService;
	
	@Autowired
	private IProductoService productoService;

	@RequestMapping(value="/inventario", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","Detalle de Inventario");
		model.addAttribute("Inventario", InventarioService.findAll());
		return "inventario";
	}
	
	@RequestMapping(value="/agregarinv", method=RequestMethod.GET)
	public String form(Map<String, Object> model) {
		Inventario inventario = new Inventario();
		model.put("Inventario", new Inventario());
		model.put("titulo", "Formulario de Inventario");
		model.put("Productos", productoService.findAll());
		return "agregarinv";
	}
	
	@RequestMapping(value="/agregarinv", method=RequestMethod.POST)
	public String guardar(@Valid Inventario inventario, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		InventarioService.save(inventario);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Creado con exito");
		return "redirect:/inventario/inventario";
	}
	
	@RequestMapping(value="/agregarinv/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Inventario inventario  = null;
		if (id > 0) {
			inventario = InventarioService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id no puede ser cero");
			return "redirect:/inventario/inventario";
		}
		model.put("Inventario", inventario);

		model.put("Productos", productoService.findAll());
		model.put("titulo", "Editar");
		
		return "agregarinv";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			InventarioService.delete(id);
		}
		flash.addFlashAttribute("success","Eliminado con exito");
		return "redirect:/inventario/inventario";
	}
	
}
