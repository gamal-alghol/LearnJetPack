package com.gamal.learnjetpack

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationController(navController:NavHostController) :NavHostController{

NavHost(navController = navController, startDestination ="home" )
{
    composable("home"){ HomeScreen(navController = navController)}
composable("search"){}    
composable("add"){}    
composable("reals"){}    
composable("profile/{user_name}", arguments = listOf((navArgument("user_name"){type = NavType.StringType})))
{
        backStackEntry ->
    val userName = backStackEntry.arguments?.getString("user_name")
    InstagramProfile(navController,userName=userName?:"")

}
}
return navController
}