import btl.ui.WindowFrame;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class StartApplication {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        WindowFrame windowFrame = WindowFrame.class.getConstructor().newInstance();
//        windowFrame.setVisible(true);
    }
}
