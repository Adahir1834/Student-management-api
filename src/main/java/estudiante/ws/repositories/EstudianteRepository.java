package estudiante.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import estudiante.ws.entities.Estudiante;
@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Integer>{

}

