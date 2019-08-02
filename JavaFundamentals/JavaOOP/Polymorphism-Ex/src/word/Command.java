package word;

public class Command {
    private String text;
    private word.TextTransform textTransform;

    public Command(String text, word.TextTransform textTransform){
        this.text = text;
        this.textTransform = textTransform;
    }
    public String getText() {
        return this.text;
    }

    public word.TextTransform getTextTransform() {
        return this.textTransform;
    }

}
