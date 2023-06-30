package com.example.composetutorial


import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar


import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() { //app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityScreen()
            obtenerResumenUsuarios()

        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainActivityScreen() {
        Scaffold(
            topBar = {
                TopAppBar(
                    //title = { Text("Datos de la aplicación") }
                    content = {

                    }
                )
            },
            content = {
                /* Box(
                    modifier = Modifier.fillMaxSize(*/
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            //.height(IntrinsicSize.Min)
                            .fillMaxHeight(0.5f)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(Color(0xFFFF6363), Color(0xFF4E7AFF)),
                                    start = Offset(0f, 0f), // Punto de inicio en la parte superior
                                    end = Offset(
                                        0f,
                                        Float.POSITIVE_INFINITY
                                    ) // Punto final en la parte inferior
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                        ) {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            //.height(100.dp)
                                            .wrapContentHeight()
                                            .padding(26.dp)

                                            .clip(
                                                shape = RoundedCornerShape(
                                                    topStart = 0.dp,
                                                    topEnd = 0.dp,
                                                    bottomStart = 0.dp,
                                                    bottomEnd = 46.dp
                                                )
                                            )
                                            .background(Color.White, RoundedCornerShape(8.dp)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "Admin",
                                            style = MaterialTheme.typography.h6,
                                            modifier = Modifier
                                                .align(Alignment.Center)
                                                .padding(16.dp)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            // .height(150.dp)
                                            .wrapContentHeight()
                                            .padding(26.dp)
                                            .clip(
                                                shape = RoundedCornerShape(
                                                    topStart = 0.dp,
                                                    topEnd = 0.dp,
                                                    bottomStart = 0.dp,
                                                    bottomEnd = 46.dp
                                                )
                                            )
                                            .background(Color.White, RoundedCornerShape(8.dp))
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .padding(4.dp)
                                                .align(Alignment.Center)
                                        ) {
                                            Text(
                                                text = "Asesores de Clientes",
                                                style = MaterialTheme.typography.h6,
                                                modifier = Modifier.scale(0.8f)
                                            )
                                            Text(
                                                text = "2",
                                                style = MaterialTheme.typography.h6,
                                                modifier = Modifier.scale(0.8f)
                                            )
                                        }
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier

                                            .fillMaxWidth()
                                            .wrapContentHeight()
                                            .padding(16.dp)
                                            .clip(
                                                shape = RoundedCornerShape(
                                                    topStart = 0.dp,
                                                    topEnd = 0.dp,
                                                    bottomStart = 0.dp,
                                                    bottomEnd = 46.dp
                                                )
                                            )
                                            .background(Color.White, RoundedCornerShape(8.dp)),

                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "Asesores Comerciales",
                                            style = MaterialTheme.typography.h6,
                                            modifier = Modifier
                                                .align(Alignment.Center)
                                                .padding(16.dp)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            //.height(70.dp)
                                            .padding(16.dp)
                                            .clip(
                                                shape = RoundedCornerShape(
                                                    topStart = 0.dp,
                                                    topEnd = 0.dp,
                                                    bottomStart = 0.dp,
                                                    bottomEnd = 46.dp
                                                )
                                            )
                                            .background(Color.White, RoundedCornerShape(8.dp))
                                            .wrapContentHeight()
                                    ) {
                                        Text(
                                            text = "Usuarios de Plataforma",
                                            style = MaterialTheme.typography.h6,
                                            modifier = Modifier
                                                .align(Alignment.Center)
                                                .padding(16.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    UserListScreen()
                }

            }
        )

    }


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun UserListScreen() {
        val userList = listOf(
            User("John Doe", "Administrador", true, "2023-06-30"),
            User("Jane Smith", "Asesor de Clientes", true, "2023-06-28"),
            User("Mike Johnson", "Asesor Comercial", true, "2023-07-01")
        )


        LazyColumn {
            items(userList) { user ->
                UserCard(user)
            }
        }


    }

    @Composable
    fun UserCard(user: User) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 10.dp)
                    ) {
                        Text(
                            text = user.name,
                            style = MaterialTheme.typography.body1
                        )
                        Text(
                            text = user.userType,
                            style = MaterialTheme.typography.caption,
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Día off",
                            style = MaterialTheme.typography.body1
                        )
                        Text(
                            text = "${user.date}",
                            style = MaterialTheme.typography.caption,

                            )
                    }


                }

            }
        }

    }


    data class User(
        val name: String,
        val userType: String,
        val isDayOff: Boolean,
        val date: String
    )



fun obtenerResumenUsuarios() {
    val db = Firebase.firestore
  db.collection("usuarios")
    .get()
    .addOnSuccessListener { result ->
        for (document in result) {
            Log.d(TAG, "${document.id} => ${document.data}")
        }
    }
    .addOnFailureListener { exception ->
        Log.w(TAG, "Error getting documents.", exception)
    }
}

}