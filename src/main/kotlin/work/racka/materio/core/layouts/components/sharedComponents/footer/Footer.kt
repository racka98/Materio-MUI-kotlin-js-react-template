package work.racka.materio.core.layouts.components.sharedComponents.footer

import csstype.*
import mui.material.Box
import mui.material.styles.Theme
import mui.material.styles.useTheme
import mui.system.sx
import react.FC
import react.Props
import react.dom.html.ReactHTML.footer

val Footer = FC<Props> {
    // ** Hook
    val theme = useTheme<Theme>()

    Box {
        component = footer
        className = ClassName("layout-footer")
        sx {
            zIndex = integer(10)
            display = Display.flex
            alignItems = AlignItems.center
            justifyContent = JustifyContent.center
        }
        Box {
            className = ClassName("footer-content-container")
            sx {
                width = 100.pct
                borderTopLeftRadius = 14.px
                borderTopRightRadius = 14.px
                padding = theme.spacing(4, 6)
                "@media (min-width:1440px)" { maxWidth = 1440.px }
            }
            // Content Here
            FooterContent()
        }
    }
}