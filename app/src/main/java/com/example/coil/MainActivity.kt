package com.example.coil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.coil.ui.theme.CoilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilTheme {
                Cartas()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cartas() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Imágenes con Coil",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }


                        },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    CartaPost(
                        username = "its_m3ndo",
                        profileImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKQiC0s43rOZ5NWHWNDFWIL7k14C5Kgqadmg&s",
                        postImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqDztr9VCk90qMMMJKOstI8UpnMfSmX21A3w&s",
                        description = "Hermosa vista desde mi casa"
                    )
                }
                item {
                    CartaPost(
                        username = "cdolimpia",
                        profileImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYmuBEhgo6Lg0kbhsMGe-EQglt69jkYTA2KQ&s",
                        postImageUrl = "https://ds-images.bolavip.com/news/image?src=https%3A%2F%2Fimages.futbolcentroamerica.com%2Fjpg%2Ffull%2FFCA_20230506_FCA_8901_El-jugador-de-CD-Olimpia-que-tiene-chances-de-salir-al-extranjero.jpg&width=1200&height=740",
                        description = "Ruge el león"
                    )
                }
                item {
                    CartaPost(
                        username = "riotgames",
                        profileImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZ6wJVokmxBCIgoIAFnuntPBwbA7aMCV9awA&s",
                        postImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwr4Xe17Q6K1GbhZFlgiVqWpBpHo5LFj5o3w&s",
                        description = "Explorando mundos"
                    )
                }
            }
        }
    )
}

@Composable
fun CartaPost(
    username: String,
    profileImageUrl: String,
    postImageUrl: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(profileImageUrl),
                    contentDescription = "User Image",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = username,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Image(
                painter = rememberAsyncImagePainter(postImageUrl),
                contentDescription = "Post Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(4 / 3f)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Like Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.Comment,
                    contentDescription = "Comment Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = "Save Icon",
                    modifier = Modifier.size(24.dp)
                )
            }



            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CoilTheme {
        Cartas()
    }
}
