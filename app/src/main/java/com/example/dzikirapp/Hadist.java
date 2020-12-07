package com.example.dzikirapp;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;

public class Hadist extends Activity {
    ListView listHadist;

    String[] judulHadist = {

            "Hadits Keutamaan Senyum",
            "Hadits Perintah Saling Menyayangi",
            "Hadits Menutup Aurat",
            "Hadits Menahan Marah",
            "Hadits Niat",
            "Hadist Jangan Suka Marah",
            "Hadist Muslim Besaudara",
            "Hadist Agama",
            "Hadits Kebersihan",
            "Hadist Kebaikan",
            "Hadist Menuntut Ilmu",
            "Hadist Paham Agama",
            "Hadist Berkata Baik/Diam",
            "Hadits Malu",
            "Hadits Menyebarkan Salam",
            "Hadits Kemuliaan Ibu",
            "Hadits Allah Maha Indah",
            "Hadits Keutamaan Belajar Al Quran",
            "Hadits Sholat Tepat Waktunya",
            "Hadits Menjaga Agama Allah",
            "Hadits Berkata Benar",
            "Hadits Keutamaan Doa",
            "Hadits Keutamaan Seorang Muslim",
            "Hadits Larangan Berburuk Sangka",
            "Hadits Larangan Mencela Makanan",
            "Hadits Tolong Menolong",
            "Hadits Makan dengan Tangan Kanan",
            "Hadits Perintah Taqwa",
            "Hadits Keutamaan Bersiwak",
            "Hadits Menjaga Lisan",
            "Hadits Keutamaan Shalat",
            "Hadits Larangan Berbuat Kerusakan"


    };

    String[] ayatHadist = {
            "تَبَسُّمُكَ فِي وَجْهِ أَخِيكَ صَدَقَةٌ",
            "مَنْ لاَ يَرْحَمْ وَلاَ يُرْحَمْ",
            "اِنَّا نُهِيْنَا اَنْ نُرَى عَوْرَاتَنَا",
            "إِذَا غَضَبَ اَحَدُكُمْ فَلْيَسْكُتْ",
            "إِنَّمَا اْلأَعْمَالُ بِالنِّيَّاتِ",
            "لا تغضب ولك الجنة",
            "الْمُسْلِمُ أَخُو الْمُسْلِمِ لَا يَظْلِمُهُ وَلَا يُسْلِمُهُ",
            "الدِّينُ النَّصِيحَةُ",
            "الطهور شطر الإيمان",
            "كل معروفٍ صدقة",
            "طَلَبُ اْلعِلْمِ فَرِيْضَةٌ عَلَى كُلِّ مُسْلِمٍ",
            "مَنْ يُرِدِ اللَّهُ بِهِ خَيْرًا يُفَقِّهْهُ فِي الدِّينِ",
            "مَنْ كَانَ يُؤْمِنُ بِاللَّهِ وَالْيَوْمِ اْلآخِرِ فَليَقُلْ خَيْرًا أَوْ لِيَصْمُتْ",
            "اَلْحَيَاءُ مِنَ اْلإِيْمَانِ",
            "اَفْشُوْا السَّلاَمَ بَيْنَكُمْ",
            "اَلْجَنَّةُ تَحْتَ اَقْدَامِ اْلأُمَّهَاتْ",
            "إِنَّ اللّٰهَ جَمِيْلُ يُحِبُّ الْجَمَلْ",
            "خَيْرُكُمْ مَنْ تَعَلَّمَ الْقُرْ اَنَ وَ عَلَّمَهْ",
            "صَلِّ الصَّلاَةَ لِوَقْتِهَا",
            "احْفَظِ اللّٰهَ يَحْفَظْكَ اِحْفَظِ اللّٰهَ تَجِدْهُ تُجَاهَكَ",
            "قُلِ الْحَقَّ وَلَوْ كَانَ مُرَّا",
            "الدُّعَاءُ هُوَ الْعِبَادَهْ",
            "مِن حُسْنِ إِسْلاَمِ الْمَرْءِ تَرْكُهُ مَا لاَ يَعْنِيْهِ",
            "اِيَّاكُمْ وَالظَّنْ",
            "مَاعَابَ رَسُوْلُ اللّٰهِ صَلَى اللّٰهُ عَلَيْهِ وَسَلَّمْ طَعَامًا قَطٌّ",
            "اللّٰهُ فِي عَوْنِ الْعَبْدِ مَا كَانَ الْعَبْدُ فِي عَوْنِ أَخِيْهِ",
            "يَاغُلاَمْ سَمِ اللّٰه تعالى وَكُلْ بِيَمِيْنِكَ وَكُلْ مِمَّا يَلِيْكَ",
            "اِتَّقِ اللّٰهَ حَيْثُ مَا كُنْتَ",
            "اَلسِّوَاكُ مُطَهِّرَةٌ لِلْفَمِّ مُرْ ضَاةٌ لِلرَّبِّ",
            "اَمْسِكْ عَلَيْكَ لِسَانَكَ",
            "اِنَّ اَوَّلَ مَا يُحَاسَبُ بِهِ الْعَبْدُ يَوْمَ الْقِيَامَةِ مِنْ عَمَلِهِ صَلاَتُهْ",
            "لاَ ضَرَرَ وَلاَ ضِرَارَ",

    };

