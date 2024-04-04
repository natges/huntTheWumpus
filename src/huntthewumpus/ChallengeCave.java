package huntthewumpus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author natal
 */
public class ChallengeCave extends Cave{
    private Level level;
    private Scanner sc;
    private List<Question> questions;
    public ChallengeCave(int id, String name,Level level) {
        super(id, name);
        this.level=level;
        sc= new Scanner(System.in);
        questions= new ArrayList<>();
        initializeComponents();
    }
    
    private void initializeComponents(){
        //Se asignan las preguntas correspondientes al nivel 1 (fácil).
        if(level.getNumLevel().name().equals(NumLevel.UNO.name())){
            //Se declaran en el orden: question + op1 + op2 + op3 + op4 +
            //correctOp.
            questions.add(new Question("Tipos de datos que corresponden a "
                    + "números enteros","a. String, char, double.","b. short,"
                            + " byte, int.","c. long, char, int.","d. double,"
                                    + " float, byte.","b"));
            questions.add(new Question("Tipo de dato que es solo un carácter y"
                    + " se encierra entre comillas","a. short","b. int","c. "
                            + "byte","d. char","d"));
            questions.add(new Question("Operadores que se emplean se emplean"
                    + " para evaluar varias expresiones que contienen "
                    + "operadores relacionales","a. Operadores lógicos"
                    ,"b. Operadores relacionales","c. Operadores de "
                            + "asignación","d. Operadores aritméticos","a"));
            questions.add(new Question("Estructura que permite repetir "
                    + "un conjunto de instrucciones mientras se\n" +
            "cumpla la condición. Sin embargo, como primero verifica la "
                    + "condición, si esta\n" +
            "no se cumple (es falsa), los estatutos no se ejecutan","a. "
                    + "Do-while","b. If","c. While","d. For","c"));
            questions.add(new Question("Estructura que ejecuta primero las "
                    + "instrucciones y después verifica la condición","a. "
                            + "For","b. Do-while","c. If","d. While","b"));
            questions.add(new Question("Estructura que repite un bloque de "
                    + "instrucciones mientras se cumpla la condición","a. "
                            + "For","b. If","c. Do-while","d. While","a"));
            questions.add(new Question("Método de la clase String que "
                    + "devuelve el carácter de una casilla especificada"
                    ,"a. substring","b. compareTo","c. length","d. "
                            + "charAt","d"));
            questions.add(new Question("Método de la clase String que "
                    + "determina si dos cadenas son iguales, sin\n" +
            "importar mayúsculas y minúsculas","a. indexOf","b. equals"
                    + "IgnoreCase","c. equals","d. split","b"));
            questions.add(new Question("Estructura de datos que permite "
                    + "almacenar una secuencia de datos del mismo tipo",
                    "a. Arreglo","b. Variable","c. For","d. Método","a"));
            questions.add(new Question("Colecciones que permiten agregar"
                    + " elementos de los cuales nos importa saber su "
                    + "posición","a. Mapas","b. Listas","c. Conjuntos"
                    ,"d. Arreglos","b"));
         //Se asignan las preguntas correspondientes al nivel 2.
        }else if(level.getNumLevel().name().equals(NumLevel.DOS.name())){
            //Se declaran en el orden: question + op1 + op2 + op3 + op4 +
            //correctOp.
            questions.add(new Question("Evento que ocurre durante la "
                    + "ejecución del programa, que rompe la\n" +
            "secuencia normal de las instrucciones y que se emplea "
                    + "para procesar el\n" +
            "manejo de errores de una manera segura","a. Método",
                    "b. Error","c. Excepción","d. Compilar","c"));
            questions.add(new Question("Instrucción que se emplea"
                    + " para encerrar la o las instrucciones que "
                    + "pueden provocar la excepción","a. Throw",
                    "b. Try","c. Catch","d. If","b"));
            questions.add(new Question("Agrupa las instrucciones "
                    + "que se deben realizar cuando la excepción "
                    + "ocurre","a. Throw","b. Try","c. Catch","d. If","b"));
            questions.add(new Question("Facilita el diseño de "
                    + "soluciones computacionales ya que esta se asemeja a\n" +
            "la manera con la que expresamos las cosas en la "
                    + "vida real","a. Programación Lineal","b."
                            + " Programación Orientada a Objetos"
                            + "","c. Programación Estructurada"
                            ,"d. Programación Modular","b"));
            questions.add(new Question("Es la descripción de un tipo de "
                    + "objeto. Indica qué atributos y comportamientos tienen "
                    + "los objetos de ese tipo","a. Clase","b. Objeto","c. "
                            + "Método","d. Característica","a"));
            questions.add(new Question("Es la capacidad de representar las "
                    + "características esenciales de un objeto sin preocuparse "
                    + "por los detalles","a. Reutilización de código","b. "
                            + "Ocultamiento","c. Abstracción","d. "
                                    + "Encapsulamiento","c"));
            questions.add(new Question("Evita el acceso directo a los atributos"
                    + " del objeto, controlando de esta\n" +
            "manera el uso o la modificación de los mismos.","a. "
                    + "Reutilización de código","b. Ocultamiento","c. "
                            + "Abstracción","d. Encapsulamiento","d"));
            questions.add(new Question("Capacidad de esconder los detalles "
                    + "internos del comportamiento de una\n" +
            "clase, y solo dejar expuesto aquello que es necesario que el "
                    + "resto del sistema\n" +
            "conozca.","a. Reutilización de código","b. Ocultamiento","c. "
                    + "Abstracción","d. Encapsulamiento","b"));
            questions.add(new Question("Se refiere al uso de software ya "
                    + "desarrollado para crear uno nuevo","a. Reutilización "
                            + "de código","b. Ocultamiento","c. Abstracción",
                    "d. Encapsulamiento","a"));
            questions.add(new Question("Concepto que se puede aplicar en las "
                    + "clases, cuando estas guardan una relación del tipo “es "
                    + "un”","a. Abstracción","b. Constructor","c. Herencia",
                    "d. Encapsulamiento","c"));

        }else{//Se asignan las preguntas correspondientes al nivel 3.
            //Se declaran en el orden: question + op1 + op2 + op3 + op4 +
            //correctOp.
            questions.add(new Question("Característica de la programación que "
                    + "permite que objetos diferentes\n" +
            "respondan de manera distinta al mismo mensaje","a. Polimorfismo",
                    "b. Herencia","c. Ocultamiento","d. Abstracción","a"));
            questions.add(new Question("Clases que se emplean comúnmente para "
                    + "representar conceptos generales\n" +
            "o las características principales de una serie de objetos","a. "
                    + "Clases hereditarias","b. Clases ocultas","c. Clases "
                            + "abstractas","d. Clases reutilizables","c"));
            questions.add(new Question("Aspecto que caracteriza al lenguaje "
                    + "de programación Python en el cual el\n" +
            "proceso de traducción a lenguaje máquina se realiza a medida "
                    + "que se ejecuta\n" +
            "el código.","a. Lenguaje interpretado","b. Lenguaje "
                    + "multiplataforma","c. Lenguaje dinámico","d. "
                            + "Lenguaje multiparadigma","a"));
            questions.add(new Question("Aspecto que caracteriza al lenguaje "
                    + "de programación Python debido a que\n" +
            "dicho lenguaje puede ser ejecutado en múltiples plataformas "
                    + "computacionales","a. Lenguaje interpretado","b. "
                            + "Lenguaje multiplataforma","c. "
                                    + "Lenguaje dinámico","d. "
                                            + "Lenguaje multiparadigma","b"));
            questions.add(new Question("Aspecto que caracteriza al lenguaje "
                    + "de programación Python en cuanto a la\n" +
            "definición del tipo de dato que se asignará a sus variables, "
                    + "ya que una variable\n" +
            "puede recibir distintos tipos de datos durante la ejecución del "
                    + "programa por lo\n" +
            "que puede omitirse la definición del tipo de la variable","a. "
                    + "Lenguaje interpretado","b. Lenguaje multiplataforma",
                    "c. Lenguaje dinámico","d. Lenguaje multiparadigma","c"));
            questions.add(new Question("Aspecto que caracteriza al lenguaje "
                    + "de programación Python ya que permite\n" +
            "la programación de varios modelos de cómputo, estructurar y "
                    + "organizar los\n" +
            "programas por medio de funciones, módulos y paquetes; y crear "
                    + "objetos por\n" +
            "medio del paradigma de programación orientada a objetos que ya "
                    + "conoces","a. Lenguaje interpretado","b. Lenguaje "
                            + "multiplataforma","c. Lenguaje dinámico","d. "
                                    + "Lenguaje multiparadigma","d"));
            questions.add(new Question("Función en el lenguaje Python que "
                    + "escribe en la salida estándar los\n" +
            "argumentos que recibe, estos pueden ser objetos de cualquier "
                    + "tipo","a. print()","b. input()","c. len()","d. "
                            + "max()","a"));
            questions.add(new Question("Función en el lenguaje Python "
                    + "que recibe como argumento una cadena de\n" +
            "caracteres y ejecuta una acción de lectura de datos desde "
                    + "la entrada estándar\n" +
            "por medio de un cuadro de texto","a. print()","b. input()"
                    ,"c. len()","d. max()","b"));
            questions.add(new Question("Función predefinida en el lenguaje "
                    + "Python que opera sobre objetos de tipo\n" +
            "lista y devuelve el valor mínimo dentro de la lista","a. "
                    + "sum(list)","b. min(list)","c. max(list)","d. "
                            + "len(list)","b"));
            questions.add(new Question("Función predefinida en el lenguaje"
                    + " Python que opera sobre objetos de tipo\n" +
            "lista y devuelve la longitud de la lista","a. sum(list)","b."
                    + " min(list)","c. max(list)","d. len(list)","d"));
        }
    }
    
