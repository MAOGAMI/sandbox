package pl.sandbox.daro.photos.base_creator;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
  private Scanner scanner = new Scanner(System.in);

  private void menu() {
    System.out.println();
    System.out.println("     ****************************************");
    System.out.println("     *                 MENU                 *");
    System.out.println("     ****************************************");
    System.out.println("     1. Create productList.txt which contains list of files in directory.");
    System.out.println("     2. Parse TXT to CSV.");
    System.out.println("     0. Quit.");
  }

  public void switchMenu() throws IOException {
    boolean quit = false;
    int wybor;
    do {
      menu();
      System.out.println();
      System.out.println("     Wybierz co chcesz zrobić: ");
      wybor = scanner.nextInt();
      switch (wybor) {
        case 1:
          createFile();
          break;
        case 2:
          shouldParse();
          break;
        case 0:
          quit = true;
          default:
            System.out.println("Invalid choice.");
      }
    } while (!quit); {
      System.out.println("     ****************************************");
      System.out.println("\n     Koniec programu\n\n");
    }
  }

  private void shouldParse() {
    Scanner in = new Scanner(System.in);
    System.out.println("Czy przeparsować plik txt na csv? (Yes/No): ");
    String typeAnswer = in.nextLine();
    if (typeAnswer.matches("YES".toLowerCase())) {
      ParseToCsv parser = new ParseToCsv();
      System.out.println("Jak nazwać plik?: ");
      parser.parse(in.nextLine());
    } else if (typeAnswer.matches("NO".toLowerCase())) {
      System.out.println("Ok no parsing today.");
    }
    in.close();
  }

  private void createFile() throws IOException {
    Scanner dirName = new Scanner(System.in);
    System.out.println("Podaj ścieżkę początkową aby rozpocząć tworzenie listy plików: ");
    FileCreator.listFiles(dirName.nextLine());
    System.out.println("Utworzono plik productsList.txt na dysku pod adresem: " + new ParseToCsv().path);
    dirName.close();
  }
}
