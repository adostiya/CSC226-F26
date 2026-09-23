package triage_efficiency;

import java.util.*;
import patient_intake.Patient;

public class EfficiencyTester {

    /**
     * REQUIRED (80%): Implement linear search.
     *
     * Search through the patient array one element at a time until the matching
     * patientID is found. Return the Patient if it exists; otherwise return null.
     *
     * This method must run in O(n) time.
     */
    public Patient linearSearch(Patient[] patients, String pid) {
        // TODO REQUIRED: Implement linear search.
        // Search the entire array in order and return the matching Patient.
        if (patients == null || pid == null) return null;

        for (int i=0; i < patients.length; i++) {
            if (patients[i] != null) {
                if (pid.equalsIgnoreCase(patients[i].getPatientID())){
                    return patients[i];
                }
            }
        }
        return null;
    }

    /**
     * REQUIRED (80%): Implement binary search.
     *
     * This method works only on an array that is sorted by patientID.
     * Repeatedly divide the search range in half until the target is found.
     *
     * This method must run in O(log n) time.
     */
    public Patient binarySearch(Patient[] patients, String pid) {
        // TODO REQUIRED: Implement iterative binary search.
        // The array must be sorted by patientID before calling this method.
        if (patients == null || pid == null) return null;
        int low = 0;
        int high = patients.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (patients[mid] == null) {
                high = mid - 1;
            }
            else {
                if (pid.compareToIgnoreCase(patients[mid].getPatientID()) < 0){
                    high = mid - 1;
                }
                else if (pid.compareToIgnoreCase(patients[mid].getPatientID()) > 0){
                    low = mid + 1;
                }
                else {
                    return patients[mid];
                }
            }
        }
        return null; // Remove this line and implement the method.
    }

    /**
     * OPTIONAL (+5%): Implement a different O(log n) search algorithm.
     *
     * Pick one of the following approaches and implement it:
     * - Exponential search
     * - Jump search
     * - Ternary search
     *
     * Add a short comment above the method explaining:
     * - which algorithm you chose
     * - where you learned about it
     * - why it works
     */
    public Patient logNSearch(Patient[] patients, String pid) {
        // TODO OPTIONAL: Research and implement a second O(log n) algorithm.
        // Cite your source and explain the approach in a comment before the logic.

        // Which algorithm you chose - Exponential search
        // Where you learned about it - https://www.geeksforgeeks.org/dsa/exponential-search/
        // Why it works - because it checks first if pid and patients are not null. Checks if first element not the patient we searching for
        // and after that doubles step everytime to find the range where our patient id locates. After that using binarysearch to find it. 
        // And It's O(Log n) algorithm that you asked for.
        if (patients == null || pid == null || patients.length == 0) return null;
        if (patients[0] != null && pid.equals(patients[0].getPatientID())) return patients[0];
        int i=1;
        while (i<patients.length && patients[i] != null && pid.compareToIgnoreCase(patients[i].getPatientID()) > 0){
            i *= 2;
        }
        int low = i/2;
        int high = Math.min(i, patients.length - 1);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (patients[mid] == null) {
                high = mid - 1;
            }
            else {
                if (pid.compareToIgnoreCase(patients[mid].getPatientID()) < 0){
                    high = mid - 1;
                }
                else if (pid.compareToIgnoreCase(patients[mid].getPatientID()) > 0){
                    low = mid + 1;
                }
                else {
                    return patients[mid];
                }
            }
        }
        return null; // Remove this line and implement the method.
    }

    public void timeDemo(int size) {
            Patient[] patients = Main.generatePatients(size);
            String testID = String.format("P%05d", size/2);

            long start = System.nanoTime();
            linearSearch(patients, testID);
            long linearTime = System.nanoTime() - start;

            patients = Main.sortByPatientId(patients);

            start = System.nanoTime();
            binarySearch(patients, testID);
            long binaryTime = System.nanoTime() - start;

            start = System.nanoTime();
            logNSearch(patients, testID);
            long logNTime = System.nanoTime() - start;

            System.out.println(size + "Linear Search: " + linearTime + " ns");
            System.out.println(size + "Binary Search: " + binaryTime + " ns");
            System.out.println(size + "Exponential Search: " + logNTime + " ns");
        }
}
