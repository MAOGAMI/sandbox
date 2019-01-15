package pl.sandbox.daro.photos.base_creator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class FileCreator {
  /**
   * @param directoryPath defines a path to directory which has to be listed.
   * @return
   * @throws IOException
   * @throws NullPointerException when path hasn't been defined.
   */
  static List<File> listFiles(String directoryPath) throws IOException, NullPointerException {
    File directory = new File(directoryPath);
    List<File> resultList = new ArrayList<>();
    File[] fList = directory.listFiles();
    resultList.addAll(Arrays.asList(fList));
    for (File file : fList) {
      if (file.isFile()) {
        file.getAbsolutePath();

      } else if (file.isDirectory()) {
        resultList.addAll(listFiles(file.getAbsolutePath()));
      }
    }
    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\Users\\Admin\\Desktop", "productsList.txt")))) {
      for (File file : resultList) {
        bufferedWriter.write(file.getAbsolutePath());
        bufferedWriter.newLine();
        bufferedWriter.flush();
      }
    }
    return resultList;
  }
}
