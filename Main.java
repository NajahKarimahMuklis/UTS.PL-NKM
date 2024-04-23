import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String namaFile = "./src/DataTrapesium.csv";
        List<Trapesium> dataTrapezoid = new ArrayList<>();
        boolean headerSkipped = false;


        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String line;
            while ((line = reader.readLine()) != null) {

                if (!headerSkipped) {

                    headerSkipped = true;
                    continue;
                }
                String[] row = line.split(",");

                if (row.length == 3) {
                    double bawah = Double.parseDouble(row[0]);
                    double atas = Double.parseDouble(row[1]);
                    double tinggi = Double.parseDouble(row[2]);


                    Trapesium trapesium = new Trapesium();
                    trapesium.bawah = bawah;
                    trapesium.atas = atas;
                    trapesium.tinggi = tinggi;
                    dataTrapezoid.add(trapesium);
                } else {

                    System.out.println("Format data tidak valid: " + line);
                }
            }

            LuasT luasT = new LuasT();
            KelilingT kelilingT = new KelilingT();

            for (Trapesium trapesium : dataTrapezoid) {

                double luasTrapesium = luasT.Luas(trapesium);
                double kelilingTrapesium = kelilingT.Keliling(trapesium);

                System.out.println("Luas trapesium dengan sisi bawah " + trapesium.bawah + ", sisi atas " + trapesium.atas + ", dan tinggi " + trapesium.tinggi + " adalah: " + luasTrapesium);
                System.out.println("Keliling trapesium dengan sisi bawah " + trapesium.bawah + ", sisi atas " + trapesium.atas + ", dan tinggi " + trapesium.tinggi + " adalah: " + kelilingTrapesium);
            }
        } catch (Exception e) {
            System.out.println("Error saat membaca file " + e.getMessage());
        }
    }
}
