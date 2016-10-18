package ct0

import acmi.l2.clientmod.l2resources.Sysstr
import acmi.l2.clientmod.l2resources.Tex
import acmi.l2.clientmod.util.ArrayLength
import acmi.l2.clientmod.util.Hide
import acmi.l2.clientmod.util.IOUtil
import acmi.l2.clientmod.util.IntValue
import acmi.l2.clientmod.util.Type
import acmi.l2.clientmod.util.defaultio.DefaultIO
import groovy.beans.Bindable
import groovy.transform.CompileStatic

@Bindable
@DefaultIO
@CompileStatic
class Window extends DefaultProperty implements Iterable<DefaultProperty> {
    String parent
    @Tex
    String backTex
    String script
    String state
    Boolean frame
    Boolean iconable
    Boolean stuckable
    Boolean hidden
    Boolean alwaysFullAlpha
    Boolean savePosition
    Boolean saveSize
    @Sysstr
    int title
    Boolean resizeFrame
    int frameSize// = FrameSizeType.None
    int frameDirection// = DirectionType.None
    Boolean exitbutton
    Boolean draggable
    int resizeFrameDirection// = DirectionType.None
    int resizeFrameX
    int resizeFrameY
    float resizeFrameWidth
    float resizeFrameHeight
    int resizeMaxIncrease
    int drawerDirection
    int offsetX
    int offsetY
    int directionFixed
//    @Hide
//    int notUsed01 // offsetX
//    @Hide
//    int notUsed02 // offsetY
//    @Hide
//    int notUsed03 // directionFixed
    int unk127
    int unk128
    String ownerWindow
    int showAnimType// = AnimType.None
    int hideAnimType// = AnimType.None
    int showAnimDirection// = DirectionType.None
    int showAnimSeconds
    int hideAnimDirection// = DirectionType.None
    int hideAnimSeconds
    @Tex
    String iconName
    int tooltipIdx
    Boolean hookKeyInput
    String workingConfiguration
    @Type(DefaultProperty.class)
    List<DefaultProperty> children = []

    @Override
    Iterator<DefaultProperty> iterator() {
        children.iterator()
    }

    enum FrameSizeType implements IntValue {
        None(-1),
        Big(0),
        Small(1)

        final int value

        FrameSizeType(int value) { this.value = value }

        @Override
        int intValue() { value }

        static FrameSizeType valueOf(int val) {
            Optional.ofNullable(values().find { it.value == val })
                    .orElseThrow({
                new IllegalArgumentException("No ${getClass().simpleName} constant with value=$val")
            })
        }
    }

    enum DirectionType {
        None,
        Left,
        Right,
        Top,
        Bottom,
        Free

        static DirectionType valueOf(int val) {
            Optional.ofNullable(values().find { it.ordinal() == val })
                    .orElseThrow({
                new IllegalArgumentException("No ${getClass().simpleName} constant with value=$val")
            })
        }
    }

    enum AnimType implements IntValue {
        None(0),
        AlphaTransition(3),
        PositionTransition(4)

        final int value

        AnimType(int value) { this.value = value }

        @Override
        int intValue() { value }

        static AnimType valueOf(int val) {
            Optional.ofNullable(values().find { it.value == val })
                    .orElseThrow({
                new IllegalArgumentException("No ${getClass().simpleName} constant with value=$val")
            })
        }
    }

    @Override
    Window read(InputStream input) throws IOException {
        super.read(input)
        
        parent = input.readString()
        backTex = input.readString()
        script = input.readString()
        state = input.readString()
        frame = input.readBoolean()
        iconable = input.readBoolean()
        stuckable = input.readBoolean()
        hidden = input.readBoolean()
        alwaysFullAlpha = input.readBoolean()
        savePosition = input.readBoolean()
        saveSize = input.readBoolean()
        title = input.readInt()
        resizeFrame = input.readBoolean()
        frameSize = input.readInt()
        frameDirection = input.readInt()
        exitbutton = input.readBoolean()
        draggable = input.readBoolean()
        resizeFrameDirection = input.readInt()
        resizeFrameX = input.readInt()
        resizeFrameY = input.readInt()
        resizeFrameWidth = input.readFloat()
        resizeFrameHeight = input.readFloat()
        resizeMaxIncrease = input.readInt()
        drawerDirection = input.readInt()
        offsetX = input.readInt()
        offsetY =input.readInt()
        directionFixed = input.readInt()
        unk127 = input.readInt()
        unk128 = input.readInt()
        ownerWindow = input.readString()
        showAnimType = input.readInt()
        hideAnimType = input.readInt()
        showAnimDirection = input.readInt()
        showAnimSeconds = input.readInt()
        hideAnimDirection = input.readInt()
        hideAnimSeconds =  input.readInt()
        iconName = input.readString()
        tooltipIdx = input.readInt()
        hookKeyInput = input.readBoolean()
        workingConfiguration = input.readString()
        
        this
    }

