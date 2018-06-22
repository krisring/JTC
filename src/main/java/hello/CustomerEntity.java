package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collections;
import java.util.List;

@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long customerRelations;
    private String customerCompanyName;
    private String companyEmail;
    private String userId;
    private String companyId;
    private String companyId2;


    protected CustomerEntity() {

    }

    public CustomerEntity(String customerCompanyName, String companyEmail) {
        this.customerCompanyName = customerCompanyName;
        this.companyEmail = companyEmail;

    }

    @Override
    public String toString() {
        return String.format(
                "CustomerEntity[id=%d, customerCompanyName='%s', companyEmail='%s']",
                id, customerCompanyName, companyEmail);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCompanyName() {
        return customerCompanyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public void setCustomerCompanyName(String customerCompanyName) {
        this.customerCompanyName = customerCompanyName;
    }

    public void addUser(String userId, Long companyId) {
        this.userId = userId;
        this.id = companyId;
    }

    public List<Long> getCustomerCompanyRelations(Long companyId) {
        return Collections.singletonList(customerRelations);
    }

    public void setCustomerCompanyRelation(String companyId, String companyId2) {
        this.companyId = companyId;
        this.companyId2 = companyId2;
    }

//    public void addUserToCustomerCompany(String userEmail, String companyId) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.getUserByEmail(userEmail);
//        customerRepository.save();
//        userRepository.findById(userEntity.getId());
//    }
}