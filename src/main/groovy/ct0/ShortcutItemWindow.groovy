package ct0

import acmi.l2.clientmod.util.defaultio.DefaultIO
import groovy.beans.Bindable
import groovy.transform.CompileStatic

@Bindable
@DefaultIO
@CompileStatic
class ShortcutItemWindow extends DefaultProperty {
    boolean alwaysShowOutline

    // @formatter:off
    @Deprecated boolean getUnk100() { alwaysShowOutline }
    @Deprecated void setUnk100(boolean unk100) { this.alwaysShowOutline = unk100 }
    // @formatter:on
}