    @Override
    Window write(OutputStream output) throws IOException {
        super.write(output)
        
        output.writeString(parent)
        output.writeString(backTex)        
        output.writeString(script)        
        output.writeString(state)        
        output.writeBoolean(frame)        
        output.writeBoolean(iconable)        
        output.writeBoolean(stuckable)        
        output.writeBoolean(hidden)        
        output.writeBoolean(alwaysFullAlpha)        
        output.writeBoolean(savePosition)        
        output.writeBoolean(saveSize)        
        output.writeInt(title)        
        output.writeBoolean(resizeFrame)
        output.writeInt(frameSize)
        output.writeInt(frameDirection)
        output.writeBoolean(exitbutton)        
        output.writeBoolean(draggable)
        output.writeInt(resizeFrameDirection)
        output.writeInt(resizeFrameX)        
        output.writeInt(resizeFrameY)        
        output.writeFloat(resizeFrameWidth)        
        output.writeFloat(resizeFrameHeight)        
        output.writeInt(resizeMaxIncrease)        
        output.writeInt(drawerDirection)        
        output.writeInt(offsetX)        
        output.writeInt(offsetY)        
        output.writeInt(directionFixed)        
        output.writeInt(unk127)        
        output.writeInt(unk128)        
        output.writeString(ownerWindow)        
        output.writeInt(showAnimType)        
        output.writeInt(hideAnimType)        
        output.writeInt(showAnimDirection)        
        output.writeInt(showAnimSeconds)        
        output.writeInt(hideAnimDirection)        
        output.writeInt(hideAnimSeconds)        
        output.writeString(iconName)        
        output.writeInt(tooltipIdx)        
        output.writeBoolean(hookKeyInput)        
        output.writeString(workingConfiguration)        
        output.writeList(children)  
        
        this
    }

