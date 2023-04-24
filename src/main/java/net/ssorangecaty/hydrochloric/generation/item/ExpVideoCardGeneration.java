package net.ssorangecaty.hydrochloric.generation.item;

public class ExpVideoCardGeneration extends HydrochloricItemGeneration{
    public int canLevelUpCount;
    public ExpVideoCardGeneration(Settings settings, String name, String quality,int canLevelUpCount) {
        super(settings, name, quality);
        this.canLevelUpCount = canLevelUpCount;
    }
}
