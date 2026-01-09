public class Book {
    private String judul;
    private String pengarang;

    public Book(String judul, String pengarang) {
        this.judul = judul;
        this.pengarang = pengarang;
    }

    public String getJudul() { return judul; }
    public String getPengarang() { return pengarang; }

    @Override
    public String toString() {
        return judul + "," + pengarang; // Format untuk simpan di txt
    }
}