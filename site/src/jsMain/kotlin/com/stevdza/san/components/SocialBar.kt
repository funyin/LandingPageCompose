package com.stevdza.san.components

import androidx.compose.runtime.Composable
import com.stevdza.san.styles.SocialLinkStyle
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px

@Composable
fun SocialBar(row: Boolean = false) {
    if (row) Row(
        modifier = Modifier.padding(leftRight = 25.px).minHeight(40.px).borderRadius(20.px).backgroundColor(
            Colors.White
        ), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
        SocialLinks(row)
    }
    else Column(
        modifier = Modifier.margin(right = 25.px).padding(topBottom = 25.px).minWidth(40.px).borderRadius(20.px)
            .backgroundColor(
                Colors.White
            ), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        SocialLinks(row = row)
    }
}

@Composable
private fun SocialLinks(row: Boolean) {
    val linkModifier = SocialLinkStyle.toModifier().thenIf(row, Modifier.margin(right = 40.px))
        .thenIf(!row, Modifier.margin(bottom = 40.px))
    Link(path = "https://funyinkash.com", openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB) {
        FaFacebook(
            modifier = linkModifier, size = IconSize.LG
        )
    }
    Link(path = "https://funyinkash.com", openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE) {
        FaTwitter(modifier = linkModifier, size = IconSize.LG)
    }
    Link(path = "https://funyinkash.com") {
        FaInstagram(modifier = linkModifier, size = IconSize.LG)
    }
    Link(path = "https://funyinkash.com") {
        FaLinkedin(size = IconSize.LG, modifier = SocialLinkStyle.toModifier())
    }
}