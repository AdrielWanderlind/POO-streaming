package br.com.cybercorp.main;

import br.com.cybercorp.model.Credencial;
import br.com.cybercorp.model.Departamento;
import br.com.cybercorp.model.Funcionario;
import br.com.cybercorp.model.SistemaSeguranca;
import br.com.cybercorp.model.Veiculo;

public class MainTeste {

    public static void main(String[] args) {

        // 1. Instanciando o Departamento
        Departamento departamento = new Departamento(
                "TI",
                "Tecnologia da Informação",
                3
        );

        // 2. Instanciando o Funcionário
        Funcionario func = new Funcionario(
                "F001",
                "João",
                departamento
        );

        // 3. Instanciando o Veículo
        Veiculo veiculo = new Veiculo(
                "ABC-1234",
                "Toyota Corolla",
                func
        );

        // 4. Sistema com apenas 2 vagas
        SistemaSeguranca sistema = new SistemaSeguranca(2);

        // 5. Credencial original
        Credencial c1 = new Credencial(
                "FFF-999",
                true,
                func
        );

        // 6. Clone da credencial
        Credencial clone = new Credencial(
                "FFF-999",
                true,
                func
        );

        // TESTE DA CATRACA
        System.out.println("=== TESTE DA CATRACA ===");

        sistema.registrarCatraca(func);
        sistema.registrarCatraca(func);

        // TESTE DO COFRE
        System.out.println("\n=== TESTE DO COFRE ===");

        sistema.acessarCofre(c1);
        sistema.acessarCofre(clone);

        // TESTE DA GARAGEM
        System.out.println("\n=== TESTE DA GARAGEM ===");

        sistema.estacionarVeiculo(veiculo, 0);

        // Deve provocar ArrayIndexOutOfBoundsException
        sistema.estacionarVeiculo(veiculo, 5);
    }
}