package kr.co.seoulit.account.operate.system.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;

@Entity
@Dataset(name = "gds_loginAuthority")
@IdClass(AuthorityMenuPK.class)
@Table(name = "AUTHORITY_MENU")
@Getter @Setter
public class AuthorityMenuEntity extends BaseBean implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTHORITY_CODE")
	private String authorityCode;

	@Column(name = "AUTHORITY_NAME")
	private String authorityName;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MENU_CODE")
	private String menuCode;

	@Column(name = "MENU_NAME")
	private String menuName;

	@Transient
    private String empCode;
	@Transient
    private String empName;
	@Transient
    private String isAuthority;
	@Transient
    private String authority;
	@Transient
    private String deptCode;
	@Transient
    private String authorityGroup;
	@Transient
    private String url;
    @Transient
	private String authorityLevel;
}
