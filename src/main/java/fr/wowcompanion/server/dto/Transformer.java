package fr.wowcompanion.server.dto;

import java.util.ArrayList;
import java.util.List;

public interface Transformer<I,O> {

    public abstract O transform(I input);

    public default List<O> transformAll(final List<I> inputList) {
        final List<O> outpuList = new ArrayList<>();
        inputList.forEach(input -> outpuList.add(this.transform(input)));
        return outpuList;
    }

}
