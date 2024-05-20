
class CarrotMarketActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewApp_parcticeTheme {
                Column {
                    topBar()
                    productShow(R.drawable.girlimage)
                    productShow(R.drawable.girl2)
                    productShow(R.drawable.ic_launcher_foreground)
                    productShow(R.drawable.baseline_search_24)
                    productShow(R.drawable.baseline_menu_24)
                    plusIcon()
                }

            }
        }
    }
}

@Composable
fun topBar() {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Text(text = "역곡동")
                Image(
                    painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
                    contentDescription = "드롭다운이미지"
                )
            }
            Row {
                Image(
                    painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "검색"
                )
                Image(
                    painterResource(id = R.drawable.baseline_menu_24),
                    contentDescription = "menu"
                )
                Image(
                    painterResource(id = R.drawable.baseline_notifications_none_24),
                    contentDescription = "notice"
                )
            }
        }
    }
}

@Composable
fun productShow(paintId: Int = R.drawable.girl2) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = paintId), contentDescription = "당근마켓",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column() {
                Text(text = "청바지", fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
                Text(text = "동탄1동", fontSize = 16.sp, color = Color.Gray)
                Text(text = "5,000원", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun plusIcon() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(42.dp),
        contentAlignment = Alignment.BottomEnd,
    )
    {
        Image(
            painterResource(id = R.drawable.baseline_add_circle_24), contentDescription = "plus",
            Modifier.size(64.dp)
        )
    }
}
