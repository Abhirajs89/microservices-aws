package com.abhiraj.appointment_ms.service;

import com.abhiraj.appointment_ms.entity.Appointment;
import com.abhiraj.appointment_ms.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientServiceClient patientServiceClient;

    public ResponseEntity<?> createAppointment(Appointment appointment) {
        // Check if the patient exists
        ResponseEntity<Boolean> response = patientServiceClient.checkPatientExists(appointment.getPatientId());

        // If the patient doesn't exist, return a 404 Not Found with a custom error message
        if (!Boolean.TRUE.equals(response.getBody())) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Error: Patient with ID " + appointment.getPatientId() + " does not exist.");
        }

        // If patient exists, save the appointment and return 201 Created
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedAppointment);
    }

    public Optional<Appointment> getAppointment(Long id) {
        return appointmentRepository.findById(id);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
