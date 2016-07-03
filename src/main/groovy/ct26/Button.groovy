package ct26

import acmi.l2.clientmod.l2resources.Sysstr
import acmi.l2.clientmod.l2resources.Tex
import acmi.l2.clientmod.util.ComponentFactory
import acmi.l2.clientmod.util.Description
import acmi.l2.clientmod.util.IOUtil
import acmi.l2.clientmod.util.defaultio.DefaultIO
import groovy.transform.CompileStatic
import groovyx.javafx.beans.FXBindable
import javafx.beans.binding.Bindings
import javafx.scene.control.Button as FXButton
import javafx.scene.layout.Border

import java.util.concurrent.Callable

@DefaultIO
@CompileStatic
@FXBindable
class Button extends DefaultProperty implements ComponentFactory<FXButton> {
    @Tex
    String normalTex = 'undefined'
    @Tex
    String pushedTex = 'undefined'
    @Tex
    String highlightTex = 'undefined'
    @Tex
    String dropTex = 'undefined'
    @Sysstr
    int buttonName = -9999
    String buttonNameText
    Boolean noHighlight
    Boolean defaultSoundOn
    @Description('-9999/5000')
    int disableTime = -9999

    @Override
    FXButton create() { new FXButton() }

    @Override
    void initProperties(FXButton button) {
        super.initProperties(button)

        button.textProperty().bind(Bindings.createStringBinding({
            if (getResources() == null)
                return null;

            return getButtonNameText() != null && !getButtonNameText().isEmpty() && !getButtonNameText().equalsIgnoreCase('undefined') ?
                    getButtonNameText() : getResources().getSysString(getButtonName());
        }, resourcesProperty(), buttonNameProperty(), buttonNameTextProperty()));

        button.borderProperty().bind(Bindings.createObjectBinding({
            if (getResources() == null)
                return null

            def border = null
            if (button.isDisabled())
                border = getResources().getBorder(getNormalTex() + "_Disable")
            else if (button.isPressed())
                border = getResources().getBorder(getPushedTex())
            else if (button.isHover())
                border = getResources().getBorder(getHighlightTex())

            if (border == null)
                border = getResources().getBorder(getNormalTex())

            border
        } as Callable<Border>, resourcesProperty(),
                normalTexProperty(), pushedTexProperty(), highlightTexProperty(),
                button.disabledProperty(), button.hoverProperty(), button.pressedProperty()));
    }

    // @formatter:off
    @Deprecated String getTexture() { normalTex }
    @Deprecated void setTexture(String texture) { this.normalTex = texture }

    @Deprecated String getTextureDown() { pushedTex }
    @Deprecated void setTextureDown(String textureDown) { this.pushedTex = textureDown }

    @Deprecated String getTextureOver() { highlightTex }
    @Deprecated void setTextureOver(String textureOver) { this.highlightTex = textureOver }

    @Deprecated String getUnk103() { dropTex }
    @Deprecated void setUnk103(String unk103) { this.dropTex = unk103 }

    @Deprecated int getTextStringId() { buttonName }
    @Deprecated void setTextStringId(int textStringId) { this.buttonName = textStringId }

    @Deprecated String getTextStringValue() { buttonNameText }
    @Deprecated void setTextStringValue(String textStringValue) { this.buttonNameText = textStringValue }

    @Deprecated int getUnk106() { IOUtil.boolToInt(noHighlight) }
    @Deprecated void setUnk106(int unk106) { this.noHighlight = IOUtil.intToBool(unk106) }

    @Deprecated int getUnk107() { IOUtil.boolToInt(defaultSoundOn) }
    @Deprecated void setUnk107(int unk107) { this.defaultSoundOn = IOUtil.intToBool(unk107) }

    @Deprecated int getUnk108() { disableTime }
    @Deprecated void setUnk108(int unk108) { this.disableTime = unk108 }
    // @formatter:on
}
