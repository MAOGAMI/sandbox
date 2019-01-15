package pl.sandbox.daro.photos.base_creator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

class ParseToCsv {

  final Path path = Paths.get("C:\\Users\\Admin\\Desktop");
  private final Path txt = path.resolve("productsList.txt");


  void parse(String fileName){
    final Path csv = path.resolve(fileName+".csv");

    try(final Stream<String> lines = Files.lines(txt);
        final PrintWriter pw = new PrintWriter(Files.newBufferedWriter(csv, StandardOpenOption.CREATE_NEW))) {
      lines.map((line) -> line.split("\\\\")).map((line) -> String.join(";", line)).forEach(pw::println);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

