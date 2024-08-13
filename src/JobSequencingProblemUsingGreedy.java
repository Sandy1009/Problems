/*
Given a set of n jobs where each jobi has a deadline and profit associated with it.
Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with a job if and only if the job is completed by its deadline.
Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time on or before which job needs to be completed to earn the profit.

Examples :
Input: Jobs = [[1,4,20],[2,1,1],[3,1,40],[4,1,30]]
Output: 2 60
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
 */

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingProblemUsingGreedy {

    public static void main(String[] ar) {
       // Job[] arr = {new Job(1,4,20),new Job(2,1,1),new Job(3,1,40),new Job(4,1,30)};

        Job[] arr = {new Job(1,2,100),new Job(2,1,19),new Job(3,2,27),new Job(4,1,25), new Job(5, 1, 15)};

        int[] res = JobScheduling(arr, arr.length);

        System.out.println("Jobs done "+res[0]);
        System.out.println("Max profit "+res[1]);
    }

    private static int[] JobScheduling(Job arr[], int n) {
        int[] res = new int[2];
        int jobsDone = 0;
        int maxProfit = 0;

        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job t1, Job t2) {
                return t2.profit - t1.profit;
            }
        });

        int maxDeadline = 0;
        for(Job j : arr) {
            if(j.deadline > maxDeadline) {
                maxDeadline = j.deadline;
            }
        }

        boolean[] visited = new boolean[maxDeadline+1];

        for(Job j : arr) {
            for(int i=Math.min(maxDeadline, j.deadline); i>0; i--) {
                if(!visited[i]) {
                    jobsDone++;
                    maxProfit += j.profit;
                    visited[i] = true;
                    break;
                }
            }
        }

        res[0] = jobsDone;
        res[1] = maxProfit;

        return res;

    }

}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
