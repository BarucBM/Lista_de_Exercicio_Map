import java.util.*;
import java.util.stream.Collectors;

public class Sistema {
    Map<String , Aluno> Alunos = new HashMap<>();

    public Sistema() {
    }

    public Map<String, Aluno> getAlunos() {
        return Alunos;
    }

    public void addAluno(String nome, Aluno aluno){
        Alunos.put(nome, aluno);
    }

    public void printMap(){
        Alunos.forEach((key, value) -> System.out.println(key + " " + value.nota + "\n"));
    }

    public void getNota(String nome){
        Map.Entry<String, Aluno> retorno = Alunos.entrySet().stream()
                                            .filter(al -> al.getValue().nome.equalsIgnoreCase(nome))
                                            .findFirst()
                                            .orElse(null);

        if (retorno != null) {
            System.out.println("A nota de " + nome + " é: " + retorno.getValue().nota + "\n");
        } else {
            System.out.println("Aluno " + nome + " não encontrado.\n");
        }
    }

    public void compararNota(double nota){
        Alunos.entrySet().stream()
                .filter(al -> al.getValue().nota >nota)
                .forEach(al -> System.out.println(al.getKey() + "\n"));
    }

    public void removeNota(double nota){
        List<String> removidos =  Alunos.entrySet().stream()
                .filter(al -> al.getValue().nota <nota)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        removidos.forEach(aluno -> Alunos.values().removeIf(a -> a.nome.equals(aluno)));
        removidos.forEach(aluno -> System.out.println(aluno + " removido!"));
    }

    public Map<String, Aluno> clasificarALunos(){
        return Alunos.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e1.getValue().nota, e2.getValue().nota))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public Map<String, List<Aluno>> faixaNota(){
        return Alunos.values().stream()
                .collect(Collectors.groupingBy(aluno -> {
                    if (aluno.nota >= 90) {
                        return "A";
                    } else if (aluno.nota >= 80) {
                        return "B";
                    } else if (aluno.nota >= 70) {
                        return "C";
                    } else if (aluno.nota >= 60) {
                        return "D";
                    } else {
                        return "F";
                    }
                }));
    }

