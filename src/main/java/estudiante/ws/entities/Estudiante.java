package estudiante.ws.entities;

import org.hibernate.annotations.JdbcTypeCode;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="estudiante")
public class Estudiante {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
    private String nombre;
    
    @Column(name = "edad")
  	@JdbcTypeCode(java.sql.Types.VARCHAR)
    private int edad;
    
    @Column(name = "grupo")
  	@JdbcTypeCode(java.sql.Types.VARCHAR)
    private String grupo;
    
    @Column(name = "promedio_general")
  	@JdbcTypeCode(java.sql.Types.DECIMAL)
    private double promedioGeneral;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public double getPromedioGeneral() {
        return promedioGeneral;
    }

    public void setPromedioGeneral(double promedioGeneral) {
        this.promedioGeneral = promedioGeneral;
    }

	public Estudiante(int id, String nombre, int edad, String grupo, double promedioGeneral) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.grupo = grupo;
		this.promedioGeneral = promedioGeneral;
	}

	public Estudiante() {
		super();
	}


}
