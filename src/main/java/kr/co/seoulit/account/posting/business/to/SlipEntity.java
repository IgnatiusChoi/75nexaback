package kr.co.seoulit.account.posting.business.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;

@Entity
@Dataset(name = "gds_slip")
@Table(name = "SLIP")
@Getter @Setter
public class SlipEntity extends BaseBean {

	@Id
    private String slipNo;
    private String accountPeriodNo;
    private String deptCode;
    @Column(columnDefinition = "nchar")
    private String slipType;
    @Column(columnDefinition = "nvarchar2")
    private String expenseReport;
//    @Column(columnDefinition = "nchar")
//    private String authorizationStatus;
    private String reportingEmpCode;
    private String reportingDate;
    private String approvalEmpCode;
    private String approvalDate;
//    @Column(columnDefinition = "nvarchar2")
//    private String slipDescription;
    private String slipStatus;

//	@Transient
//    private String id;	
//	@Transient
//    private String deptName;
//	@Transient
//    private String reportingEmpName;
//	@Transient
//    private String balanceDivision;
//	@Transient
//    private String positionCode;
}
