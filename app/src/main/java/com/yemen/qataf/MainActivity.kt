package com.yemen.qataf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Product(val title: String, val price: String, val location: String, val emoji: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val demoProducts = listOf(
            Product("عنب رازقي فاخر", "1,500 ريال / كيلو", "صنعاء - بني حشيش", "🍇"),
            Product("عنب أسود بلدي", "1,800 ريال / كيلو", "صنعاء - سعوان الأوسط", "🍇"),
            Product("زبيب رازقي أشقر", "4,500 ريال / كيلو", "صنعاء - بني حشيش", "🫒"),
            Product("رمان صعدي ممتاز", "2,000 ريال / سلة", "صعدة - مجز", "🍎")
        )

        setContent {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                MaterialTheme {
                    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFF4F6F4)) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Card(
                                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                                colors = CardDefaults.cardColors(containerColor = Color(0xFF2E7D32))
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text("قطاف اليمن", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                                    Text("من المزرعة اليمنية إلى باب بيتك", color = Color(0xFFE8F5E9), fontSize = 13.sp)
                                }
                            }

                            Text("المحاصيل المتاحة حالياً (نسخة تجريبية):", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp))

                            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                items(demoProducts) { item ->
                                    Card(
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = CardDefaults.cardColors(containerColor = Color.White),
                                        shape = RoundedCornerShape(8.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(12.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(item.emoji, fontSize = 32.sp)
                                            Spacer(modifier = Modifier.width(12.dp))
                                            Column {
                                                Text(item.title, fontWeight = FontWeight.Bold, color = Color(0xFF1B5E20))
                                                Text(item.location, fontSize = 12.sp, color = Color.Gray)
                                                Text(item.price, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFFB78103))
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
