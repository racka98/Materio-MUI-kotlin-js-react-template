package work.racka.materio.core.layouts

import csstype.*
import dom.html.HTMLElement
import emotion.styled.StyledComponent
import emotion.styled.styled
import mui.material.Box
import mui.material.styles.Theme
import mui.system.Breakpoint
import react.FC
import react.PropsWithChildren
import react.dom.html.HTMLAttributes
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.main
import react.useContext
import react.useState
import work.racka.materio.core.theme.ThemeContext

private val verticalLayoutWrapper = div.styled { _, _ ->
    height = 100.pct
    display = Display.flex
}

private val mainContentWrapper = Box.styled { _, _ ->
    flexGrow = number(1.0)
    minWidth = 0.px
    display = Display.flex
    minHeight = 100.vh
    flexDirection = FlexDirection.column
}

private val Theme.contentWrapper: StyledComponent<HTMLAttributes<HTMLElement>>
    get() = main.styled { _, _ ->
        val theme = this@contentWrapper
        flexGrow = number(1.0)
        width = 100.pct
        padding = theme.spacing(6)
        transition = Transition(PropertyName.padding, .25.s, TransitionTimingFunction.easeInOut)
        val smClass = theme.breakpoints.down(Breakpoint.sm)
        smClass {
            paddingLeft = theme.spacing(4)
            paddingRight = theme.spacing(4)
        }
    }

val VerticalLayout = FC<PropsWithChildren> { props ->
    val theme by useContext(ThemeContext)

    var navVisible by useState(false)
    fun toggleNavVisible() { navVisible = !navVisible }

    verticalLayoutWrapper {

    }
}