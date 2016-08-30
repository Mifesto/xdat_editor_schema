package etoa4_p3

import acmi.l2.clientmod.util.defaultio.DefaultIO
import groovy.beans.Bindable
import groovy.transform.CompileStatic

@Bindable
@DefaultIO
@CompileStatic
class FlashCtrl extends DefaultProperty {
    String flashFile
}
