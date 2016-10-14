package ct0

import acmi.l2.clientmod.util.IOUtil
import acmi.l2.clientmod.util.defaultio.DefaultIO
import groovy.beans.Bindable
import groovy.transform.CompileStatic

@Bindable
@DefaultIO
@CompileStatic
class EditBox extends DefaultProperty {
    Type type = Type.NORMAL
    int maxLength = -9999
    Boolean showCursor
    Boolean chatMarkOn = false

    enum Type {
        NORMAL,
        CHAT,
        PASSWORD,
        COUNT,    //number with delimiters
        NUMBER,
        UNK5,
        TYPE6,
    }

    // @formatter:off
    @Deprecated int getUnk102() { IOUtil.boolToInt(showCursor) }
    @Deprecated void setUnk102(int unk102) { this.showCursor = IOUtil.intToBool(unk102) }

    @Deprecated boolean getUnk103() { chatMarkOn }
    @Deprecated void setUnk103(boolean unk103) { this.chatMarkOn = unk103 }
    // @formatter:on
}
