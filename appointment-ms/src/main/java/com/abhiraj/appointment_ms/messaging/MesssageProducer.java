package com.abhiraj.appointment_ms.messaging;

import com.abhiraj.appointment_ms.dto.AppointmentDTO;
import com.abhiraj.appointment_ms.entity.Appointment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class MesssageProducer {

    private final RabbitTemplate rabbitTemplate;

    public MesssageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendAppointmentMessage(Appointment appointment){
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setPatientId(appointment.getPatientId());
        appointmentDTO.setPatientName(appointment.getPatientName());
        appointmentDTO.setDoctorName(appointment.getDoctorName());
        appointmentDTO.setAppointmentDate((appointment.getAppointmentDate()).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        rabbitTemplate.convertAndSend("appointmentqueue",appointmentDTO);
    };
}
