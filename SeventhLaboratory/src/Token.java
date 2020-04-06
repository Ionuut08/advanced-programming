import javax.print.attribute.standard.RequestingUserName;
import java.util.Arrays;
import java.util.Random;

public class Token {

    private int token;
    int numberOfTokens = 0;
    private boolean controlBlank;

    public Token(int token) {
        this.token = token;
        this.controlBlank = false;
    }

    public Token() {
        this.controlBlank = true;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }

    public void setNumberOfTokens(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token=" + token +
                '}';
    }
}
