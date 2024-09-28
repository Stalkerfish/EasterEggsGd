package awesome_dialog

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AwesomeCustomDialog(
    modifier: Modifier = Modifier,
    type: AwesomeCustomDialogType,
    title: String,
    desc: String,
    onDismiss: () -> Unit
) {
    MaterialTheme {
        when (type) {
            AwesomeCustomDialogType.SUCCESS -> {
                SuccessDialog(
                    title = title,
                    desc = desc,
                    onDismiss = onDismiss
                )
            }
            AwesomeCustomDialogType.ERROR -> {
                ErrorDialog(
                    title = title,
                    desc = desc,
                    onDismiss = onDismiss
                )
            }
            AwesomeCustomDialogType.INFO -> {
                InfoDialog(
                    title = title,
                    desc = desc,
                    onDismiss = onDismiss
                )
            }
        }
    }
}

enum class AwesomeCustomDialogType {
    SUCCESS, ERROR, INFO
}