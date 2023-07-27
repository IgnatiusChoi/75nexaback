package kr.co.seoulit.account.posting.business.DTO;

import kr.co.seoulit.account.posting.business.to.JournalDetailEntity;
import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Dataset(name="gds_journal")
public class JournalDto extends BaseBean {

    private String journalNo;

    private String slipNo;

    private String balanceDivision;

    private String accountInnerCode;

    private String accountName;
    private String customerCode;
    private String customerName;

    private String leftDebtorPrice;

    private String rightCreditsPrice;

    private List<JournalDetailDto> journalDetailList;
}
