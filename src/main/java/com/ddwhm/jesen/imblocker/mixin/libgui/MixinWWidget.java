package com.ddwhm.jesen.imblocker.mixin.libgui;

import com.ddwhm.jesen.imblocker.ImBlocker;
import com.ddwhm.jesen.imblocker.util.WidgetManager;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "io.github.cottonmc.cotton.gui.widget.WWidget", remap = false)
public class MixinWWidget {
    @Dynamic
    @Inject(method = "onFocusLost", at = @At("RETURN"))
    private void postOnFocusLost(CallbackInfo info) {
        if (this.getClass().getName().toLowerCase().contains("text")) {
            ImBlocker.LOGGER.debug("WWidget.onFocusLost");
            WidgetManager.updateWidgetStatus("libgui.WWidget", false);
        }
    }
    @Dynamic
    @Inject(method = "onFocusGained", at = @At("RETURN"))
    private void postOnFocusGained(CallbackInfo info) {
        if (this.getClass().getName().toLowerCase().contains("text")) {
            ImBlocker.LOGGER.debug("WWidget.onFocusGained");
            WidgetManager.updateWidgetStatus("libgui.WWidget", true);
        }
    }
}
