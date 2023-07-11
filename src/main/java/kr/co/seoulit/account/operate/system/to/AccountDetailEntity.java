package kr.co.seoulit.account.operate.system.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
@Dataset(name = "gds_account_detail")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountDetailEntity extends BaseBean {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_INNER_CODE")
    private String accountInnerCode;
    @Column(name = "PARENT_ACCOUNT_INNER_CODE")
    private String parentAccountInnerCode;
    @Column(name = "ACCOUNT_CODE")
    private String accountCode;
    @Column(name="GROUP_CODE")
    private String groupCode;
    @Column(name = "ACCOUNT_NAME", columnDefinition = "nvarchar2")
    private String accountName;


}
