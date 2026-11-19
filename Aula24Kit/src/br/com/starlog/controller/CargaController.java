
public void cadastrarCarga(String codigoRaw, String categoriaRaw, String pesoRaw, String valorRaw,
        TelaCadastroCarga tela) {

    try {
        // PASSO 1: Conversão Segura de Tipos (Parse)

        // Verifica se os campos estão vazios ou nulos
        if (pesoRaw == null || pesoRaw.trim().isEmpty()
                || valorRaw == null || valorRaw.trim().isEmpty()) {

            throw new IllegalArgumentException("Peso e Valor não podem estar vazios!");
        }

        // Substitui vírgula por ponto e converte para double
        double peso = Double.parseDouble(pesoRaw.replace(",", "."));
        double valor = Double.parseDouble(valorRaw.replace(",", "."));

        // PASSO 2: Instanciar a classe de Modelo (Model)
        Carga novaCarga = new Carga(codigoRaw, categoriaRaw, peso, valor);

        // PASSO 3: Salvar no repositório de memória
        this.repositorio.add(novaCarga);

        // PASSO 4: Notificar a View com Sucesso e atualizar a tela
        tela.exibirMensagemSucesso(
                "Carga cadastrada com sucesso!\n" + novaCarga.toString());

        tela.atualizarRelatorio(gerarTextoRelatorio());

    } catch (NumberFormatException e) {

        // Trata erros de conversão numérica
        tela.exibirMensagemErro(
                "Erro de formato numérico: Digite apenas números válidos para Peso e Valor!");

    } catch (IllegalArgumentException e) {

        // Trata violações das regras de negócio do Model
        tela.exibirMensagemErro(
                "Regra de Negócio Violada: " + e.getMessage());
    }
}
