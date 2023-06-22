package kr.co.seoulit.account.sys.base.to;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter @Setter
public class DetailCodePK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String divisionCodeNo;
    private String detailCode;
}