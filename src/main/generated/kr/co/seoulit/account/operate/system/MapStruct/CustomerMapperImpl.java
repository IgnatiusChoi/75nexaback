package kr.co.seoulit.account.operate.system.MapStruct;

import javax.annotation.processing.Generated;
import kr.co.seoulit.account.operate.system.entity.Customer;
import kr.co.seoulit.account.operate.system.to.CustomerUpdateRequest;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-22T19:02:55+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerUpdateRequest toCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerUpdateRequest.CustomerUpdateRequestBuilder customerUpdateRequest = CustomerUpdateRequest.builder();

        customerUpdateRequest.customerCode( customer.getCustomerCode() );
        customerUpdateRequest.workplaceCode( customer.getWorkplaceCode() );
        customerUpdateRequest.customerName( customer.getCustomerName() );
        customerUpdateRequest.customerType( customer.getCustomerType() );
        customerUpdateRequest.customerCeo( customer.getCustomerCeo() );
        customerUpdateRequest.businessLicenseNumber( customer.getBusinessLicenseNumber() );
        customerUpdateRequest.socialSecurityNumber( customer.getSocialSecurityNumber() );
        customerUpdateRequest.customerBusinessConditions( customer.getCustomerBusinessConditions() );
        customerUpdateRequest.customerBusinessItems( customer.getCustomerBusinessItems() );
        customerUpdateRequest.customerZipCode( customer.getCustomerZipCode() );
        customerUpdateRequest.customerBasicAddress( customer.getCustomerBasicAddress() );
        customerUpdateRequest.customerDetailAddress( customer.getCustomerDetailAddress() );
        customerUpdateRequest.customerTelNumber( customer.getCustomerTelNumber() );
        customerUpdateRequest.customerFaxNumber( customer.getCustomerFaxNumber() );

        return customerUpdateRequest.build();
    }
}
