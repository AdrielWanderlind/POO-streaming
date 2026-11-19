
package br.com.starlog.model;

/**
 * CAMADA MODEL (Modelo de Domínio)
 * Representa uma carga a ser despachada pela estação StarLog.
 *
 * ATENÇÃO: Esta classe NÃO deve importar nenhum componente visual do Swing!
 */
public class Carga {

    private final String codigoRastreio;
    private final String categoria;
    private final double peso;
    private final double valorDeclarado;

    public Carga(String codigoRastreio, String categoria, double peso, double valorDeclarado) {

        // MISSÃO 2: BARREIRA FAIL-FAST

        // 1. Valida o código de rastreio
        if (codigoRastreio == null || codigoRastreio.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Código de rastreio não pode ser nulo ou vazio."
            );
        }

        // 2. Valida a categoria
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Categoria não pode ser nula ou vazia."
            );
        }

        // 3. Valida o peso
        if (peso <= 0 || Double.isNaN(peso) || Double.isInfinite(peso)) {
            throw new IllegalArgumentException(
                    "Peso deve ser estritamente positivo (maior que zero)."
            );
        }

        // 4. Valida o valor declarado
        if (valorDeclarado <= 0 || Double.isNaN(valorDeclarado)
                || Double.isInfinite(valorDeclarado)) {
            throw new IllegalArgumentException(
                    "Valor declarado deve ser maior que zero."
            );
        }

        // Inicialização dos atributos após as validações
        this.codigoRastreio = codigoRastreio.trim().toUpperCase();
        this.categoria = categoria.trim().toUpperCase();
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPeso() {
        return peso;
    }

    public double getValorDeclarado() {
        return valorDeclarado;
    }

    /**
     * Regra de Negócio: Cálculo do Seguro Espacial da Carga.
     */
    public double calcularSeguro() {

        // 1. Calcula a taxa base de 2% do valor declarado
        double seguro = valorDeclarado * 0.02;

        // 2. Adiciona sobretaxa para cargas perigosas ou pesadas
        if (categoria.equals("PERIGOSA") || peso > 100) {
            seguro += 150.00;
        }

        return seguro;
    }

    @Override
    public String toString() {
        return String.format(
                "[%s] Categoria: %s | Peso: %.2f kg | Valor: R$ %.2f | Seguro: R$ %.2f",
                codigoRastreio, categoria, peso, valorDeclarado, calcularSeguro()
        );
    }
}
