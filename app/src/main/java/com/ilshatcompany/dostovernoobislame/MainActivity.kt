package com.ilshatcompany.dostovernoobislame


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            WelcomeScreen()
            Drawer()

        }
    }
}

@Composable
fun WelcomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Ассаляму `алейкум",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Divider(
            Modifier.width(220.dp),
            color = Color.LightGray,
            thickness = 3.dp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean " +
                    "commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus " +
                    "et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis," +
                    " ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa " +
                    "quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget," +
                    " arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo." +
                    " Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras" +
                    " dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus." +
                    " Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. " +
                    "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus " +
                    "viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet." +
                    " Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. " +
                    "Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum " +
                    "rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum." +
                    " Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. " +
                    "Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut " +
                    "libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget " +
                    "eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh." +
                    " Donec sodales sagittis magna. ",
            textAlign = TextAlign.Center,
        )
    }
}




