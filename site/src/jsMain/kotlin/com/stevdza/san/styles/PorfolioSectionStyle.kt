package com.stevdza.san.styles

import com.stevdza.san.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val PorfolioCardStyle by ComponentStyle {
    val columnSuffix = " > #columnParent"
    val suffixRule = "$columnSuffix > #boxParent > #greenOverlay"
    cssRule(suffixRule) {
        Modifier.width(0.percent)
            .transition(CSSTransition(property = "width", duration = 300.ms))
    }
    val linkIconSuffix = "$suffixRule > #linkIcon"
    cssRule(linkIconSuffix) {
        Modifier.visibility(Visibility.Hidden)
            .transition(CSSTransition(property = "visibility", duration = 300.ms))
    }
    cssRule(":hover $linkIconSuffix") {
        Modifier.visibility(Visibility.Visible)
    }
    cssRule(":hover$suffixRule") {
        Modifier.width(100.percent)
    }

    val textSuffix = "$columnSuffix > p"
    cssRule(textSuffix) {
        Modifier.color(Theme.Secondary.rgb)
            .translateX(0.px)
            .transition(CSSTransition(property = "color", duration = 500.ms),CSSTransition(property = "translate", duration = 500.ms))
    }
    cssRule(":hover $textSuffix") {
        Modifier.color(Theme.Primary.rgb)
            .translateX(8.px)
    }

}