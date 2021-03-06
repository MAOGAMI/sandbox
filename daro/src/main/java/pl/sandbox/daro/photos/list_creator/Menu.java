package pl.sandbox.daro.photos.list_creator;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
  private Scanner scanner = new Scanner(System.in);

  private void menu() {
    System.out.println("************************************************************************");
    System.out.println("*                                 MENU                                 *");
    System.out.println("************************************************************************");
    System.out.println("*                                                                      *");
    System.out.println("* 1. Create productList.txt which contains list of files in directory. *");
    System.out.println("* 2. Parse TXT to CSV.                                                 *");
    System.out.println("* 0. Quit.                                                             *");
    System.out.println("*                                                                      *");
    System.out.println("************************************************************************");

  }

  public void switchMenu() throws IOException {
    boolean quit = false;
    int wybor;
    do {
      menu();
      System.out.println();
      System.out.println("Wybierz co chcesz zrobić: ");
        wybor = scanner.nextInt();
        scanner.nextLine();
      switch (wybor) {
        case 1:
          createFile();
          break;
        case 2:
          shouldParse();
          break;
        case 0:
          quit = true;
          break;
          default:
            System.out.println("Invalid choice.");
            break;
      }
    } while (!quit); {
      System.out.println("\n****************************************");
      System.out.println("Koniec programu");
      System.out.println("****************************************");
    }
  }

  private static void shouldParse() {
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
  }

  private void createFile() throws IOException {
    System.out.println("Podaj nazwe pliku docelowego: ");
    String fileName = scanner.nextLine();
    System.out.println("Podaj nazwę folderu początkowego: ");
    String rootDirectory = scanner.nextLine();
    FileCreator.start(fileName,rootDirectory);
    System.out.println(String.format("Utworzono plik '%s' na dysku pod adresem: C:\\Users\\Admin\\Desktop\n", fileName));
  }
}
