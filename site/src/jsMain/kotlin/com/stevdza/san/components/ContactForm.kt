package com.stevdza.san.components

import androidx.compose.runtime.Composable
import com.stevdza.san.models.Theme
import com.stevdza.san.styles.InputStyle
import com.stevdza.san.styles.MainButtonStyle
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactForm() {
    val breakpoint = rememberBreakpoint()
    val inputWidth = if (breakpoint > Breakpoint.MD) 500.px else 80.vw
    Form(
        action = "https://formspree.io/f/xbjenpjo",
        attrs = Modifier
            .attrsModifier {
                attr("method","POST")
            }
            .toAttrs()
    ) {
        Label(attrs = Modifier.classNames("form-label").toAttrs(), forId = "InputName") {
            Text("Name")
        }
        Input(
            type = InputType.Text, attrs = InputStyle.toModifier()
                .id("InputName")
                .classNames("form-control")
                .boxShadow(offsetX = 0.px, offsetY = 0.px, spreadRadius = 0.px, color = null)
                .attrsModifier {
                    attr("placeHolder", "Full Name")
                    attr("name", "Full Name")
                    attr("required", "true")
                }
                .width(inputWidth)
                .margin(bottom = 10.px)
                .backgroundColor(Theme.LighterGray.rgb)
                .toAttrs()
        )
        Label(attrs = Modifier.classNames("form-label").toAttrs(), forId = "InputEmail") {
            Text("Email")
        }
        Input(
            type = InputType.Email, attrs = InputStyle.toModifier()
                .id("InputEmail")
                .classNames("form-control")
                .boxShadow(offsetX = 0.px, offsetY = 0.px, spreadRadius = 0.px, color = null)
                .attrsModifier {
                    attr("placeHolder", "Email Address")
                    attr("name", "Email")
                    attr("required", "true")
                }
                .width(inputWidth)
                .margin(bottom = 10.px)
                .backgroundColor(Theme.LighterGray.rgb)
                .toAttrs()
        )
        Label(attrs = Modifier.classNames("form-label").toAttrs(), forId = "InputMessage") {
            Text("Message")
        }
        TextArea(
            attrs = InputStyle.toModifier()
                .id("InputMessage")
                .classNames("form-control")
                .boxShadow(offsetX = 0.px, offsetY = 0.px, spreadRadius = 0.px, color = null)
                .attrsModifier {
                    attr("placeHolder", "Your Message")
                    attr("name", "Message")
                    attr("required", "true")
                }
                .height(150.px)
                .minHeight(80.px)
                .width(inputWidth)
                .margin(bottom = 20.px)
                .backgroundColor(Theme.LighterGray.rgb)
                .toAttrs()
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(attrs = MainButtonStyle.toModifier()
                .height(40.px)
                .backgroundColor(Theme.Primary.rgb)
                .borderRadius(5.px)
                .border(width = 0.px)
                .color(Colors.White)
                .cursor(Cursor.Pointer)
                .onClick {

                }
                .toAttrs()) {
                Text("Submit")
            }
        }
    }
}