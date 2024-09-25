package com.abhiraj.patient_ms.repository;

import com.abhiraj.patient_ms.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
