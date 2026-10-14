package medical_action_tracking;

import patient_intake.Patient;

public class EmergencyWaitingRoom {
    private LinkedQueue<Patient> level1;
    private LinkedQueue<Patient> level2;
    private LinkedQueue<Patient> level3;
    private LinkedQueue<Patient> level4;

    private final int capacity;

    public EmergencyWaitingRoom(int capacity) {
        // TODO: Create one empty FIFO queue for each triage level.
        level1 = new LinkedQueue<Patient>();
        level2 = new LinkedQueue<Patient>();
        level3 = new LinkedQueue<Patient>();
        level4 = new LinkedQueue<Patient>();
        this.capacity = capacity;
    }

    public EmergencyWaitingRoom() {
        this(Integer.MAX_VALUE);
    }

    /**
     * Add a patient to the FIFO lane matching their triage level.
     *
     * @return true if added; false for null patients or levels outside 1-4
     */
    public boolean addPatient(Patient patient) {
        // TODO: Validate the patient and place them in the matching lane.
        if (patient == null || patient.getTriageLevel() < 1 || patient.getTriageLevel() > 4) return false;
        
        // Give each triage lane a documented capacity. addPatient returns
        // false when the selected lane is full and leaves all lanes unchanged.
        int level = patient.getTriageLevel();

        LinkedQueue<Patient> targetLane;
        if (level == 1) targetLane = level1;
        else if (level == 2) targetLane = level2;
        else if (level == 3) targetLane = level3;
        else targetLane = level4;

        if (targetLane.size() >= capacity) {
            return false;
        }
        targetLane.enqueue(patient);
        return true;
    }

    /**
     * Remove the next patient, checking triage level 1 before level 2, and so on.
     */
    public Patient nextPatient() {
        // TODO: Dequeue from the first non-empty lane, or return null if all are empty.
        if (!level1.isEmpty()) return level1.dequeue();
        else if (!level2.isEmpty()) return level2.dequeue();
        else if (!level3.isEmpty()) return level3.dequeue();
        else if (!level4.isEmpty()) return level4.dequeue();
        else return null;
    }

    public boolean isEmpty() {
        // TODO: Return true only when all four lanes are empty.
        if (level1.isEmpty() && level2.isEmpty() && level3.isEmpty() && level4.isEmpty()) return true;
        else return false;
    }

    public int size() {
        // TODO: Return the total number of patients across all four lanes.
        return level1.size() + level2.size() + level3.size() + level4.size();
    }
}
