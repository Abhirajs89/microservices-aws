package com.abhiraj.notification_ms.messaging;

import com.abhiraj.notification_ms.dto.AppointmentDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @RabbitListener(queues = "appointmentqueue")
    public void receiveAppointmentMessage(AppointmentDTO appointmentDTO){
        System.out.println("Received appointment for notification: " + appointmentDTO);
    }
}
