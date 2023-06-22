package kr.co.seoulit.account.posting.ledger.to;

import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Dataset(name="ds_cashJournal")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CashJournalBean {
	private String monthReportingDate;
	private String reportingDate;
	private String expenseReport;
	private String customerCode;
	private String customerName;
	private int deposit;
	private int withdrawal;
	private int balance;
	
	
	
}