package com.isaquematos.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), //atribuindo números para evitar erros futuros
	PAID(2),
	SHPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	//construtor enumerado é especial, por isso é private
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		//percorrendo todos valores do order status
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {//verifica se o código digitado está no orderstatus
				return value;
			}
		}
		//caso não esteja é lançado uma exceção
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
