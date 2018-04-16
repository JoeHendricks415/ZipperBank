package io.zipcoder.bank.model;

import io.zipcoder.bank.enums.Type;
import io.zipcoder.core.model.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Account extends BaseEntity {

    private static final Integer serialVersionUID = 12345;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;


    @Column(name = "TYPE")
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @NotEmpty
    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "REWARDS")
    private Integer rewards;

    @Column(name = "BALANCE")
    private Double balance;

    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", insertable = false, updatable = false)
    private Customer customer;

    public Account(){

    }

    public Account(Integer id, String nickname, Integer rewards, Double balance) {
        this.id = id;
        this.nickname = nickname;
        this.rewards = rewards;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRewards() {
        return rewards;
    }

    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

}
