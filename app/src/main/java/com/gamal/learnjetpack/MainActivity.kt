package com.gamal.learnjetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

class MainActivity : ComponentActivity() {
    val fontFamily = FontFamily(
        Font(R.font.poppins_light, FontWeight.Light),
        Font(R.font.poppins_bold, FontWeight.Bold)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var navController= rememberNavController();
            NavHost(navController = navController, startDestination = "splash" ){
                composable("main_screen"){
                    MainScreen()
                }
                composable("splash"){
                    SplashScreen(navController)

                    navController
                }
            }


           // HomeScreen()
         //   MyTimer()
          //  InstagramProfile(navController)
         //   constraintLayoutContent()
        }


        /*Scaffold(  content = { paddingValues -> Column(modifier = Modifier.padding(paddingValues)) { myTextFailed() } },
        topBar = { myTopBar(rememberCoroutineScope()) },

    )*/
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun myTopBar(scope: CoroutineScope) {
        var drawerState = rememberDrawerState(DrawerValue.Closed)
        TopAppBar(title = { Text(stringResource(id = R.string.app_name)) },
            navigationIcon = {
                Icon(modifier = Modifier.clickable(enabled = true, onClick = {
                    //Open Drawer
                    scope.launch(Dispatchers.Main) {
                        if (drawerState.isClosed) {
                            drawerState.open()
                        } else {
                            drawerState.close()

                        }
                    }


                }), imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        )
    }

    @Composable
    fun myImageCard() {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(top = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            shape = RoundedCornerShape(12.dp),
        )
        {

            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.dd),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = stringResource(id = R.string.usaflag),
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    colorResource(id = R.color.black_hint)
                                ),
                                startY = 50f,
                            )
                        )
                )
                Row(
                    modifier = Modifier
                        .align(alignment = Alignment.BottomStart)
                        .fillMaxSize()
                        .padding(bottom = 8.dp, start = 16.dp)
                )
                {
                    Text(text = stringResource(id = R.string.usaflag), color = Color.White,)
                }


            }
        }
    }

    @Composable
    fun myText(text: String): Unit {
        val fontFamily = FontFamily(
            Font(R.font.poppins_light, FontWeight.Light),
            Font(R.font.poppins_bold, FontWeight.Bold)
        )


        return Text(
            text,
            color = Color.Blue,
            fontSize = 24.sp,
            fontFamily = fontFamily,
            textDecoration = TextDecoration.Underline
        )

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun myTextFailed() {
        var text by remember { mutableStateOf("") }
        var textFailed by remember { mutableStateOf("") }
        val snackbar = remember { SnackbarHostState() }

        val scope = CoroutineScope(newSingleThreadContext("name"))


        myText(text)
        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = textFailed, onValueChange = { textFailed = it },
            label = { Text(stringResource(id = R.string.Enter_your_Name)) },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {


            text = textFailed
            if (text.isNotEmpty()) {
                Toast.makeText(applicationContext, "Hello $text", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Fill the Fiel d", Toast.LENGTH_LONG).show()

            }
        }) {
            Text(text = stringResource(id = R.string.login))
        }
    }


    @Composable
    fun constraintLayoutContent() {
        ConstraintLayout(modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white_l))){
            // Create references for the composables to constrain
            val (logo, name,password,forgetpassword,login) = createRefs()
            val guideline=createGuidelineFromTop(0.3f)
            var inputName by remember {mutableStateOf("")}
            var inputPassword by remember {mutableStateOf("")}



            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo",
                modifier=Modifier.constrainAs(logo){
                    bottom.linkTo(guideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end) })



OutlinedTextField(value = inputName, onValueChange = {inputName=it},label ={Text(stringResource(id = R.string.Enter_your_Name),fontFamily=fontFamily)}
    ,modifier=Modifier.constrainAs(name){
        top.linkTo(logo.bottom,32.dp)
        start.linkTo(parent.start,16.dp)
        end.linkTo(parent.end,16.dp)
        width= Dimension.fillToConstraints
        height= Dimension.wrapContent
    }
)
            OutlinedTextField(value = inputPassword, onValueChange = {inputPassword=it},label ={Text(text=stringResource(id = R.string.Enter_password),fontFamily=fontFamily)}
    ,modifier=Modifier.constrainAs(password){
        top.linkTo(name.bottom,24.dp)
        start.linkTo(name.start)
        end.linkTo(name.end)
        width= Dimension.fillToConstraints
        height= Dimension.wrapContent
    }
)

            Text(text= stringResource(id = R.string.forgetPassword),color= colorResource(id = R.color.purple_500),fontFamily=fontFamily,textDecoration=TextDecoration.Underline,
                modifier=Modifier.constrainAs(forgetpassword){
                    top.linkTo(password.bottom)
                    end.linkTo(password.end)

                })

Button(onClick = {
                 if (checkInputs(inputName,inputPassword)){

                 }else{
                     Toast.makeText(applicationContext, resources.getText(R.string.fill),Toast.LENGTH_SHORT).show()
                 } },

    Modifier.constrainAs(login) {
        top.linkTo(forgetpassword.bottom)
        bottom.linkTo(parent.bottom)
        start.linkTo(name.start,32.dp)
        end.linkTo(name.end,32.dp)
        width= Dimension.fillToConstraints
        height= Dimension.wrapContent },shape=RoundedCornerShape(8.dp)) {
    Text(text= stringResource(id = R.string.login), fontSize = 16.sp,color= colorResource(id = R.color.white),fontFamily=fontFamily)
}


        }
    }

    private fun checkInputs(inputName: String,inputPassword: String): Boolean {
        if (inputName.isNotEmpty() && inputPassword.isNotEmpty()){
            return true
        }
return false
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   MainActivity()
}




    


