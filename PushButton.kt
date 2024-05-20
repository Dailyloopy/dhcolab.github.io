class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewApp_parcticeTheme1 {
                DefaultPreview()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewApp_parcticeTheme1 {
        Surface(
            color = Color(0xFF4666d0),
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(30.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$100", style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(50.dp))
                CreateCircle()
            }


        }
    }
}

@Preview
@Composable
fun CreateCircle() {
    var moneyCounter by remember {// 기본적인 선언 방법
        mutableStateOf(0)
    }
    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(70.dp)
            .clickable {
                moneyCounter += 1
                if(moneyCounter > 5){

                }
                Log.d("Clicked", "CreateCircle: Clicked")
            },//클릭할때마다 Log가 찍힘
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(6.dp) //Card Elevation은 CardDefaults.으로 진행
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "${moneyCounter}")
        }
    }
}
