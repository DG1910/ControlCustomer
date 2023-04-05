
package pe.com.cibertec.Dao;

import org.springframework.data.repository.CrudRepository;
import pe.com.cibertec.domain.Customer;


public interface CustomerDao extends CrudRepository<Customer, Long> {
    
}
