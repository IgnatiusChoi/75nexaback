package kr.co.seoulit.account.operate.humanresource.to;

import javax.persistence.*;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;
@Entity
@Dataset(name = "gds_emp")
@Table(name = "EMPLOYEE")
@Getter@Setter
public class EmployeeEntity extends BaseBean {
    private String BasicAddress;
    private String DetailAddress;
    private String userOrNot;
    private String deptName;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_CODE", columnDefinition = "nvarchar2")
    private String empCode;

    @Column(name = "EMP_NAME", columnDefinition = "nvarchar2")
    private String empName;

    @Column(name = "COMPANY_CODE", columnDefinition = "nvarchar2")
    private String companyCode;

    private String workplaceCode;
    private String deptCode;
    private String positionCode;
    private String positionName;
    private String socialSecurityNumber;
    private String birthDate;
    private String gender;
    private String email;
    private String phoneNumber;
    private String Image;
    private String userPw;
    private String ZipCode;
    private String levelOfEducation;


}
