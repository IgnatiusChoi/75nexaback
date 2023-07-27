package kr.co.seoulit.account.posting.business.mapstruct;

import kr.co.seoulit.account.posting.business.DTO.SlipDto;
import kr.co.seoulit.account.posting.business.to.SlipEntity;
import kr.co.seoulit.account.sys.common.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SlipMapstruct extends EntityMapper<SlipEntity, SlipDto> {
}
