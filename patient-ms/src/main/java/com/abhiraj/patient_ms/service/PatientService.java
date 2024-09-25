package com.abhiraj.patient_ms.service;

import com.abhiraj.patient_ms.entity.Patient;
import com.abhiraj.patient_ms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientById(Long id){
        return patientRepository.findById(id);
    }

    public boolean existsById(Long id){
        return patientRepository.existsById(id);
    }

    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }

    public Patient updatePatient (Long id, Patient updatedPatient){
        if(patientRepository.existsById(id)){
            updatedPatient.setId(id);
            return patientRepository.save(updatedPatient);
        }else {
            throw new RuntimeException("Patient Not Found");
        }
    }
}
