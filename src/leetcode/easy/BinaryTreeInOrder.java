package leetcode.easy;

import java.util.ArrayList;

public class BinaryTreeInOrder {
  // TODO complete this challenge
  static ArrayList<Integer> list;

  static void main() {

    TreeNode three = new TreeNode( 3, null, null );
    TreeNode two = new TreeNode( 2, three, null );
    TreeNode one = new TreeNode( 1, null, two );

    list = inorderTraversal( one );

    for ( Integer i : list ) {
      System.out.print( i + " " );
    }

  }

  public static ArrayList<Integer> inorderTraversal( TreeNode root ) {

    while ( root.left != null ) {
      root = root.left;

    }
    list.add( root.val );

    while ( root.right != null ) {
      root = root.right;
    }

    return list;
  }
}
