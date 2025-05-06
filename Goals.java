public class Goals {
    private String goalName;
    private double targetAmount;

    public Goals() {
        this.goalName = "Default Goal";
        this.targetAmount = 0.0;
    }

    public String getGoalName() { return goalName; }
    public double getTargetAmount() { return targetAmount; }

    public void setGoalName(String goalName) { this.goalName = goalName; }
    public void setTargetAmount(double amount) { this.targetAmount = amount; }
}
