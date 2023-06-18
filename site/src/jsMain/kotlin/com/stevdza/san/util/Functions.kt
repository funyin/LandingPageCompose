package com.stevdza.san.util

import androidx.compose.runtime.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.w3c.dom.events.EventListener

@Composable
fun ObserveViewPortEntered(
    sectionId: String,
    distanceFromPort: Double,
    onViewPortEntered: () -> Unit
) {
    var viewPortEntered by remember { mutableStateOf(false) }
    val listener = remember {
        EventListener {
            document.getElementById(sectionId)?.getBoundingClientRect()?.top?.let { top ->
                if (top < distanceFromPort)
                    viewPortEntered = true
            }
        }
    }
    LaunchedEffect(viewPortEntered) {
        if (viewPortEntered) {
            onViewPortEntered()
            window.removeEventListener("scroll", listener)
        } else {
            window.addEventListener("scroll", listener)
        }
    }
}

suspend fun animatePercentage(percent: Float, delay: Long, onUpdate: (Int) -> Unit) {
    (0..percent.toInt()).forEach {
        delay(delay)
        onUpdate(it)
    }
}