import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Bagli_Sirala {
    public static void main(String[] args) {
        Node[] degerler = new Node[100];
        Node[] siralanmisDegerler = new Node[100];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen .txt metninin konumunu giriniz.");
        String dosya = scanner.nextLine();
        scanner.close();

        File file = new File(dosya);

        try {
            Scanner reader = new Scanner(file);
            int index = 0;
            while (reader.hasNextLine()) {
                int deger = Integer.parseInt(reader.nextLine().trim());
                degerler[index] = new Node(deger, index);
                siralanmisDegerler[index] = new Node(deger, index);
                index++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        sirala(siralanmisDegerler);
        yazdir(degerler, siralanmisDegerler);
    }

    public static void yazdir(Node[] degerler, Node[] siralanmisDegerler) {
        System.out.println("Normal Hali \t Sıralanmış Hali");
        for (int i = 0; i < degerler.length; i++) {
            if (degerler[i] != null && siralanmisDegerler[i] != null) {
                System.out.println(degerler[i].deger + " -> " + degerler[i].adres + "\t\t" + siralanmisDegerler[i].deger
                        + " -> " + siralanmisDegerler[i].adres);
            }
        }
    }

    public static void sirala(Node[] siralanmisDegerler) {
        for (int i = 0; siralanmisDegerler[i + 1] != null && i < siralanmisDegerler.length; i++) {
            for (int j = 0; siralanmisDegerler[j + 1] != null && j < siralanmisDegerler.length - 1; j++) {
                if (siralanmisDegerler[j].deger > siralanmisDegerler[j + 1].deger) {
                    Node t = siralanmisDegerler[j];
                    siralanmisDegerler[j] = siralanmisDegerler[j + 1];
                    siralanmisDegerler[j + 1] = t;
                }
            }
        }
    }

}