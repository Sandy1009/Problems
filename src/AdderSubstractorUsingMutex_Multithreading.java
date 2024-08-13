import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdderSubstractorUsingMutex_Multithreading {

    public static void main(String[] ar) throws ExecutionException, InterruptedException {
        int val = 0;
        Lock lock = new ReentrantLock(true);

        ExecutorService ex = Executors.newCachedThreadPool();

        Future<Integer> add = ex.submit(new Adder(val, lock));
        Future<Integer> sub = ex.submit(new Substractor(val, lock));

        add.get();
        sub.get();

        ex.shutdown();
        System.out.println("val = "+val);
    }

}

class Adder implements Callable<Integer> {
    int val;
    Lock lock;

    Adder(int val, Lock lock) {
        this.val = val;
        this.lock = lock;
    }

    @Override
    public Integer call() {
        for(int i=1; i<=10; i++) {
            System.out.println("requesting lock for adding "+i);
            lock.lock();
            val += i;
            lock.unlock();
            System.out.println("added = "+i);
        }
        return val;
    }
}

class Substractor implements Callable<Integer> {
    int val;
    Lock lock;

    Substractor(int val, Lock lock) {
        this.val = val;
        this.lock = lock;
    }

    @Override
    public Integer call() {
        for(int i=1; i<=10; i++) {
            System.out.println("requesting lock for substracting "+i);
            lock.lock();
            val -= i;
            lock.unlock();
            System.out.println("substracted = "+i);
        }
        return val;
    }
}


/*   OUTPUT:

requesting lock for adding 1
added = 1
requesting lock for adding 2
added = 2
requesting lock for adding 3
added = 3
requesting lock for adding 4
requesting lock for substracting 1
added = 4
requesting lock for adding 5
substracted = 1
requesting lock for substracting 2
added = 5
substracted = 2
requesting lock for substracting 3
requesting lock for adding 6
substracted = 3
added = 6
requesting lock for substracting 4
requesting lock for adding 7
substracted = 4
added = 7
requesting lock for substracting 5
requesting lock for adding 8
substracted = 5
added = 8
requesting lock for substracting 6
requesting lock for adding 9
substracted = 6
requesting lock for substracting 7
added = 9
substracted = 7
requesting lock for adding 10
requesting lock for substracting 8
added = 10
substracted = 8
requesting lock for substracting 9
substracted = 9
requesting lock for substracting 10
substracted = 10
val = 0
 */
