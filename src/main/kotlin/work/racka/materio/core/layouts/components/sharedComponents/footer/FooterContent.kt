package work.racka.materio.core.layouts.components.sharedComponents.footer

import csstype.*
import mui.material.Box
import mui.material.Link
import mui.material.Typography
import mui.material.useMediaQuery
import mui.system.Breakpoint
import mui.system.sx
import react.FC
import react.Props
import react.dom.html.AnchorTarget
import react.dom.html.ReactHTML.span
import react.useContext
import work.racka.materio.core.theme.ThemeContext
import kotlin.js.Date

val FooterContent = FC<Props> {
    val theme by useContext(ThemeContext)
    val hidden = useMediaQuery(theme.breakpoints.down(Breakpoint.md))

    Box {
        sx {
            display = Display.flex
            flexWrap = FlexWrap.wrap
            alignItems = AlignItems.center
            justifyContent = JustifyContent.spaceBetween
        }
        Typography {
            sx { marginRight = 4.px }
            +"© ${Date().getFullYear()}, Made with "
            Box {
                component = span
                sx { color = theme.palette.error.main }
                +"♥️"
            }
            +" by "
            Link {
                target = AnchorTarget._blank
                href = "https://themeselection.com/"
                +"ThemeSelection + Racka"
            }
        }

        if (!hidden) {
            Box {
                sx {
                    display = Display.flex
                    flexWrap = FlexWrap.wrap
                    alignItems = AlignItems.center
                    "& :not(:last-child)" { marginRight = 8.px }
                }
                Link {
                    target = AnchorTarget._blank
                    href =
                        "https://github.com/themeselection/materio-mui-react-nextjs-admin-template-free/blob/main/LICENSE"
                    +"MIT License"
                }
                Link {
                    target = AnchorTarget._blank
                    href = "https://themeselection.com/"
                    +"More Themes"
                }
                Link {
                    target = AnchorTarget._blank
                    href =
                        "https://github.com/themeselection/materio-mui-react-nextjs-admin-template-free/blob/main/README.md"
                    +"Documentation"
                }
                Link {
                    target = AnchorTarget._blank
                    href = "https://github.com/themeselection/materio-mui-react-nextjs-admin-template-free/issues"
                    +"Support"
                }
            }
        }
    }
}