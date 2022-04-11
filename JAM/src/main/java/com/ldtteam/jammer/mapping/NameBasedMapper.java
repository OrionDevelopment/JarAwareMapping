package com.ldtteam.jammer.mapping;

import com.ldtteam.jam.jamspec.mapping.IMapper;
import com.ldtteam.jam.jamspec.name.INameProvider;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Optional;
import java.util.Set;

public class NameBasedMapper<T> extends SingleEntryBasedMapper<T>
{

    public static IMapper<ClassNode> classes() {
        return new NameBasedMapper<>(INameProvider.classes());
    }

    public static IMapper<MethodNode> methods() {
        return new NameBasedMapper<>(INameProvider.methods());
    }

    public static IMapper<FieldNode> fields() {
        return new NameBasedMapper<>(INameProvider.fields());
    }

    private final INameProvider<T> nameProvider;

    private NameBasedMapper(final INameProvider<T> nameProvider) {this.nameProvider = nameProvider;}

    @Override
    protected Optional<T> map(final T source, final Set<T> candidates)
    {
        final String sourceName = nameProvider.getName(source);
        return candidates.stream().filter(candidate -> nameProvider.getName(candidate).equals(sourceName)).findFirst();
    }
}
