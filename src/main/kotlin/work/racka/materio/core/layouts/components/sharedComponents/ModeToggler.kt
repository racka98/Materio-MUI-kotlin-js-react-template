package work.racka.materio.core.layouts.components.sharedComponents

import mui.icons.material.Brightness4
import mui.icons.material.Brightness7
import mui.material.IconButton
import mui.material.IconButtonColor
import mui.material.styles.Theme
import react.FC
import react.Props
import react.dom.aria.AriaHasPopup
import react.dom.aria.ariaHasPopup
import react.useContext
import work.racka.materio.core.theme.ThemeContext
import work.racka.materio.core.theme.Themes

val ModeToggler = FC<Props> {
    var theme by useContext(ThemeContext)

    fun handleModeChange(mode: Theme) {
        theme = mode
    }

    fun handleModeToggle() {
        handleModeChange(if (theme == Themes.Light) Themes.Dark else Themes.Light)
    }

    IconButton {
        color = IconButtonColor.inherit
        ariaHasPopup = AriaHasPopup.`true`
        onClick = { handleModeToggle() }

        if (theme == Themes.Dark) Brightness7() else Brightness4()
    }
}