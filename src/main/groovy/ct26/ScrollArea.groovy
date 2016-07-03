package ct26

import acmi.l2.clientmod.util.ComponentFactory
import acmi.l2.clientmod.util.IOUtil
import acmi.l2.clientmod.util.Type
import groovyx.javafx.beans.FXBindable
import javafx.beans.InvalidationListener
import javafx.scene.layout.Pane

@FXBindable
class ScrollArea extends DefaultProperty implements Iterable<DefaultProperty>, ComponentFactory<Pane> {
    int areaHeight
    @Type(DefaultProperty.class)
    List<DefaultProperty> children = []

    @Override
    Iterator<DefaultProperty> iterator() {
        children.iterator()
    }

    {
        resourcesProperty().addListener({ observable ->
            children.each {
                it.resources = resources
            }
        } as InvalidationListener)
    }

    @Override
    Pane create() {
        def component = new Pane()
        component.children.addAll(children.collect { it.component })
        component
    }

    @Override
    void initProperties(Pane component) {
        super.initProperties(component)
    }

    @Override
    ScrollArea read(InputStream input) {
        super.read(input)

        use(IOUtil) {
            areaHeight = input.readInt()
            children = input.readList(DefaultProperty)
        }

        this
    }

    @Override
    ScrollArea write(OutputStream output) {
        super.write(output)

        use(IOUtil) {
            output.writeInt(areaHeight)
            output.writeInt(children.size())
            for (DefaultProperty child : children)
                output.writeUIEntity(child)
        }

        this
    }

    // @formatter:off
    @Deprecated int getUnk100() { areaHeight }
    @Deprecated void setUnk100(int unk100) { this.areaHeight = unk100 }
    // @formatter:on
}
