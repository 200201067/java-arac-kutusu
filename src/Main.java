import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;



void main() {
    Scanner scanner = new Scanner(System.in);
    int secim;

    do {
        System.out.println("\n===== JAVA ARAÇ KUTUSU =====");
        System.out.println("1. Tek/Çift Sayı Bulma");
        System.out.println("2. Dört İşlem (Toplama, Çıkarma, Çarpma, Bölme)");
        System.out.println("3. Asal Sayı Bulma");
        System.out.println("4. Üs Alma");
        System.out.println("5. Faktöriyel Hesaplama");
        System.out.println("6. fibonacci hesaplama");
        System.out.println("7. Değişken atama örnekleri");
        System.out.println("8. girilen sayıyı basamaklarına ayırma");
        System.out.println("9. polindrom sayı ve kelime");
        System.out.println("10. Girilen metinde harf arama");
        System.out.println("11. Girilen metinde kelime arama");
        System.out.println("12. Girilen metinde kelime sayısı bulma");
        System.out.println("13. dosya okuma yazma işlemleri");
        System.out.println("14. Heap üzerinden pointer örneği");
        System.out.println("15. Binary search örneği");
        System.out.println("0. Çıkış");
        System.out.print("Seçiminiz: ");
        secim = scanner.nextInt();

        switch (secim) {
            case 1 -> tekCiftMenu(scanner);
            case 2 -> dortIslemMenu(scanner);
            case 3 -> asalSayiMenu(scanner);
            case 4 -> usAlmaMenu(scanner);
            case 5 -> faktoriyelMenu(scanner);
            case 6 -> fibonacciMenu(scanner);
            case 7 -> degiskenAtama();
            case 8 -> basamakMenu(scanner);
            case 9 -> polindromSayiKelime(scanner);
            case 10 -> harfMenu(scanner);
            case 11 -> kelimeMenu(scanner);
            case 12 -> kelimeSayisiMenu(scanner);
            case 13 -> dosyaIslemleriMenu(scanner);
            case 14 -> DugumMenu(scanner);
            case 15-> binarySearchMenu();
            case 0 -> System.out.println("Programdan çıkılıyor...");
            default -> System.out.println("Geçersiz seçim, tekrar deneyin!");
        }

    } while (secim != 0);

    scanner.close();
}

// ---------- 1. Tek/Çift Sayı ----------
void tekCiftMenu(Scanner scanner) {
    System.out.print("Bir sayı girin: ");
    int sayi = scanner.nextInt();
    System.out.println(sayi + " sayısı " + tekMiCiftMi(sayi) + " sayıdır.");
}

String tekMiCiftMi(int sayi) {
    return (sayi % 2 == 0) ? "Çift" : "Tek";
}

// ---------- 2. Dört İşlem ----------
void dortIslemMenu(Scanner scanner) {
    System.out.print("Birinci sayıyı girin: ");
    double a = scanner.nextDouble();
    System.out.print("İkinci sayıyı girin: ");
    double b = scanner.nextDouble();

    System.out.println("Toplama: " + topla(a, b));
    System.out.println("Çıkarma: " + cikar(a, b));
    System.out.println("Çarpma: " + carp(a, b));
    System.out.println("Bölme: " + bol(a, b));


}

double topla(double a, double b) { return a + b; }
double cikar(double a, double b) { return a - b; }
double carp(double a, double b) { return a * b; }
double bol(double a, double b) {
    if (b == 0) throw new ArithmeticException("Sıfıra bölme hatası!");
    return a / b;
}

// ---------- 3. Asal Sayı ----------
void asalSayiMenu(Scanner scanner) {
    System.out.print("Bir sayı girin: ");
    int sayi = scanner.nextInt();

    System.out.println(sayi + (asalMi(sayi) ? " asal bir sayıdır." : " asal bir sayı değildir."));
    System.out.print(sayi + " sayısına kadar olan asal sayılar: ");
    for (int i = 2; i <= sayi; i++) {
        if (asalMi(i)) System.out.print(i + " ");
    }
    System.out.println();
}

boolean asalMi(int sayi) {
    if (sayi < 2) return false;
    for (int i = 2; i <= Math.sqrt(sayi); i++) {
        if (sayi % i == 0) return false;
    }
    return true;
}

// ---------- 4. Üs Alma ----------
void usAlmaMenu(Scanner scanner) {
    System.out.print("Taban sayıyı girin: ");
    double taban = scanner.nextDouble();
    System.out.print("Üssü girin: ");
    double us = scanner.nextDouble();

    System.out.println(taban + " üzeri " + us + " = " + Math.pow(taban, us));
}

