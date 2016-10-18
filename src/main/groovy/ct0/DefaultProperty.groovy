package ct0

import acmi.l2.clientmod.l2resources.Sysstr
import acmi.l2.clientmod.util.IOUtil
import acmi.l2.clientmod.util.UIEntity
import groovy.beans.Bindable
import groovy.transform.CompileStatic

@Bindable
@CompileStatic
abstract class DefaultProperty implements UIEntity {
    String name = 'undefined'
    String superName = 'undefined'
    Boolean alwaysOnTop
    Boolean alwaysOnBack
    String parentName = 'undefined'
    String preOrder = 'undefined'
    String postOrder = 'undefined'
    Boolean anchored
    Boolean size = false
    Boolean size_absolute_values = true
    String size_percent_window
    float size_percent_width
    float size_percent_height
    int size_absolute_width
    int size_absolute_height
    Boolean usePosition = false
    Alignment relativePoint = Alignment.NONE
    Alignment anchorPoint = Alignment.NONE
    String relativeTo = 'undefined'
    int anchor_x
    int anchor_y
    int unk22
    Boolean virtual
    int unk24
    String tooltipType = 'undefined'
    @Sysstr
    int tooltipText = -9999

    @Override
    DefaultProperty read(InputStream input) {
        name = input.readString()
        superName = input.readString()
        alwaysOnTop = input.readBoolean()
        alwaysOnBack = input.readBoolean()
        parentName = input.readString()
        preOrder = input.readString()
        postOrder = input.readString()
        anchored = input.readBoolean()
        size = input.readBoolean()
        if (size) {
            size_absolute_values = input.readBoolean()
            if (!size_absolute_values) {
                size_percent_window = input.readString()
                size_percent_width = input.readFloat()
                size_percent_height = input.readFloat()
            }
            size_absolute_width = input.readInt()
            size_absolute_height = input.readInt()
        }
        usePosition = input.readBoolean()
        if (usePosition) {
            relativePoint = Alignment.values()[input.readInt()]
            anchorPoint = Alignment.values()[input.readInt()]
            relativeTo = input.readString()
            anchor_x = input.readInt()
            anchor_y = input.readInt()
        }
        unk22 = input.readInt()
        virtual = input.readBoolean()
        unk24 = input.readInt()
        tooltipType = input.readString()
        tooltipText = input.readInt()

        this
    }

    @Override
    DefaultProperty write(OutputStream output) {
        output.writeString(name)
        output.writeString(superName)
        output.writeBoolean(alwaysOnTop)
        output.writeBoolean(alwaysOnBack)
        output.writeString(parentName)
        output.writeString(preOrder)
        output.writeString(postOrder)
        output.writeBoolean(anchored)
        output.writeBoolean(size)
        if (size) {
            output.writeBoolean(size_absolute_values)
            if (!size_absolute_values) {
                output.writeString(size_percent_window)
                output.writeFloat(size_percent_width)
                output.writeFloat(size_percent_height)
            }
            output.writeInt(size_absolute_width)
            output.writeInt(size_absolute_height)
        }
        output.writeBoolean(usePosition)
        if (usePosition) {
            output.writeInt(relativePoint.ordinal())
            output.writeInt(anchorPoint.ordinal())
            output.writeString(relativeTo)
            output.writeInt(anchor_x)
            output.writeInt(anchor_y)
        }
        output.writeInt(unk22)
        output.writeBoolean(virtual)
        output.writeInt(unk24)
        output.writeString(tooltipType)
        output.writeInt(tooltipText)

        this
    }

    @Override
    String toString() {
        "$name[${getClass().simpleName}]"
    }

    //@formatter:off
    @Deprecated String getSuperName() { superName }
    @Deprecated void setSuperName(String superName) { this.superName = superName }

    @Deprecated int getUnk2() { IOUtil.boolToInt(alwaysOnTop) }
    @Deprecated void setUnk2(int unk2) { this.alwaysOnTop = IOUtil.intToBool(unk2) }

    @Deprecated int getUnk3() { IOUtil.boolToInt(alwaysOnBack) }
    @Deprecated void setUnk3(int unk3) { this.alwaysOnBack = IOUtil.intToBool(unk3) }

    @Deprecated String getUnk4() { parentName }
    @Deprecated void setUnk4(String unk4) { this.parentName = unk4 }

    @Deprecated String getUnk5() { preOrder }
    @Deprecated void setUnk5(String unk5) { this.preOrder = unk5 }

    @Deprecated String getUnk6() { postOrder }
    @Deprecated void setUnk6(String unk6) { this.postOrder = unk6 }

    @Deprecated int getUnk7() { IOUtil.boolToInt(anchored) }
    @Deprecated void setUnk7(int unk7) { this.anchored = IOUtil.intToBool(unk7) }

    @Deprecated boolean getSize() { size }
    @Deprecated void setSize(boolean size) { this.size = size }

    @Deprecated boolean getSize_absolute_values() { size_absolute_values }
    @Deprecated void setSize_absolute_values(boolean size_absolute_values) { this.size_absolute_values = size_absolute_values }

    @Deprecated float getSize_percent_width() { size_percent_width }
    @Deprecated void setSize_percent_width(float size_percent_width) { this.size_percent_width = size_percent_width }

    @Deprecated float getSize_percent_height() { size_percent_height }
    @Deprecated void setSize_percent_height(float size_percent_height) { this.size_percent_height = size_percent_height }

    @Deprecated int getSize_absolute_width() { size_absolute_width }
    @Deprecated void setSize_absolute_width(int size_absolute_width) { this.size_absolute_width = size_absolute_width }

    @Deprecated int getSize_absolute_height() { size_absolute_height }
    @Deprecated void setSize_absolute_height(int size_absolute_height) { this.size_absolute_height = size_absolute_height }

    @Deprecated boolean getAnchor() { usePosition }
    @Deprecated void setAnchor(boolean anchor) { this.usePosition = anchor }

    @Deprecated Alignment getAnchor_parent() { relativePoint }
    @Deprecated void setAnchor_parent(Alignment anchor_parent) { this.relativePoint = anchor_parent }

    @Deprecated Alignment getAnchor_this() { anchorPoint }
    @Deprecated void setAnchor_this(Alignment anchor_this) { this.anchorPoint = anchor_this }

    @Deprecated String getAnchor_ctrl() { relativeTo }
    @Deprecated void setAnchor_ctrl(String anchor_ctrl) { this.relativeTo = anchor_ctrl }

    @Deprecated int getAnchor_x() { anchor_x }
    @Deprecated void setAnchor_x(int anchor_x) { this.anchor_x = anchor_x }

    @Deprecated int getAnchor_y() { anchor_y }
    @Deprecated void setAnchor_y(int anchor_y) { this.anchor_y = anchor_y }

    @Deprecated int getUnk23() { IOUtil.boolToInt(virtual) }
    @Deprecated void setUnk23(int unk23) { this.virtual = IOUtil.intToBool(unk23) }

    @Deprecated String getPopupType() { tooltipType }
    @Deprecated void setPopupType(String popupType) { this.tooltipType = popupType }

    @Deprecated int getPopupValue() { tooltipText }
    @Deprecated void setPopupValue(int popupValue) { this.tooltipText = popupValue }
    //@formatter:on
}
