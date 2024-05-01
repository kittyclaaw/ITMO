package Data;

import Cities.City;

import java.io.*;
import java.util.Scanner;
import java.util.LinkedHashSet;

/**
 * Data Class responsible for saving and unloading files
 * */

public class DataProvider {
    public void Save(LinkedHashSet<City> set, String fileName){

        /**
         * Saving a collection to a file
         *
         * @param LinkedHashSet collection where we store SpaceMarine objects
         * @param fileName file name where to save
         * */

        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            outputStream.writeObject(set);
        } catch (Exception e) {
            System.out.println("Нет доступа к файлу");
        }
    }

    /**
     * Load a collection from file
     *
     * @param fileName the name of the file from which the collection should be loaded
     * @return collection where we store City objects
     * */

    public LinkedHashSet<City> Load(String fileName){
        System.out.println(fileName);
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
            LinkedHashSet<City> loadSet = (LinkedHashSet<City>) inputStream.readObject();
            System.out.println("Успешно загружено!");
            return loadSet;
        } catch (Exception e) {
            System.out.println("Файл не найден или в файле не LinkedHashSet<City>!");
            return new LinkedHashSet<City>();
        }
    }

    /**
     * Load a script from file
     *
     * @param fileName the name of the file from which the script should be loaded
     * @return collection where we store script
     * */

    public LinkedHashSet<String> LoadScript(String fileName){
        LinkedHashSet<String> lines = new LinkedHashSet<String>();
        try{
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                lines.add(line);}
        }catch (FileNotFoundException e){
            System.out.println("К файлу нету доступа или он отсутствует!");
        }
        return lines;
    }

}
