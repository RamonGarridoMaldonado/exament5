package com.oretania.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oretania.portal.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
    
    Alumno findByUserName(String name);

}
