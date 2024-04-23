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
                    // Lewati baris pertama (header)
                    headerSkipped = true;
                    continue;
                }
                String[] row = line.split(",");

                if (row.length == 3) {
                    double bawah = Double.parseDouble(row[0]);
                    double atas = Double.parseDouble(row[1]);
                    double tinggi = Double.parseDouble(row[2]);

                    // Buat objek Trapesium baru dan tambahkan ke dalam list
                    Trapesium trapesium = new Trapesium();
                    trapesium.bawah = bawah;
                    trapesium.atas = atas;
                    trapesium.tinggi = tinggi;
                    dataTrapezoid.add(trapesium);
                } else {
                    // Kasus jika jumlah nilai dalam baris tidak sesuai
                    System.out.println("Format data tidak valid: " + line);
                }
            }


            LuasT luasT = new LuasT();


            for (Trapesium trapesium : dataTrapezoid) {

                double luasTrapesium = luasT.Luas(trapesium);

                System.out.println("Luas trapesium dengan sisi bawah " + trapesium.bawah + ", sisi atas " + trapesium.atas + ", dan tinggi " + trapesium.tinggi + " adalah: " + luasTrapesium);
            }
        } catch (Exception e) {
            System.out.println("Error saat membaca file " + e.getMessage());
        }
    }
}