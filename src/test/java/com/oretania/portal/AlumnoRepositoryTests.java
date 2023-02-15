package com.oretania.portal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oretania.portal.models.Alumno;
import com.oretania.portal.models.Asignatura;
import com.oretania.portal.repositories.AlumnoRepository;
import com.oretania.portal.repositories.AsignaturaRepository;

import java.util.*;

@SpringBootTest
class AlumnoRepositoryTests {

	@Autowired
	AlumnoRepository repoAlumno; 
	
	@Autowired
	AsignaturaRepository repoAsignatura; 

	@Autowired
	PasswordEncoder encoder;

	@Test
	void crearalumnosTest() {

		Alumno u1 = new Alumno();
		u1.setCodigo(1);
		u1.setUserName("alumno1");
		u1.setPassword(encoder.encode("1234"));

        Alumno u2 = new Alumno();
		u2.setCodigo(2);
		u2.setUserName("alumno2");
		u2.setPassword(encoder.encode("1234"));

        Alumno u3 = new Alumno();
		u3.setCodigo(3);
		u3.setUserName("alumno3");
		u3.setPassword(encoder.encode("1234"));

        

		Asignatura a1 = new Asignatura();
		a1.setCodigo("MAT");
		a1.setDescrripcion("Matemáticas");
		repoAsignatura.save(a1);

		Asignatura a2 = new Asignatura();
		a2.setCodigo("LEN");
		a2.setDescrripcion("Lengua");
		repoAsignatura.save(a2);

		Asignatura a3 = new Asignatura();
		a3.setCodigo("ING");
		a3.setDescrripcion("Inglés");
		repoAsignatura.save(a3);

		Asignatura a4 = new Asignatura();
		a4.setCodigo("REL");
		a4.setDescrripcion("Religión");
		repoAsignatura.save(a4);

		Asignatura a5 = new Asignatura();
		a5.setCodigo("FIS");
		a5.setDescrripcion("Física");
		repoAsignatura.save(a5);

		Asignatura a6 = new Asignatura();
		a6.setCodigo("QUI");
		a6.setDescrripcion("Química");
		repoAsignatura.save(a6);

		List<Asignatura> asignaturaAlumno1 = new ArrayList<Asignatura>();
		asignaturaAlumno1.add(a1);
		asignaturaAlumno1.add(a2);
		asignaturaAlumno1.add(a3);

		u1.setAsignaturas(asignaturaAlumno1);


		Alumno u1OK = repoAlumno.save(u1);

		assertTrue(a6.getDescrripcion().equalsIgnoreCase("QUI"));
	}

}
