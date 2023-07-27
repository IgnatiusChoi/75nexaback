package kr.co.seoulit.account.sys.common.mapper;

import java.util.ArrayList;
import java.util.List;

public interface EntityMapper<E,D> {

    //ReqMapper
    E toEntity(D dto);
    ArrayList<E> toEntity(ArrayList<D> dtos);
    List<E> toEntity(List<D> dtos);

    //ResMapper
    D toDto(E entity);
    List<D> toDto(List<E> entities);
    ArrayList<D> toDto(ArrayList<E> entities);
}
