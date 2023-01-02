package com.example.vm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.vm.ui.theme.VmTheme
import kotlinx.coroutines.flow.MutableStateFlow


class MainActivityViewModel : ViewModel() {

    var number: MutableStateFlow<Int> = MutableStateFlow(0)

    fun increaseNumber() {
        number.value = number.value + 1
    }

}


class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VmTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(viewModel)
                }
            }
        }
    }
}



@Composable
fun Greeting(myMyCurrentPhoneState: MainActivityViewModel) {
    val numberFromModel = myMyCurrentPhoneState.number.collectAsState()
    Column(
        modifier = Modifier
            .width(20.dp)
            .height(20.dp)
    ) {
        Button(onClick = {
            myMyCurrentPhoneState.increaseNumber()
        }) {
            Text("Some text ${numberFromModel.value}")
        }

    }
}