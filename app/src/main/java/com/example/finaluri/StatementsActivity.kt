package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StatementsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statements)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerViewItemAdapter(getItemData())


    }
    private fun getItemData(): List<Item>{
        val itemList = ArrayList<Item>()
        itemList.add(
            Item(
                1,
                "https://live.staticflickr.com/7357/9215846664_85251c549d_b.jpg",
                "photinia nana",
                "იყიდება, plantcton@gmail.com",
            )
        )
        itemList.add(
            Item(
                2,
                "https://interiorpros.files.wordpress.com/2015/07/cropped-img_1936.jpg",
                "String of bananas",
                "For Sale, flowers@gmail.com",
            )
        )
        itemList.add(
            Item(
                3,
                "https://cdn.shopify.com/s/files/1/0598/5271/8266/products/Aeonium-Zwartkop-Alamy_1024x1024@2x.jpg?v=1650643720",
                "Aeonium arboreum zwartkop",
                "Contact: plantcton@gmail.com",
            )
        )
        itemList.add(
            Item(
                4,
                "https://plantingman.com/wp-content/uploads/2020/10/Agave-potatorum-var.-verschaffeltii-Succulent-plants.jpg",
                "Agave Potatorum ",
                "potatorum@gmail.com",
            )
        )
        itemList.add(
            Item(
                5,
                "https://images.cactuseros.com/Imagenes/CactusUsuarios/FoxPro/133017.jpg",
                "sedum luteoviride",
                "20$. potaturum@gmail.com",
            )
        )
        itemList.add(
            Item(
                6,
                "https://n4.sdlcdn.com/imgs/k/e/f/BlackRose-85ee4.jpg",
                "Black Rose",
                "40GEL. rosashop@gmail.com",
            )
        )
        itemList.add(
            Item(
                7,
                "https://i.pinimg.com/736x/7f/f3/3f/7ff33fae1896f12a779a5640f7c8d232.jpg",
                "Red Rose",
                "rosashop@gmail.com",
            )
        )
        itemList.add(
            Item(
                8,
                "https://www.supersadovnik.ru/binfiles/images/20181016/b532e7f2.jpg",
                "Hydrangea",
                "flower@gmail.com"
            )
        )
        itemList.add(
            Item(
                9,
                "https://flowermag.com/wp-content/uploads/2018/03/shutterstock-warwick-foxglove-plant-1000x1000.jpg",
                "Fox Gloven",
                "12 GPB. bbb@gmail.com",
            )
        )



        itemList.add(
            Item(
                10,
                "https://littleprinceplants.com/wp-content/uploads/2020/08/Kalanchoe-eriophylla-Snow-White-Panda-Plant-Bloom-scaled.jpg",
                "Kalanchoe-Eriophylla",
                "letsbuyflower@gmail.com",
            )
        )
        itemList.add(
            Item(
                11,
                "https://www.mydomaine.com/thmb/viLFU754Mg922J4rd4ucTDokTSY=/2119x1192/smart/filters:no_upscale()/GettyImages-949430328-72b1d6615a79469d82b675f4b0966b8a.jpg",
                "Panda Plant",
                "mdmd@gmail.com. For sale.",
            )
        )
        itemList.add(
            Item(
                12,
                "https://succulentsnetwork.com/wp-content/uploads/2021/02/Screenshot-2021-02-08-at-09.54.01.png",
                " Potatorum",
                "flowerbuy@gmail.com For Info.",
            )
        )
        itemList.add(
            Item(
                13,
                "https://orchidwubben.com/wp-content/uploads/2021/09/Dendrobium-victoria-reginae.jpg",
                "Dendrobium-Victoria-Reginae",
                "20 EUR plantium@gmail.com",
            )
        )
        itemList.add(
            Item(
                14,
                "https://plantcaretoday.com/wp-content/uploads/agave-victoriae-200-630-FB-05312019-min.jpg",
                "Victoriae Reginae",
                "Contact: plantium@gmail.com",
            )
        )
        itemList.add(
            Item(
                15,
                "https://cdn.webshopapp.com/shops/107930/files/325284851/notocactus-leninghausii-cv-nudum.jpg",
                "Notocactus-leninghausii-",
                "6.90EUR. cactusbuy@gmail.com",
            )
        )
        itemList.add(
            Item(
                16,
                "https://images.immediate.co.uk/production/volatile/sites/10/2018/08/4a363516-de0f-4113-a2c5-8e3f9682c403-efed791.jpg?quality=90&resize=960%2C640",
                "Mammillaria Hahniana",
                "plantium@gmail.com",
            )
        )



        return itemList
    }

}