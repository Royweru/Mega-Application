package com.example.megaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.megaapp.ui.theme.ui.theme.MegaAppTheme

class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          outerLayout()
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun outerLayout(){
    var username by remember {
       mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column( modifier = Modifier
        .background(color = Color.Black)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Text(text = "Welcome to the sign up page!!", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 23.sp, modifier = Modifier.fillMaxWidth(), fontFamily = FontFamily.Monospace)
        Column(
            modifier = Modifier
                .background(color = Color.Cyan)
                .padding(all = 20.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "Sign Up", fontFamily = FontFamily.Cursive, fontSize = 60.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(value = username, modifier = Modifier.fillMaxWidth(), leadingIcon = { Icon(
                Icons.Default.Person,
                contentDescription =null
            )}, onValueChange ={username},label = { Text(text = "username")})
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(value = password,modifier = Modifier.fillMaxWidth(), leadingIcon = { Icon(
                Icons.Default.Lock,
                contentDescription =""
            )}, onValueChange ={password}, label = { Text(text = "password")})
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Sign UP")
            }

        }
    }

}
