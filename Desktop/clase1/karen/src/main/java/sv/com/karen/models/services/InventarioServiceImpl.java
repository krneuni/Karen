package sv.com.karen.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.karen.models.dao.IInventarioDAO;
import sv.com.karen.models.entities.Inventario;
@Service
public class InventarioServiceImpl implements IInventarioService{
	@Autowired
	private IInventarioDAO inventarioDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Inventario> findAll(){
		return (List<Inventario>) inventarioDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Inventario findOne(Long id) {
		return inventarioDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void save(Inventario inventario) {
		inventarioDao.save(inventario);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		inventarioDao.deleteById(id);
	}
}
