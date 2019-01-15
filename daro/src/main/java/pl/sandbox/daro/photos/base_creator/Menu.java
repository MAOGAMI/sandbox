package pl.sandbox.daro.photos.base_creator;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
  private Scanner scanner = new Scanner(System.in);

  public void shouldParse(String typeAnswer){
    if (typeAnswer.matches("YES".toLowerCase())) {
      ParseToCsv parser = new ParseToCsv();
      System.out.println("\nRozpoczynam parsowanie TXT na CSV.\nPodaj nazwę pliku CSV: ");
      parser.parse(scanner.nextLine());
      System.out.println("Parsing...");
    } else if (typeAnswer.matches("NO".toLowerCase())) {
      System.out.println("Ok no parsing today.");
    }
  }

  public void createFile() throws IOException {
    System.out.println("Podaj ścieżkę początkową: ");
    FileCreator.listFiles(scanner.nextLine());
    System.out.println("Utworzono plik productsList.txt na dysku pod adresem: "+new ParseToCsv().path);
  }
}
