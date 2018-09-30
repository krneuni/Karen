package sv.com.karen.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.karen.models.entities.Inventario;
public interface IInventarioDAO extends CrudRepository<Inventario, Long>{
	
}
