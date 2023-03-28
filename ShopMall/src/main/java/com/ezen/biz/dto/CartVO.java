package com.ezen.biz.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartVO {
	/*
	 * c.CSEQ,c.ID,m.NAME MANME,p.PSEQ,c.quantity,p.PRICE2,c.INDATE,c.RESULT FROM
	 * CART c, MEMBER m, PRODUCT p
	 */
	private int cseq;
	private String id;
	private int pseq;
	private String mname;
	private String pname;
	private int quantity;
	private int price2;
	private Date indate;
}
