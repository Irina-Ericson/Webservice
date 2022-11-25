/**package webservice.irina.task3.repo;

import org.springframework.data.repository.CrudRepository;
import webservice.irina.task3.model.CanvasStudent;

import java.util.List;

public interface CanvasStudentRepo extends CrudRepository<CanvasStudent,Long> {

    List<CanvasStudent> findAllById(Long Id);

}
**/