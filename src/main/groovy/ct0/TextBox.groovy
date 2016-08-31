package ct0

import acmi.l2.clientmod.l2resources.Sysstr
import acmi.l2.clientmod.l2resources.Tex
import acmi.l2.clientmod.util.IOUtil
import acmi.l2.clientmod.util.defaultio.DefaultIO
import groovy.beans.Bindable
import groovy.transform.CompileStatic
import javafx.scene.paint.Color

@Bindable
@DefaultIO
@CompileStatic
class TextBox extends DefaultProperty {
    String text = 'undefined'
    TextAlign textAlign = TextAlign.Undefined
    int offsetY
    @Tex
    String backTex = 'undefined'
    int fontType = -9999
    @Sysstr
    int sysstring = -9999
    int systemMsg = -9999
    Color textColor = new Color(0.0, 0.0, 0.0, 0.0)
    Boolean emoticon
    Boolean autosize

    enum TextAlign {
        Undefined,
        Left,
        Center,
        Right,
        MacroIcon,
    }

    // @formatter:off
    @Deprecated String getUnk100() { text }
    @Deprecated void setUnk100(String unk100) { this.text = unk100 }

    @Deprecated int getUnk101() { textAlign.ordinal() }
    @Deprecated void setUnk101(int unk101) { textAlign = TextAlign.values()[unk101] }

    @Deprecated int getUnk102() { offsetY }
    @Deprecated void setUnk102(int unk102) { this.offsetY = unk102 }

    @Deprecated String getUnk103() { backTex }
    @Deprecated void setUnk103(String unk104) { this.backTex = unk104 }

    @Deprecated int getUnk104() { fontType }
    @Deprecated void setUnk104(int unk103) { this.fontType = unk103 }

    @Deprecated int getUnk105() { sysstring }
    @Deprecated void setUnk105(int unk105) { this.sysstring = unk105 }

    @Deprecated int getUnk106() { systemMsg }
    @Deprecated void setUnk106(int unk106) { this.systemMsg = unk106 }

    @Deprecated Color getUnk107() { textColor }
    @Deprecated void setUnk107(Color unk107) { this.textColor = unk107 }

    @Deprecated boolean getUnk108() { emoticon }
    @Deprecated void setUnk108(boolean unk108) { this.emoticon = unk108 }

    @Deprecated int getUnk109() { IOUtil.boolToInt(autosize) }
    @Deprecated void setUnk109(int unk109) { this.autosize = IOUtil.intToBool(unk109) }
    // @formatter:on
}
