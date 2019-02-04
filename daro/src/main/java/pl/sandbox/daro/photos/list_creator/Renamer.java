package pl.sandbox.daro.photos.list_creator;

import java.io.File;


public class Renamer {

  private static File oldFile;
  private static File newFile;


  static void setOldFile(File path) {
    oldFile = path;
  }

  static void setNewFile(File path) {
    newFile = path;
  }

  public static File getOldFile() {
    return oldFile;
  }

  void fileExists(){
    String fileName = "";
    String directoryName = "";
    if(!(oldFile.exists())){
      System.out.println(String.format("File: '%s' in directory '%s' does not exist!", fileName, directoryName));
    }
  }

  //TODO:
  // scan if there is a file to rename,
  // then rename it to LocalDateTime + productList.txt
  // if there is no file or filename is the same, throw an exception
}
