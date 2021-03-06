package com.ldtteam.jam.spi.mapping;

import com.google.common.collect.BiMap;

import java.util.Set;

public record MappingResult<T>(Set<T> unmappedSources, BiMap<T, T> mappings, Set<T> unmappedCandidates)
{
}
