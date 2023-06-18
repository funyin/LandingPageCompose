package com.stevdza.san.sections

import androidx.compose.runtime.*
import com.stevdza.san.components.SectionTitle
import com.stevdza.san.components.TestimonialCard
import com.stevdza.san.models.Section
import com.stevdza.san.models.Testimonial
import com.stevdza.san.models.Theme
import com.stevdza.san.util.Constants
import com.stevdza.san.util.animateNumber
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import kotlin.math.roundToInt

@Composable
fun TestimonialSection() {
    val breakpoint = rememberBreakpoint()
    var selectedPage by remember { mutableStateOf(0) }
    val testimonials = Testimonial.values()
    Box(
        modifier = Modifier.id(Section.Service.id).maxWidth(Constants.SECTION_WIDTH.px).padding(topBottom = 100.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 90.percent else 80.percent
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SectionTitle(
                modifier = Modifier.margin(bottom = 25.px),
                section = Section.Testimonial,
                alignment = Alignment.CenterHorizontally
            )
            SimpleGrid(numColumns = numColumns(base = 1, md = 2), modifier = Modifier.margin(bottom = 20.px)) {
                val fromIndex = selectedPage + selectedPage
                val activeTestimonials =
                    testimonials.sliceArray(fromIndex..((fromIndex + 1).takeIf { it < testimonials.lastIndex }
                        ?: testimonials.lastIndex))
                var opacity by remember { mutableStateOf(0) }
                val coroutineScope = rememberCoroutineScope()
                LaunchedEffect(selectedPage) {
                    coroutineScope.launch {
                        repeat(100) {
                            delay(1)
                            opacity = it
                        }
                    }
                }
                activeTestimonials.forEach { testimonial ->
                    TestimonialCard(
                        testimonial = testimonial,
                        modifier = Modifier.thenIf(breakpoint >= Breakpoint.MD, Modifier.margin(right = 25.px))
                            .thenIf(breakpoint < Breakpoint.MD, Modifier.margin(bottom = 25.px))
                            .opacity(opacity.percent)
                            .transition(CSSTransition(property = "opacity", duration = 200.ms))
                    )
                }
            }
            TestimonialNavigation(pages = (testimonials.size / 2.0).roundToInt(), selectedPage = selectedPage) {
                selectedPage = it
            }
        }
    }
}

@Composable
fun TestimonialNavigation(pages: Int, selectedPage: Int, onSelectPage: (Int) -> Unit) {
    Row {
        repeat(pages) { page ->
            Box(
                modifier = Modifier.margin(right = 10.px).cursor(Cursor.Pointer).size(12.px).borderRadius(50.px)
                    .backgroundColor(
                        if (selectedPage == page) Theme.Primary.rgb else Theme.LightGray.rgb
                    ).onClick {
                        onSelectPage(page)
                    }
            )
        }
    }
}