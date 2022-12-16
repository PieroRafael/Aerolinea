package com.aerolinea.aerolinea.mapper;

import java.util.List;

public interface IMapper<I, O> {

    public O toDomain(I in);

    public I toDto(O out);

    public List<O> toLstDomain(List<I> LstDto);

    public List<I> toLstDto(List<O> LstDomain);

}
