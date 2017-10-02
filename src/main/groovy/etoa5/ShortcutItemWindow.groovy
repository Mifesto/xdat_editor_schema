package etoa5

import acmi.l2.clientmod.util.defaultio.DefaultIO
import groovy.beans.Bindable
import groovy.transform.CompileStatic

@Bindable
@DefaultIO
@CompileStatic
class ShortcutItemWindow extends DefaultProperty {
    Boolean alwaysShowOutline = false
    Boolean useReservedShortcut = false

    // @formatter:off
    @Deprecated boolean getUnk100() { alwaysShowOutline }
    @Deprecated void setUnk100(boolean unk100) { this.alwaysShowOutline = unk100 }

    @Deprecated  boolean getUnk101() { useReservedShortcut }
    @Deprecated void setUnk101(boolean unk101) { this.useReservedShortcut = unk101 }
    // @formatter:on
}
