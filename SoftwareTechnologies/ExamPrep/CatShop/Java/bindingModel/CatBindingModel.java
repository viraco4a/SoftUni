package cat.bindingModel;

import javax.validation.constraints.NotNull;

public class CatBindingModel {

    @NotNull
    private String name;
    @NotNull
    private String nickname;
    @NotNull
    private Double price;

    public CatBindingModel() {
    }

    public CatBindingModel(@NotNull String name, @NotNull String nickname, @NotNull Double price) {
        this.name = name;
        this.nickname = nickname;
        this.price = price;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public String getNickname() {
        return nickname;
    }

    public void setNickname(@NotNull String nickname) {
        this.nickname = nickname;
    }

    @NotNull
    public Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull Double price) {
        this.price = price;
    }
}
