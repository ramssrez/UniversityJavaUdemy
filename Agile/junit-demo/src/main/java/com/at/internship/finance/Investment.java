package com.at.internship.finance;

import java.math.BigDecimal;

public class Investment {

    private BigDecimal initialCapital;
    private BigDecimal interestRate;

    public Investment(BigDecimal initialCapital, BigDecimal interestRate) {
        if(initialCapital == null) throw new IllegalArgumentException("Initial capital is required");
        if(interestRate == null) throw new IllegalArgumentException("Interest rate is required");
        if(BigDecimal.ZERO.compareTo(initialCapital) > 0) throw new IllegalArgumentException("Initial capital should be 0 at minimum");
        if(BigDecimal.ZERO.compareTo(interestRate) > 0) throw new IllegalArgumentException("Interest rate should be 0 at minimum");
        this.initialCapital = initialCapital;
        this.interestRate = interestRate;
    }

    public BigDecimal getInitialCapital() {
        return initialCapital;
    }

    public void setInitialCapital(BigDecimal initialCapital) {
        this.initialCapital = initialCapital;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    BigDecimal getFinalCapital(int periods) {
        validatePeriodCount(periods);
        return BigDecimal.ONE.add(interestRate).pow(periods).multiply(initialCapital);
    }

    BigDecimal getYield(int periods) {
        return getFinalCapital(periods).subtract(initialCapital);
    }

    void validatePeriodCount(int periods) {
        if(periods <= 0) throw new IllegalArgumentException("The number of periods should be 1 at minimum");
    }

}
