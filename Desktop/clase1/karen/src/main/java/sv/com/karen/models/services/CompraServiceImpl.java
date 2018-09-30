package sv.com.karen.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.karen.models.dao.ICompraDAO;
import sv.com.karen.models.entities.Compra;
@Service
public class CompraServiceImpl implements ICompraService{
	@Autowired
	private ICompraDAO compraDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Compra> findAll(){
		return (List<Compra>) compraDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Compra findOne(Long id) {
		return compraDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void save(Compra compra) {
		compraDao.save(compra);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		compraDao.deleteById(id);
	}
}
