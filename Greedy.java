package assignment2;
import java.util.LinkedList;

public class Greedy {

    public static LinkedList<Activity> activitySelection(LinkedList<Activity> activities) {
        LinkedList<Activity> noOverlap = new LinkedList<>();
        int counter = 0;

        // add the first element
        noOverlap.add(activities.get(0));
        
        // check each element, reaching no overlap adds the element and increases the comparison index
        for (int idx = 0; idx < activities.size(); idx++) {
            Activity CurrActivity = activities.get(idx);
            if(!CurrActivity.overlap(noOverlap.get(counter))){
                noOverlap.add(CurrActivity);
                counter+=1;
            }
        }
        return noOverlap;
    }

    public static LinkedList<Integer> makeChange(int amount, int[] denominations) {
        // TASK 1.B.b
        LinkedList<Integer> changeDue = new LinkedList<>();
        int num;
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


/*  
V1 makeChange code
        num = denominations[idx];
        change = amount / num;
        amount = amount % num;
        if(change!=0){
            for (int i = 0; i < change; i++) {
                changeDue.add(num);
            }
}
    */