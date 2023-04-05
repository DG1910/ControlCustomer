
package pe.com.cibertec.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.cibertec.Dao.CustomerDao;
import pe.com.cibertec.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
    
    @Autowired
    private CustomerDao customerDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Customer> listarCustomers() {
        return   (List<Customer>) customerDao.findAll();
        
    }

    @Override
    @Transactional
    public void guardar(Customer customer) {
       customerDao.save(customer);
    }

    @Override
    @Transactional
    public void eliminar(Customer customer) {
       customerDao.delete(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public Customer encontrarCustomer(Customer customer) {
       return customerDao.findById(customer.getId()).orElse(null);
    }
    
}
