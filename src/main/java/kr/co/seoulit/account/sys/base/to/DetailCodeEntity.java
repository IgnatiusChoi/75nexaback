package kr.co.seoulit.account.sys.base.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;


@Entity
@IdClass(DetailCodePK.class)
@Dataset(name = "gds_detail_code")
@Table(name = "CODE_DETAIL")
@Getter @Setter
public class DetailCodeEntity extends BaseBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String divisionCodeNo;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String detailCode;
    @Column(columnDefinition = "nvarchar2")
    private String detailCodeName;
    @Column(columnDefinition = "char")
    private String codeUseCheck;
    @Column(columnDefinition = "nvarchar2")
    private String description;


}
