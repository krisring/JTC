package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByCustomerCompanyName(String customerCompanyName);

    List<CustomerEntity> findAll();

    List<Long> findCompanyRelationByCompanyId(String companyId);
}