/* double usAl(double taban, int us) {
    double sonuc = 1;
    for (int i = 0; i < us; i++) {
        sonuc = sonuc * taban;
    }
    return sonuc;  */

// ---------- 5. Faktöriyel ----------
void faktoriyelMenu(Scanner scanner) {
    System.out.print("Bir sayı girin: ");
    int sayi = scanner.nextInt();
    System.out.println(sayi + "! = " + faktoriyelHesapla(sayi));
}

int faktoriyelHesapla(int sayi) {
    int sonuc = 1;
    for (int i = 1; i <= sayi; i++) sonuc *= i;
    return sonuc;
}

void fibonacciMenu (Scanner scanner) {


    System.out.print("Kaçıncı Fibonacci sayısını istiyorsunuz: ");
    int n = scanner.nextInt();

    System.out.println(n + ". Fibonacci sayısı: " + fibonacciHesapla(n));

    System.out.print("\nİlk kaç Fibonacci sayısını görmek istersiniz: ");
    int adet = scanner.nextInt();

    System.out.print("Fibonacci dizisi: ");
    for (int i = 0; i < adet; i++) {
        System.out.print(fibonacciHesapla(i) + " ");
    }



}

int fibonacciHesapla(int n) {
    if (n <= 1) {
        return n;
    }

    int onceki = 0, simdiki = 1;
    for (int i = 2; i <= n; i++) {
        int sonraki = onceki + simdiki;
        onceki = simdiki;
        simdiki = sonraki;
    }
    return simdiki;
}

void degiskenAtama() {
    // Tam sayı (int)
    int yas = 25;
    System.out.println("Yaş: " + yas);

    // Ondalıklı sayı (double)
    double boy = 1.75;
    System.out.println("Boy: " + boy);

    // Ondalıklı sayı (float) - sonuna 'f' eklenir
    float agirlik = 68.5f;

    System.out.println("Ağırlık: " + agirlik);
    // Uzun tam sayı (long) - sonuna 'L' eklenir
    long nufus = 85000000L;
    System.out.println("Nüfus: " + nufus);

    // Karakter (char) - tek tırnak kullanılır
    char harf = 'A';
    System.out.println("Harf: " + harf);

    // Metin (String) - çift tırnak kullanılır
    String isim = "Ahmet";
    System.out.println("İsim: " + isim);

    // Mantıksal (boolean) - sadece true/false
    boolean ogrenciMi = true;
    System.out.println("Öğrenci mi: " + ogrenciMi);

    // byte - küçük tam sayılar için (-128 ile 127 arası)
    byte puan = 100;
    System.out.println("Puan: " + puan);

    // short - int'ten küçük tam sayılar için
    short stok = 500;
    System.out.println("Stok: " + stok);

    // var ile otomatik tip çıkarımı (Java 10+)
    var sehir = "İstanbul";  // derleyici bunun String olduğunu anlar
    System.out.println("Şehir: " + sehir);

    // Birden fazla değişkeni aynı satırda tanımlama
    int x = 5, y = 10, z = 15;
    System.out.println("x=" + x + ", y=" + y + ", z=" + z);

    // Önce tanımlama, sonra değer atama
    int sicaklik;
    sicaklik = 22;
    System.out.println("Sıcaklık: " + sicaklik);


    // final ile değiştirilemez (sabit) değişken
    final double PI = 3.14159;
    System.out.println("PI: " + PI);
}

void basamakMenu(Scanner scanner) {


    System.out.print("Bir sayı girin: ");
    int sayi = scanner.nextInt();

    System.out.print(sayi + " sayısının basamakları: ");
    basamaklaraAyir(sayi);


}

void basamaklaraAyir(int sayi) {
    // Negatif sayıları da doğru işlemek için mutlak değerini alıyoruz
    sayi = Math.abs(sayi);

    if (sayi == 0) {
        System.out.println("0");
        return;
    }

    // Basamakları geçici olarak bir listede tutuyoruz (ters sırada bulunacak)
    String basamaklar = "";
    while (sayi > 0) {
        int basamak = sayi % 10;
        basamaklar = basamak + " " + basamaklar;
        sayi = sayi / 10;
    }

    System.out.println(basamaklar.trim());
}




void polindromSayiKelime(Scanner scanner) {


    System.out.print("Bir sayı girin: ");
    int sayi = scanner.nextInt();
    System.out.println(sayi + (palindromMuSayi(sayi) ? " bir palindromdur." : " bir palindrom değildir."));

    scanner.nextLine(); // Scanner'ın buffer'ında kalan satır sonunu temizler

    System.out.print("Bir kelime girin: ");
    String kelime = scanner.nextLine();
    System.out.println(kelime + (palindromMuKelime(kelime) ? " bir palindromdur." : " bir palindrom değildir."));


}

