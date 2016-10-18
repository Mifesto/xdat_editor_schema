package ct0

import acmi.l2.clientmod.l2resources.Tex
import acmi.l2.clientmod.util.defaultio.DefaultIO
import groovy.beans.Bindable
import groovy.transform.CompileStatic

@Bindable
@DefaultIO
@CompileStatic
class StatusBar extends DefaultProperty {
    String title = ''
    int barWidth
    int barHeight
    @Tex
    String foreTex = 'undefined'
    @Tex
    String backTex = 'undefined'
    @Tex
    String warnTex = 'undefined'
    @Tex
    String regenTex = 'undefined'

    // @formatter:off
    @Deprecated String getUnk100() { title }
    @Deprecated void setUnk100(String unk100) { this.title = unk100 }

    @Deprecated int getUnk101() { barWidth }
    @Deprecated void setUnk101(int unk101) { this.barWidth = unk101 }

    @Deprecated int getTextureWidth() { barWidth }
    @Deprecated void setTextureWidth(int textureWidth) { this.barWidth = textureWidth }

    @Deprecated int getUnk102() { barHeight }
    @Deprecated void setUnk102(int unk102) { this.barHeight = unk102 }

    @Deprecated int getTextureHeight() { barHeight }
    @Deprecated void setTextureHeight(int textureHeight) { this.barHeight = textureHeight }

    @Deprecated String getUnk103() { foreTex }
    @Deprecated void setUnk103(String unk103) { this.foreTex = unk103 }

    @Deprecated String getForeTexture() { foreTex }
    @Deprecated void setForeTexture(String foreTexture) { this.foreTex = foreTexture }

    @Deprecated String getUnk104() { backTex }
    @Deprecated void setUnk104(String unk104) { this.backTex = unk104 }

    @Deprecated String getBackTexture() { backTex }
    @Deprecated void setBackTexture(String backTexture) { this.backTex = backTexture }

    @Deprecated String getUnk105() { warnTex }
    @Deprecated void setUnk105(String unk105) { this.warnTex = unk105 }

    @Deprecated String getWarnTexture() { warnTex }
    @Deprecated void setWarnTexture(String warnTexture) { this.warnTex = warnTexture }

    @Deprecated String getUnk106() { regenTex }
    @Deprecated void setUnk106(String unk106) { this.regenTex = unk106 }

    @Deprecated String getRegenTexture() { regenTex }
    @Deprecated void setRegenTexture(String regenTexture) { this.regenTex = regenTexture }
    // @formatter:on
}
