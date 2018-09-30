package sv.com.karen.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.karen.models.entities.Producto;
public interface IProductoDAO extends CrudRepository<Producto, Long>{
	
}
