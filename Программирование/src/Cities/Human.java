package Cities;

import java.io.Serializable;
import static Cities.SimpleScanner.Scan;

public class Human implements Serializable {
    private String name;
    private Float height;

    public Human(){
        setName();
        setHeight();
    }
    private void setName(){
        while (true){
            System.out.print("Введите имя: ");
            name = Scan();
            if (name.replaceAll(" ", "").equals("")) {
                System.out.println("Вы ввели пустую строчку! Имя не может быть пустой строчкой.");
            } else {
                break;
            }
        }
    }

    private void setHeight(){
        while(true){
            System.out.print("Введите значение больше 0 (Float)height: ");
            try{
                String sHeight = Scan();
                if (sHeight.replaceAll(" ", "").equals("")){
                    height = null;
                    break;
                }
                height = Float.parseFloat(sHeight);
                if (height<=0){
                    System.out.println("Значение health должно быть больше 0!");
                }else{
                    break;
                }
            }catch(NumberFormatException e){
                System.out.println("Надо ввести Float!");
            }
        }
    }

    public String getName(){
        return name;
    }
}
