package work.racka.materio

import csstype.AlignItems
import csstype.Display
import csstype.vh
import csstype.vw
import mui.material.Box
import mui.material.styles.Theme
import mui.material.styles.useTheme
import mui.system.sx
import react.FC
import react.Props
import react.create
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter
import work.racka.materio.core.layouts.components.sharedComponents.UserDropdown
import work.racka.materio.core.theme.ThemeModule

val App = FC<Props> {
    ThemeModule {
        Box {
            sx {
                height = 100.vh
                width = 100.vw
                alignItems = AlignItems.center
                display = Display.flex
            }

            appContents()
        }
    }
}

private val appContents = FC<Props> {
    val theme = useTheme<Theme>()
    BrowserRouter {
        Routes {
            Route {
                path = "/"
                element = UserDropdown.create()
            }
        }
    }
}