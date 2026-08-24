package dexian.dtcc;

import java.util.*;
import java.util.stream.Collectors;

public class Methods {

  // Find the most repeated number in a list of integers using Java collections

  static void main( String[] args ) {

    Integer[] array = { 1, 1, 2, 3, 4, 4, 5, 4 };

    int[] array2 = { 1, 1, 2, 3, 4, 0 };
    List<Integer> list1 = Arrays.stream( array2 )
                                .boxed()
                                .collect( Collectors.toCollection( ArrayList::new ) );

    List<Integer> list = new ArrayList<>( Arrays.asList( array ) );

    List<Integer> list2 = new ArrayList<>( List.of( array ) );
    System.out.println( mostRepeatedNumber( list ) );
    System.out.println( mostRepeatedNumber( list1 ) );

  }

  public static Integer mostRepeatedNumber( List<Integer> list ) {

    if ( list.isEmpty() ) {
      return null;
    }

    Map<Integer, Integer> map = new HashMap<>();

    for ( int num : list ) {
      map.merge( num, 1, Integer::sum );
    }

    Map.Entry<Integer, Integer> maxEntry = Collections.max( map.entrySet(), Map.Entry.comparingByValue() );

    return maxEntry.getKey();
  }
}
