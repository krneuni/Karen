package sv.com.karen.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.karen.models.dao.IVentaDAO;
import sv.com.karen.models.entities.Venta;
@Service
public class VentaServiceImpl implements IVentaService{
	@Autowired
	private IVentaDAO ventaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Venta> findAll(){
		return (List<Venta>) ventaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Venta findOne(Long id) {
		return ventaDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void save(Venta venta) {
		ventaDao.save(venta);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		ventaDao.deleteById(id);
	}
}
