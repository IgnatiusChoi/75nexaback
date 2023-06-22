package kr.co.seoulit.account.operate.system.to;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class AuthorityMenuPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String authorityCode;
    private String menuCode;
}
