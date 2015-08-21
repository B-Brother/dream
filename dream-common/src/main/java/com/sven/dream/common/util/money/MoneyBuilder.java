package com.sven.dream.common.util.money;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;

import static com.sven.dream.common.util.money.Money.DEFAULT_CURRENCY_CODE;
 
/**
 * 
 * 金额生成器
 * 
 * @author beckham
 *
 */
public class MoneyBuilder {

	@SuppressWarnings("unused")
	private Currency currency;
    
	private BigDecimal cent;
    
	/**
	 * 传入已经转换成分的金额数目和当前币种，生成金额生成器
	 * 
	 * @param cent
	 * @param currency
	 */
    public MoneyBuilder(long cent, Currency currency) {
        this.cent = BigDecimal.valueOf(cent);
        this.currency = checkNotNull(currency);
    }

    /**
     * 用CNY(中国币种)来生成金额生成器
     * 
     * @param cent
     */
    public MoneyBuilder(long cent) {
        this(cent, Currency.getInstance(DEFAULT_CURRENCY_CODE));
    }

    /**
     * 用0金额和CNY(中国币种)来生成金额生成器
     */
    public MoneyBuilder() {
        this(0, Currency.getInstance(DEFAULT_CURRENCY_CODE));
    } 

    /**
     * 用已有的Money对象生成Builder对象。
     * 
     * ※用Money的currency来代表我的currency。用Money的金额(getCent)来代表我的cent。
     * 
     * @param money
     */
    public MoneyBuilder(Money money) {
        this.currency = money.getCurrency();
        this.cent = BigDecimal.valueOf(money.getCent());
    }

    /**
     * 金额相加。就是BigDecimal.add()
     * 
     * @param cent
     * @return
     */
    public MoneyBuilder add(long cent) {
        this.cent = this.cent.add(BigDecimal.valueOf(cent));
        return this;
    }

    /**
     * 金额相减。就是BigDecimal.subtract()
     * 
     * @param cent
     * @return
     */
    public MoneyBuilder subtract(long cent) {
        this.cent = this.cent.subtract(BigDecimal.valueOf(cent));
        return this;
    }

    /**
     * 金额相加。传入Money，实际还是取出了money.getCent然后调用了BigDecimal.add()
     * 
     * @param money
     * @return
     */
    public MoneyBuilder add(Money money) {
        return add(money.getCent());
    }

    /**
     * 金额相减。传入Money，实际还是取出了money.getCent然后调用了BigDecimal.subtract()
     * 
     * @param money
     * @return
     */
    public MoneyBuilder subtract(Money money) {
        return subtract(money.getCent());
    }

    /**
     * 金额相乘。调用BigDecimal.multiply()
     * 
     * @param val
     * @return
     */
    public MoneyBuilder multiply(double val) {
        this.cent = cent.multiply(BigDecimal.valueOf(val));
        return this;
    }

    /**
     * 金额相乘。调用BigDecimal.multiply()
     * 
     * @param val
     * @return
     */
    public MoneyBuilder multiply(BigDecimal val) {
        this.cent = cent.multiply(val, MathContext.UNLIMITED);
        return this;
    }

    /**
     * 金额相除。调用BigDecimal.divide()， 
     * MathContext.DECIMAL32精度设置与 IEEE 754R Decimal32 格式（即 7 个数字）匹配，
     * 舍入模式为 HALF_EVEN ，这是 IEEE 754R 的默认舍入模式。
     * 
     * @param val
     * @return
     */
    public MoneyBuilder divide(double val) {
        checkArgument(val != 0);
        this.cent = cent.divide(BigDecimal.valueOf(val), MathContext.DECIMAL32);
        return this;
    } 
    
    public static void main(String[] args) {
		System.out.println(Currency.getInstance("CNY").getSymbol());
	}

    /**
     * 检查参数是否为空，若空抛出NPE
     * 
     * @param obj
     * @return
     */
    private <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    /**
     * 检查参数的boolean表达式，如果为false抛出非法参数异常
     * 
     * @param expr
     */
    private void checkArgument(boolean expr) {
        if (!expr) {
            throw new IllegalArgumentException();
        }
    } 
}