    // @formatter:off
//    @Deprecated String getUnk100() { parent }
//    @Deprecated void setUnk100(String unk100) { this.parent = unk100 }
//
//    @Deprecated String getUnk101() { backTex }
//    @Deprecated void setUnk101(String unk101) { this.backTex = unk101 }
//
//    @Deprecated String getUnk102() { script }
//    @Deprecated void setUnk102(String unk102) { this.script = unk102 }
//
//    @Deprecated String getUnk103() { state }
//    @Deprecated void setUnk103(String unk103) { this.state = unk103 }
//
//    @Deprecated int getUnk104() { IOUtil.boolToInt(frame) }
//    @Deprecated void setUnk104(int unk104) { this.frame = IOUtil.intToBool(unk104) }
//
//    @Deprecated int getUnk105() { IOUtil.boolToInt(iconable) }
//    @Deprecated void setUnk105(int unk105) { this.iconable = IOUtil.intToBool(unk105) }
//
//    @Deprecated int getUnk106() { IOUtil.boolToInt(stuckable) }
//    @Deprecated void setUnk106(int unk106) { this.stuckable = IOUtil.intToBool(unk106) }
//
//    @Deprecated int getUnk107() { IOUtil.boolToInt(hidden) }
//    @Deprecated void setUnk107(int unk107) { this.hidden = IOUtil.intToBool(unk107) }
//
//    @Deprecated int getUnk108() { IOUtil.boolToInt(alwaysFullAlpha) }
//    @Deprecated void setUnk108(int unk108) { this.alwaysFullAlpha = IOUtil.intToBool(unk108) }
//
//    @Deprecated int getUnk109() { IOUtil.boolToInt(savePosition) }
//    @Deprecated void setUnk109(int unk109) { this.savePosition = IOUtil.intToBool(unk109) }
//
//    @Deprecated int getUnk110() { IOUtil.boolToInt(saveSize) }
//    @Deprecated void setUnk110(int unk110) { this.saveSize = IOUtil.intToBool(unk110) }
//
//    @Deprecated int getUnk111() { title }
//    @Deprecated void setUnk111(int unk111) { this.title = unk111 }
//
//    @Deprecated int getUnk112() { IOUtil.boolToInt(resizeFrame) }
//    @Deprecated void setUnk112(int unk112) { this.resizeFrame = IOUtil.intToBool(unk112) }

//    @Deprecated int getUnk113() { frameSize.ordinal() }
//    @Deprecated void setUnk113(int unk113) { this.frameSize = FrameSizeType.valueOf(unk113) }
//
//    @Deprecated int getUnk114() { frameDirection.ordinal() }
//    @Deprecated void setUnk114(int unk114) { this.frameDirection = DirectionType.valueOf(unk114) }
//
//    @Deprecated int getUnk115() { IOUtil.boolToInt(exitbutton) }
//    @Deprecated void setUnk115(int unk115) { this.exitbutton = IOUtil.intToBool(unk115) }
//
//    @Deprecated int getUnk116() { IOUtil.boolToInt(draggable) }
//    @Deprecated void setUnk116(int unk116) { this.draggable = IOUtil.intToBool(unk116) }
//
//    @Deprecated int getUnk117() { resizeFrameDirection.ordinal() }
//    @Deprecated void setUnk117(int unk117) { this.resizeFrameDirection = DirectionType.valueOf(unk117) }
//
//    @Deprecated int getUnk118() { resizeFrameX }
//    @Deprecated void setUnk118(int unk118) { this.resizeFrameX = unk118 }
//
//    @Deprecated int getUnk119() { resizeFrameY }
//    @Deprecated void setUnk119(int unk119) { this.resizeFrameY = unk119 }
//
//    @Deprecated float getUnk120() { resizeFrameWidth }
//    @Deprecated void setUnk120(float unk120) { this.resizeFrameWidth = unk120 }
//
//    @Deprecated float getUnk121() { resizeFrameHeight }
//    @Deprecated void setUnk121(float unk121) { this.resizeFrameHeight = unk121 }
//
//    @Deprecated int getUnk122() { resizeMaxIncrease }
//    @Deprecated void setUnk122(int unk122) { this.resizeMaxIncrease = unk122 }
//
//    @Deprecated int getUnk123() { drawerDirection.ordinal() }
//    @Deprecated void setUnk123(int unk123) { this.drawerDirection = DirectionType.valueOf(unk123) }
//
//    @Deprecated int getUnk124() { offsetX }
//    @Deprecated void setUnk124(int unk124) { this.offsetX = unk124 }
//
//    @Deprecated int getUnk125() { offsetY }
//    @Deprecated void setUnk125(int unk125) { this.offsetY = unk125 }
//
//    @Deprecated int getUnk126() { IOUtil.boolToInt(directionFixed) }
//    @Deprecated void setUnk126(int unk126) { this.directionFixed = IOUtil.intToBool(unk126) }
//
//    @Deprecated String getUnk129() { ownerWindow }
//    @Deprecated void setUnk129(String unk129) { this.ownerWindow = unk129 }
//
//    @Deprecated int getUnk130() { showAnimType.ordinal() }
//    @Deprecated void setUnk130(int unk130) { this.showAnimType = AnimType.valueOf(unk130) }
//
//    @Deprecated int getUnk131() { hideAnimType.ordinal() }
//    @Deprecated void setUnk131(int unk131) { this.hideAnimType = AnimType.valueOf(unk131) }
//
//    @Deprecated int getUnk132() { showAnimDirection.ordinal() }
//    @Deprecated void setUnk132(int unk132) { this.showAnimDirection = DirectionType.valueOf(unk132) }
//
//    @Deprecated int getUnk133() { showAnimSeconds }
//    @Deprecated void setUnk133(int unk133) { this.showAnimSeconds = unk133 }
//
//    @Deprecated int getUnk134() { hideAnimDirection.ordinal() }
//    @Deprecated void setUnk134(int unk134) { this.hideAnimDirection = DirectionType.valueOf(unk134) }
//
//    @Deprecated int getUnk135() { hideAnimSeconds }
//    @Deprecated void setUnk135(int unk135) { this.hideAnimSeconds = unk135 }
//
//    @Deprecated String getUnk136() { iconName }
//    @Deprecated void setUnk136(String unk136) { this.iconName = unk136 }
//
//    @Deprecated int getUnk137() { tooltipIdx }
//    @Deprecated void setUnk137(int unk137) { this.tooltipIdx = unk137 }
//
//    @Deprecated int getUnk138() { IOUtil.boolToInt(hookKeyInput) }
//    @Deprecated void setUnk138(int unk138) { this.hookKeyInput = IOUtil.intToBool(unk138) }
//
//    @Deprecated String getUnk139() { workingConfiguration }
//    @Deprecated void setUnk139(String unk139) { this.workingConfiguration = unk139 }
    // @formatter:on
}
