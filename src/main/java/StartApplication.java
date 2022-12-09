import cinema.booking.ui.WindowFrame;
import java.lang.reflect.InvocationTargetException;

public class StartApplication {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        WindowFrame windowFrame = WindowFrame.class.getConstructor().newInstance();
//        windowFrame.setVisible(true);
    }
}
