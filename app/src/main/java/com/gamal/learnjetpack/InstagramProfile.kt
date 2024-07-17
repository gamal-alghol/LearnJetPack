package com.gamal.learnjetpack

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun InstagramProfile(navController: NavHostController, userName: String) {

    var selected by remember {
        mutableStateOf(0)
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        topLayout(userName)
        ImageAndNumsSection()
        pio()
        Buttons()

        tapRow(
             listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                ),
            )
        ){
            selected=it
        }

        when(selected){
            0 ->posts(listOf(R.drawable.dd,R.drawable.gamal,R.drawable.logo))

        }
    }

}

@Composable
fun topLayout(userName: String) {
    Box (
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)){
        Row (modifier=Modifier.align(Alignment.CenterStart), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
            Icon(imageVector =  Icons.AutoMirrored.Default.ArrowBack, contentDescription ="Back")
            Text(text = userName,modifier=Modifier.padding(start=8.dp), fontSize = 24.sp, overflow = TextOverflow.Ellipsis)

        }
        Row (modifier=Modifier.align(Alignment.CenterEnd),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Icon(painter =  painterResource(id = R.drawable.ic_bell), contentDescription ="bell",Modifier.padding(top = 16.dp, start = 16.dp))
            Icon(imageVector =  Icons.Default.MoreVert, contentDescription ="bell",Modifier.padding(top = 16.dp, start = 16.dp))
        }
    }

}


@Composable
fun ImageAndNumsSection() {
    Row (
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround){
        Image(painter = painterResource(id = R.drawable.gamal), contentDescription ="my_image",
            Modifier
                .clip(CircleShape)
                .size(90.dp)
                .border(width = 1.5.dp, color = Color.LightGray, shape = CircleShape))

        TextNum("601","Posts")
        TextNum("99.4k","Followers")
        TextNum("80","Following")
    }


}

@Composable
fun TextNum(nums: String, des: String) {
    Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = nums,modifier=Modifier.padding(start=8.dp), fontSize = 20.sp, overflow = TextOverflow.Ellipsis)
        Text(text = des,modifier=Modifier.padding(start=8.dp, top = 8.dp),color= Color.DarkGray, fontSize = 16.sp, overflow = TextOverflow.Ellipsis)
    }


}
@Composable
fun pio(){
    Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.Start, modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, top = 8.dp, end = 16.dp)) {
        Text(text = "Gamal Najeeb Alghol",modifier=Modifier.padding(start=8.dp),  fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = stringResource(id = R.string.pio),modifier=Modifier.padding(start=8.dp,top = 4.dp),  fontSize = 14.sp)

    }
}


@Composable
fun Buttons() {
    Row (
        Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){
        OutlinedButton(onClick = { /*TODO*/ }, shape  = RoundedCornerShape(8.dp), border = BorderStroke(1.dp, Color.LightGray), modifier = Modifier.padding(end=8.dp)) {
            Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                Text(text = "Following", color = Color.Black, fontWeight = FontWeight.Bold)
                Icon(imageVector =  Icons.Default.KeyboardArrowDown,tint=Color.Black, contentDescription ="KeyboardArrowDown")

            }

        }
        OutlinedButton(onClick = { /*TODO*/ }, shape  = RoundedCornerShape(8.dp), border = BorderStroke(1.dp, Color.LightGray), modifier = Modifier.padding(end=8.dp)) {
            Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                Text(text = "Message", color = Color.Black, fontWeight = FontWeight.Bold)

            }

        }
        OutlinedButton(onClick = { /*TODO*/ }, shape  = RoundedCornerShape(8.dp), border = BorderStroke(1.dp, Color.LightGray), modifier = Modifier.padding(end=8.dp)) {
                Text(text = "Email", color = Color.Black, fontWeight = FontWeight.Bold)


        }

        Row(Modifier.border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp))) {
            Icon(imageVector =  Icons.Default.KeyboardArrowDown,tint=Color.Black, contentDescription ="KeyboardArrowDown", modifier = Modifier.padding( 4.dp))
        }
    }


}

@Composable
fun tapRow(list:List<ImageWithText>,    onTabSelected: (selectedIndex: Int)->Unit) {
    val inactiveColor = Color(0xFF777777)
    var selectedTab by remember{mutableStateOf(0)}
    TabRow(selectedTabIndex = selectedTab,
        containerColor = Color.Transparent,
        indicator = {tabPositions->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedTab])
                    .height(2.dp)
                    .background(color = Color.Black)
            )
        },
        contentColor = Color.Black, modifier = Modifier.fillMaxWidth()) {

        list.forEachIndexed{index,imageWithText ->

            Tab(selected = selectedTab==index, onClick = {
                selectedTab = index
                onTabSelected(selectedTab) }) {
                Icon(
                    painter = imageWithText.image,
                    contentDescription = imageWithText.text,
                    tint = if(selectedTab == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )

            }
        }

        
    }

}
@Composable
fun itemPost(item: Int) {
    Image(painter = painterResource(id = item), contentDescription = "",  contentScale = ContentScale.Crop,
        modifier = Modifier
            .aspectRatio(1f)
            .border(
                width = 1.dp,
                color = Color.White
            )
    )
}



@Composable
fun posts(posts:List<Int>){
    LazyVerticalGrid(columns =  GridCells.Fixed(3), content ={
        items(posts.size) { item ->
            itemPost(item = posts.get(item))}
    })
}
