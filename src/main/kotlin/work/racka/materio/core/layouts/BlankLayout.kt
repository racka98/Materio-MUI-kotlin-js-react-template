package work.racka.materio.core.layouts

import csstype.*
import emotion.styled.StyledComponent
import emotion.styled.styled
import mui.material.Box
import mui.material.BoxProps
import mui.system.Theme
import mui.system.sx
import react.FC
import react.PropsWithChildren
import react.useContext
import work.racka.materio.core.theme.ThemeContext

private val Theme.blankLayoutWrapper: StyledComponent<BoxProps>
    get() = Box.styled { boxProps, _ ->
        val theme = this@blankLayoutWrapper
        height = 100.vh

        // For V1 Blank layout pages
        "& .content-center" {
            display = Display.flex
            minHeight = 100.vh
            alignItems = AlignItems.center
            justifyContent = JustifyContent.center
            padding = theme.spacing(5)
        }
        // For V2 Blank layout pages
        "& .content-right" {
            display = Display.flex
            minHeight = 100.vh
            overflow = Overflow.hidden
            position = Position.relative
        }
    }

val BlankLayout = FC<PropsWithChildren> {props ->
    val theme by useContext(ThemeContext)
    theme.blankLayoutWrapper {
        className = ClassName("layout-wrapper")
        Box {
            className = ClassName("app-content")
            sx {
                minHeight = 100.vh
                overflowX = Overflow.hidden
                position = Position.relative
            }
            +props.children
        }
    }
}
