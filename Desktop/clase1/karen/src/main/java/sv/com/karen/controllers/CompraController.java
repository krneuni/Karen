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

import sv.com.karen.models.entities.Compra;
import sv.com.karen.models.services.ICompraService; 

@Controller
@SessionAttributes("compra")
@RequestMapping(value="/compra")
public class CompraController {

	@Autowired
	private ICompraService compraService;

	@RequestMapping(value="/compra", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de compras");
		model.addAttribute("compras", compraService.findAll());
		return "compra";
	}
	
	@RequestMapping(value="/agregarcompra", method=RequestMethod.GET)
	public String form(Map<String, Object> model) {
		Compra compra = new Compra();
		model.put("compra", compra);
		model.put("titulo", "Formulario de compra");
		return "agregarcompra";
	}
	
	@RequestMapping(value="/agregarcompra", method=RequestMethod.POST)
	public String guardar(@Valid Compra compra, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "agregarcompra";
		}
		compraService.save(compra);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Compra creado con exito");
		return "redirect:/compra/compra";
	}
	
	@RequestMapping(value="/agregarcompra/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Compra compra = null;
		if (id > 0) {
			compra = compraService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id de la compra no puede ser cero");
			return "redirect:/compra/agregarcompra";
		}
		model.put("compra", compra);
		model.put("titulo", "Editar compra");
		
		return "agregarcompra";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			compraService.delete(id);
		}
		flash.addFlashAttribute("success","Compra eliminado con exito");
		return "redirect:/compra/compra";
	}
	
}
