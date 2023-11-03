package com.model;

import java.sql.Date;



import lombok.Builder;
import lombok.Data;


@Data

@Builder
public class FeedBackResponse {
	private Integer feedbackId;
	private String feedbackTitle;
	private String feedbackFrom;
	private String feedbackBody;
	private Date feedbackDate;
	private Boolean feedbackAcknowledge;
}