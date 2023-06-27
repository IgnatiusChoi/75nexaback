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
    @Column(name = "ACCOUNT_CHARACTER", columnDefinition = "nvarchar2")
    private String accountCharacter;
    @Column(name = "ACCOUNT_NAME", columnDefinition = "nvarchar2")
    private String accountName;
    @Column(name = "ACCOUNT_USE_CHECK", columnDefinition = "char")
    private String accountUseCheck;
    @Column(name = "ACCOUNT_DESCRIPTION", columnDefinition = "nvarchar2")
    private String accountDescription;
    @Column(name = "EDITABLE", columnDefinition = "number")
    private String editable;
    @Column(name = "BUDGET", columnDefinition = "char")
    private String budget;
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "accountCodeId")
//    private List<AccountControlEntity> accountControlList;
    @Transient
    private String editform;
    @Transient
	private String lev;

}
