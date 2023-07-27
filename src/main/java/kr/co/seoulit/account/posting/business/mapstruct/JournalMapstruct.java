package kr.co.seoulit.account.posting.business.mapstruct;

import kr.co.seoulit.account.posting.business.DTO.JournalDto;
import kr.co.seoulit.account.posting.business.to.JournalEntity;
import kr.co.seoulit.account.sys.common.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JournalMapstruct extends EntityMapper<JournalEntity, JournalDto> {
}
