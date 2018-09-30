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

import sv.com.karen.models.entities.Producto;
import sv.com.karen.models.services.IProductoService; 

@Controller
@SessionAttributes("producto")
@RequestMapping(value="/producto")
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	@RequestMapping(value="/producto", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de Producto");
		model.addAttribute("producto", productoService.findAll());
		return "producto";
	}
	
	@RequestMapping(value="/agregarprod", method=RequestMethod.GET)
	public String form(Map<String, Object> model) {
		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", "Formulario de Producto");
		return "agregarprod";
	}
	
	@RequestMapping(value="/agregarprod", method=RequestMethod.POST)
	public String guardar(@Valid Producto producto, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "producto";
		}
		productoService.save(producto);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Producto creado con exito");
		return "redirect:/producto/producto";
	}
	
	@RequestMapping(value="/agregarprod/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Producto producto = null;
		if (id > 0) {
			producto = productoService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id  no puede ser cero");
			return "redirect:/producto/agregarprod";
		}
		model.put("producto", producto);
		model.put("titulo", "Editar Producto");
		
		return "agregarprod";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			productoService.delete(id);
		}
		flash.addFlashAttribute("success","Producto eliminado con exito");
		return "redirect:/producto/producto";
	}
	
}
