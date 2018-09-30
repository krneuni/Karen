package sv.com.karen.models.services;

import java.util.List;
import sv.com.karen.models.entities.DetalleVenta;

public interface IDetalleVentaService {
	public List<DetalleVenta> findAll();
	public void save(DetalleVenta detalleventa);
	public DetalleVenta findOne(Long id);
	public void delete (Long id);
}
