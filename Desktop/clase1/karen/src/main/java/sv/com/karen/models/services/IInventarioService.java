package sv.com.karen.models.services;

import java.util.List;
import sv.com.karen.models.entities.Inventario;

public interface IInventarioService {
	public List<Inventario> findAll();
	public void save(Inventario inventario);
	public Inventario findOne(Long id);
	public void delete (Long id);
}
