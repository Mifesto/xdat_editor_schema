package ct0

import acmi.l2.clientmod.l2resources.Sysstr
import acmi.l2.clientmod.util.IOEntity
import acmi.l2.clientmod.util.Type
import acmi.l2.clientmod.util.defaultio.DefaultIO
import groovy.beans.Bindable

@Bindable
@DefaultIO
class ListCtrl extends DefaultProperty {
    int unk100
    int unk101
    int unk102
    int unk103
    int unk104
    @Type(ListElement.class)
    List<ListElement> values = []

    @Bindable
    @DefaultIO
    static class ListElement implements IOEntity {
        @Sysstr
        int textStringId
        int width
        boolean unk108
        boolean unk109
        boolean unk110

        @Override
        String toString() {
            return getClass().simpleName
        }
    }
}
