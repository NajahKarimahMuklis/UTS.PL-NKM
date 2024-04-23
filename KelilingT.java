class KelilingT {

    public double Keliling(Trapesium trapesium) {

        // Sisi kanan dan kiri diasumsikan memiliki panjang yang sama dengan sisi atas dan sisi bawah
        double sisiKanan = trapesium.atas;
        double sisiKiri = trapesium.bawah;

        return trapesium.bawah + trapesium.atas + sisiKanan + sisiKiri;
    }
}
