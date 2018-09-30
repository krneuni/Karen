package sv.com.karen.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.karen.models.entities.Compra;
public interface ICompraDAO extends CrudRepository<Compra, Long>{
	
}
