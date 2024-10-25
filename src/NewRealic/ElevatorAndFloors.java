/*
there is a newly constructed building with N floors. there are M elevators available in teh building. each of which ocnencts two specific floors. Unforatunaltely each elevator us not accessible on all the floors meaning the elevators do not make any stops betwn two specified levels
you are given two arrays representing the starting and ending floors of each elevator. using the elevators you want tp reach teh highest floor you can in teh building. task is to find and return teh highest floor you can reach using the elevators

input1 - value of N
input2 - value of M
input3 - array representing strting point of each elevator
input4 - array representing ending point of each elevator


test cases:
input1 = 10
input2 = 3
input3 = {1,7,3}
input4 = {3,6,9}

output = 6

explanation:    total number of floors is 10 and given below is thr ay to reach the highest floor possible:
initially from teh forst floor take the first elevator and reach teh third floor
then from the third floor take the third elevator and reach the sixth floor

this is the highest floor you can reah by suing the elevators. so 6 is retured

teast case 2:

input1 = 100
input2 = 2
iinput3 = {45,5}
input4 = {55,10}

output = 1

exaplantion
initially you are in the first floor and there are no elevators taht start or end on the first floor. thus you are unable to ascend from the forst floor. therefore 1 is returned as the ouput
 */


package NewRealic;

import java.util.*;

public class ElevatorAndFloors {

    public int highest(int input1, int input2, int[] input3, int[] input4) {
        int N = input1; // Total number of floors
        int m = input2; // Number of elevators

        // Edge case: No elevators
        if (m == 0) {
            return 1;
        }

        // Map floors to a set of reachable floors from that floor
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int start = input3[i];
            int end = input4[i];
            map.computeIfAbsent(start, k -> new HashSet<>()).add(end);
            map.computeIfAbsent(end, k -> new HashSet<>()).add(start);
        }

        // Use DFS to explore reachable floors, tracking visited floors to avoid cycles
        Set<Integer> visited = new HashSet<>();
        int highestFloor = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(1); // Start from floor 1

        while (!stack.isEmpty()) {
            int currentFloor = stack.pop();
            visited.add(currentFloor);
            highestFloor = Math.max(highestFloor, currentFloor);

            for (int reachableFloor : map.getOrDefault(currentFloor, Collections.emptySet())) {
                if (!visited.contains(reachableFloor)) {
                    stack.push(reachableFloor);
                }
            }
        }

        return highestFloor;
    }

    public static void main(String[] args) {
        ElevatorAndFloors er = new ElevatorAndFloors();

        // Basic Test Cases
        System.out.println(er.highest(10, 3, new int[]{1, 7, 3}, new int[]{3, 6, 9})); // Expected output: 6
        System.out.println(er.highest(100, 2, new int[]{45, 5}, new int[]{55, 10})); // Expected output: 1
    }
}
