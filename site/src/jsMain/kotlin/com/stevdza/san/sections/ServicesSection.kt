package com.stevdza.san.sections

import androidx.compose.runtime.Composable
import com.stevdza.san.components.SectionTitle
import com.stevdza.san.components.ServiceCard
import com.stevdza.san.models.Section
import com.stevdza.san.models.Service
import com.stevdza.san.util.Constants
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ServicesSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier.id(Section.Service.id).maxWidth(Constants.SECTION_WIDTH.px).padding(topBottom = 100.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(if (breakpoint >= Breakpoint.MD) 90.percent else 100.percent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SectionTitle(
                modifier = Modifier.fillMaxWidth().margin(bottom = 20.px),
                alignment = Alignment.CenterHorizontally,
                section = Section.Service
            )
            SimpleGrid(numColumns = numColumns(base = 1, sm = 2, md = 3)) {
                Service.values().forEach { service ->
                    ServiceCard(service = service)
                }
            }
        }
    }
}