// ---------- Sayı Palindrom Kontrolü ----------
boolean palindromMuSayi(int sayi) {
    int orijinal = sayi;
    int ters = 0;

    sayi = Math.abs(sayi);
    while (sayi > 0) {
        int basamak = sayi % 10;
        ters = ters * 10 + basamak;
        sayi = sayi / 10;
    }

    return orijinal == ters;
}

// ---------- Kelime Palindrom Kontrolü ----------
boolean palindromMuKelime(String kelime) {
    // Büyük/küçük harf duyarlılığını kaldırmak için hepsini küçük harfe çeviriyoruz
    kelime = kelime.toLowerCase().replaceAll("\\s+", ""); // boşlukları da temizler

    int basIndex = 0;
    int sonIndex = kelime.length() - 1;

    while (basIndex < sonIndex) {
        if (kelime.charAt(basIndex) != kelime.charAt(sonIndex)) {
            return false;
        }
        basIndex++;
        sonIndex--;
    }

    return true;
}

void harfMenu(Scanner scanner) {


    System.out.print("Bir metin girin: ");
    String metin = scanner.nextLine();

    if (metin.isBlank()) {
        metin = scanner.nextLine();
    }

    System.out.print("Aranacak harfi girin: ");
    char harf = scanner.next().charAt(0);

    int sayac = harfAra(metin, harf);

    if (sayac > 0) {
        System.out.println("'" + harf + "' harfi metinde " + sayac + " kez geçiyor.");
    } else {
        System.out.println("'" + harf + "' harfi metinde bulunamadı.");
    }


}

int harfAra(String metin, char harf) {
    // Büyük/küçük harf duyarlılığını kaldırmak için ikisini de küçük harfe çeviriyoruz
    metin = metin.toLowerCase();
    harf = Character.toLowerCase(harf);

    int sayac = 0;
    for (int i = 0; i < metin.length(); i++) {
        if (metin.charAt(i) == harf) {
            sayac++;
        }
    }

    return sayac;
}



void kelimeMenu(Scanner scanner) {
    System.out.print("Bir metin girin: ");
    String metin = scanner.nextLine();

    // Buffer'da kalan boşluk veya \n temizliği için güvence
    if (metin.isBlank()) {
        metin = scanner.nextLine();
    }

    System.out.print("Aranacak kelimeyi girin: ");
    // Aranacak kelimeyi alıp boşluklardan arındırıyoruz
    String kelime = scanner.next().trim();

    int sayac = kelimeAra(metin, kelime);

    if (sayac > 0) {
        System.out.println("'" + kelime + "' kelimesi metinde " + sayac + " kez geçiyor.");
    } else {
        System.out.println("'" + kelime + "' kelimesi metinde bulunamadı.");
    }
}

int kelimeAra(String metin, String aranan) {
    if (metin == null || aranan == null || metin.isBlank() || aranan.isBlank()) {
        return 0;
    }

    // Türkçe karakter uyumu için varsayılan yerel ayar kullanılır
    metin = metin.toLowerCase();
    aranan = aranan.toLowerCase();

    // Sadece boşluklardan değil, noktalama işaretlerinden de ayırır (\P{L}+: harf olmayan tüm karakterler)
    String[] kelimeler = metin.split("\\P{L}+");
    int sayac = 0;

    for (String k : kelimeler) {
        if (k.equals(aranan)) {
            sayac++;
        }
    }

    return sayac;
}

 void kelimeSayisiMenu(Scanner scanner) {
    System.out.print("Lütfen bir metin girin: ");
    String metin = scanner.nextLine();

    // Buffer'da kalan boşluk/satır atlamasını engellemek için kontrol
    if (metin.isBlank()) {
        metin = scanner.nextLine();
    }

    int toplamKelime = kelimeSayisiBul(metin);
    System.out.println("Metindeki toplam kelime sayısı: " + toplamKelime);
}

 int kelimeSayisiBul(String metin) {
    if (metin == null || metin.isBlank()) {
        return 0;
    }

    // Harf harici tüm karakterleri (boşluk, noktalama işaretleri vb.) ayırıcı kabul eder
    String[] kelimeler = metin.trim().split("\\P{L}+");

    return kelimeler.length;
}



