package entity;

import org.hibernate.annotations.Formula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by cq on 2017/8/3.
 */

@Entity
@Table(name = "bus_appointfee")
public class AppointRecordFee implements Serializable {

    @Column(name = "APPOINTID")
    @Id
    private Integer appointId;

    @Column(name = "APPOINTTOTALFEE")
    private BigDecimal appointTotalFee;
    @Column(name = "APPOINTDISCOUNTFEE")
    private BigDecimal appointDiscountFee;
    @Column(name = "APPOINTCOUPONFEE")
    private BigDecimal appointCouponFee;

    @Formula(value = "APPOINTTOTALFEE - APPOINTDISCOUNTFEE - APPOINTCOUPONFEE") // formula 只在查询时使用，保存时还得设置计算后的值
    @Column(name = "APPOINTAFTERDISCOUNTFEE")
    private BigDecimal appointAfterDiscountFee;


    


    public Integer getAppointId() {
        return appointId;
    }

    public void setAppointId(Integer appointId) {
        this.appointId = appointId;
    }

    public BigDecimal getAppointTotalFee() {
        return appointTotalFee;
    }

    public void setAppointTotalFee(BigDecimal appointTotalFee) {
        this.appointTotalFee = appointTotalFee;
    }

    public BigDecimal getAppointDiscountFee() {
        return appointDiscountFee;
    }

    public void setAppointDiscountFee(BigDecimal appointDiscountFee) {
        this.appointDiscountFee = appointDiscountFee;
    }

    public BigDecimal getAppointCouponFee() {
        return appointCouponFee;
    }

    public void setAppointCouponFee(BigDecimal appointCouponFee) {
        this.appointCouponFee = appointCouponFee;
    }

    public BigDecimal getAppointAfterDiscountFee() {
        return appointAfterDiscountFee;
    }

    public void setAppointAfterDiscountFee(BigDecimal appointAfterDiscountFee) {
        this.appointAfterDiscountFee = appointAfterDiscountFee;
    }
}
