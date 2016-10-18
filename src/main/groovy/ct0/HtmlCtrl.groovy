package ct0

import acmi.l2.clientmod.util.Description
import acmi.l2.clientmod.util.defaultio.DefaultIO
import groovy.beans.Bindable
import groovy.transform.CompileStatic

@Bindable
@DefaultIO
@CompileStatic
class HtmlCtrl extends DefaultProperty {
    @Description("''/'Normal'/'Help'/'BBS'")
    String viewType = "Normal"

    // @formatter:off
    @Deprecated String getType() { viewType }
    @Deprecated void setType(String type) { this.viewType = type }
    // @formatter:on
}
