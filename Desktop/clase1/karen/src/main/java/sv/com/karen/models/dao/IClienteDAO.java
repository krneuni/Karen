package sv.com.karen.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.karen.models.entities.Cliente;
public interface IClienteDAO extends CrudRepository<Cliente, Long>{
	
}
