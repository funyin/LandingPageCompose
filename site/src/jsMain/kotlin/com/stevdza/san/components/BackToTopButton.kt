package com.stevdza.san.components

import androidx.compose.runtime.*
import com.stevdza.san.models.Theme
import com.stevdza.san.styles.BackToTopButonStyle
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.css.zIndex
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun BackToTopButton(modifier: Modifier) {
    val breakpoint = rememberBreakpoint()
    var scroll: Double? by remember { mutableStateOf(null) }
    LaunchedEffect(Unit) {
        window.addEventListener("scroll", {
            scroll = document.documentElement?.scrollTop
        })
    }
    val buttonMargin = if (breakpoint <= Breakpoint.SM) 30.px else 40.px
    Box(
        modifier = BackToTopButonStyle.toModifier().then(modifier).size(50.px).backgroundColor(Theme.Primary.rgb)
            .visibility(if (scroll != null && scroll!! > 499) Visibility.Visible else Visibility.Hidden)
            .borderRadius(20.percent)
            .margin(bottom = buttonMargin, right = buttonMargin)
            .cursor(Cursor.Pointer)
            .onClick {
                document.documentElement?.scroll(x = 0.0, y = 0.0)
            },
        contentAlignment = Alignment.Center
    ) {
        FaArrowUp(modifier = Modifier.color(Colors.White), size = IconSize.LG)
    }
}