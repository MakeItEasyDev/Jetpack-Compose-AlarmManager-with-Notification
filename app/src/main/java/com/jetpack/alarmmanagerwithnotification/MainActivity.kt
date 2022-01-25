package com.jetpack.alarmmanagerwithnotification

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.alarmmanagerwithnotification.ui.theme.AlarmManagerWithNotificationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlarmManagerWithNotificationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val context = LocalContext.current
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "AlarmManager Notification",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Set Alarm Time : 10 Seconds",
                                modifier = Modifier
                                    .padding(10.dp),
                                fontSize = 16.sp
                            )
                            Button(
                                onClick = {
                                    setAlarm(context)
                                }
                            ) {
                                Text(text = "Set Alarm")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun setAlarm(context: Context) {
        val timeSec = System.currentTimeMillis() + 10000
        val alarmManager = context.getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, MyAlarm::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)
        alarmManager.set(AlarmManager.RTC_WAKEUP, timeSec, pendingIntent)
    }
}




















