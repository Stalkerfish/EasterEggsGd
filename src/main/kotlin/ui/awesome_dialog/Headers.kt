package awesome_dialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import kottieAnimation.KottieAnimation
import kottieComposition.KottieCompositionSpec
import kottieComposition.animateKottieCompositionAsState
import kottieComposition.rememberKottieComposition
import java.io.File


@Composable
fun InfoHeader(modifier: Modifier) {

    val animation = File("src/main/resources/raw/info.json")    // Path to json lottie
        .readText()     // Get the content from the file

    //  Make the composition with the Json
    val composition = rememberKottieComposition(spec = KottieCompositionSpec.JsonString(animation))

    //  Loop forever
    val progress by animateKottieCompositionAsState(composition, iterations = Int.MAX_VALUE)

    //  Final animation object
    KottieAnimation(
        modifier = modifier,
        composition = composition,
        progress = { progress.progress }
    )
}

@Composable
fun ErrorHeader(modifier: Modifier) {
    val animation = File("src/main/resources/raw/error.json")
        .readText()

    val composition = rememberKottieComposition(
        spec = KottieCompositionSpec.JsonString(animation)
    )
    val progress by animateKottieCompositionAsState(composition, iterations = Int.MAX_VALUE)
    KottieAnimation(
        modifier = modifier,
        composition = composition,
        progress = { progress.progress }
    )
}

@Composable
fun SuccessHeader(modifier: Modifier) {
    val animation = File("src/main/resources/raw/success.json")
        .readText()

    val composition = rememberKottieComposition(
        spec = KottieCompositionSpec.JsonString(animation)
    )
    val progress by animateKottieCompositionAsState(composition, iterations = Int.MAX_VALUE)
    KottieAnimation(
        modifier = modifier,
        composition = composition,
        progress = { progress.progress }
    )
}