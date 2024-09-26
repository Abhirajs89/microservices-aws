Microservices in the Project can be dockerize, and images can be pushed to ECR and then deployed on EKS
=======================================================================================================
Patient Service:
1) Manages CRUD operations for patients. 
2) Provides a synchronous API to check if a patient exists.

Appointment Service: 
1) Manages doctor-patient appointments. 
2) Uses Feign Client to communicate synchronously with Patient Service to verify the patient's existence.

Endpoints:
=================================================================
Patient Service Endpoints
=======================================================
1) localhost:8081/patients/ - create patients
2) localhost:8081/patients/2 - Get patients
3) localhost:8081/patients/2/exists - Check patients 
4) localhost:8081/patients/1 - update Patients
5) localhost:8081/patients/2 - Delete patients

Appointment Service Enpoints:
==============================================================
1) localhost:8082/appointments/ - Create apintments only after verifying the patient's existence
