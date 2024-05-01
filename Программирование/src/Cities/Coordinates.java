package Cities;

import java.io.Serializable;
import static Cities.SimpleScanner.Scan;

public class Coordinates implements Serializable {
    private Float x;
    private Integer y;

    public Coordinates(){
        while (true){
            try {
                System.out.print("Введите (float)x: ");
                x = Float.parseFloat(Scan());
                if (x < -978){
                    System.out.println("Введено недопустимое значение, попробуйте еще раз!");
                } else {
                    break;
                }
                break;
            } catch (NumberFormatException e){
                System.out.println("Требуется ввести float!");
            }
        }

        while (true){
            try {
                System.out.print("Введите (int)y: ");
                y = Integer.parseInt(Scan());
                if (y < -426){
                    System.out.println("Введено недопустимое значение, попробуйте еще раз!");
                } else {
                    break;
                }
                break;
            } catch (NumberFormatException e){
                System.out.println("Требуется ввести int!");
            }
        }
    }
}
