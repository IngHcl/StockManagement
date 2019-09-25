package com.hcl.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Laxman
 * @date 25 SEPT 2019
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {

	private String emailId;
	private String emailSubject;
	private String textBody;
}
