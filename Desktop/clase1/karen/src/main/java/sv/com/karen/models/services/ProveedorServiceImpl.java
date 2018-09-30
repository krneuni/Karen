package sv.com.karen.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.karen.models.dao.IProveedorDAO;
import sv.com.karen.models.entities.Proveedor;
@Service
public class ProveedorServiceImpl implements IProveedorService{
	@Autowired
	private IProveedorDAO proveedorDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Proveedor> findAll(){
		return (List<Proveedor>) proveedorDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Proveedor findOne(Long id) {
		return proveedorDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void save(Proveedor proveedor) {
		proveedorDao.save(proveedor);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		proveedorDao.deleteById(id);
	}
}
