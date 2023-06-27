package kr.co.seoulit.account.operate.system.entity;

import kr.co.seoulit.account.operate.system.to.CustomerUpdateRequest;
import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Dataset(name="ds_customer")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Customer extends BaseBean {

    @Id
    public String customerCode;
    public String workplaceCode;
    public String customerName;
    public String customerType;
    public String customerCeo;
    public String businessLicenseNumber;
    public String socialSecurityNumber;
    @Column(columnDefinition = "nvarchar2")
    public String customerBusinessConditions;
    public String customerBusinessItems;
    public String customerZipCode;
    @Column(columnDefinition = "nvarchar2")
    public String customerBasicAddress;
    public String customerDetailAddress;
    public String customerTelNumber;
    public String customerFaxNumber;
    public String customerNote;
    public String accountNumber;
    public String cardNumber;
    public String cardType;
    public String cardMemberName;
    public String cardOpenPlace;
    public String financialInstituteCode;
    public String financialInstituteName;
    @Transient
    private String checked;

    public Customer() {
    }

    public void updateCustomer(String customerCeo) {
        this.customerCeo = customerCeo;
    }

    public void updateCustomerList(List<String> customerCeo){

    }

}
