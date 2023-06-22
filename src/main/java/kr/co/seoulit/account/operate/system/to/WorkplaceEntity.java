package kr.co.seoulit.account.operate.system.to;

import javax.persistence.*;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WORKPLACE")
@Dataset(name="ds_workplace")
@Getter @Setter
public class WorkplaceEntity extends BaseBean{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WORKPLACE_CODE", columnDefinition = "char")
	private String workplaceCode;
    private String companyCode;
	@Column(name = "WORKPLACE_NAME", columnDefinition = "nvarchar2")
    private String workplaceName;
	@Column(name = "BUSINESS_LICENSE_NUMBER")
    private String businessLicense;
	@Column(name = "CORPORATION_LICENSE_NUMBER")
    private String corporationLicence;
	@Column(name = "WORKPLACE_CEO_NAME", columnDefinition = "nvarchar2")
    private String workplaceCeoName;
	@Column(name = "WORKPLACE_BUSINESS_CONDITIONS", columnDefinition = "nvarchar2")
    private String businessConditions;
	@Column(name = "WORKPLACE_BUSINESS_ITEMS", columnDefinition = "nvarchar2")
    private String businessItems;
    private String workplaceTelNumber;
    private String workplaceFaxNumber;
	@Column(name = "WORKPLACE_BASIC_ADDRESS", columnDefinition = "nvarchar2")
    private String workplaceBasicAddress;
    private String approvalStatus; 
    private String workplaceZipCode;
	@Column(name = "WORKPLACE_DETAIL_ADDRESS", columnDefinition = "nvarchar2")
    private String workplaceDetailAddress;
    @Transient
    private String checked;
    
    
    
	

}
