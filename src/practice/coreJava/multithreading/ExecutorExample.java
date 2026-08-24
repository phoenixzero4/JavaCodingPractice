package practice.coreJava.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

  static void main( String[] args ) {

    ExecutorService executorService = Executors.newFixedThreadPool( 2 );

    Runnable task = () -> {
      System.out.println( "Executing task in " + Thread.currentThread().getName() );
    };

    executorService.submit( task );
    executorService.submit( task );

    executorService.shutdown();
  }
}
