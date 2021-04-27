package np.edu.deerwalk.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import np.edu.deerwalk.models.UserModel;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {
	List<UserModel> findByUsername(String username);
	List<UserModel> findByEmail(String email);
}
