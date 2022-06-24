package btl;

import btl.component.OptionSelect;

import java.util.List;

public class Global {
    public static int WIDTH_SCREEN = 1700;
    public static int HEIGHT_SCREEN = 950;

    public static int HEIGHT_HEAD_TABLE = 50;

    // modal
    public static int HEIGHT_LABEL = 30;
    public static int HEIGHT_INPUT = 35;
    public static int WIDTH_INPUT = 200;

    public static int sizeKhungGio = 6;
    public static OptionSelect[] enumKhungGio = new OptionSelect[]{
            new OptionSelect(1, "7:00 - 9:00"),
            new OptionSelect(2, "9:30 - 11:30"),
            new OptionSelect(3, "13:00 - 15:00"),
            new OptionSelect(4, "15:30 - 17:30"),
            new OptionSelect(5, "18:00 - 20:00"),
            new OptionSelect(6, "20:30 - 22:30"),
    };
    public static OptionSelect[] enumThu = new OptionSelect[]{
            new OptionSelect(1, "Thứ 2"),
            new OptionSelect(2, "Thứ 3"),
            new OptionSelect(3, "Thứ 4"),
            new OptionSelect(4, "Thứ 5"),
            new OptionSelect(5, "Thứ 6"),
            new OptionSelect(6, "Thứ 7"),
            new OptionSelect(7, "Chủ nhật"),
    };

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
