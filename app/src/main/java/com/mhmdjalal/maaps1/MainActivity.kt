package com.mhmdjalal.maaps1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: PostAdapter
    private var posts: ArrayList<Post> = ArrayList()
    private val titles = arrayOf(
        "Menengok Tokyo, Kota Futuristik yang Membawa Masa Depan",
        "Apa Perbedaan Kopitiam dan Kedai Kopi Kekinian?",
        "Potala, Istana 'Di Atas Awan' yang Sempat Menjadi Rumah Dalai Lama",
        "Kreativitas di Yokohama, Menggabungkan Masa Lalu dan Masa Kini",
        "Echigo-Tsumari Art Field: Ketika Seni Modern Menyatu dengan Alam",
        "Suka Traveling? Ini Cara Menjadi Pejalan yang Bertanggung Jawab Pada Alam",
        "Taj Mahal, Makam Sekaligus Monumen Pembuktian Cinta yang Melegenda",
        "Ingin Mendaki Gunung? Berikut 7 Hal yang Perlu Kita Persiapkan",
        "Bingung Tujuan Liburan di Jakarta, Coba Yuk Berkunjung ke Kota Tua Saat Malam Hari. Dijamin Bikin Ketagihan!",
        "Glenn Fredly Langsung Jatuh Hati dan Sempurnakan Festival Teluk Jailolo 2019"
    )

    private val dates = arrayOf(
        "Jumat, 9 Agustus 2019 | 16:00 WIB",
        "Kamis, 8 Agustus 2019 | 15:54 WIB",
        "Kamis, 8 Agustus 2019 | 14:25 WIB",
        "Selasa, 6 Agustus 2019 | 10:38 WIB",
        "Kamis, 1 Agustus 2019 | 18:04 WIB",
        "Selasa, 30 Juli 2019 | 18:24 WIB",
        "Jumat, 19 Juli 2019 | 14:18 WIB",
        "Senin, 8 Juli 2019 | 09:05 WIB",
        "Kamis, 4 Juli 2019 | 18:40 WIB",
        "Senin, 1 Juli 2019 | 19:45 WIB"
    )

    private val imageUrls = arrayOf(
        "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/2019/08/08/330513345.png",
        "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/nationalgeographic/201501151130072_b.jpg",
        "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/2018/08/31/507287838.jpg",
        "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/2019/08/05/1776875239.png",
        "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/2019/08/01/3049587559.png",
        "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/nationalgeographic/201512171725369_b.jpg",
        "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/nationalgeographic/201605241842226_b.jpg",
        "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/nationalgeographic/201306100632510_b.jpg",
        "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/2019/07/04/1829300550.jpg",
        "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/2019/07/01/2445994089.jpeg"
    )

    private val overviews = arrayOf(
        "Nationalgeographic.co.id - Pengalaman menelusuri Jepang terasa seperti masuk ke lorong waktu menuju masa depan. Sebagai salah satu negeri yang paling bersemangat memanfaatkan teknologi di kehidupan keseharian, Jepang menjadi unik tak ada duanya di muka Bumi.\n\n" +
                "Kereta super cepat, hotel tabung, sampai banyaknya mesin pintar makanan dan minuman di tepi jalan membuat Negeri Matahari Terbit ini seperti hidup berdekade lamanya di masa depan.\n\n" +
                "Berdasarkan Innovation Cities Index 2018, bahkan Tokyo dinobatkan sebagai Kota Paling Futuristik Sedunia. Mengungguli kota-kota modern lainnya seperti London, Boston, dan New York.\n\n" +
                "Menurut Christopher Hire dari lembaga 2thinknow yang melakukan studi untuk Innovation Citiex Index, Tokyo terpilih karena ia menunjukkan arah yang jelas dalam menyambut perubahan teknologi.",
        "Owner Ya Kun Kaya Toast Indonesia, Lanny Budiman ditemui di acara peluncuran varian makanan dan minuman bari di Ya Kun Kaya Toast Plaza Indonesia, Jakarta, Kamis (1/8/2019) menyebutkan hal yang paling membedakan kopitiam dengan kedai kopi modern adalah alat pembuat kopi.\n\n" +
                "Kedai kopi modern mengandalkan mesin pembuat kopi modern, sedangkan kopi tiam mengandalkan alat tradisional yakni teko berukuran besar dengan leher panjang. Teko ini dilengkapi saringan tradisional untuk menyaring ampas kopi.",
        "Berdiri 12.139 di atas permukaan laut, Potala merupakan istana tertinggi di dunia. Strukturnya yang berusia 1.300 tahun, dibangun sebagai tanda cinta. Menjadi kado pernikahan dari raja Tibet, Songsten Gambo, kepada Putri Wencheng dari Dinasti Tang Tiongkok.\n\n" +
                "Ketika para biksu datang untuk memerintah Tibet, Istana Potala diperluas dan diubah menjadi rumah musim dingin bagi Dalai Lama.\n" +
                "Namun, setelah Dalai Lama diasingkan ke India pada 1959, pemerintah Tiongkok pun mengambil alih dan membuatnya menjadi museum.",
        "Nationalgeographic.co.id – Saya mencoba membayangkan situasi Yokohama ketika ia hanyalah desa nelayan kecil dan belum menjadi kota besar yang ramai seperti sekarang. Ya, berbicara tentang Yokohama, kehidupannya yang sederhana perlahan berubah ketika Matthew C.Perry bersama dengan armada dan kapal perang Angkatan Laut AS menginjakkan kakinya di kota tetangga Kanagawa pada 1853.\n\n" +
                "Lima tahun setelah kedatangan armada AS tersebut, Kanagawa ditetapkan sebagai pelabuhan pertama Jepang di bawah Perjanjian Harris 1858. Dengan begitu, orang-orang asing pun bisa tinggal dan berdagang di sana. Sayangnya, Kanagawa saat itu juga menjadi salah satu pos penting dan jalanan utama sehingga pemerintah Jepang tidak suka jika ada orang asing yang bisa mengaksesnya dengan bebas.\n\n" +
                "Sebagai gantinya, mereka kemudian mendirikan pelabuhan di Yokohama, yang terisolasi dari jalan raya.\n\n" +
                "Seiring berjalannya waktu, Yokohama pun berkembang pesat menjadi salah satu pelabuhan utama dan pusat perdagangan Jepang.",
        "Nationalgeographic.co.id - Perjalanan mobile journalism saya kali ini dimulai dari Echigo Tsumari, Jepang. Sebuah perjalanan visual pencarian bukti agar lebih memahami bagaimana Jepang begitu melestarikan nilai-nilai bangsanya melewati berbagai era dan tren.\n\n" +
                "Jepang dikenal berhasil memadu padankan seni modern dengan kehidupan keseharian mereka, tanpa mengubah identitasnya destinasi-destinasi mereka terus menyimpan roh ke\"Jepang-annya\".\n\n" +
                "Sebagai seorang pejalan, saya ingin mencari inspirasi untuk kemudian menjadi bahan bercerita kembali sehingga bisa menjadi hal yang ditiru untuk tempat asal saya.",
        "Nationalgeographic.co.id - Bayangkan Anda sedang berjalan di hutan tropis yang rimbun, tiba-tiba mendengar suara gaduh di antara dedaunan. Buah yang sudah setengah digigit menggelinding di jalur yang Anda lewati. Hanya beberapa saat, Anda beradu mata dengan Monyet Howler (genus Alouatta), salah satu jenis monyet yang terkenal karena teriakannya. Ia mengeluarkan suara geraman sebelum akhirnya melompat ke cabang pohon lebih tinggi.\n\n" +
                "Pertemuan singkat dengan satwa di alam liar seperti ini bisa saja menjadi pengalaman yang menakjubkan dari liburan Anda.\n\n" +
                "Model berwisata di alam semacam ini memang sedang berkembang dan bisa menjadi menjadi sumber dana konservasi yang memang sangat dibutuhkan, sekaligus sarana meningkatkan kesadaran masyarakat akan satwa liar.\n\n" +
                "Namun, ada dampak lain dari perkembangan turisme model ini. Banyak wisatawan, secara tidak sadar, justru membahayakan satwa liar tersebut karena bisa mendorong perburuan ilegal satwa liar atau bahkan melukai mereka.\n\n" +
                "Tapi, tidak berarti Anda harus menghindari pariwisata ke alam liar sama sekali - kita hanya perlu lebih sadar akan dampak yang ditimbulkan terhadap kehidupan satwa liar. Berikut ini lima cara untuk berlibur di alam liar sambil berkontribusi terhadap dunia konservasi dan menjamin kesejahteraan satwa.",
        "Nationalgeographic.co.id - Taj Mahal dikenal sebagai salah satu bangunan paling indah yang pernah diciptakan. Bangunan marmer yang indah di Agra, India, ini merupakan makam yang menjadi monumen pembuktian cinta dari suami kepada istri tersayangnya.\n\n" +
                "Shah Jahan, “Raja Dunia” yang mengambil alih tahta Kerajaan Mughal pada 1628, sangat mencintai ratunya yang dijuluki Mumtaz Mahal atau “Yang Terpilih di Istana”.\n\n" +
                "Para pujangga di istana Mughal, Agra, mengatakan, kecantikan sang ratu bisa membuat bulan menyembunyikan wajahnya karena malu.\n\n" +
                "Kerajaan Mughal mencapai puncak kekuasaan dan kekayaannya saat Shah Jahan memimpin. Meskipun begitu, ia tidak berdaya untuk menghentikan kematian Mumtaz Mahal saat melahirkan anaknya pada 1631.",
        "Nationalgeographic.co.id - Mendaki gunung saat ini telah menjadi trending wisata yang populer dikalangan anak muda.\n\n" +
                "Terutama bagi Kamu yang tengah bosan dengan suasana kota dan menginginkan suasana yang menenangkan, sekaligus memacu adrenalin. Maka mendaki gunung adalah jawabannya.\n\n" +
                "Menembus hutan hujan tropis, menyusuri jalan setapak, menghirup udara sejuk, mendengar kicauan burung berirama dengan desis angin, menikmati dinginnya alam, merupakan sebuah relaksasi yang bisa menghilangkan stres dan membuat kita bahagia.",
        "Nationalgeographic.co.id - Cobalah datang ke Kota Tua di malam hari. Suasana syahdu dan sejuk akan membantumu melepaskan strees dan penat karena seharian beraktivitas.\n\n" +
                "Cahaya Lampu berpendaran dan suasana yang teduh membuatmu bisa menikmati malam di Kota Tua dengan lebih intim.\n\n" +
                "Seperti seorang pemuda bernama Beno (23). Ia membuka website sebuah tur lokal di Jakarta. Ia ingin mencoba pengalaman baru dengan menikmati jalan-jalan di ruang terbuka Jakarta pada malam hari.\n\n" +
                "Baca Juga: Kisah dari Tijuana, Ketika Studio Foto Jalanan Menarik Perhatian Para Migran dan Pengungsi\n\n" +
                "Beno akhirnya memilih group walking tour yang destinasinya ke Kawasan Kota Tua.",
        "Fotokita.net – Acara puncak Festival Teluk Jailolo 2019 berlangsung meriah. Kemeriahan berasal dari dua acara yang digelar di Panggung Festival Teluk Jailolo, Sabtu (29/6) malam. Pertama atraksi Sasadu On The Sea karya koreografer kelas dunia Eko Supriyanto. Dan yang kedua penampilan penyanyi Glenn Fredly.\n\n" +
                "Eko Supriyanto adalah koreografer yang terlibat di balik suksesnya opening ceremony Asian Games 2018 lalu. Atraksi dari pria yang kerap dipanggil Eko Pece itu tampil lebih dahulu. Sasadu On The Sea mengangkat tema Sang Penjaga.\n\n" +
                "Atraksi ini mengajak anak-anak muda agar bangga terlahir di Jailolo. Karena, Jailolo kaya akan rempah. Seperti cengkeh, pala, kopra, gunung, dan laut.  Kekayaan ini harus dijaga bersama. Dan harus bergandengan tangan. Atraksi ini mendapat sambutan luar biasa."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setup toolbar
        setupToolbar()

        // load data
        load()

        // implement to recycler view
        initAdapter()

    }

    fun load() {
        for (i in titles.indices) {
            posts.add(Post(i, titles[i], overviews[i], dates[i], imageUrls[i]))
        }
    }

    fun initAdapter() {
        adapter = PostAdapter(posts) {
            startActivity<DetailPostActivity>("id" to it.id, "title" to it.title, "overview" to it.overview, "date" to it.date, "imgUrl" to it.imageUrl)
        }

        recycler_post.layoutManager = LinearLayoutManager(this)
        recycler_post.isNestedScrollingEnabled = false
        recycler_post.adapter = adapter
    }

    fun setupToolbar() {
        toolbar.setTitleTextAppearance(this, R.style.customToolbarfont)
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("National Geographic")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            startActivity<AboutActivity>()
        }
        return super.onOptionsItemSelected(item)
    }
}
