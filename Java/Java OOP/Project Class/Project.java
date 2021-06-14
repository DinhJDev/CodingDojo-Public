public class Project {
    private String name;
    private String description;
    private double initialCost;

    public void elevatorPitch() {}
    public void elevatorPitch(String name) {}
    public String elevatorPitch(String name, double cost, String description) {
        return (this.name + " (" + cost + "): " + this.description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = this.name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = this.description;
    }

    public String getCost() {
        return String.valueOf(initialCost);
    }

    public void setCost(double cost) {
        initialCost = cost;
    }
}