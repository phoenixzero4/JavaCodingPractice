package leetcode.easy;

import java.io.*;
import java.util.Scanner;

/*
195: Tenth Line

Given a file "file.txt", print just the 10th line of the file

If the file contains less than 10 lines, what should you output?
There are at least 3 different solutions, Try to solve them all.
 */
public class TenthLine {

  static void main() {

    String filename = "file.txt";
    File file = new File( filename );
    int i = 0;
    String line = "";

    try ( Scanner scan = new Scanner( file ) ) {

      while ( scan.hasNextLine() ) {
        i++;
        line = scan.nextLine();

        if ( line.isEmpty() ) {
          System.out.println( "The file " + file.getName() + " has no contents" );
        }

        if ( i == 10 ) {
          System.out.println( "Line " + i + " = " + line );
        }

      }
    }
    catch ( FileNotFoundException ex ) {
      ex.printStackTrace();
    }

    String filenameCopy = "fileCopy3.txt";
    File fileCopy = new File( filenameCopy );

    readWithInputStream( file );
    copyWithOutputStream( file, fileCopy );
  }

  public static void readWithInputStream( File file ) {

    // InputStream and OutputStream read/write bytes respectively using these methods make it
    // possible to read/write from any type of file (text, image, audio, pdf, etc.).

    // try/with closes streams automatically
    try ( FileInputStream input = new FileInputStream( file ) ) {
      int i;
      while ( ( i = input.read() ) != -1 ) {
        System.out.print( ( char ) i );
      }
      System.out.println( "\n" );
    }

    catch ( IOException e ) {
      System.out.println( e.getMessage() );
    }
  }

  public static void copyWithOutputStream( File file, File fileCopy ) {
    // InputStream and OutputStream read/write bytes respectively using these methods make it
    // possible to read/write from any type of file (text, image, audio, pdf, etc.).

    // try/with closes streams automatically
    try ( FileInputStream input = new FileInputStream( file ) ) {
      int i;
      FileOutputStream output = new FileOutputStream( fileCopy );
      while ( ( i = input.read() ) != -1 ) {
        System.out.print( ( char ) i );
        output.write( i );
      }
      System.out.println();
    }
    catch ( IOException e ) {
      System.out.println( e.getMessage() );
    }
  }

}
