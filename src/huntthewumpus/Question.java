package huntthewumpus;

/**
 *
 * @author natal
 */
public class Question {
    private String question;//Pregunta
    private String op1;//inciso a
    private String op2;//inciso b
    private String op3;//inciso c
    private String op4;//inciso d
    private String correctOp;//Respuesta correcta.

    public Question(String question, String op1, String op2, 
            String op3, String op4,String correctOp) {
        this.question = question;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.correctOp=correctOp;
    }

    public String getQuestion() {
        return question;
    }

    public String getOp1() {
        return op1;
    }

    public String getOp2() {
        return op2;
    }

    public String getOp3() {
        return op3;
    }

    public String getOp4() {
        return op4;
    }

    public String getCorrectOp() {
        return correctOp;
    }
    
}
