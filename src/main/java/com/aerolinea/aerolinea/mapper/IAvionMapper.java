package com.aerolinea.aerolinea.mapper;

import java.util.List;

public interface IAvionMapper<I, O, K> {

    public O toDomain(I in);

    public I toDto(O out);

    public K toDtoAvion(O in);

    public List<O> toLstDomain(List<I> LstDto);

    public List<I> toLstDto(List<O> LstDomain);

    public List<K> toLstDtoAvion(List<O> LstDto);

}
