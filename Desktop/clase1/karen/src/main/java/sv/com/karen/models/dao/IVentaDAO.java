package sv.com.karen.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.karen.models.entities.Venta;
public interface IVentaDAO extends CrudRepository<Venta, Long>{
	
}
