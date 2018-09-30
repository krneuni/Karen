package sv.com.karen.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.karen.models.dao.IDetalleVentaDAO;
import sv.com.karen.models.entities.DetalleVenta;
@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService{
	@Autowired
	private IDetalleVentaDAO detalleventaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<DetalleVenta> findAll(){
		return (List<DetalleVenta>) detalleventaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public DetalleVenta findOne(Long id) {
		return detalleventaDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void save(DetalleVenta detalleventa) {
		detalleventaDao.save(detalleventa);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		detalleventaDao.deleteById(id);
	}
}
