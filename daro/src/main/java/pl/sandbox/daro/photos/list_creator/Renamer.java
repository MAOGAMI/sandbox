package pl.sandbox.daro.photos.list_creator;

import java.io.File;


public class Renamer {

  private File oldFile;
  private File newFile;


  private void setOldFile(String directory, String fileName) {
    this.oldFile = new File (directory,fileName);
//    oldFile.
  }

  private void setNewFile(String directory, String fileName) {
    this.newFile = new File (directory,fileName);
  }

  void fileExists(String directory, String fileName){
    setOldFile(directory, fileName);
    if(!(oldFile.exists())){
      System.out.println(String.format("File: '%s' in directory '%s' does not exist!", fileName, directory));
    }
  }











  public static void main(String[] args) {
    Renamer renamer = new Renamer();

    renamer.fileExists("O:\\zdjęcia produktów\\aksam","fota.jpg");
  }

  //TODO:
  // scan if there is a file to rename,
  // then rename it to LocalDateTime + productList.txt
  // if there is no file or filename is the same, throw an exception
}