// Ana yönetici fonksiyon: Kullanıcıdan işlem alır ve ilgili fonksiyonları çağırır
public static void dosyaIslemleriMenu(Scanner scanner) {
    System.out.print("İşlem yapılacak dosya adını/yolunu girin (örn: metin.txt): ");
    String dosyaYolu = scanner.nextLine().trim();

    if (dosyaYolu.isBlank()) {
        dosyaYolu = scanner.nextLine().trim();
    }

    System.out.println("\n1. Dosyaya Yaz (Üzerine yazar)");
    System.out.println("2. Dosya Sonuna Ekle");
    System.out.println("3. Dosyayı Oku ve Göster");
    System.out.print("Seçiminiz (1-3): ");

    int secim = scanner.nextInt();
    scanner.nextLine(); // Buffer temizleme

    switch (secim) {
        case 1:
            System.out.print("Yazılacak metni girin: ");
            String yeniIcerik = scanner.nextLine();
            dosyayaYaz(dosyaYolu, yeniIcerik);
            break;
        case 2:
            System.out.print("Eklenecek metni girin: ");
            String eklenecekIcerik = scanner.nextLine();
            dosyayaEkle(dosyaYolu, eklenecekIcerik);
            break;
        case 3:
            System.out.println("\n--- Dosya İçeriği ---");
            String icerik = dosyadanOku(dosyaYolu);
            System.out.println(icerik.isEmpty() ? "[Dosya boş veya okunamadı]" : icerik);
            break;
        default:
            System.out.println("Geçersiz seçim yapıldı.");
            break;
    }
}

public static void dosyayaYaz(String dosyaYolu, String icerik) {
    try {
        Files.writeString(Paths.get(dosyaYolu), icerik);
        System.out.println("Dosya başarıyla yazıldı.");
    } catch (IOException e) {
        System.err.println("Yazma hatası: " + e.getMessage());
    }
}

public static void dosyayaEkle(String dosyaYolu, String icerik) {
    try {
        Path path = Paths.get(dosyaYolu);
        Files.writeString(
                path,
                icerik + System.lineSeparator(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
        System.out.println("Veri dosyanın sonuna eklendi.");
    } catch (IOException e) {
        System.err.println("Ekleme hatası: " + e.getMessage());
    }
}

public static String dosyadanOku(String dosyaYolu) {
    try {
        return Files.readString(Paths.get(dosyaYolu));
    } catch (IOException e) {
        System.err.println("Okuma hatası: " + e.getMessage());
        return "";
    }
}

public static class Dugum {
    int veri;

    Dugum(int veri) {
        this.veri = veri;
    }
}


    public static void DugumMenu(Scanner scanner) {
        // Heap bellekte yeni bir Dugum nesnesi oluşur, adresi 'a' referansına atanır
        Dugum a = new Dugum(10);

        // 'b' değişkeni, 'a'nın işaret ettiği bellek adresini kopyalar (Pointer kopyalama)
        Dugum b = a;
        System.out.println("a.veri: " + a.veri);
        System.out.println("b.veri: " + b.veri);
        System.out.println("yeni veri değerini giriniz:");
        // 'b' üzerinden heap'teki nesnenin değerini değiştiriyoruz
        b.veri = scanner.nextInt();

        // 'a' üzerinden okuduğumuzda da 42 görürüz çünkü ikisi de aynı nesneyi gösterir
        System.out.println("a.veri: " + a.veri); // Çıktı: 42
        System.out.println("b.veri: " + b.veri); // Çıktı: 42
    }



    public static int binarySearchRecursive(int[] dizi, int sol, int sag, int hedef) {
        if (sol > sag) {
            return -1;
        }

        int orta = sol + (sag - sol) / 2;

        if (dizi[orta] == hedef) {
            return orta;
        }

        if (hedef < dizi[orta]) {
            return binarySearchRecursive(dizi, sol, orta - 1, hedef);
        }

        return binarySearchRecursive(dizi, orta + 1, sag, hedef);
    }

    public static int binarySearch(int[] dizi, int hedef) {
        return binarySearchRecursive(dizi, 0, dizi.length - 1, hedef);
    }
    public static void binarySearchMenu() {
        int[] sayilar = {10, 23, 35, 42, 50, 68, 74, 89, 95};

        // Senaryo 1: Dizide var olan elemanı arama
        int hedef1 = 42;
        int sonuc1 = binarySearch(sayilar, hedef1);
        System.out.println(hedef1 + (sonuc1 != -1 ? " bulundu, İndeks: " + sonuc1 : " bulunamadı"));
        // Senaryo 2: Dizide olmayan elemanı arama
        int hedef2 = 60;
        int sonuc2 = binarySearch(sayilar, hedef2);
        System.out.println(hedef2 + (sonuc2 != -1 ? " bulundu, İndeks: " + sonuc2 : " bulunamadı"));
    }

