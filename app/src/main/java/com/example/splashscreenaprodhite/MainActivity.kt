package com.example.splashscreenaprodhite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splashscreenaprodhite.ui.theme.Poppins
import com.example.splashscreenaprodhite.ui.theme.SplashscreenAprodhiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashscreenAprodhiteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFFFFFFF)),
                ) {
                    Splash()
                }
            }
        }
    }
}

@Composable
fun Splash() {
    val firstSlidePict = R.drawable.welcome  //resource gambar 1
    val secondSlidePict = R.drawable.welcome2  //resource gambar 2
    val thirdSlidePict = R.drawable.welcome3  //resource gambar 3

    var title by remember {
        mutableStateOf(R.string.firstSlideTitle)  //state untuk title yang valuenya akan berubah
    }

    var caption by remember {
        mutableStateOf(R.string.firstSlideCaption)  //state untuk caption yang valuenya akan berubah
    }

    var currentPict by remember {
        mutableStateOf(firstSlidePict)  //state untuk gambar yang valuenya akan berubah
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp)
            .background(Color(0xFFFFFFFF)), // disini saya memberikan background color berwarna putih
        verticalArrangement = Arrangement.Center,  // kegunaan modifier ini yaitu untuk mensetting agar tampilan bisa ada di tengah
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(58.dp))  // kegunaan spacer ini untuk memberikan jarak atas pada logo aprodhite agar sesuai dengan tampilan yang sudah saya desain

        // disini saya memberikan column lagi untuk membungkus gabar yang akan saya tampilkan
        Column {
            Text(
                text = stringResource(id = title),  // disini saya memberikan text agar keluar output selamat datang
                fontFamily = Poppins, // kegunaan font family ini untuk mengubah agar font yang saya pakai pada tampilan output berubah menjadi poppins
                fontWeight = FontWeight.Bold,  // kegunaan ini yaitu memberikan efek bold pada teks hasil output
                color = Color(0xFFE562B3),  // kegunaan ini yaitu memberikan warna font yaitu pink dengan hex E562B3
                fontSize = 28.sp  // kegunaan ini yaitu memberikan ukuran pada huruf selamat datang
            )

            Text(
                text = stringResource(id = caption),  // kegunaan ini yaitu memberikan output text
                fontFamily = Poppins,  // kegunaan font family ini untuk mengubah agar font yang saya pakai pada tampilan output berubah menjadi poppins
                textAlign = TextAlign.Left,  // kegunaan text align yaitu memberikan posisi agar tulisan ini menjadi rata tengah
                color = Color(0xFF9C9C9C),  // kegunaan ini yaitu memberikan warna font yaitu pink dengan hex 9C9C9C

                fontSize = 13.sp  // kegunaan ini yaitu memberikan ukuran pada huruf selamat datang
            )
            Spacer(modifier = Modifier.height(28.dp))
            Image(
                painterResource(currentPict), // kegunaan painter resource yaitu memanggil gambar splashscreen yang sudah saya taruh di drawable
                contentDescription = "splash image",
                modifier = Modifier
                    .size(300.dp)  // Kegunaan modifier size yaitu untuk menentukan ukuran gambar
            )



            Button(
                onClick = {
                    when (currentPict) {
                        firstSlidePict -> {
                            // Jika gambar saat ini adalah gambar pertama,
                            // ganti gambar ke gambar kedua
                            currentPict = secondSlidePict
                            title = R.string.secondSlideTitle
                            caption = R.string.secondSlideCaption
                        }
                        secondSlidePict -> {
                            // Jika gambar saat ini adalah gambar kedua,
                            // ganti gambar ke gambar ketiga
                            currentPict = thirdSlidePict
                            title = R.string.thirdSlideTitle
                            caption = R.string.thirdSlideCaption
                        }
                        thirdSlidePict -> {
                            // Jika gambar saat ini adalah gambar ketiga,
                            // ganti gambar ke gambar pertama
                            currentPict = firstSlidePict
                            title = R.string.firstSlideTitle
                            caption = R.string.firstSlideCaption
                        }
                    }
                }, // onClick saya kosongkan karena memang belum ingin melakukan sesuatu ketika di klik
                Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),  // kegunaan ini yaitu memberikan padding pada button dan agar tampilan button memanjang
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE562B3)),  // kegunaan ini yaitu memberikan warna pada button agar menjadi pink

            ) { Text("Next", fontSize = 18.sp) }  // kegunaan font size yaitu memberikan efek agar besar teks bisa lebih besar
            Button(
                onClick = {
                    when (currentPict) {
                        firstSlidePict -> {
                            // Jika gambar saat ini adalah gambar pertama,
                            // ganti gambar ke gambar ketiga
                            currentPict = thirdSlidePict
                            title = R.string.thirdSlideTitle
                            caption = R.string.thirdSlideCaption
                        }
                        secondSlidePict -> {
                            // Jika gambar saat ini adalah gambar kedua,
                            // ganti gambar ke gambar pertama
                            currentPict = firstSlidePict
                            title = R.string.firstSlideTitle
                            caption = R.string.firstSlideCaption
                        }
                        thirdSlidePict -> {
                            // Jika gambar saat ini adalah gambar ketiga,
                            // ganti gambar ke gambar kedua
                            currentPict = secondSlidePict
                            title = R.string.secondSlideTitle
                            caption = R.string.secondSlideCaption
                        }
                    }

                }, // onClick saya kosongkan karena memang belum ingin melakukan sesuatu ketika di klik
                Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),  // kegunaan ini yaitu memberikan padding pada button dan agar tampilan button memanjang
                border = BorderStroke(2.dp, Color(0xFFE562B3)),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFAFA), contentColor = Color(0xFFE562B3)),  // kegunaan ini yaitu memberikan warna pada button agar menjadi pink
                //color = Color(0xFFE562B3),
            ) { Text("Previous", fontSize = 18.sp) }  // kegunaan font size yaitu memberikan efek agar besar teks bisa lebih besar
        }
    }


}


// Code dibawah digunakan untuk menampilkan preview dari component Splash
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SplashscreenAprodhiteTheme {
        Splash()
    }
}