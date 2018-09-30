package sv.com.karen.models.services;

import java.util.List;
import sv.com.karen.models.entities.Compra;

public interface ICompraService {
	public List<Compra> findAll();
	public void save(Compra compra);
	public Compra findOne(Long id);
	public void delete (Long id);
}
