package com.gamal.learnjetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gamal.learnjetpack.ui.theme.ButtonBlue
import com.gamal.learnjetpack.ui.theme.DarkerButtonBlue
import com.gamal.learnjetpack.ui.theme.LightRed
import com.gamal.learnjetpack.ui.theme.LightRed2
import com.gamal.learnjetpack.ui.theme.TextWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(

        content = { paddingValues -> Column(modifier = Modifier.padding(paddingValues)) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.White))
            {
                Column (Modifier.fillMaxSize()){
                    TopBar()
                    Stories(listOf(ImageWithText(painterResource(id = R.drawable.gamal),"Your story"),
                            ImageWithText(painterResource(id = R.drawable.abdo),"Abdulaiz Hassan"),

                            ImageWithText(painterResource(id = R.drawable.dd),"ahmed_albrens"),
                            ImageWithText(painterResource(id = R.drawable.gh),"amany_ta"),
                            ImageWithText(painterResource(id = R.drawable.images), "alvirus alsa5er"),
                            ImageWithText(painterResource(id = R.drawable.stevdza_san),"stevdza_san"),
                            ImageWithText(painterResource(id = R.drawable.wad3),"wade3_kadsh"),))
                    Posts(listOf(Post(painterResource(id = R.drawable.jasera),"Aljazeera","jasera_insgram",
                        painterResource(id = R.drawable.post1),"#عاجل | مصادر للجزيرة: كتائب القسام سلمت 24 محتجزا بينهم العمال التايلانديون\n" +
                                "يمكنكم متابعة تطورات #حرب_غزة عبر قناة #الجزيرة على واتساب: https://aja.me/csamyu"),
                        Post(painterResource(id = R.drawable.mpm),"Kelyan Mpappe","kelyan_mpappe26",
                        painterResource(id = R.drawable.kylian_mbappe),"ريال مدريد أعلن قبل فترة عن تعاقده مع مبابي في صفقة انتقال حر عقب انتهاء عقده مع باريس سان جيرمان.")))


                  /*  greatingView("Gamal")
                    chips(listOf("Sweet sleep","Insomina","Depressic"),navController)
                    dailyThought()
                    var f1=Featured("Sleep meditiaion",R.drawable.ic_headphone,BlueViolet1,BlueViolet2,BlueViolet3)
                    var f2=Featured("Tips for sleeping",R.drawable.ic_videocam, LightGreen1,LightGreen2,LightGreen3)
                    var f3=Featured("Night island",R.drawable.ic_moon, OrangeYellow1,OrangeYellow2,OrangeYellow3)
                    var f4=Featured("Calming sound",R.drawable.music, Beige1,Beige2,Beige3)
                    featuredList(features = listOf(f1,f2,f3,f4),navController)*/

                } }
        }
    })




}

@Composable
fun Posts(Posts:List<Post>) {
    LazyColumn (Modifier.padding(top = 12.dp)){
        items(Posts.size){
            Column (
                Modifier
                    .fillMaxWidth()){
                UserNamePost(Posts[it])
                Image(painter = Posts[it].postImg, contentScale = ContentScale.FillWidth, contentDescription ="", modifier = Modifier.padding(top=4.dp))
                ButtonsPost()
                LikesAndDesc(Posts[it])

            }

        }
    }

 }

@Composable
fun LikesAndDesc(post : Post) {
    Column(modifier = Modifier
        .padding(start = 8.dp, end = 8.dp)){
            Text(text =  "Like by nayf and 4,555,338 others", color=Color.Black, fontSize = 10.sp, modifier = Modifier.padding(top = 2.dp),fontFamily = FontFamily(Font(R.font.poppins)))
            Text(text = post.name+"  "+post.text , color=Color.Black, fontSize = 11.sp, modifier = Modifier.padding(top = 2.dp),fontFamily = FontFamily(Font(R.font.poppins_medium)))

        }

}

@Composable
fun ButtonsPost() {
    Row (modifier = Modifier.padding(8.dp)){
        Row (Modifier.weight(1f,true)){
            Icon(painter = painterResource(id = R.drawable.love), contentDescription = "",modifier = Modifier.padding(end = 16.dp).size(25.dp))
            Icon(painter = painterResource(id = R.drawable.comment), contentDescription = "",modifier = Modifier.padding(end = 16.dp).size(25.dp))
            Icon(painter = painterResource(id = R.drawable.sent), tint = Color.Black, contentDescription = "",modifier = Modifier.padding(end = 25.dp).size(25.dp))
        }
        Icon(painter = painterResource(id = R.drawable.save), contentDescription = "",modifier = Modifier.padding(end = 8.dp).size(25.dp))

    }
}

@Composable
fun UserNamePost(post: Post) {
Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier .padding(start=8.dp, top = 12.dp), horizontalArrangement =  Arrangement.SpaceBetween){
    Image(painter =   post.icon, contentScale = ContentScale.Inside, contentDescription ="" , modifier = Modifier
        .size(50.dp)
        .border(
            width = 1.5.dp,
            brush = Brush.horizontalGradient(
                listOf(
                    colorResource(id = R.color.yallow),
                    colorResource(id = R.color.zahry)
                )
            ),
            shape = CircleShape
        )
        .padding(4.dp)
        .clip(CircleShape))
    Column(modifier = Modifier
        .padding(start = 4.dp)
        .weight(1f, true)) {
        Text(text =  post.name, color=Color.Black, fontSize = 12.sp, modifier = Modifier.padding(top = 2.dp),fontFamily = FontFamily(Font(R.font.poppins_bold)))
        Text(text =  post.userName, color=Color.Black, fontSize = 10.sp, modifier = Modifier.padding(top = 2.dp),fontFamily = FontFamily(Font(R.font.poppins_light)))
    }

    Icon(imageVector =  Icons.Default.MoreVert, contentDescription ="MoreVert", modifier = Modifier.padding(end = 8.dp))


}
}

