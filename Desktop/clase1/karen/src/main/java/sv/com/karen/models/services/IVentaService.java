package sv.com.karen.models.services;

import java.util.List;
import sv.com.karen.models.entities.Venta;

public interface IVentaService {
	public List<Venta> findAll();
	public void save(Venta venta);
	public Venta findOne(Long id);
	public void delete (Long id);
}
