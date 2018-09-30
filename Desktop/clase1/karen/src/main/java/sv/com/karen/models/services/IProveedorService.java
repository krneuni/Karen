package sv.com.karen.models.services;

import java.util.List;
import sv.com.karen.models.entities.Proveedor;

public interface IProveedorService {
	public List<Proveedor> findAll();
	public void save(Proveedor proveedor);
	public Proveedor findOne(Long id);
	public void delete (Long id);
}
