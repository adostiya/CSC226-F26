package medical_action_tracking;

import org.junit.jupiter.api.Test;
import patient_intake.Patient;

import static org.junit.jupiter.api.Assertions.*;

class StudentCareTests {
    @Test
    void emptyStructures() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        assertTrue(queue.isEmpty());

        LinkedStack<String> stack = new LinkedStack<>();
        assertTrue(stack.isEmpty());

        EmergencyWaitingRoom room = new EmergencyWaitingRoom();
        assertTrue(room.isEmpty());

        TreatmentHistory history = new TreatmentHistory();
        assertEquals("[]", history.displayHistory());
    }

    @Test
    void transitionsToAndFromOneElement() {
        LinkedQueue<String> queue = new LinkedQueue<>();

        queue.enqueue("first");
        assertEquals("first", queue.peekFront());

        queue.dequeue();
        assertNull(queue.peekFront());
    }

    @Test
    void RecursiveTraversalWithoutMutation() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        int size = queue.size();

        assertEquals("[first, second, third]", queue.toString());
        assertEquals(size, queue.size());
    }

    @Test
    void FIFOOrderWithinASingleTriageLane() {
        EmergencyWaitingRoom waitingRoom = new EmergencyWaitingRoom();
        Patient first = patient("P00001", 1);
        Patient second = patient("P00002", 1);

        waitingRoom.addPatient(first);
        waitingRoom.addPatient(second);

        assertSame(first, waitingRoom.nextPatient());
        assertSame(second, waitingRoom.nextPatient());
    }

    @Test
    void LIFOOrderInTheLinkedStack() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("first");
        stack.push("second");

        assertEquals("second", stack.pop());
        assertEquals("first", stack.pop());
    }

    @Test
    void FullLogDisplayWithoutMutation () {
        TreatmentHistory history = new TreatmentHistory();
        history.addTreatment("P00001", "Medication", "2026-10-12 12:00");
        history.addTreatment("P00002", "Medication", "2026-10-12 13:00");
        history.addTreatment("P00003", "Medication", "2026-10-12 14:00");

        String displayed = history.displayHistory();

        assertEquals("[2026-10-12 14:00 | P00003 | Medication, "
        + "2026-10-12 13:00 | P00002 | Medication, "
        + "2026-10-12 12:00 | P00001 | Medication]", displayed);
    }

    @Test
    void recursiveCount() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        
        assertEquals(queue.size(), queue.recursiveSize());

        queue.enqueue("first");
        queue.enqueue("second");
        assertEquals(queue.size(), queue.recursiveSize());
    }

    private Patient patient(String patientID, int triageLevel) {
        return new Patient(patientID, "Test", "Patient", 30, "Checkup", triageLevel,
                "Waiting", "ER-001", 9, "INS-001");
    }
}
