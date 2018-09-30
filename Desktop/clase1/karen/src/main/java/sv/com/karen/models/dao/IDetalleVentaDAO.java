package sv.com.karen.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.karen.models.entities.DetalleVenta;
public interface IDetalleVentaDAO extends CrudRepository<DetalleVenta, Long>{
	
}