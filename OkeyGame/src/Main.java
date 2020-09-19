
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class Main {

    public static List<Integer> modSort(List<Integer> renkList) {

        List<Integer> modList = new ArrayList<Integer>();
        int tas = 0;
        int mod = 0;
        for (int i = 0; i < renkList.size(); i++) {
            tas = renkList.get(i) % 13;
            mod = tas % 13;
            modList.add(tas);
        }
        Collections.sort(modList);
        System.out.println(modList);
        return modList;
    }

    public static void renklereAyir(List<Integer> player) {

        List<Integer> sari = new ArrayList<Integer>();
        List<Integer> mavi = new ArrayList<Integer>();
        List<Integer> siyah = new ArrayList<Integer>();
        List<Integer> kırmızı = new ArrayList<Integer>();
        List<Integer> sahteOkey = new ArrayList<Integer>();
        List<Integer> okey = new ArrayList<Integer>();

        for (int i = 0; i < player.size(); i++) {
            int kontrol = player.get(i);
            if (0 <= kontrol && kontrol <= 12) {
                sari.add(kontrol);
            } else if (13 <= kontrol && kontrol <= 25) {
                mavi.add(kontrol);
            } else if (26 <= kontrol && kontrol <= 38) {
                siyah.add(kontrol);
            } else if (39 <= kontrol && kontrol <= 51) {
                kırmızı.add(kontrol);
            } else {
                sahteOkey.add(kontrol);
            }
        }
        //Oyuncuların ellerinde bulunan taşların modlarını alıp sortlayarak düzenler.
        System.out.println("Oyuncu Elleri ");
        modSort(sari);
        modSort(mavi);
        modSort(siyah);
        modSort(kırmızı);
        modSort(sahteOkey);
       

    }

    //Listeden Random olarak tas secer.
    public static int getRandomElement(List<Integer> taslar) {
        Random rand = new Random();
        return taslar.get(rand.nextInt(taslar.size()));
    }

    //********************************
    //Listeden Random olarak oyuncu listesi seçer
    public static List<Integer> getRandomPlayer(List<List<Integer>> players) {

        Random rand = new Random();
        return players.get(rand.nextInt(players.size()));
    }

    //********************************
    //İlk oyuncuya 15 tane tas dagitir.
    public static void ilkTasiDagit(List<Integer> taslar, List<Integer> player) {
        List<Integer> dagitilanTaslar = new ArrayList<Integer>();
        for (int i = 0; i < 15; i++) {
            dagitilanTaslar.add(getRandomElement(taslar));
            taslar.remove(dagitilanTaslar.get(i));
        }
        player.addAll(dagitilanTaslar);

    }

    //********************************
    //Kalan Tasları Diğer Oyunculara Dağıtır.
    public static void kalanTasiDagit(List<Integer> taslar, List<Integer> player) {
        List<Integer> dagitilanTaslar = new ArrayList<Integer>();
        for (int i = 0; i < 14; i++) {
            dagitilanTaslar.add(getRandomElement(taslar));
            taslar.remove(dagitilanTaslar.get(i));
        }
        player.addAll(dagitilanTaslar);

    }

    public static void main(String[] args) {

        System.out.println("**********OYUN BAŞLIYOR************");

        //Tasların bulunduğu diziyi oluşturur.
        List<Integer> taslar = new ArrayList<Integer>();
        // Oyuncuların bulunduğu diziyi oluşturur.    
        List<List<Integer>> players = new ArrayList<List<Integer>>();
        List<Integer> player1 = new ArrayList<Integer>();
        List<Integer> player2 = new ArrayList<Integer>();
        List<Integer> player3 = new ArrayList<Integer>();
        List<Integer> player4 = new ArrayList<Integer>();
        List<Integer> dagitilanTaslar = new ArrayList<Integer>();
        List<Integer> gosterge = new ArrayList<Integer>();
        //Taslar dizisinin içini 0 dan 53'e kadar doldurur.
        for (int i = 0; i < 53; i++) {
            taslar.add(i);
            taslar.add(i);
        }
        
        // Players listesine 4 tane  playerları ekler.
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        //******************************************   
        //Gosterge taş seçilip Okey tasi belirlenir.Ve Gösterge taş taşlar dizisinden çıkarılır.
        gosterge.add(getRandomElement(taslar));
        int okey;
        int gost = gosterge.get(0);
        int modGosterge = 0;
        modGosterge = gosterge.get(0) % 13;
        okey = modGosterge + 1;
        taslar.remove(gosterge.get(0));
        if (0 <= gost && gost <= 12) {
            System.out.println("Gösterge Taşı Sarı: " + modGosterge + " Okey Sarı :" + okey);
        } else if (13 <= gost && gost <= 25) {
            System.out.println("Gösterge Taşı Mavi: " + modGosterge + " Okey Mavi :" + okey);
        } else if (26 <= gost && gost <= 38) {

            System.out.println("Gösterge Taşı Siyah: " + modGosterge + " Okey Siyah :" + okey);
        } else if (39 <= gost && gost <= 51) {

            System.out.println("Gösterge Taşı Kırmızı: " + modGosterge + " Okey Kırmızı:" + okey);
        } else {

            System.out.println("Gösterge Taşı SahteOkey: " + modGosterge + " Okey Sarı:" + okey);
        }

        //*******************************************
        //tas dagitilacak ilk oyuncu seçilir ve ilk 15 tas dagıtılır.
        //Sonra geri kalan oyunculara taşları dağıtılır.
        if (getRandomPlayer(players) == player1) {

            ilkTasiDagit(taslar, player1);
            kalanTasiDagit(taslar, player2);
            kalanTasiDagit(taslar, player3);
            kalanTasiDagit(taslar, player4);
            System.out.println("1. Oyuncu oyuna başlar...");

        } else if (getRandomPlayer(players) == player2) {

            ilkTasiDagit(taslar, player2);
            kalanTasiDagit(taslar, player1);
            kalanTasiDagit(taslar, player3);
            kalanTasiDagit(taslar, player4);
            System.out.println("2. Oyuncu oyuna başlar...");

        } else if (getRandomPlayer(players) == player3) {

            ilkTasiDagit(taslar, player3);
            kalanTasiDagit(taslar, player1);
            kalanTasiDagit(taslar, player2);
            kalanTasiDagit(taslar, player4);
            System.out.println("3. Oyuncu oyuna başlar...");

        } else if (getRandomPlayer(players) == player4) {

            ilkTasiDagit(taslar, player4);
            kalanTasiDagit(taslar, player1);
            kalanTasiDagit(taslar, player2);
            kalanTasiDagit(taslar, player3);
            System.out.println("4. Oyuncu oyuna başlar...");

        }
        //************************************************

        System.out.println("1. Oyuncunun Eli" + player1);
        System.out.println("2. Oyuncunun Eli" + player2);
        System.out.println("3. Oyuncunun Eli" + player3);
        System.out.println("4. Oyuncunun Eli" + player4);

        renklereAyir(player1);
        renklereAyir(player2);
        renklereAyir(player3);
        renklereAyir(player4);

    }
}
