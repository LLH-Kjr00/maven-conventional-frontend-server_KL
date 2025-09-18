package com.cmt.vending.server.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * More detailed information of this Vending Machine
 */
@XmlRootElement
public class VmInfo {
	@Getter @Setter
	private boolean enabled;			// If the vending machine is not enabled -> all UI cells cannot be selected (WebSocketHandler: getVmInfoResult)

	@Setter
	private int[] paymentMethods;		// Payment methods: 1: Octopus; 4: WechatPay; 5: Alipay
	
	// VIP : Special rate for specified card ID
	@Getter @Setter
	private boolean vip;
	@Getter @Setter
	private int vipDiscountType;		// 1: fixed amount, 2: fixed percentage
	@Getter @Setter
	private BigDecimal vipDiscountAmount;
	@Getter @Setter
	private BigDecimal vipDiscountPercentage;

	// Temperature Setting
	@Getter @Setter
	private BigDecimal tempMin = new BigDecimal(5);
	@Getter @Setter
	private BigDecimal tempMax = new BigDecimal(10);
	@Getter @Setter
	private BigDecimal tempTarget = new BigDecimal(5);
	@Getter @Setter
	private Integer tempOperMode = 2;		// 1: Room, 2: Cold, 3: Hot
	@Getter @Setter
	private String tempFanFlag = "Y";		// Y: Fan Open

	@XmlElementWrapper(name="paymentMethods")  
    @XmlElement(name="paymentMethod")  
	public int[] getPaymentMethods() {
		return this.paymentMethods;
	}
}
