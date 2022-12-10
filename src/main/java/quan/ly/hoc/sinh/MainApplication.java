package quan.ly.hoc.sinh;

import quan.ly.hoc.sinh.ui.WindowFrame;

public class MainApplication {
  public static void main(String[] args){
    WindowFrame windowFrame = new WindowFrame();
  }

  public static class Global {
      public static int WIDTH_SCREEN = 1000;
      public static int HEIGHT_SCREEN = 700;

      // login
      public static int WIDTH_LOGIN = 400;
      public static int HEIGHT_LOGIN = 400;
      public static int WIDTH_CONTENT = 200;
      public static int HEIGHT_CONTENT = 50;
      public static int POS_NAME_X = 300;
      public static int POS_NAME_Y = 100;
      public static int SIZE_NAME = 40;


      // header
      public static int HEIGHT_HEADER = 60;
      public static int HEADER_TITLE_SIZE = 30;
      public static int HEADER_TITLE_X = 20;
      public static int HEADER_TITLE_Y = HEIGHT_HEADER / 2 + HEADER_TITLE_SIZE / 4;


      // sidebar
      public static int WIDTH_SIDEBAR = 160;

      // table
      public static int TABLE_PADDING = 10;
      public static int TABLE_HEIGHT_HEAD = 100;

      // form
      public static int FORM_WIDTH = 250;
      public static int FORM_HEIGHT_INPUT = 70;

      public static int TABLE_WIDTH = WIDTH_SCREEN - WIDTH_SIDEBAR - TABLE_PADDING*2 - FORM_WIDTH;

      public static int X_FORM = TABLE_WIDTH + TABLE_PADDING*2 + 20;

      // modal
      public static int HEIGHT_LABEL = 30;
      public static int HEIGHT_INPUT = 35;
      public static int WIDTH_INPUT = 200;

  }
}
