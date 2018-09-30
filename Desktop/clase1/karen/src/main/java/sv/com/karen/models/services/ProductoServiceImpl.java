package sv.com.karen.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.karen.models.dao.IProductoDAO;
import sv.com.karen.models.entities.Producto;
@Service
public class ProductoServiceImpl implements IProductoService{
	@Autowired
	private IProductoDAO productoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll(){
		return (List<Producto>) productoDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Producto findOne(Long id) {
		return productoDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void save(Producto producto) {
		productoDao.save(producto);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		productoDao.deleteById(id);
	}
}
