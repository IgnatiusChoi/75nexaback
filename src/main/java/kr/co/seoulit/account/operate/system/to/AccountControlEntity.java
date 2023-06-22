package kr.co.seoulit.account.operate.system.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "ACCOUNT_CONTROL_DETAIL")
@Getter @Setter
@Dataset(name = "gds_account_control_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountControlEntity extends BaseBean {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_CONTROL_CODE")
    private String accountControlCode;
    private String accountControlName;
    private String accountControlType;
    @Column(name = "DESCRIPTION")
    private String accountControlDescription;
    

}
