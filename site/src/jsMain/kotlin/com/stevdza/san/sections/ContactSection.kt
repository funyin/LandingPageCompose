package com.stevdza.san.sections

import androidx.compose.runtime.Composable
import com.stevdza.san.components.ContactForm
import com.stevdza.san.components.SectionTitle
import com.stevdza.san.models.Section
import com.stevdza.san.util.Constants
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ContactSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier.id(Section.Contact.id).maxWidth(Constants.SECTION_WIDTH.px).padding(topBottom = 100.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 60.percent else 100.percent
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SectionTitle(
                section = Section.Contact, modifier = Modifier.fillMaxWidth().margin(bottom = 25.px),
                alignment = Alignment.CenterHorizontally
            )
            ContactForm()
        }
    }
}