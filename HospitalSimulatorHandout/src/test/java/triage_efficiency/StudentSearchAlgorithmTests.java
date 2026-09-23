package triage_efficiency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import patient_intake.Patient;

class StudentSearchAlgorithmTests {

    private final EfficiencyTester tester = new EfficiencyTester();

    private Patient[] buildSortedPatients() {
        Patient[] patients = new Patient[6];
        patients[0] = new Patient("P00001", "Alice", "Smith", 25, "Headache", 2, "Triage", "ER-001", 9, "INS-00001");
        patients[1] = new Patient("P00002", "Bob", "Jones", 35, "Back Pain", 3, "Treatment", "ER-002", 10, "INS-00002");
        patients[2] = new Patient("P00003", "Cara", "Nguyen", 42, "Chest Pain", 1, "Waiting", "ER-003", 11, "INS-00003");
        patients[3] = new Patient("P00004", "Dylan", "Brown", 51, "Shortness of Breath", 2, "Triage", "ER-004", 12, "INS-00004");
        patients[4] = new Patient("P00005", "Emma", "Davis", 27, "Nausea", 4, "Recovery", "ER-005", 13, "INS-00005");
        patients[5] = new Patient("P00006", "Frank", "Miller", 60, "Fractured Arm", 3, "Treatment", "ER-006", 14, "INS-00006");
        return patients;
    }

    // Check algorithm works when searching element in the first position. Important because checks if algorithm works properly with boundary case.
    @Test
    void testLinearSearchElementFoundInTheFirstPosition() {
        Patient[] patients = buildSortedPatients();
        Patient result = tester.linearSearch(patients, "P00001");
        assertNotNull(result, "Linear search should find a patient that exists in the array.");
        assertEquals("P00001", result.getPatientID(), "Linear search should return the matching patient record.");
    }

    @Test
    void testBinarySearchElementFoundInTheFirstPosition() {
        Patient[] patients = buildSortedPatients();
        Patient result = tester.binarySearch(patients, "P00001");
        assertNotNull(result, "Binary search should find a patient that exists in the array.");
        assertEquals("P00001", result.getPatientID(), "Binary search should return the matching patient record.");
    }

    // Check algorithm works when searching element in the middle of the array. Important because checks if algorithm works properly.
    @Test
    void testLinearSearchElementFoundInTheMiddleOfTheArray() {
        Patient[] patients = buildSortedPatients();
        Patient result = tester.linearSearch(patients, "P00003");
        assertNotNull(result, "Linear search should find a patient that exists in the array.");
        assertEquals("P00003", result.getPatientID(), "Linear search should return the matching patient record.");
    }

    @Test
    void testBinarySearchElementFoundInTheMiddleOfTheArray() {
        Patient[] patients = buildSortedPatients();
        Patient result = tester.binarySearch(patients, "P00003");
        assertNotNull(result, "Binary search should find a patient that exists in the array.");
        assertEquals("P00003", result.getPatientID(), "Binary search should return the matching patient record.");
    }

    // Check algorithm works when searching element in the end of the array. Important because checks if algorithm works properly with boundary case.
    @Test
    void testLinearSearchElementFoundNearTheEnd() {
        Patient[] patients = buildSortedPatients();
        Patient result = tester.linearSearch(patients, "P00006");
        assertNotNull(result, "Linear search should find a patient that exists in the array.");
        assertEquals("P00006", result.getPatientID(), "Linear search should return the matching patient record.");
    }

    @Test
    void testBinarySearchElementFoundNearTheEnd() {
        Patient[] patients = buildSortedPatients();
        Patient result = tester.binarySearch(patients, "P00006");
        assertNotNull(result, "Binary search should find a patient that exists in the array.");
        assertEquals("P00006", result.getPatientID(), "Binary search should return the matching patient record.");
    }

    // Check algorithm works when searching element that doesn't match. Important because checks if algorithm works when searches for IDs that do not exist. 
    @Test
    void testLinearSearchNoMatchReturnsNull() {
        Patient[] patients = buildSortedPatients();
        Patient result = tester.linearSearch(patients, "P00007");
        assertNull(result, "Linear search should return null when the identifier is not present.");
    }
    
    @Test
    void testBinarySearchNoMatchReturnsNull() {
        Patient[] patients = buildSortedPatients();
        Patient result = tester.binarySearch(patients, "P00007");
        assertNull(result, "Binary search should return null when the identifier is not present.");
    }

    // Check algorithm works properly with SortedArray using BinarySearch. Important to make sure that array sorted before trying binary search.
    @Test
    void testBinarySearchSortedArrayBehavior() {
        Patient[] patients = buildSortedPatients();
        Patient result = tester.binarySearch(patients, "P00005");
        assertNotNull(result, "Binary search should find a patient in a sorted array.");
        assertEquals("P00005", result.getPatientID(), "Binary search should return the correct patient record.");
    }

    // Check algorithm works when searching element that doesn't match. Important because checks if algorithm works when searches for IDs that do not exist. 
    @Test
    void testLogNSearchNotFoundBehavior() {
        Patient[] patients = buildSortedPatients();
        Patient result = tester.logNSearch(patients, "P00007");
        assertNull(result, "Alternative logarithmic search should return null when no match exists.");
    }
}
