package com.telus.ds.entity.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class BorrowedBookDTO {
	private Integer userid;
	private LocalDateTime returnDate;
	private LocalDateTime borrowDate;
	private Integer renewalQuantity;
	private Integer bookid;
}
