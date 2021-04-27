package np.edu.deerwalk.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import np.edu.deerwalk.models.LogModel;

@Repository
public interface LogRepository extends MongoRepository<LogModel,String> {
	List<LogModel> findByName(String name);
}
