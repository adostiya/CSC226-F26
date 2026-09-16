package patient_intake;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class StudentAdditionalTests {

    private PatientRegistry registry;
    private Patient testPatient;

    @BeforeEach
    void setUp() {
        registry = new PatientRegistry();
        testPatient = new Patient(
            "P001", "John", "Doe", 45, "Chest pain", 3, "Waiting", "Room101", 14, "INS12345"
        );
    }

    // Check if adding a null patient does not crash the system
    @Test
    void testAddNullPatient() {
        registry.addPatient(null);
        assertEquals(0, registry.getPatientRegistry().length, "Registry size should be 0");
    }

    // Check updating a patient's room
    @Test
    void testSetAssignedRoom() {
        testPatient.setAssignedRoom("Room202");
        assertEquals("Room202", testPatient.getAssignedRoom(), "Room should be Room202");
    }

    // Check updating a patient's stage
    @Test
    void testSetCurrentStage() {
        testPatient.setCurrentStage("Discharged");
        assertEquals("Discharged", testPatient.getCurrentStage(), "Stage should be Discharged");
    }

    // Check if searching with null does not crash the system
    @Test
    void testGetPatientByNullID() {
        registry.addPatient(testPatient);
        Patient found = registry.getPatientByID(null);
        assertNull(found, "Should return null");
    }

    // Check removing a patient by index
    @Test
    void testRemovePatientByIndex() {
        registry.addPatient(testPatient);
        Patient removed = registry.removePatient(0);
        
        assertNotNull(removed, "Should not be null");
        assertEquals("P001", removed.getPatientID(), "Should be P001");
        assertEquals(0, registry.getPatientRegistry().length, "Should be 0");
    }

    // Check age boundary for setting age
    @Test
    void testInvalidAge() {
        testPatient.setAge(150);
        assertEquals(45, testPatient.getAge());
    }
}