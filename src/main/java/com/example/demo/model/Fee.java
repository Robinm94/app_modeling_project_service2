package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@ToString
public class Fee {

    public enum FeeType {
        BUY, SELL
    }

    @Id
    @JsonProperty("id")
    private String feeId;

    @JsonProperty("type")
    private FeeType feeType;

    @JsonProperty("amount")
    private float feeAmount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate feeDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime feeTime;

    @JsonProperty("sales_tax")
    private float salesTax;

    // Manual constructor (no builder)
    public Fee(FeeType feeType, float feeAmount, float salesTax, LocalDate feeDate, LocalTime feeTime) {
        this.feeType = feeType;
        this.feeAmount = feeAmount;
        this.salesTax = salesTax;
        this.feeDate = feeDate;
        this.feeTime = feeTime;
    }

	public String getFeeId() {
		return feeId;
	}

	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}

	public FeeType getFeeType() {
		return feeType;
	}

	public void setFeeType(FeeType feeType) {
		this.feeType = feeType;
	}

	public float getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(float feeAmount) {
		this.feeAmount = feeAmount;
	}

	public LocalDate getFeeDate() {
		return feeDate;
	}

	public void setFeeDate(LocalDate feeDate) {
		this.feeDate = feeDate;
	}

	public LocalTime getFeeTime() {
		return feeTime;
	}

	public void setFeeTime(LocalTime feeTime) {
		this.feeTime = feeTime;
	}

	public float getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(float salesTax) {
		this.salesTax = salesTax;
	}
    
    
}
