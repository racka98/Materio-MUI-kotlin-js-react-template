package work.racka.materio.core.layouts.components.sharedComponents

import csstype.*
import dom.Element
import dom.html.HTMLSpanElement
import emotion.react.css
import emotion.styled.StyledComponent
import emotion.styled.styled
import mui.material.*
import mui.material.styles.Theme
import mui.material.styles.TypographyVariant
import mui.material.styles.useTheme
import mui.system.sx
import react.*
import react.dom.events.MouseEvent
import react.dom.events.MouseEventHandler
import react.dom.html.HTMLAttributes
import react.dom.html.ReactHTML.span
import react.router.useNavigate
import work.racka.materio.core.layouts.components.jsToKotlin.*

private val Theme.badgeContentSpan: StyledComponent<HTMLAttributes<HTMLSpanElement>>
    get() = span.styled { _, _ ->
        val theme = this@badgeContentSpan
        width = 8.px
        height = 8.px
        borderRadius = 50.pct
        backgroundColor = theme.palette.success.main
        boxShadow = BoxShadow(0.px, 0.px, 0.px, 2.px, Color(theme.palette.background.paper))
    }

private fun PropertiesBuilder.boxStyles(theme: Theme) = apply {
    padding = Padding(2.px, 4.px)
    width = 100.pct
    display = Display.flex
    alignItems = AlignItems.center
    color = theme.palette.text.primary
    textDecoration = None.none
    "& svg" {
        fontSize = 1.375.rem
        color = theme.palette.text.secondary
    }
}

val UserDropdown = FC<Props> {
    var anchorElement by useState<Element?>(null)

    val theme = useTheme<Theme>()
    val navigate = useNavigate()

    val handleDropdownOpen: MouseEventHandler<*> = { event: MouseEvent<*, *> ->
        anchorElement = event.currentTarget
    }

    fun handleDropdownClose(url: String? = null) {
        anchorElement = null
        url?.run { navigate(this) }
    }

    Fragment {
        Badge {
            overlap = BadgeOverlap.circular
            onClick = handleDropdownOpen
            sx { marginLeft = 2.px; cursor = Cursor.pointer }
            badgeContent = theme.badgeContentSpan.create {
                css { backgroundColor = theme.palette.success.main }
            }
            anchorOrigin = object : BadgeOrigin {
                override var vertical: BadgeOriginVertical = BadgeOriginVertical.bottom
                override var horizontal: BadgeOriginHorizontal = BadgeOriginHorizontal.right
            }
            Avatar {
                alt = "John Doe"
                onClick = handleDropdownOpen
                sx { width = 40.px; height = 40.px }
                src = "/images/avatars/1.png"
            }
        }
        Menu {
            anchorEl = { anchorElement ?: it }
            open = anchorElement != null
            onClose = { handleDropdownClose() }
            sx { "& .MuiMenu-paper" { width = 230.px; marginTop = 4.px } }
            anchorOrigin = object : PopoverOrigin {
                override var vertical: mui.system.Union = "bottom"
                override var horizontal: mui.system.Union = "right"
            }
            transformOrigin = object : PopoverOrigin {
                override var vertical: mui.system.Union = "top"
                override var horizontal: mui.system.Union = "right"
            }

            dropdownUserStats {
                username = "John Doe"
                imageSrc = "/images/avatars/1.png"
                isOnline = false
                role = "Admin"
            }
            Divider { sx { marginTop = 0.px; marginBottom = 1.px } }
            MenuItem {
                sx { padding = 0.px }
                onClick = { handleDropdownClose() }
                Box {
                    sx { boxStyles(theme) }
                    AccountOutline { sx { marginRight = 2.px } }
                    +"Profile"
                }
            }
            MenuItem {
                sx { padding = 0.px }
                onClick = { handleDropdownClose() }
                Box {
                    sx { boxStyles(theme) }
                    EmailOutline { sx { marginRight = 2.px } }
                    +"Inbox"
                }
            }
            MenuItem {
                sx { padding = 0.px }
                onClick = { handleDropdownClose() }
                Box {
                    sx { boxStyles(theme) }
                    MessageOutline { sx { marginRight = 2.px } }
                    +"Chat"
                }
            }
            MenuItem {
                sx { padding = 0.px }
                onClick = { handleDropdownClose() }
                Box {
                    sx { boxStyles(theme) }
                    CogOutline { sx { marginRight = 2.px } }
                    +"Settings"
                }
            }
            MenuItem {
                sx { padding = 0.px }
                onClick = { handleDropdownClose() }
                Box {
                    sx { boxStyles(theme) }
                    CurrencyUsd { sx { marginRight = 2.px } }
                    +"Pricing"
                }
            }
            MenuItem {
                sx { padding = 0.px }
                onClick = { handleDropdownClose() }
                Box {
                    sx { boxStyles(theme) }
                    HelpCircleOutline { sx { marginRight = 2.px } }
                    +"FAQ"
                }
            }
            MenuItem {
                sx { paddingTop = 2.px; paddingBottom = 2.px }
                onClick = { handleDropdownClose("pages/login") }
                Box {
                    sx { boxStyles(theme) }
                    LogoutVariant {
                        sx {
                            marginRight = 2.px
                            fontSize = 1.375.rem
                            color = theme.palette.text.secondary
                        }
                    }
                    +"Logout"
                }
            }
        }
    }
}

private val dropdownUserStats = FC<UserStatsProps> { props ->
    val theme = useTheme<Theme>()
    Box {
        sx { paddingTop = 2.px; paddingBottom = 3.px; paddingLeft = 4.px; paddingRight = 4.px }
        Box {
            sx { display = Display.flex; alignItems = AlignItems.center }
            Badge {
                overlap = BadgeOverlap.circular
                badgeContent = theme.badgeContentSpan.create {
                    css {
                        backgroundColor = if (props.isOnline) theme.palette.success.main
                        else theme.palette.error.main
                    }
                }
                anchorOrigin = object : BadgeOrigin {
                    override var vertical: BadgeOriginVertical = BadgeOriginVertical.bottom
                    override var horizontal: BadgeOriginHorizontal = BadgeOriginHorizontal.right
                }
                Avatar {
                    alt = props.username
                    sx { width = 2.5.rem; height = 2.5.rem }
                    src = props.imageSrc
                }
            }
            Box {
                sx {
                    display = Display.flex
                    marginLeft = 3.px
                    alignItems = AlignItems.flexStart
                    flexDirection = FlexDirection.column
                }
                Typography { sx { fontWeight = integer(600) }; +props.username }
                Typography {
                    variant = TypographyVariant.body2
                    sx { fontSize = .8.rem; color = theme.palette.text.disabled }
                    +props.role
                }
            }
        }
    }
}

external interface UserStatsProps : Props {
    var imageSrc: String
    var username: String
    var isOnline: Boolean
    var role: String
}
