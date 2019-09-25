/**
 * @author User1
 * @name Stock.java
 * @date Sep 25, 2019
 */
package com.hcl.stock.entity;

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
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stockId;
	private String stockName;
	private Double stockPrice;
	private Integer stockQuantity;
	private String stockDescription;

}