    @Override
    /**
     * Método para mostrar la alerta correspondiente a la cueva.
     */
    public String toString() {//Texto en celeste.
        return "\033[36mEl más inteligente sobrevivirá.\u001B[0m\n";
    }

    @Override
    /**
     * Método para mostrar la habilidad correspondiente  a la caverna 
     * (Que le haga una pregunta aleatoria al jugador y que el jugador deba 
     * responder correctamente para poder avanzar).
     */
    public void abilityCave(Player j) {
        //se elige un número aleatorio del 1 al 10, ya que son 10 preguntas
        //en cada nivel.
        int alea= (int)(Math.random()*10);
        System.out.println("\033[36m¡Ha caido en una caverna Desafio!"
                + "\u001B[0m\n");
        //Se elige una pregunta aleatoria correspondiente al nivel del jugador.
        question(j,questions.get(alea).getQuestion(),questions.get(alea)
                .getOp1(),questions.get(alea).getOp2(),questions.get(alea)
                        .getOp3(),questions.get(alea).getOp4(),questions.
                            get(alea).getCorrectOp());
        
    }
    /**
     * Método para imprimir la pregunta aleatoria, junto con sus opciones
     * de respuesta y que el jugador ingrese una respuesta.
     * @param j
     * @param question
     * @param op1
     * @param op2
     * @param op3
     * @param op4
     * @param correct 
     */
    private void question(Player j,String question, String op1, String
            op2, String op3, String op4, String correct){
        String op;//opción elegida por el jugador.
        do{
            if(j.isLive()){
                System.out.println("\n"+question);
                System.out.println(op1);
                System.out.println(op2);
                System.out.println(op3);
                System.out.println(op4);
                System.out.print("Seleccione opción: ");
                op=sc.nextLine();
                if(op.toLowerCase().equals(correct.toLowerCase()))
                {//respuesta correcta
                    System.out.println("\033[36m¡Respuesta correcta!"
                            + "\u001B[0m\n");
                    break;
                }else{
                    System.out.println("\033[36mRespuesta incorrecta, "
                            + "has perdido oxígeno, sigue intentando\u001B[0m");
                          
                    j.reduceOxygen(5);//Se reduce 5 a la cantidad de oxígeno
                                      //del jugador cada que ingresa una 
                                      //respuesta incorrecta.
                } 
            }else{
                break;
            }
        }while(true);
    }
}
