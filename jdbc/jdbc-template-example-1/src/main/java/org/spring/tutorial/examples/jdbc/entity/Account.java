package org.spring.tutorial.examples.jdbc.entity;

import java.util.Objects;

public class Account {

    private Integer id;
    private Double balance;
    private String accountName;
    private String dateOpened;
    private Integer customerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(balance, account.balance) &&
                Objects.equals(accountName, account.accountName) &&
                Objects.equals(dateOpened, account.dateOpened) &&
                Objects.equals(customerId, account.customerId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, balance, accountName, dateOpened, customerId);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", accountName='" + accountName + '\'' +
                ", dateOpened='" + dateOpened + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
