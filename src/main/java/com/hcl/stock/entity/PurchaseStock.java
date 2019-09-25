/**
 * @author User1
 * @name PurchaseStock.java
 * @date Sep 25, 2019
 */
package com.hcl.stock.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author User1
 *
 */
@Entity
@Setter
@Getter
public class PurchaseStock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer purchaseStockId;
	private Integer userId;
	private Double purchasePrice;
	private Integer stockQuantity;
	private Integer stockId;
	private LocalDate purchsedDate;
	private Double brokerageAmount;

}
