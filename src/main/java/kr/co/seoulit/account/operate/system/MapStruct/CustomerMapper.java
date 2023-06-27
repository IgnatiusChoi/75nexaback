package kr.co.seoulit.account.operate.system.MapStruct;

import kr.co.seoulit.account.operate.system.entity.Customer;
import kr.co.seoulit.account.operate.system.to.CustomerUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerUpdateRequest toCustomerDTO(Customer customer);
}
