Queue enqueue / dequeue | O(1) | Because it uses references to add and remove from queue, not going through whole queue

EmergencyWaitingRoom.nextPatient() | O(1) | Because we always have same amount of levels, so it will do same action over and over again, not depending on amount of patients

Stack push / pop / peek | O(1) | Because it uses only top to do all methods, doesn't care about all stack

Recursive queue toString() | O(N) | Because it needs to check every node, so if it's 1000 nodes it will do 1000 checks and so on