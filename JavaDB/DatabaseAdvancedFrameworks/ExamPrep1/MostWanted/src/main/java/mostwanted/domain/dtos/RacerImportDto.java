package mostwanted.domain.dtos;

import com.google.gson.annotations.Expose;
import com.sun.istack.NotNull;

import java.math.BigDecimal;

public class RacerImportDto {
    @Expose
    private String name;

    @Expose
    private Integer age;

    @Expose
    private BigDecimal bounty;

    @Expose
    private String townName;

    public RacerImportDto() {
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBounty() {
        return bounty;
    }

    public void setBounty(BigDecimal bounty) {
        this.bounty = bounty;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
