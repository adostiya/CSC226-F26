package triage_efficiency;

import java.util.Arrays;
import java.util.Comparator;

import patient_intake.Patient;

public class Main {
    public static void main(String[] args) {
        // TODO REQUIRED: Generate the patient data.
        Patient[] patientsData = generatePatients(10);
        // TODO REQUIRED: Run each search method and print a found and not-found example.
        EfficiencyTester tester = new EfficiencyTester();
        String testIDFound = "P00001";
        Patient LinearSearchTest = tester.linearSearch(patientsData, testIDFound);
        if (LinearSearchTest != null) {
            System.out.println("Patient was found by ID: " + LinearSearchTest.toString());
        }
        else {
            System.out.println("Patient was not found by ID");
        }
        String testIDNotFound = "P99999";
        Patient LinearSearchTest2 = tester.linearSearch(patientsData, testIDNotFound);
        if (LinearSearchTest2 != null) {
            System.out.println("Patient was found by ID: " + LinearSearchTest2.toString());
        }
        else {
            System.out.println("Patient was not found by ID");
        }
        // TODO REQUIRED: Sort the data by patientID when needed.
        patientsData = sortByPatientId(patientsData);
        Patient BinarySearchTest = tester.binarySearch(patientsData, testIDFound);
        if (BinarySearchTest != null) {
            System.out.println("Patient was found by ID: " + BinarySearchTest.toString());
        }
        else {
            System.out.println("Patient was not found by ID");
        }
        Patient BinarySearchTest2 = tester.binarySearch(patientsData, testIDNotFound);
        if (BinarySearchTest2 != null) {
            System.out.println("Patient was found by ID: " + BinarySearchTest2.toString());
        }
        else {
            System.out.println("Patient was not found by ID");
        }

        Patient LogNSearchTest = tester.logNSearch(patientsData, testIDFound);
        if (LogNSearchTest != null) {
            System.out.println("Patient was found by ID: " + LogNSearchTest.toString());
        }
        else {
            System.out.println("Patient was not found by ID");
        }
        Patient LogNSearchTest2 = tester.logNSearch(patientsData, testIDNotFound);
        if (LogNSearchTest2 != null) {
            System.out.println("Patient was found by ID: " + LogNSearchTest2.toString());
        }
        else {
            System.out.println("Patient was not found by ID");
        }
        // TODO OPTIONAL: Call timeDemo() to compare algorithm runtimes.
        tester.timeDemo(100);
        tester.timeDemo(1000);
        tester.timeDemo(10000);
        tester.timeDemo(100000);
    }
    
    /**
     * REQUIRED (80%): Generate sample patient data for testing.
     *
     * Build an array of Patient objects with realistic IDs, names, complaints,
     * and triage information so you can test each search method.
     */

    public static Patient[] generatePatients(int count) {
        // TODO REQUIRED: Create the patient array and fill it with sample data.
        Patient [] samplePatients = new Patient[count];
        for (int i=0; i<count; i++) {
            String patientID = String.format("P%05d", i+1);
            // String firstName = "TestPatientFirstName" + String.valueOf(i);
            // String lastName = "TestPatientLastName" + String.valueOf(i);
            // int age = 25;
            // String chiefComplaint = "TestComplaint" + String.valueOf(i);
            // int triageLevel = 3;
            // String currentStage = "TestCurrentStage" + String.valueOf(i);
            Patient TestPatient = new Patient(patientID, "Kai", "Havertz", 27, "Leg pain", 4, "Admission", "JR-109", 12, "INS-18854");
            samplePatients[i] = TestPatient;
        }
        return samplePatients; // Replace this with your implementation.
    }

    /**
     * REQUIRED (80%): Sort patients by patientID before binary search.
     *
     * The binary-search version only works on an array sorted by patientID.
     */
    public static Patient[] sortByPatientId(Patient[] patients) {
        // TODO REQUIRED: Sort the array by patientID before testing binary search.
        Arrays.sort(patients, Comparator.nullsLast(Comparator.comparing(Patient::getPatientID))); // reference https://www.baeldung.com/java-sorting-arrays#:~:text=We%20can%20do%20this%20very%C2%A0easily%20in%20Java%208%20by%20specifying%20the%20property%20that%20we%20would%20like%20to%20compare%20our%C2%A0Employee%C2%A0objects%20on%20within%20our%C2%A0Comparator%3A
        return patients; // Replace this with your implementation.
    }
}
