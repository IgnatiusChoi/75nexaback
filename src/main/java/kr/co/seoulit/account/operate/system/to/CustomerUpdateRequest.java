package kr.co.seoulit.account.operate.system.to;

import kr.co.seoulit.account.operate.system.entity.Customer;
import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Dataset(name="ds_customer")
public class CustomerUpdateRequest extends BaseBean {

    public String customerCode;
    public String workplaceCode;
    public String customerName;
    public String customerType;
    public String customerCeo;
    public String businessLicenseNumber;
    public String socialSecurityNumber;
    public String customerBusinessConditions;
    public String customerBusinessItems;
    public String customerZipCode;
    public String customerBasicAddress;
    public String customerDetailAddress;
    public String customerTelNumber;
    public String customerFaxNumber;

    public CustomerUpdateRequest() {
    }

    @Builder
    public CustomerUpdateRequest(String customerCode, String workplaceCode, String customerName, String customerType, String customerCeo, String businessLicenseNumber, String socialSecurityNumber, String customerBusinessConditions, String customerBusinessItems, String customerZipCode, String customerBasicAddress, String customerDetailAddress, String customerTelNumber, String customerFaxNumber) {
        this.customerCode = customerCode;
        this.workplaceCode = workplaceCode;
        this.customerName = customerName;
        this.customerType = customerType;
        this.customerCeo = customerCeo;
        this.businessLicenseNumber = businessLicenseNumber;
        this.socialSecurityNumber = socialSecurityNumber;
        this.customerBusinessConditions = customerBusinessConditions;
        this.customerBusinessItems = customerBusinessItems;
        this.customerZipCode = customerZipCode;
        this.customerBasicAddress = customerBasicAddress;
        this.customerDetailAddress = customerDetailAddress;
        this.customerTelNumber = customerTelNumber;
        this.customerFaxNumber = customerFaxNumber;
    }

    public Customer toEntity(){
        return Customer.builder()
                .customerCode(customerCode)
                .workplaceCode(workplaceCode)
                .customerName(customerName)
                .customerType(customerType)
                .customerCeo(customerCeo)
                .businessLicenseNumber(businessLicenseNumber)
                .socialSecurityNumber(socialSecurityNumber)
                .customerBusinessConditions(customerBusinessConditions)
                .customerBusinessItems(customerBusinessItems)
                .customerZipCode(customerZipCode)
                .customerBasicAddress(customerBasicAddress)
                .customerDetailAddress(customerDetailAddress)
                .customerTelNumber(customerTelNumber)
                .customerFaxNumber(customerFaxNumber)
                .build();
    }
}
