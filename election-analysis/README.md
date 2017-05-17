<b>ANALISE DE RELAÇÕES ENTRE DOADORES E RECEBEDORES NAS ELEIÇÕES 2014 NO BRASIL</b>

<b>DESCRIÇÃO GERAL</b>

<b>Projeto fazendo uso de banco de dados orientado a grafo (Neo4J) e tecnologias java e angular:</b>

<b>- Spring Boot</b>
<b>- Spring Data Neo4J</b>
<b>- Spring Rest</b>
<b>- AngularJS</b>
<b>- D3JS</b>

<p align="justify">No cenário politico brasileiro, as doações de campanha são fontes de recursos importantes para financiar a politica nacional, neste contexto pessoas fisicas e pessoas juridicas são responsáveis por boa parcela do financiamento da campanha. Para alguns orgãos de controle e para a população em geral o conhecimento de quais empresas e setores economicos são responsáveis pelo financiamento de determinados candidatos e partidos é de extrema importância.</p>
<p align="justify">Este projeto visa mostrar em tabelas estruturadas e gráficos as relações entre os doadores e recebedores, permitindo analises que demonstram quais doadores financiaram os dois lados da disputas, exibe casos de doações não baseadas em ideologia, favorecendo a detecção de casos que indicam a necessidade de maior aprofundamento na análise. Por exemplo, com base neste levantamento, a população em geral pode rastrear quanto de retorno essas empresas obtiveram em licitações nos anos seguintes, aqueles candidatos que foram financiados por um determinado setor economico, participam de comissões que atuam em regulações daquele setor ?. Essas e outras indagações podem ser exploradas uma vez que se obtenham informações que indiquem um determinado padrão.</p>
<p align="justify">Para a carga deste projeto foi utilizado dados abertos do Tribunal Superior Eleitoral, que podem ser verificados no seguinte endereço http://www.tse.jus.br/hotSites/pesquisas-eleitorais/prestacao_contas_anos/2014.html.</p>
<p align="justify">O resultado do projeto rodando pode ser observado nas imagens a seguir:</p>

<p align="justify">- Imagem do Dashboard Principal</p>
<p align="center">
  <img src="https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/001.png">
</p>

<p align="justify">- Imagem da tabela de maiores doadores pessoa juridica</p>
<p align="center">
  <img src="https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/002.png">
</p>

<p align="justify">- Imagem do gráfico D3.js de maiores doadores pessoa juridica</p>
<p align="center">
  <img src="https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/003.png">
</p>

<p align="justify">Podemos notar que a visualização das informações se faz de maneira bem intuitiva, possuindo um menu de navegação lateral e áreas de informações bem definidas no dashboard principal, nas sessões seguintes será descrito os passos para carga das informações obtidas de fontes abertas como dito anteriormente, como preparar e realizar carga no banco de dados Neo4J e um pouco da arquitetura desenvolvida para apresentar essas informações.</p>

<b>CARGA DOS DADOS</b>



PROJETO FINAL DA DISCIPLINA BANCO DE DADOS MASSIVOS

O projeto final visa analisar informações de campanha eleitoral com a utilização de banco de dados orientado a gráfico, no caso o Neo4J.

Para executar este projeto, deve-se ter: 

- O Neo4J community rodando e disponível em localhost:7474
- Realizar checkout deste repositório (git clone )
- É necessário entrar na pasta src/main/resources/static/plugins e executar o comando bower install para carregar dependências .js
- Dentro da pasta do projeto executar o seguinte comando mvn spring-boot:run
- Outra forma é na pasta do projeto executar o comando mvn clean package, com isso na pasta target será gerado o .war que pode ser publicado em um servidor de aplicação.

O projeto estará disponível no contexto http://localhost:8080
