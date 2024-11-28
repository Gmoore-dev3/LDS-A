package assignment2;
import java.util.LinkedList;

public class Greedy {

    public static LinkedList<Activity> activitySelection(LinkedList<Activity> activities) {
        // ----------- TASK 1.B.a --------------- //
        LinkedList<Activity> noOverlap = new LinkedList<>();

        // add the first element as the input list is sorted (given on spec)
        noOverlap.add(activities.get(0));
        
        /* check each element for an overlap against the most recent addition to noOverlap
         * if an overlap doesn't exist, add the element to noOverlap
        */
        for (int idx = 0; idx < activities.size(); idx++) {
            Activity CurrActivity = activities.get(idx);
            if(!CurrActivity.overlap(noOverlap.get(noOverlap.size() - 1))){
                noOverlap.add(CurrActivity);
            }
        }
        return noOverlap;
    }

    public static LinkedList<Integer> makeChange(int amount, int[] denominations) {
        // ----------- TASK 1.B.b --------------- //
        LinkedList<Integer> changeDue = new LinkedList<>();
        int num;

        /* while the amount is more than a denomination, 
         * remove the denomination from the amount and add the it to the list of change
         * continue this until the amount has been entirely parsed
         */

        for (int idx = 0; idx < denominations.length; idx++) {
            num = denominations[idx];
            while(num <= amount){
                amount-=num;
                changeDue.add(num);
            }     
        }
        return changeDue;
    }

    public static void main(String[] args) {
        LinkedList<Activity> activities = new LinkedList<Activity>();
        activities.add(new Activity(1,1, 4));
        activities.add(new Activity(2, 3, 5));
        activities.add(new Activity(3, 0, 6));
        activities.add(new Activity(4, 5, 7));
        activities.add(new Activity(5, 3, 8));
        activities.add(new Activity(6, 5, 9));
        activities.add(new Activity(7, 6, 10));
        activities.add(new Activity(8, 8, 11));
        activities.add(new Activity(9, 8, 12));
        activities.add(new Activity(10, 2, 13));
        activities.add(new Activity(11, 12, 14));
        activitySelection(activities).forEach(a -> a.print());

        System.out.println();
        makeChange(1234, new int[] { 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 }).forEach(i -> System.out.println(i));
    }
}