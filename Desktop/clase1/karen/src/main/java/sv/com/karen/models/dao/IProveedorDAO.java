package sv.com.karen.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.karen.models.entities.Proveedor;
public interface IProveedorDAO extends CrudRepository<Proveedor, Long>{
	
}
