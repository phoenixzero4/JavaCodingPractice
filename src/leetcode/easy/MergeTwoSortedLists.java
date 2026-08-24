package leetcode.easy;

public class MergeTwoSortedLists {

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the
nodes of the first two lists.

Return the head of the merged linked list.
*/

  public ListNode mergeTwoListRecursive( ListNode one, ListNode two ) {

    if ( one == null ) {
      return two;
    }
    if ( two == null ) {
      return one;
    }

    if ( one.val < two.val ) {
      one.next = mergeTwoListRecursive( one.next, two );
      return one;
    }
    else {
      two.next = mergeTwoListRecursive( one, two.next );
      return two;
    }
  }

  public ListNode mergeTwoLists( ListNode one, ListNode two ) {

    ListNode dummy = new ListNode();
    ListNode tail = dummy;

    while ( one != null && two != null ) {
      if ( one.val < two.val ) {
        tail.next = one;
        one = one.next;
      }
      else {
        tail.next = two;
        two = two.next;
      }
      tail = tail.next;
    }
    tail.next = ( one != null ) ? one : two;

    return dummy.next;
  }

  void main( String[] args ) {

    ListNode list1 = new ListNode( 1, new ListNode( 2, new ListNode( 4 ) ) );
    ListNode list2 = new ListNode( 1, new ListNode( 3, new ListNode( 4 ) ) );
    ListNode result = mergeTwoLists( list1, list2 );

    ListNode one = new ListNode( 1, new ListNode( 4, new ListNode( 8 ) ) );
    ListNode two = new ListNode( 2, new ListNode( 4, new ListNode( 7 ) ) );

    ListNode recursiveResult = mergeTwoListRecursive( one, two );

    while ( recursiveResult != null ) {
      System.out.print( recursiveResult.val + " " );
      recursiveResult = recursiveResult.next;
    }

    System.out.println();

    while ( result != null ) {
      System.err.print( result.val + " " );
      result = result.next;
    }
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {}

    ListNode( int val ) {

      this.val = val;
    }

    ListNode( int val, ListNode next ) {

      this.val = val;
      this.next = next;
    }
  }

}
