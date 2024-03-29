package Data;

import Cities.City;

import java.io.*;
import java.util.Scanner;
import java.util.LinkedHashSet;

public class DataProvider {
    public void Save(LinkedHashSet<City> set, String fileName){

        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            outputStream.writeObject(set);
        } catch (Exception e) {
            System.out.println("Нет доступа к файлу");
        }

    }
    public LinkedHashSet<City> Load(String fileName){
        System.out.println(fileName);
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
            LinkedHashSet<City> loadSet = (LinkedHashSet<City>) inputStream.readObject();
            System.out.println("Успешно загружено!");
            return loadSet;
        } catch (Exception e) {
            System.out.println("Файл не найден или в файле не Vector<SpaceMarine>!");
            return new LinkedHashSet<City>();
        }
    }

    public LinkedHashSet<String> LoadScript(String fileName){
        LinkedHashSet<String> lines = new LinkedHashSet<String>();
        try{
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();//убираем пробелы
                lines.add(line);}
        }catch (FileNotFoundException e){
            System.out.println("К файлу нету доступа или он отсутствует!");
        }
        return lines;
    }

}
