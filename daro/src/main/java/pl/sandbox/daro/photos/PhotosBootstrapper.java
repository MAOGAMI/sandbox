package pl.sandbox.daro.photos;

import pl.sandbox.daro.photos.base_creator.Menu;

import java.io.IOException;

public class PhotosBootstrapper {
  public static void run() throws IOException {
    Menu menu = new Menu();
    menu.switchMenu();
  }
}