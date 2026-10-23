package medical_action_tracking;

import patient_intake.Patient;
import patient_intake.PatientRegistry;
import triage_efficiency.EfficiencyTester;

public class Main {
    public static void main(String[] args) {
        PatientRegistry registry = new PatientRegistry();
        Patient[] samplePatients = {
                patient("P001", 3),
                patient("P002", 1),
                patient("P003", 1)
        };
        for (Patient patient : samplePatients) {
            registry.addPatient(patient);
        }

        Patient[] patients = registry.getPatientRegistry();
        Patient searchedPatient = new EfficiencyTester().linearSearch(patients, "P002");
        System.out.println("Week 2 search found: " + searchedPatient);

        EmergencyWaitingRoom waitingRoom = new EmergencyWaitingRoom();
        for (Patient patient : patients) {
            waitingRoom.addPatient(patient);
        }
        while (!waitingRoom.isEmpty()) {
            Patient nextPatient = waitingRoom.nextPatient();
            System.out.println("Next patient: " + nextPatient.getPatientID()
                    + " (triage level " + nextPatient.getTriageLevel() + ")");
        }

        TreatmentHistory history = new TreatmentHistory();
        history.addTreatment("P002", "Initial assessment", "2026-09-27 09:00");
        history.addTreatment("P001", "X-ray", "2026-09-27 09:10");
        history.addTreatment("P002", "Pain relief", "2026-09-27 09:15");

        System.out.println("Treatment log: " + history.displayHistory());
        TreatmentRecord undone = history.undoLastAction();
        System.out.println("Undid: " + undone);
        System.out.println("Remaining log: " + history.displayHistory());

        // Optional
        runSimulationMetrics();
    }

    private static Patient patient(String patientID, int triageLevel) {
        return new Patient(patientID, "Test", "Patient", 30, "Checkup", triageLevel,
                "Waiting", "ER-001", 9, "INS-001");
    }

    private static Patient simPatient(String patientID, int triageLevel, int arrivalMinute, int serviceMinutes) {
        Patient patient = new Patient(patientID, "Test", "Patient", 30, "Checkup", triageLevel,
            "Waiting", "ER-001", arrivalMinute, "INS-001");
        patient.setServiceMinutes(serviceMinutes);
        return patient;
}

    private static void runSimulationMetrics() {
        Patient[] schedule = {
                simPatient("P001", 3, 0, 10),
                simPatient("P002", 1, 2, 15),
                simPatient("P003", 1, 3, 10),
        };

        EmergencyWaitingRoom room = new EmergencyWaitingRoom();

        int clock = 0;
        int totalWait = 0;
        int served = 0;
        int nextPatientID = 0;

        while (nextPatientID < schedule.length || !room.isEmpty()) {

            while (nextPatientID < schedule.length && schedule[nextPatientID].getArrivalHour() <= clock) {
                room.addPatient(schedule[nextPatientID]);
                nextPatientID++;
            }

            if (room.isEmpty()) {
                if (nextPatientID < schedule.length) {
                    clock = schedule[nextPatientID].getArrivalHour();
                }
                continue;
            }

            Patient patient = room.nextPatient();
            int wait = clock - patient.getArrivalHour();
            int service = patient.getServiceMinutes();
            if (wait < 0 || service < 0) {
                System.out.println("Invalid");
                return;
            }
            totalWait += wait;
            served++;

            clock += service;
        }

        if (served > 0) {
            double averageWait = (double) totalWait / served;
            System.out.println("Average waiting time: " + averageWait);
        } else {
            System.out.println("No patients was served");
        }
    }
}
