package com.tempus.gss.product.hol.api.entity.response.tc;

import java.io.Serializable;

/**
 * 同程订单状态枚举类
 * @author kai.yang
 *
 */
public enum TcOrderStatus implements Serializable{
	/**
	 * 默认状态
	 */
	ORIGINAL("-1","默认状态"),
	/**
	 * 待确认库存
	 */
	WATI_CONFIRM_INVENTORY("0","待确认库存"),
	/**
	 * 待支付
	 */
	WAIT_PAY("1","待支付"),
	/**
	 * 已取消
	 */
	ALREADY_CANCEL("2","已取消"),
	/**
	 * 已取消
	 */
	ALREADY_REFUND_CANCEL("222","退款取消"),
	/**
	 * 已支付
	 */
	ALREADY_PAY("3","已支付"),
	/**
	 * 待同程确认
	 */
	WAIT_TC_CONFIRM("5","待酒店确认"),
	/**
	 * 同程已确认
	 */
	ALREADY_TC_CONFIRM("10","酒店已确认"),
	/**
	 * 确认入住
	 */
	CONFIRM_TO_ROOM("11","确认入住"),
	/**
	 * 确认未住
	 */
	CONFIRM_NOT_TO_ROOM("12","确认未住"),
	/**
	 * 申请部分退款(有人出游)
	 */
	APPLY_PART_REFUND("15","申请部分退款(有人出游)"),
	/**
	 * 申请全额退款
	 */
	APPLY_ALL_REFUND("20","申请全额退款"),
	/**
	 * 全额退款结束
	 */
	FINISH_ALL_REFUND("25","全额退款结束"),
	/**
	 * 部分退款结束
	 */
	FINISH_PART_REFUND("30","部分退款结束"),
	/**
	 * 已结算
	 */
	ALREADY_ACCOUNT("35","已结算"),
	/**
	 * 订单结束
	 */
	ORDER_FINISH("40","订单结束"),
	/**
	 * 新单
	 */
	NEW_ORDER("45","新单"),
	/**
	 * 订单变更
	 */
	ORDER_CHANGED("50","订单变化"),
	
	/**
	 * 支付失败
	 */
	PAY_BAD("999","支付失败"),
	
	/**
	 * 变价
	 */
	CHANGE_PRICE("301", "变价"),
	
	/**
	 * 退订中
	 */
	CANCEL_ING("401","退订中"),
	
	/**
	 * 已退订
	 */
	CANCEL_FINISH("508","已退订"),

	/**
	 * 已拒绝
	 */
	HAS_REFUSED_TO("000","已拒绝");
	
	private String key;
	private String value;
	
	private TcOrderStatus(String key,String value) {
        this.key=key;
        this.value=value;
    }
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	 public static TcOrderStatus keyOf(String index)
	    {
	        for (TcOrderStatus key : values())
	        {
	            if (key.getKey().equals(index))
	            {
	                return key;
	            }
	        }
	        return null;
	    }
	
	 public static TcOrderStatus bqyKey(String key){
		 switch (key) {
			
		case "2":	//待确认
			return WAIT_TC_CONFIRM;
			
		case "3":	//已确认
			return ALREADY_TC_CONFIRM;
		case "33":	//已支付
			return ALREADY_PAY;
		case "5":	//退订中
			return CANCEL_ING;
		case "9":	//已取消
			return ALREADY_CANCEL;
		default:
			for (TcOrderStatus tcOrderStatus : values()) {
	            if (tcOrderStatus.getKey().equals(key)) {
	                return tcOrderStatus;
	            }
	        }
	        return null;
		}
		 
	 }

	public static TcOrderStatus zhxKey(String key){
		switch (key) {
			case "CON":	//已确认
				return ALREADY_TC_CONFIRM;
			case "RCM":	//确认入住
				return CONFIRM_TO_ROOM;
			case "CAN":	//已取消
				return ALREADY_CANCEL;
			default:
				for (TcOrderStatus tcOrderStatus : values()) {
					if (tcOrderStatus.getKey().equals(key)) {
						return tcOrderStatus;
					}
				}
				return null;
		}

	}

	public static TcOrderStatus ndaKey(String key){
		switch (key) {
			case "paid":	//已支付
				return ALREADY_PAY;
			case "confirmPass":	//确认入住
				return ALREADY_TC_CONFIRM;
			case "refused":	//已拒绝
				return HAS_REFUSED_TO;
			case "canceled":	//取消
				return ALREADY_CANCEL;
			case "toPay":	//待支付
				return WAIT_PAY;
			case "finished":	//已完成
				return ORDER_FINISH;
			case "toConfirm":	//待确认
				return WAIT_TC_CONFIRM;
			case "auditedToConfirm":	//已审核待确认
				return ORIGINAL;
			default:
				for (TcOrderStatus tcOrderStatus : values()) {
					if (tcOrderStatus.getKey().equals(key)) {
						return tcOrderStatus;
					}
				}
				return null;
		}

	}
}
