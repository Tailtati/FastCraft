package net.benwoodworth.fastcraft.crafting.view.buttons

import net.benwoodworth.fastcraft.Config
import net.benwoodworth.fastcraft.FastCraftConfig
import net.benwoodworth.fastcraft.Strings
import net.benwoodworth.fastcraft.platform.gui.FcGui
import net.benwoodworth.fastcraft.platform.gui.FcGuiButton
import net.benwoodworth.fastcraft.platform.gui.FcGuiClick
import net.benwoodworth.fastcraft.platform.gui.FcGuiClickModifier
import net.benwoodworth.fastcraft.platform.player.FcSound
import net.benwoodworth.fastcraft.platform.text.FcText
import net.benwoodworth.fastcraft.platform.world.FcItem
import java.util.*
import javax.inject.Inject

class PageButtonView(
    private val button: FcGuiButton,
    private val locale: Locale,
    private val textFactory: FcText.Factory,
    private val sounds: FcSound.Factory,
    config: FastCraftConfig,
) {
    var page: Int = 1
    var pageCount: Int = 1

    var listener: Listener = Listener.Default

    init {
        val c = config.layout.buttons.page

        button.apply {
            listener = ButtonListener()

            copyItem(c.item)

            setDescription(
                listOf(
                    textFactory.createLegacy(
                        Strings.guiButtonPageDescription0(locale)
                    ),
                    textFactory.createLegacy(
                        Strings.guiButtonPageDescription1(locale)
                    ),
                    textFactory.createLegacy(
                        Strings.guiButtonPageDescription2(locale)
                    )
                )
            )

            hideItemDetails()
        }

        update()
    }

    fun update() {
        button.apply {
            setText(
                textFactory.createLegacy(
                    Strings.guiButtonPageTitle(locale, page, pageCount)
                )
            )

            setProgress(page.toDouble() / pageCount)
        }
    }

    private companion object {
        val CLICK_PAGE_NEXT = FcGuiClick.Primary()
        val CLICK_PAGE_PREVIOUS = FcGuiClick.Secondary()
        val CLICK_PAGE_FIRST = FcGuiClick.Primary(FcGuiClickModifier.Shift)
    }

    interface Listener {
        object Default : Listener

        fun onPageNext() {}
        fun onPagePrevious() {}
        fun onPageFirst() {}
    }

    private inner class ButtonListener : FcGuiButton.Listener {
        override fun onClick(gui: FcGui<*>, button: FcGuiButton, click: FcGuiClick) {
            val action = when (click) {
                CLICK_PAGE_NEXT -> listener::onPageNext
                CLICK_PAGE_PREVIOUS -> listener::onPagePrevious
                CLICK_PAGE_FIRST -> listener::onPageFirst
                else -> null
            }

            action?.let {
                gui.player.playSound(sounds.uiButtonClick, Config.buttonVolume)
                action()
            }
        }
    }

    class Factory @Inject constructor(
        private val items: FcItem.Factory,
        private val textFactory: FcText.Factory,
        private val sounds: FcSound.Factory,
        private val config: FastCraftConfig,
    ) {
        fun create(button: FcGuiButton, locale: Locale): PageButtonView {
            return PageButtonView(
                button = button,
                locale = locale,
                textFactory = textFactory,
                sounds = sounds,
                config = config,
            )
        }
    }
}
