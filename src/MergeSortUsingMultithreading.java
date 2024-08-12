import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MergeSortUsingMultithreading {

    public static void main(String[] ar) throws ExecutionException, InterruptedException {

        List<Integer> arrayToSort = Arrays.asList(8, 2, 4, 1, 9, 6, 0, 7) ;

        ExecutorService ex = Executors.newCachedThreadPool();
        List<Integer> sortedList = new Merging(ex, arrayToSort).call();

        System.out.println(sortedList);

        ex.shutdown();
    }

}


class Merging implements Callable<List<Integer>> {

    private ExecutorService ex;
    private List<Integer> list;

    Merging(ExecutorService ex, List<Integer> list) {
        this.ex = ex;
        this.list = list;
    }

    @Override
    public List<Integer> call() throws ExecutionException, InterruptedException {
        if(list.size() <= 1) return list;

        int mid = list.size()/2;

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for(int i=0; i<mid; i++) leftList.add(list.get(i));
        for(int i=mid; i<list.size(); i++) rightList.add(list.get(i));

        Future<List<Integer>> leftSide = ex.submit(new Merging(ex, leftList));
        Future<List<Integer>> rightSide = ex.submit(new Merging(ex, rightList));

        List<Integer> ll = leftSide.get();
        List<Integer> rr = rightSide.get();

        List<Integer> sortedArray = new ArrayList<>();
        int i=0, j=0;

        while(i < ll.size() && j < rr.size()) {
            if(ll.get(i) <= rr.get(j)) {
                sortedArray.add(ll.get(i));
                i++;
            } else {
                sortedArray.add(rr.get(j));
                j++;
            }
        }

        while(i < ll.size()) {
            sortedArray.add(ll.get(i));
            i++;
        }

        while(j < rr.size()) {
            sortedArray.add(rr.get(j));
            j++;
        }

        return sortedArray;

    }

}
