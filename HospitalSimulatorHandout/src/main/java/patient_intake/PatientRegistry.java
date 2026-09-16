package patient_intake;
// Switch from using ArrayList to a flat array implementation for patient storage.

import java.util.Arrays;

public class PatientRegistry {
    // Flat array to store patients and a size field to track the number of stored patients.
    private Patient[] patientRegistry;
    private int size; // track actual number of patients

    // Initial capacity for the flat array. Can be adjusted as needed.
    private static final int INITIAL_CAPACITY = 10;

    public PatientRegistry() {
        // TODO REQUIRED: Create the initial array and set the starting size.
        this.patientRegistry = new Patient[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void addPatient(Patient patient) {
        // TODO REQUIRED: Add a patient to the registry.
        // TODO OPTIONAL (+5%): Expand the array when it becomes full.
        if (patient == null) return;

        if (size == patientRegistry.length) {
            Patient[] newArray = new Patient[patientRegistry.length + 1];
                for (int i = 0; i < patientRegistry.length; i++) {
                    newArray[i] = patientRegistry[i];
                }
                patientRegistry = newArray;
        }
        patientRegistry[size] = patient;
        size++;
    }
    /**
     * Returns the patients currently stored in the registry.
     * The optional encapsulation extension requires returning a defensive copy.
     */
    public Patient[] getPatientRegistry() {
        Patient[] currentPatients = new Patient[size];
        for (int i = 0; i < size; i++) {
            currentPatients[i] = patientRegistry[i];
        }
        return currentPatients;
    } // TODO REQUIRED: Return the patients currently stored.

    public Patient getPatientByID(String patientID) {
        if (patientID == null) return null;
        for (int i = 0; i < size; i++) {
            if (patientID.equals(patientRegistry[i].getPatientID())) {
                return patientRegistry[i];
            }
        }
        return null;
    } // TODO REQUIRED: Search for and return the matching patient.

    /**
     * Removes a patient from the registry by patientID.
     * @param patientID The ID of the patient to remove
     * @return true if patient was found and removed, false otherwise
     */
    public boolean removePatient(String patientID) {
        for (int i = 0; i < size; i++) {
            if (patientRegistry[i].getPatientID().equals(patientID)) {
                removePatient(i);
                return true;
            }
        }
        return false;
    } // TODO OPTIONAL (+5%): Remove the patient with this ID.

    /**
     * Removes a patient from the registry by index.
     * @param index The index of the patient to remove
     * @return the removed Patient, or null if index is invalid
     */
    public Patient removePatient(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Patient removed = patientRegistry[index];
        for (int i = index; i < size - 1; i++) {
            patientRegistry[i] = patientRegistry[i + 1];
        }
        size--;
        patientRegistry[size] = null;
        return removed;
    } // TODO OPTIONAL (+5%): Remove by index and shift later elements left.

    /**
     * Updates a patient in the registry by matching patientID.
     * @param updatedPatient The patient with updated information
     * @return true if patient was found and updated, false otherwise
     */
    public boolean updatePatient(Patient updatedPatient) {
        if (updatedPatient == null || updatedPatient.getPatientID() == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (patientRegistry[i].getPatientID().equals(updatedPatient.getPatientID())) {
                patientRegistry[i] = updatedPatient;
                return true;
            }
        }
        return false;
    } // TODO OPTIONAL (+5%): Replace the patient with the same ID.
    
    @Override
    public String toString() {
        return "PatientRegistry size=" + size + ", patients=" + Arrays.toString(getPatientRegistry()); // TODO REQUIRED: Return a useful representation of the registry.
    }

}


