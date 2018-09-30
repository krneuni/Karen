package sv.com.karen.models.services;

import java.util.List;
import sv.com.karen.models.entities.Producto;

public interface IProductoService {
	public List<Producto> findAll();
	public void save(Producto producto);
	public Producto findOne(Long id);
	public void delete (Long id);
}
