package com.muslim.islamicplaylists.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.muslim.islamicplaylists.domain.model.Playlist
import com.muslim.islamicplaylists.domain.model.Sections

@Composable
fun HomeScreen(
    viewModel: HomeViewModel= hiltViewModel(),
    navController: NavController,
    modifier: Modifier = Modifier
){

    val state by viewModel.state.collectAsState()
    HomeScreenContent(
        state,
        modifier = modifier
    )
}

@Composable
private fun HomeScreenContent(
    state:List<Sections> ,
    modifier: Modifier
){

    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        item {
            Box(modifier = Modifier.padding(16.dp)){
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column {
                        Text(
                            text = "اهلا بك مجدد "
                        )
                        Text(
                            text = "محمد علي"
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    Icon(
                        modifier = Modifier.padding(6.dp).size(28.dp),
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                    Icon(
                        modifier = Modifier.size(28.dp),
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 52.dp,
                            bottom = 0.dp,
                            start = 0.dp,
                            end =0.dp ,
                        ),
                    contentAlignment = Alignment.Center
                ){
                    SubcomposeAsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                        ,
                        model = "https://i.ytimg.com/vi/SL2CdQ1cqKE/maxresdefault.jpg",
                        contentDescription = null,
                        alignment = Alignment.Center
                    )
                }

            }
        }
        state.forEach { section ->
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(
                        top = 4.dp ,  bottom = 2.dp , start = 16.dp , end = 16.dp
                    ),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text =section.name ,
                        modifier = Modifier,
                    )
                    Text(
                        text ="المزيد" ,
                        modifier = Modifier,
                    )
                }

            }
            item{
                LazyRow (
                    modifier = Modifier.fillMaxWidth().height(180.dp)//.size(width = 180.dp, height = 200.dp),
                   , contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    items(section.playlists){
                        Column(
                            modifier=Modifier
                        ) {
                            SubcomposeAsyncImage(
                                modifier = Modifier.size(width = 140.dp, height = 140.dp),
                                alignment = Alignment.Center,
                                model = it.url,
                                loading = { CircularProgressIndicator(
                                    modifier = Modifier.size(64.dp))
                                    },
                                error = {},
                                contentDescription = null ,
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                modifier = Modifier.size(width = 140.dp, height = 160.dp),
                                text = it.name,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                    }
                }
            }
        }
    }
}