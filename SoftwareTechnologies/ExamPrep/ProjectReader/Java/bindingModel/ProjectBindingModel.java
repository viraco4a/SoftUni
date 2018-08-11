package projectrider.bindingModel;

import javax.validation.constraints.NotNull;

public class ProjectBindingModel {

    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private Integer budget;

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    @NotNull
    public Integer getBudget() {
        return budget;
    }

    public void setBudget(@NotNull Integer budget) {
        this.budget = budget;
    }
}
