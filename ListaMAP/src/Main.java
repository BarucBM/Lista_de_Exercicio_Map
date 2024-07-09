import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
         Sistema sistema = new Sistema();


        sistema.addAluno("Baruc", new Aluno("Baruc", 8.0));
        sistema.addAluno("Joao", new Aluno("Joao", 5.0));
        sistema.addAluno("Maria", new Aluno("Maria", 6.0));
        sistema.addAluno("Vitoria", new Aluno("Vitoria", 10.0));
        sistema.addAluno("Davi", new Aluno("Davi", 2.0));

        //sistema.printMap();

        //sistema.getNota("Denis");

        //sistema.compararNota(4);

        //sistema.removeNota(1);

        Map<String, Aluno> ordenados = sistema.clasificarALunos();

        ordenados.forEach((key, value) -> System.out.println(key + " " + value.nota + "\n"));


    }
}