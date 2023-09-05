package com.example.megaapp.Add

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.firebase.ktx.Firebase

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(viewModel: AuthViewModel?, navController: NavController){


    var firebaseDatabase = FirebaseDatabase.getInstance().getReference("Data")
        .child("Name");

    // on below line we are calling method to display UI
    firebaseUI(LocalContext.current, firebaseDatabase )



}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun firebaseUI(context: Context, databaseReference: DatabaseReference) {

    val name = remember {
        mutableStateOf(TextFieldValue())
    }

    val address = remember {
        mutableStateOf(TextFieldValue())
    }

    val contactNumber = remember {
        mutableStateOf(TextFieldValue())
    }

    // on below line creating a column to display our retrieved list.

    Column(
        // adding modifier for our column
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        // on below line adding vertical and horizontal alignment for column.
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Add data to Database",
            // in modifier we are specifying padding
            // for our text from all sides.
            modifier = Modifier.padding(10.dp),
            // on below line we are specifying
            // style for our text
            style = TextStyle(
                color = Color.Black, fontSize = 20.sp
            ), fontWeight = FontWeight.Bold
        )

        // on below line we are creating
        // a text field for our email.
        TextField(
            // on below line we are specifying
            // value for our email text field.
            value = name.value,

            // on below line we are adding on
            // value change for text field.
            onValueChange = { name.value = it },

            // on below line we are adding place holder
            // as text as "Enter your email"
            placeholder = { Text(text = "Enter your Name") },
            label = { Text(text = "Enter your Name") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(10.dp))

        // on below line we are creating
        // a text field for our email.
        TextField(
            // on below line we are specifying
            // value for our email text field.
            value = contactNumber.value,

            // on below line we are adding on
            // value change for text field.
            onValueChange = { contactNumber.value = it },

            // on below line we are adding place holder
            // as text as "Enter your email"
            placeholder = { Text(text = "Enter your contact number") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(10.dp))

        // on below line we are creating
        // a text field for our email.
        TextField(
            // on below line we are specifying
            // value for our email text field.
            value = address.value,

            // on below line we are adding on
            // value change for text field.
            onValueChange = { address.value = it },

            // on below line we are adding place holder
            // as text as "Enter your email"
            placeholder = { Text(text = "Enter your address") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(10.dp))

        // on below line creating button
        Button(
            onClick = {
                // on below line we are adding data.

                val empObj =
                    EmployeeObj(name.value.text, contactNumber.value.text, address.value.text);

                // we are using add value event listener method
                // which is called with database reference.
                databaseReference.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        // inside the method of on Data change we are setting
                        // our object class to our database reference.
                        // data base reference will sends data to firebase.
                        databaseReference.setValue(empObj)

                        // after adding this data we
                        // are showing toast message.
                        Toast.makeText(
                            context,
                            "Data inserted successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // if the data is not added or it is cancelled then
                        // we are displaying a failure toast message.
                        Toast.makeText(
                            context,
                            "$error",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
            },
            // on below line we are
            // adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "Add data", modifier = Modifier.padding(8.dp))
        }
    }
}