@Composable
fun Stories(items:List<ImageWithText>) {
    LazyRow (){
        items(items.size){
            Column (Modifier.padding( start = 8.dp, end = 8.dp), horizontalAlignment = Alignment.CenterHorizontally){
                Image(painter =   items[it].image, contentScale = ContentScale.Inside, contentDescription ="" , modifier = Modifier
                    .size(80.dp)
                    .border(
                        width = 1.5.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                colorResource(id = R.color.yallow),
                                colorResource(id = R.color.zahry)
                            )
                        ),
                        shape = CircleShape
                    )
                    .padding(4.dp)
                    .clip(CircleShape)

                )

                Text(text =  items[it].text, color=Color.Black, fontSize = 12.sp, modifier = Modifier.padding(top = 2.dp),fontFamily = FontFamily(Font(R.font.poppins_light)))
            }

        }
    }

}

@Composable
fun TopBar() {
    Box (
        Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)){
        Image(painter = painterResource(id = R.drawable.word_instagram), contentDescription = "", modifier = Modifier
            .align(Alignment.CenterStart)
            .size(110.dp))
Row (modifier = Modifier.align(Alignment.CenterEnd), verticalAlignment = Alignment.CenterVertically){
    Icon(painter = painterResource(id = R.drawable.love), contentDescription = "",modifier = Modifier
        .padding(end = 16.dp)
        .size(30.dp))
    Icon(painter = painterResource(id = R.drawable.msng), contentDescription = "",modifier = Modifier.size(30.dp))

}
    }
}

@Composable
fun greatingView(name: String) {
    Row(
        Modifier
            .padding(all = 20.dp)
            .padding(top = 36.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
        Column {
            Text(
                stringResource(id = R.string.Good_Morning,name), fontSize = 24.sp,
                color = TextWhite,
                style = MaterialTheme.typography.labelLarge,
                fontFamily = FontFamily(Font(R.font.poppins_medium))
            )

            Text(text = stringResource(id = R.string.we_wish_you_have_a_good_day),
                fontSize = 18.sp,
                color = colorResource(id = R.color.darktext_color),
                style = MaterialTheme.typography.bodyLarge)
        }
        Icon(painter = painterResource(id = R.drawable.ic_search), tint = Color.White, contentDescription = "search")
    }




}
@Composable
fun chips(chips: List<String>, navController: NavHostController){

var selected by remember { mutableStateOf(0) }

    LazyRow{
        items(chips.size){
            Box (
                Modifier
                    .padding(top = 18.dp, start = 14.dp, end = 14.dp)

                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        if (selected == it) {
                            ButtonBlue
                        } else {
                            DarkerButtonBlue
                        }
                    )
                    .padding(15.dp)
                    .clickable
                    {
                        selected = it

                    }){


                Text(text = chips[it], color=Color.White, fontSize = 16.sp,fontFamily = FontFamily(Font(R.font.poppins_medium)))
            }
        }
    }

}

@Composable
fun dailyThought(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 15.dp, end = 15.dp, top = 24.dp)
        .clip(RoundedCornerShape(15.dp))
        .background(
            Brush.horizontalGradient(
                listOf(LightRed2, LightRed),
                startX = 50f,


                )
        )) {
        Row(
            Modifier
                .padding(all = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    stringResource(id = R.string.dailyThought), fontSize = 24.sp,
                    color = TextWhite,
                    style = MaterialTheme.typography.labelLarge,
                    fontFamily = FontFamily(Font(R.font.poppins_medium))
                )

                Text(
                    text = stringResource(id = R.string.mediation_3_10_min),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.darktext_color),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Box( contentAlignment = Alignment.Center,modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)){
                Icon(
                    painter = painterResource(id = R.drawable.play),
                    tint = Color.White,
                    contentDescription = "play"
                )
            }

        }
    }
}

@Composable
fun featuredList(features: List<Featured>,navController: NavHostController){
Column (
    Modifier
        .fillMaxWidth()
        .padding(15.dp)){
    Text(
        text = stringResource(id = R.string.Featured),
        fontSize = 24.sp,
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        color = colorResource(id = R.color.white),
        style = MaterialTheme.typography.bodyLarge
    )
}

    LazyVerticalGrid(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),columns = GridCells.Fixed(2), content = {
        items(features.size) { item ->
            itemFeatured(item = features.get(item),navController)}
    })
}

@Composable
fun itemFeatured(item: Featured, navController: NavHostController) {
    Box(
        Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                Brush.verticalGradient(
                    listOf(
                        item.third,
                        item.second,
                        item.first
                    ),
                    startY = 50f,
                )
            )
            .fillMaxSize()

            ){
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(12.dp),
            text =item.title,
            fontSize = 24.sp,
            color = colorResource(id = R.color.white),
            style = MaterialTheme.typography.bodyLarge
        )

        Icon(painter = painterResource(id = item.icon),tint= Color.White, contentDescription ="" , modifier = Modifier
            .padding(top = 120.dp, bottom = 20.dp, start = 20.dp)
            .align(Alignment.BottomStart)
            )

            Text(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 20.dp, end = 20.dp)
                    .clip(RoundedCornerShape(12.dp))

                    .background(ButtonBlue)

                    .padding(8.dp)
                    .clickable {
                        navController.navigate("instagram_profile/gamal_najeeb")

                    }

                ,
                text = stringResource(id = R.string.start),
                fontSize = 16.sp,

                color = colorResource(id = R.color.white),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }




