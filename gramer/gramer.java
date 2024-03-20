import java.util.Scanner;

public class gramer {
    public static void main(String[] args) {
        String[] ozneler = { "Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin",
                "Naki" };
        String[] nesneler = { "Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe",
                "Cuma",
                "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı" };
        String[] yuklemler = { "Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek" };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen cümlenizi giriniz. ");
        String cumle = scanner.nextLine().trim();

        String[] kelimeler = cumle.split("\\s+");

        if (kelimeler.length == 3) {
            String ozne = kelimeler[0];
            String nesne = kelimeler[1];
            String yuklem = kelimeler[2];

            if (kontrol(ozne, ozneler) && kontrol(nesne, nesneler) && kontrol(yuklem, yuklemler)) {
                System.out.println("EVET");
            } else {
                System.out.println("HAYIR");
            }
        } else {
            System.out.println("Eksik veya fazla kelime girdiniz.Girdiğiniz cümle gramer kurallarına uygun değil.");
        }

    }

    static boolean kontrol(String deger, String[] degerKumesi) {
        for (String d : degerKumesi) {
            if (deger.equals(d)) {
                return true;
            }
        }
        return false;
    }

}