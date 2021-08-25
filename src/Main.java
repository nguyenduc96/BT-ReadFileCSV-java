import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Country> countries = readFileCSV("country.csv");
        for (Country country:countries) {
            System.out.println(country);
        }

        writeFileCSV("countrynew.csv", countries);
    }

    public static List<Country> readFileCSV(String path) {
        List<Country> countries = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                String id = strings[0];
                String code = strings[1];
                String name = strings[2];
                countries.add(new Country(id, code, name));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("File nguồn hoặc đường dẫn không hợp lệ.");
        }
        return countries;
    }


    public static void writeFileCSV(String path, List<Country> countries) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Country country: countries) {
                bufferedWriter.write(country.toString() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Tệp nguồn không tồn tại hoặc bị lỗi.");
        }

    }
}
