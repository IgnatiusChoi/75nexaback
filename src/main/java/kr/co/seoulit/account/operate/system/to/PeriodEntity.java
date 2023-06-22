package kr.co.seoulit.account.operate.system.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PERIOD")
@Dataset(name = "gds_period")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PeriodEntity extends BaseBean{
//회계기수
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_PERIOD_NO")
	private String accountPeriodNo;

	@Transient
	private String fiscalYear; //그리드 선택 DB 연관없음

	private String workplaceCode;
	private String periodStartDate;
	private String periodEndDate;
}
