package com.sven.dream.common.util.money;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * 
 * dream中的金额工具
 *  
 * @author beckham
 *
 */
public class Money implements Comparable<Money>, Serializable {
    private static final long serialVersionUID = 2158419477655294341L;
     
    public static final String DEFAULT_CURRENCY_CODE = "CNY";
    
    // 0金额的钱。
    public static final Money ZERO_CNY = new Money(0);
    
    private final Currency currency;
    private final long cent;
 
    /**
     * 0金额和CNY币种创建金额对象。
     */
    Money(){
        this.currency = Currency.getInstance(DEFAULT_CURRENCY_CODE);
        this.cent = 0L;
    }

    /**
     * 指定金额和指定币种创建金额对象。
     */
    Money(long cent, Currency currency) {
        this.currency = checkNotNull(currency);
        this.cent = cent;
    }

    /**
     * 指定金额和CNY币种创建金额对象。
     */
    Money(long cent) {
        this(cent, Currency.getInstance(DEFAULT_CURRENCY_CODE));
    }
 
    /**
     * 获取指定金额(cent)在当前的货币下的金额标准显示方法。
     * 其中currency.getDefaultFractionDigits()是获取了货币的默认使用小数位数。
     * 
     * @return
     */
    public BigDecimal getAmount() {
        int fractionDigits = Math.max(0, currency.getDefaultFractionDigits());
        return BigDecimal.valueOf(cent, fractionDigits);
    }

    /**
     * 获取金额转换为分的数值。
     * 
     * @return
     */
    public long getCent() {
        return cent;
    }
 
    /**
     * getSymbol方法返回了币种字符表达。比如人民币是返回了￥。 
     * 
     * @return
     */
    public String format() {
        return currency.getSymbol() + getAmount();
    }
 
    /**
     * 当前类实现了Comprable接口。
     */
    public int compareTo(Money o) {
        if (o == null) return 1;

        if (!o.currency.equals(currency)) {
            throw new IllegalArgumentException("can't compare money of different currencies");
        }

        return (int) Math.signum(cent - o.cent);
    }

    /**
     * 获取当前的币种
     * 
     * @return
     */
    public Currency getCurrency() {
        return this.currency;
    }  

    /**
     * 空判断检查
     * 
     * @param obj
     * @return
     */
    private static <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }
  
    /**
     * 金额是否大于0.也可以理解为是一个异常情况校验
     * 
     * @return
     */
    public boolean isPositive() {
        return cent > 0;
    } 

    /**
     * 获取字符串的标准金额输出
     * 
     * @see #getAmount()
     */
    public String getAmountString() {
        return getAmount().toString();
    }
    
    // ==========================hashcode,equals,toString===========================
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        Money other = (Money) obj;
        return this.cent == other.cent && this.currency.equals(other.currency);
    }

    @Override
    public int hashCode() {
        int h = 4;
        h = h * 31 + currency.hashCode();
        h = h * 31 + (int) (cent ^ (cent >>> 32));
        return h;
    }

    @Override
    public String toString() {
        // Obscure the string so that clients won't try to rely on this implementation.
        return "######## " + format();
    }
}
