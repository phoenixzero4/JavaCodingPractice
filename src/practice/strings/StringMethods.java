package practice.strings;

import java.io.File;

public class StringMethods {

  public static void getFileMeta( File file ) {

    if ( file.exists() ) {

      // Get file name
      String filename = file.getName();

      // Get absolute path
      String path = file.getAbsolutePath();

      // Executable
      String executable = file.canExecute() ? "executable" : "not executable";

      // Writeable?
      String writeable = file.canWrite() ? "writable" : "not writable";

      // Readable?
      String readable = file.canRead() ? "readable" : "not readable";

      // Size
      String size = "bytes";
      if ( ( ( int ) file.length() ) >= 1024 ) {
        size = "megabytes";
      }

      byte A = 'A';
      byte Z = 'Z';
      byte a = 'a';
      byte z = 'z';

      System.out.println( "A: " + A + " Z: " + Z + " a: " + a + " z: " + z );
      System.out.println( ( Z - A ) + " " + ( z - a ) );
      System.out.println( A + 32 );

      int filesize = file.length() >= 1024 ? ( int ) file.length() / 1024 : ( int ) file.length();

      System.out.printf( "%s is %s, %s, %s and has a size of %d %s", filename, executable, readable, writeable, filesize, size );
    }
  }
}
