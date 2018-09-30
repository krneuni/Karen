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

import sv.com.karen.models.entities.Proveedor;
import sv.com.karen.models.services.IProveedorService; 

@Controller
@SessionAttributes("proveedor")
@RequestMapping(value="/proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorService proveedorService;

	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de proveedores");
		model.addAttribute("proveedores", proveedorService.findAll());
		return "listar";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(Map<String, Object> model) {
		Proveedor proveedor = new Proveedor();
		model.put("proveedor", proveedor);
		model.put("titulo", "Formulario de Proveedor");
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid Proveedor proveedor, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		proveedorService.save(proveedor);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Proveedor creado con exito");
		return "redirect:/proveedor/listar";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Proveedor proveedor = null;
		if (id > 0) {
			proveedor = proveedorService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del proveedor no puede ser cero");
			return "redirect:/proveedor/listar";
		}
		model.put("proveedor", proveedor);
		model.put("titulo", "Editar Proveedor");
		
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			proveedorService.delete(id);
		}
		flash.addFlashAttribute("success","Proveedor eliminado con exito");
		return "redirect:/proveedor/listar";
	}
	
}
