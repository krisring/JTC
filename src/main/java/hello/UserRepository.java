package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findUserIdByUserEmail(String userEmail);

    List<UserEntity> findAllByUserEmail(String userEmail);

    List<UserEntity> findAll();
}