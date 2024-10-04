package estudiante.ws.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import estudiante.ws.entities.Estudiante;
import estudiante.ws.repositories.EstudianteRepository;
import jakarta.validation.Valid;
 
@RestController
@RequestMapping("/estudiante")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
RequestMethod.DELETE })

public class EstudianteController {

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	
	@GetMapping()
	public @ResponseBody Iterable<Estudiante> obtenerTodos() {
		return estudianteRepository.findAll();
	}
	
	
	@PostMapping()
	public ResponseEntity<String> registrar(@Valid @RequestBody Estudiante estudiante) {
	    Optional<Estudiante> estudianteExistente = estudianteRepository.findById(estudiante.getId());
	    if (estudianteExistente.isPresent()) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un Estudiante con este id");
	    }
	    estudianteRepository.save(estudiante);
	    return ResponseEntity.status(HttpStatus.CREATED).body("Estudiante registrado correctamente");
	}

    @PutMapping("/{id}")
    public ResponseEntity<String> modificar(@Valid @RequestBody Estudiante estudiante, @PathVariable Integer id) {
        try {
            Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);

            if (estudianteOptional.isPresent()) {
                Estudiante estudianteExistente = estudianteOptional.get();
                estudianteExistente.setNombre(estudiante.getNombre());
                estudianteExistente.setEdad(estudiante.getEdad());
                estudianteExistente.setGrupo(estudiante.getGrupo());
                estudianteExistente.setPromedioGeneral(estudiante.getPromedioGeneral());
                estudianteRepository.save(estudianteExistente);
                return ResponseEntity.ok("Estudiante modificado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Estudiante con id " + id + " no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar el Estudiante");
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        try {
            Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);

            if (estudianteOptional.isPresent()) {
                Estudiante estudianteExistente = estudianteOptional.get();
                estudianteRepository.delete(estudianteExistente);
                return ResponseEntity.ok("Estudiante eliminado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el Estudiante");
        }
    }
    
    
}
