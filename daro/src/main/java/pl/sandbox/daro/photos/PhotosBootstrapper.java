package pl.sandbox.daro.photos;

import pl.sandbox.daro.photos.base_creator.Menu;

import java.io.IOException;
import java.util.Scanner;

public class PhotosBootstrapper {
  public static void run() throws IOException {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    menu.createFile();
    System.out.println("Czy przeparsować plik txt na csv? (Yes/No): ");
    menu.shouldParse(scanner.nextLine().toLowerCase());

  }
}