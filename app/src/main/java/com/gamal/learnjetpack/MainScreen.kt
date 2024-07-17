package com.gamal.learnjetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen() {

    var navController= rememberNavController()


    Scaffold(bottomBar = {BottomBar(navController)}){
            paddingValues -> Column(modifier = Modifier.padding(paddingValues)) { }

        NavigationController(navController)
    }





}

@Composable
fun BottomBar(navController: NavHostController) {

    NavigationBar (modifier = Modifier.fillMaxWidth(), containerColor = Color.White,tonalElevation=50.dp){
        var items= getListOfItem();
        items.forEach{item->

         NavigationBarItem(selected = navController.currentDestination?.route==item.route,
                onClick ={navController.navigate(item.route){
                    launchSingleTop = true
                    restoreState = true
                } },
                icon = {
                    Image(   painter = painterResource(id = item.icon), contentDescription = item.route,
                    modifier = Modifier
                        .clip(Shape(item))
                        .size(24.dp))}

            )

             }


        }
    }

fun Shape(item: BottomNavItem): RoundedCornerShape {
    if (item.route.contains("profile")){
        return CircleShape
    }
return RoundedCornerShape(0.dp);
}


fun getListOfItem():List<BottomNavItem>{
    return listOf(
        BottomNavItem(R.drawable.home,"home"),
        BottomNavItem(R.drawable.ic_search,"search"),
        BottomNavItem(R.drawable.add,"add"),
        BottomNavItem(R.drawable.instagram_reels_seeklogo,"reals"),
        BottomNavItem(R.drawable.gamal,"profile/gamal_najeeb"))
}