    String[] artiHadist = {
            "\"Senyum manismu dihadapan saudaramu adalah shadaqah.\" (HR. Tirmidzi)",
            "\"Barangsiapa tidak menyayangi maka tidak disayangi.\" (HR. Bukhari)",
            "\"Sesungguhnya kita dilarang menampakkan aurat kita.\" (HR. Ahmad)",
            "\"Jika di antara kalian marah maka hendaklah ia diam.\" (HR. Ahmad)",
            "\"Sesungguhnya amal itu tergantung niatnya.\" (HR. Bukhari, Muslim)\n",
            "\"Jangan marah, maka bagimu syurga.\" (HR.Thabrani)",
            "\"Muslim itu bersaudara bagi muslim yang lainnya, jangan menzhaliminya dan jangan memasrahkannya.\"" +
                    "(HR. Bukhari, Muslim)",
            "\"Agama adalah nasihat.\" (HR. Muslim, Abu Dawud dan An-Nasai’i)\n",
            "\"Kebersihan itu sebagian dari (cabang) keimanan.\" (HR. Muslim)",
            "\"Setiap kebaikan adalah shadaqah.\" (HR. Muslim)",
            "\"Menuntut ilmu itu wajib atas setiap muslim.\" (HR. Ibnu Abdurrahman)\n",
            "\"Barangsiapa yang Allah menginginkan kebaikan baginya, maka akan dipahamkan akan agamanya.\"\n(HR. Bukhari, Muslim)",
            "\"Barangsiapa yang beriman kepada Allah dan hari akhir maka hendaknya dia berkata yang baik atau diam.\"" +
                    "(HR. Bukhari, Muslim)",
            "\"Malu itu sebagian dari iman.\" (HR. Muttafaq'alaih)",
            "\"Sebarkanlah salam diantara kamu.\" (HR. Muslim)",
            "\"Surga itu dibawah telapak kaki ibu.\" (HR. Ahmad)",
            "\"Sesungguhnya Allah itu maha indah dan mencintai keindahan.\"\n" +
                    "(HR. Muslim, Ahmad dan At-Tirmidzi)",
            "\"Sebaik baik kalian adalah orang yang belajar Al Quran dan yang mengajarkannya.\" (HR. Bukhari)\n",
            "\"Kerjakanlah shalat tepat pada waktunya.\" (HR. Muslim)\n",
            "\"Jagalah Allah niscaya Dia akan menjagamu, jagalah Allah niscaya kamu dapati Dia dihadapanmu.\" " +
                    "(HR. Tirmidzi)\n",
            "\"Katakanlah yang benar walau pahit sekalipun.\" (HR. Baihaqi)\n",
            "\"Doa itu adalah ibadah.\" (HR. At-Tirmidzi)",
            "\"Setengah dari bukti kebaikan Islamnya seseorang ialah meninggalkan sesuatu yang tidak berguna baginya.\" " +
                    "(HR. Tirmidzi)",
            "\"Jauihilah olehmu berburuk sangka.\" (HR. Muttafaq'alaih)",
            "\"Rasulullah SAW sama sekali tidak pernah mencela makanan.\" (HR. Muttafaq'alaih)\n",
            "\"Allah senantiasa menolong hambaNya, selama hambaNya suka menolong saudaranya.\" (HR. Muslim)\n",
            "\"Wahai anak kecil, bacalah basmalah dan makanlah dengan tangan kananmu dan ambilah yang terdekat darimu.\" " +
                    "(HR. Bukhari, Muslim)\n",
            "\"Bertaqwalah kepada Allah dimanapun kamu berada.\" (HR. Tirmidzi)\n",
            "\"Siwak itu pembersih mulut dan merupakan penyebab keridhaan dari Allah.\" (HR. An-Nasa’i)\n",
            "\"Jagalah lisanmu.\" (HR. Tirmidzi)\n",
            "\"Sesungguhnya amalan hamba yang pertama kali dihisab pada hari kiamat adalah shalat.\" (HR. Tirmidzi)",
            "\"Janganlah engkau saling membahayakan dan jangan saling merugikan.\""



    };

    int[] list_musik = {
            R.raw.hadist_keutamaan_senyum,
            R.raw.hadist_saling_menyayangi,
            R.raw.hadist_penutup_aurat,
            R.raw.hadist_menahan_marah,
            R.raw.hadist_niat,
            R.raw.hadist_jangan_suka_marah,
            R.raw.hadist_muslim_bersaudara,
            R.raw.hadist_agama,
            R.raw.hadist_kebersihan,
            R.raw.hadist_kebaikan,
            R.raw.hadist_menuntut_ilmu,
            R.raw.hadist_paham_agama,
            R.raw.hadist_berkata_baik,
            R.raw.hadist_malu,
            R.raw.hadist_menyebar_salam,
            R.raw.hadist_kemuliaan_ibu,
            R.raw.hadist_allah_mata_indah,
            R.raw.hadist_keutamaan_belajar_alquraan,
            R.raw.hadiat_sholat_tepat_waktu,
            R.raw.hadist_menjaga_agama_allah,
            R.raw.hadist_berkata_benar,
            R.raw.hadist_keutamaan_doa,
            R.raw.hadist_keutamaan_seorang_muslim,
            R.raw.hadist_larangan_buruk_sangka,
            R.raw.hadist_larangan_mencela_makanan,
            R.raw.hadist_tolong_menolong,
            R.raw.hadist_makan_dengan_tangan_kanan,
            R.raw.hadist_perintah_taqwah,
            R.raw.hadist_keutamaan_bersiwak,
            R.raw.hadist_menjaga_lisan,
            R.raw.hadist_keutamaan_shalat,
            R.raw.hadist_laranga_berbuar_kerusakan
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hadist);

        listHadist = findViewById(R.id.hadist);

        CustomHadistAdapter adapter = new CustomHadistAdapter(this, judulHadist, ayatHadist, artiHadist);

        listHadist.setAdapter(adapter);

        listHadist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),judulHadist[position],
                        Toast.LENGTH_SHORT).show();
                Uri myUri = Uri.parse("android.resource://" + getPackageName() + "/" + list_musik[position]);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(getApplicationContext(), myUri);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
            }

        });


    }
}
