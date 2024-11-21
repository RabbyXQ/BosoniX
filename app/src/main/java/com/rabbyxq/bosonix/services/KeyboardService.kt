class CustomKeyboardService : InputMethodService() {
    @Composable
    fun CustomKeyboardView(onKeyPress: (String) -> Unit) {
        val keys = listOf(
            "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
            "A", "S", "D", "F", "G", "H", "J", "K", "L",
            "Z", "X", "C", "V", "B", "N", "M"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(4.dp)
        ) {
            keys.chunked(10).forEach { rowKeys ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    rowKeys.forEach { key ->
                        Button(
                            onClick = { onKeyPress(key) },
                            modifier = Modifier
                                .padding(4.dp)
                                .size(50.dp)
                        ) {
                            Text(text = key, fontSize = 18.sp)
                        }
                    }
                }
            }
        }
    }

    override fun onCreateInputView(): View {
        return ComposeView(this).apply {
            setContent {
                CustomKeyboardView { key ->
                    currentInputConnection?.commitText(key, 1)
                }
            }
        }
    }
}
