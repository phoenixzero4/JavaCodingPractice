package practice.coreJava.multithreading;

import java.util.concurrent.*;

public class CallableExample {

  static void main() throws InterruptedException, ExecutionException {

    ExecutorService executor = Executors.newFixedThreadPool( 3 );

    Callable<Integer> callableTask = () -> {
      return Integer.MAX_VALUE;
    };

    Future<Integer> future = executor.submit( callableTask );

    System.out.println( "Result of callable task: " + future.get() );

    executor.shutdown();
  }
}
