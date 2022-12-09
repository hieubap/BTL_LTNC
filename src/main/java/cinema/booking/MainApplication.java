package cinema.booking;

import cinema.booking.ui.WindowFrame;
import java.util.List;

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
      public static int POS_NAME_X = 220;
      public static int POS_NAME_Y = 100;
      public static int SIZE_NAME = 40;


      // header
      public static int HEIGHT_HEADER = 60;
      public static int HEADER_TITLE_SIZE = 30;
      public static int HEADER_TITLE_X = 20;
      public static int HEADER_TITLE_Y = HEIGHT_HEADER / 2 + HEADER_TITLE_SIZE / 4;


      // sidebar
      public static int WIDTH_SIDEBAR = 160;

      public static int HEIGHT_HEAD_TABLE = 50;

      // table
      public static int TABLE_PADDING = 10;
      public static int TABLE_HEIGHT_HEAD = 100;

      // form
      public static int FORM_WIDTH = 250;
      public static int FORM_HEIGHT_INPUT = 70;

      public static int TABLE_WIDTH = WIDTH_SCREEN - WIDTH_SIDEBAR - TABLE_PADDING*2 - FORM_WIDTH;

      public static int X_FORM = TABLE_WIDTH + TABLE_PADDING*2 + 20;

      // button màn ds phim
      public static int PHIM_HEIGHT = HEIGHT_SCREEN - HEIGHT_HEADER;
      public static int PHIM_PADDING = 20;
      public static int PHIM_MARGIN = 20;
      public static int PHIM_BOX_SIZE = (WIDTH_SCREEN - PHIM_PADDING * 2 - 20) / 4;
      public static int PHIM_SIZE = PHIM_BOX_SIZE - PHIM_MARGIN * 2;
      public static int MAN_HINH_X = 400;
      public static int MAN_HINH_Y = 650;
      public static int THONG_TIN_X = 700;
      public static int THONG_TIN_Y = 0;
      public static int THONG_TIN_LEFT = THONG_TIN_X + 50;
      public static int THONG_TIN_TOP = THONG_TIN_Y + 50;
      public static int BTN_SUBMIT_HEIGHT = 60;
      public static int BTN_SUBMIT_WIDTH = (WIDTH_SCREEN - THONG_TIN_X) / 2;
      public static int BTN_SUBMIT_Y = HEIGHT_SCREEN - HEIGHT_HEADER - BTN_SUBMIT_HEIGHT - 50;


      // ds hàng ghế
      public static int GHE_X = 20;
      public static int GHE_Y = 20;
      public static int GHE_PADDING = 5;
      public static int GHE_SIZE = 60;
      public static int GHE_BOX_SIZE = GHE_SIZE + GHE_PADDING;

      // modal
      public static int HEIGHT_LABEL = 30;
      public static int HEIGHT_INPUT = 35;
      public static int WIDTH_INPUT = 200;

      public static Object[][] convertToListArr(List<List<?>> lists) {
          if (lists == null || lists.size() == 0) return new Object[][]{};
          int w = lists.get(0).size();
          int h = lists.size();
          Object[][] output = new Object[h][w];
          for (int i = 0; i < h; i++) {
              for (int j = 0; j < w; j++) {
                  output[i][j] = lists.get(i).get(j);
              }
          }
          return output;
      }

      public static Object[] convertToArr(List<?> lists) {
          if (lists == null || lists.size() == 0) return new Object[]{};
          int length = lists.size();
          Object[] output = new Object[length];
          for (int i = 0; i < length; i++) {
              output[i] = lists.get(i);

          }
          return output;
      }

      public static String[] convertToArrString(List<String> lists) {
          int length = lists.size();
          String[] output = new String[length];
          for (int i = 0; i < length; i++) {
              output[i] = lists.get(i);
          }
          return output;
      }

  }
}
