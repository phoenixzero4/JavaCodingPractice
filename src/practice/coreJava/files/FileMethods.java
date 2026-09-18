package practice.coreJava.files;

import java.io.File;

public class FileMethods {

  static void main() {

    String filename = "fileCopy.txt";

    File file = new File( filename );

    if ( file.exists() ) {
      file.delete();
    }

    int i = 1;
    String stringI = String.valueOf( i );
    String file2 = "fileCopy" + stringI + ".txt";
    System.out.println( file2 );
    file = new File( file2 );
    if ( file.exists() ) {
      file.delete();
    }
  }

}
