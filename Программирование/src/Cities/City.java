package Cities;

import static Cities.SimpleScanner.Scan;
import java.io.Serializable;

import java.util.Date;

/**
 * This is the collection class that we collect in this program.
 * */

public class City implements Serializable {
    private long id;
    private String name;
    private Coordinates coordinates = new Coordinates();
    private java.util.Date creationDate = new Date();
    private Long area;
    private Integer population;
    private float metersAboveSeaLevel;
    private Integer carCode;
    private Climate climate;
    private StandardOfLiving standardOfLiving;
    private Human governor;

    public City(){
        setName();
        setId();
        setArea();
        setPopulation();
        setMetersAboveSeaLevel();
        setCarCode();
        setClimate();
        setStandardOfLiving();
        setGovernor();
    }

    public void setId(){
        this.id = (long) (Math.random() * 1234567L)+1;
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

    private void setArea(){
        while (true){
            System.out.println("Введите площадь: ");
            try {
                area = Long.parseLong(Scan());
                if (area < 0){
                    System.out.println("Значение должно быть больше 0!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Требуется ввести Long!");
            }
        }
    }

    private void setPopulation(){
        while (true){
            System.out.println("Введите количество проживающих: ");
            try {
                population = Integer.parseInt(Scan());
                if (population < 0){
                    System.out.println("Значение должно быть больше 0!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Требуется ввести Int!");
            }
        }
    }

    private void setMetersAboveSeaLevel(){
        while (true){
            System.out.println("Введите высоту над уровнем моря: ");
            try {
                metersAboveSeaLevel = Float.parseFloat(Scan());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Требуется ввести Float!");
            }
        }
    }

    private void setCarCode(){
        while(true){
            System.out.println("Введите автомобильный номер: ");
            try {
                carCode = Integer.parseInt(Scan());
                if (carCode < 0 || carCode > 1000){
                    System.out.println("Значение должно быть в диапозоне от 1 до 1000!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Требуется ввести Int!");
            }
        }
    }

    private void setClimate(){
        while (true){
            System.out.println("Введите номер нужной погоды");
            System.out.println("1 - TROPICAL_SAVANNA\n2 - HUMIDSUBTROPICAL\n3 - MEDITERRANIAN\n4 - STEPPE\n5 - DESERT");
            try {
                int climateChoice = Integer.parseInt(Scan());
                if (climateChoice < 1 || climateChoice > 5) {
                    System.out.println("Указан неверный номер, попробуйте еще раз!");
                } else {
                    switch (climateChoice){
                        case 1:
                            climate = Climate.TROPICAL_SAVANNA;
                            break;
                        case 2:
                            climate = Climate.HUMIDSUBTROPICAL;
                            break;
                        case 3:
                            climate = Climate.MEDITERRANIAN;
                            break;
                        case 4:
                            climate = Climate.STEPPE;
                            break;
                        case 5:
                            climate = Climate.DESERT;
                            break;
                        case 6:
                            climate = null;
                    }
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("Требуется ввести int!");
            }
        }
    }

    private void setStandardOfLiving(){
        while (true){
            System.out.println("Введите номер нужного уровня жизни");
            System.out.println("1 - ULTRA_HIGH\n2 - VERY_HIGH\n3 - MEDIUM\n4 - VERY_LOW");
            try {
                int StandardOfLivingChoice = Integer.parseInt(Scan());
                if (StandardOfLivingChoice < 1 || StandardOfLivingChoice > 4) {
                    System.out.println("Указан неверный номер, попробуйте еще раз!");
                } else {
                    switch (StandardOfLivingChoice){
                        case 1:
                            standardOfLiving = StandardOfLiving.ULTRA_HIGH;
                            break;
                        case 2:
                            standardOfLiving = StandardOfLiving.VERY_HIGH;
                            break;
                        case 3:
                            standardOfLiving = StandardOfLiving.MEDIUM;
                            break;
                        case 4:
                            standardOfLiving = StandardOfLiving.VERY_LOW;
                            break;
                    }
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("Требуется ввести int!");
            }
        }
    }

    private void setGovernor(){
        int governorChoice;
        while (true){
            try {
                System.out.println("Если хотите добавить Governor, введите 1 иначе 2: ");
                governorChoice = Integer.parseInt(Scan());
                if (governorChoice != 1 && governorChoice != 2) {
                    System.out.println("Требуется ввести 1 или 2!");
                } else if (governorChoice == 1){
                    governor = new Human();
                    break;
                } else if (governorChoice == 2){
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Требуется ввести int!");
            }
        }
    }

    public long getId(){
        return id;
    }

    public int getCarCode(){
        return carCode;
    }

    public String getName(){
        return name;
    }

    public StandardOfLiving getStandardOfLiving(){
        return standardOfLiving;
    }

    public java.util.Date getDate(){
        return creationDate;
    }

    @Override
    public String toString(){
        return ("Name: " + name + "\nid: " + id + "\nCoordinates: " + coordinates + "\nArea: " + area + "\nPopulation: " + population + "\nmetersAboveSeeLevel: "
                + metersAboveSeaLevel + "\nCarCode: " + carCode + "\nClimate: " + climate + "\nStandardOfLiving: "
                + standardOfLiving + "\nGovernor: " + governor);
    }
}
