package pl.sandbox.daro.photos.list_creator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

class ParseToCsv {

  final Path path = Paths.get("C:\\Users\\Admin\\Desktop");
  private final Path txt = path.resolve("productsList.txt");

  void parse(String fileName){
    final Path csv = path.resolve(new SimpleDateFormat(String.format("yyyy-MM-dd HH_mm' %s.csv'", fileName)).format(new Date()));
    System.out.println("Parsing...");
    try(final Stream<String> lines = Files.lines(txt);
        final PrintWriter pw = new PrintWriter(Files.newBufferedWriter(csv, CREATE_NEW))) {
      lines.map((line) -> line.split("\\\\")).map((line) -> String.join(";", line)).forEach(pw::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Done!");
  }
}