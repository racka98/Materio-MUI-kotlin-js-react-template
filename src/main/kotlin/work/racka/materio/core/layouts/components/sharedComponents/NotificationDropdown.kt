package work.racka.materio.core.layouts.components.sharedComponents

import csstype.*
import emotion.styled.StyledComponent
import emotion.styled.styled
import mui.material.Menu
import mui.material.MenuItem
import mui.material.MenuItemProps
import mui.material.MenuProps
import mui.material.styles.Theme
import mui.system.Breakpoint

private val Theme.styleMenu: StyledComponent<MenuProps>
    get() = Menu.styled { _, _ ->
        val theme = this@styleMenu
        "& .MuiMenu-paper" {
            width = 300.px
            overflow = Overflow.hidden
            marginTop = theme.spacing(4)
            (theme.breakpoints.down(Breakpoint.sm)) {
                width = 100.pct
            }
        }
        "& .MuiMenu-list" {
            padding = 0.px
        }
    }

private val Theme.styleMenuItem: StyledComponent<MenuItemProps>
    get() = MenuItem.styled { _, _ ->
        val theme = this@styleMenuItem
        paddingTop = theme.spacing(3)
        paddingBottom = theme.spacing(3)
        borderBottom = Border(1.px, LineStyle.solid, Color(theme.palette.divider.toString()))
    }

private fun PropertiesBuilder.boxStyles() = apply {
    maxHeight = 349.px
    "& .MuiMenuItem-root:last-of-type" { border = 0.px }
}