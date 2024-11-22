package com.example.pam_nvvm2_andini_copy.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam_nvvm2_andini_copy.R
import com.example.pam_nvvm2_andini_copy.model.Mahasiswa
import com.example.pam_nvvm2_andini_copy.model.RencanaStudy


@Composable
fun TampilView(
    mahasiswa: Mahasiswa,
    rencanaStudy: RencanaStudy,
    onBackToMainClicked: () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(
                    id = R.color.primary
                )
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(16.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.logoumy
                ),
                contentDescription = "",
                modifier = Modifier.size(45.dp)
            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column {
                Text(
                    text = "Data Mahasiswa",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topEnd = 15.dp,
                        topStart = 15.dp
                    )
                )
                .fillMaxSize(),
        ) {
            val listDataTampil = listOf(
                Pair("NIM", mahasiswa.nim),
                Pair("Nama", mahasiswa.nama),
                Pair("Email", mahasiswa.email),
                Pair("Mata Kuliah", rencanaStudy.mataKuliah),
                Pair("Kelas", rencanaStudy.kelas)
            )

           }
    }
}

@Composable
//Menampilkan isi data
fun CardSection(judulParam:String, isiParam:String){
    Column (horizontalAlignment = Alignment.Start, modifier = Modifier.padding(8.dp)){

        Row (modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$isiParam", modifier = Modifier.weight(2f))
        }
    }
}