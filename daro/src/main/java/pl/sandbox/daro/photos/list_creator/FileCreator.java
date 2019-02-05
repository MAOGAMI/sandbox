package pl.sandbox.daro.photos.list_creator;

import java.io.*;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


class FileCreator {

  static String fileName;

  private static void setFileName(String name) {
    fileName = new SimpleDateFormat(String.format("yyyy-MM-dd HH_mm' %s.txt'", name)).format(new Date());
  }


  /**
   * This method creates a file which current local timestamp.
   * Created file contains a list of all files (with their directories) from a given directory
   *
   * @param directoryPath defines a path to directory which has to be listed.
   * @return
   * @throws IOException
   * @throws NullPointerException when path hasn't been defined.
   */

  private static List<File> listFiles(String directoryPath, String withName) throws IOException, NullPointerException {
    File directory = new File(directoryPath);
    File[] fList = directory.listFiles();
    List<File> resultList = new ArrayList<>(Arrays.asList(fList));
    for (File file : fList) {
      if (file.isDirectory()) {
        resultList.addAll(listFiles(file.getAbsolutePath(), withName));
      }
    }
    String saveTo = "C:\\Users\\Admin\\Desktop";
    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(saveTo, fileName)))) {
      for (File file : resultList) {
        if (file.getName().contains(withName)) {
          bufferedWriter.write(file.getAbsolutePath());
          bufferedWriter.newLine();
          bufferedWriter.flush();
        }
/*          bufferedWriter.write(file.getAbsolutePath());
          bufferedWriter.newLine();
          bufferedWriter.flush();*/
      }
    }
    return resultList;
  }

  /**
   * @param fileName      - name of a file with products list.
   * @param rootDirectory
   * @throws IOException
   */

  public static void start(String fileName, String rootDirectory) throws IOException {

    String[] partarray = rootDirectory.split("~");
    ArrayList<String> parts = new ArrayList<>(Arrays.asList(partarray));

    if (!fileName.isEmpty()) {
      setFileName(fileName);
    } else {
      System.out.println("type file name: ");
    }
    if (parts.size() > 0) {
      if (parts.size() > 1){
        listFiles(parts.get(0), parts.get(1));
        } else {
        listFiles(parts.get(0), "");
        }
    } else {
      System.out.println("type root dir: ");
    }
  }

  private static void parseToCsv() {

  }
}


