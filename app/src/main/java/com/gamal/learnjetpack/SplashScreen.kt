package com.gamal.learnjetpack

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
var scale = remember {
    androidx.compose.animation.core.Animatable(0f)
}
    LaunchedEffect(key1 = true ){
            scale.animateTo(targetValue = .8f, animationSpec = tween(
                durationMillis = 1000,
                easing ={OvershootInterpolator(2f).getInterpolation(it)}
            ))

        delay(2000L)
       navController.navigate("main_screen"){
           popUpTo("splash") { inclusive = false }
       }

    }
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.instagram), contentDescription = "",
            Modifier
                .align(Alignment.Center)
        )
        Column (modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "from",color= Color.Gray, fontSize = 22.sp)
            Image(painter = painterResource(id = R.drawable.meta), contentDescription = "", modifier = Modifier
                .size(100.dp))


        }



    }

}


