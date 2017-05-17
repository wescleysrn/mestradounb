<b>ANALISE DE RELAÇÕES ENTRE DOADORES E RECEBEDORES NAS ELEIÇÕES 2014 NO BRASIL</b>

<b>DESCRIÇÃO GERAL</b>

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

<b>PREPARAÇÃO DOS DADOS</b>

<p align="justify">A parte principal do trabalho foi a preparação da carga de dados obtidos do site do TSE em formato .txt, sendo estes arquivos abertos e integrantes da prestação de contas eleitoral dos candidatos e partidos nas eleições 2014, para isso foi realizado um tratamento nestes arquivos .txt com o uso da ferramenta Data Integration da suite Pentaho, com a intenção de separar os dados realmente importantes e gerar um arquivo .csv que é utilizado no banco de dados Neo4J para realização da carga.</p>
<p align="justify">Informaçes sobre o Data Integration utilizado na carga dos dados, podem ser encontradas no seguinte endereço http://community.pentaho.com/projects/data-integration/, onde é possível realizar o download e seguindo as instruções a instalação da ferramenta em seu sistema operacional em uso.</p>
<p align="justify">Uma vez instalado a ferramenta, foi trabalhado a estrutura dos arquivos de prestação de contas eleitorais que se resumem em três arquivos principais, sendo receitas_candidatos_2014_brasil.txt, receitas_comites_2014_brasil.txt, receitas_partidos_2014_brasil.txt no data integration foi criado Transformation para obter cada tipo de arquivo de carga necessário para inserir no banco Neo4J.</p>
<p align="justify">Abaixo é exibido imagens dos Transformation's criados e sua estrutura:</p>

<p align="center">
  <img src="https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/004.png">
</p>

<p align="justify">É importante notar que as transformações dos dados são realizados por meio dos componentes Data Integration, todos de fácil utilização, sendo utilizados basicamente, Input Stream, Select Value, Regular Expression, Filter Row, Sort Row, Merge Join e Output Stream, com isso foi possível gerar todos os arquivos de carga necessários.</p>
<p align="justify">Abaixo, temos a imagem de um componente de transformação Regex Evalution, que foi utilizado para filtrar na transformação pessoas fisicas e pessoas juridicas.</p>

<p align="center">
  <img src="https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/005.png">
</p>

<p align="justify">Alguns tratamentos foram necessários no procedimento de tratamento dos dados para realização da carga, com o modelo proposto, houve a necessidade de simplificar os recebedores em duas entidades, sendo estas Partido e Candidato. Ocorre que os partidos possuem diversos comitês financeiros com inúmeros CNPJ's por todo o país, havendo a necessidade de filtrar essas doações de comitê para uma única entidade no caso o Partido. Isso foi realizado por meio de agregação dos dados e totalização dos comitês pela sigla do partido.</p>
<p align="justify">Outro ponto de tratamento é que nos arquivos .txt do TSE constam doações realizadas entre Candidatos, entre comitê, de Partido para Candidato, etc. Esses tipos de operações não eram importantes para as perguntas que se gostaria de responder com o trabalho, sendo necessário excluir essas transações entre estas entidades, deixando somente doações de Pessoas Fisicas que não eram Candidato e de Empresas que não eram pertencentes a estrutura dos comitês partidários, sendo assim obtido somente doações diretas destes últimos</p>
<p align="justify">Uma vez realizado todos os tratamentos um componente de output é inserido na transformação, gerando a saída de um arquivo .csv, como pode ser verificado na imagem abaixo:</p>

<p align="center">
  <img src="https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/006.png">
</p>

<p align="justify">Os arquivos que foram usados nas transformações, são disponibilizados a seguir, para que possa ser reproduzido por qualquer pessoa:</p>

[DadosTSE_Candidato.ktr](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/ktl/DadosTSE_Candidato.ktr).
[DadosTSE_Comite.ktr](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/ktl/DadosTSE_Comite.ktr).
[DadosTSE_DoacaoPFCandidato.ktr](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/ktl/DadosTSE_DoacaoPFCandidato.ktr).
[DadosTSE_DoacaoPFPartido.ktr](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/ktl/DadosTSE_DoacaoPFPartido.ktr).
[DadosTSE_DoacaoPJCandidato.ktr](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/ktl/DadosTSE_DoacaoPJCandidato.ktr).
[DadosTSE_DoacaoPJPartido.ktr](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/ktl/DadosTSE_DoacaoPJPartido.ktr).
[DadosTSE_DoadorPessoaFisica.ktr](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/ktl/DadosTSE_DoadorPessoaFisica.ktr).
[DadosTSE_DoadorPessoaJuridica.ktr](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/ktl/DadosTSE_DoadorPessoaJuridica.ktr).
[DadosTSE_Partido.ktr](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/ktl/DadosTSE_Partido.ktr).

<p align="justify">Também estão aqui disponíveis os arquivos .csv gerados pelas transformações, que podem ser utilizadas para realizar a carga no banco Neo4J:</p>

[CANDIDATO.csv](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/csv/CANDIDATO.csv).
[DOACAO_PF_CANDIDATO.csv](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/csv/DOACAO_PF_CANDIDATO.csv).
[DOACAO_PF_PARTIDO.csv](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/csv/DOACAO_PF_PARTIDO.csv).
[DOACAO_PJ_CANDIDATO.csv](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/csv/DOACAO_PJ_CANDIDATO.csv).
[DOACAO_PJ_PARTIDO.csv](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/csv/DOACAO_PJ_PARTIDO.csv).
[DOADORES_PF.csv](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/csv/DOADORES_PF.csv).
[DOADORES_PJ.csv](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/csv/DOADORES_PJ.csv).
[PARTIDOS.csv](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/csv/PARTIDOS.csv).
[UFS.csv](https://github.com/wescleysrn/mestradounb/blob/master/imagens/election-analysis/csv/UFS.csv).

<p align="justify">Uma vez com os arquivos preparados, é possível realizar a carga no banco Neo4J por meio de uma ferramenta própria do banco que auxilia exatamente neste procedimento. Na seção a seguir será explicado o passo de carga do banco.</p>

<b>CARGA DOS DADOS</b>


<p align="justify"></p>
<p align="justify"></p>


<b>CHYPER QUERY'S UTILIZADAS</b>



PROJETO FINAL DA DISCIPLINA BANCO DE DADOS MASSIVOS

O projeto final visa analisar informações de campanha eleitoral com a utilização de banco de dados orientado a gráfico, no caso o Neo4J.

Para executar este projeto, deve-se ter: 

- O Neo4J community rodando e disponível em localhost:7474
- Realizar checkout deste repositório (git clone )
- É necessário entrar na pasta src/main/resources/static/plugins e executar o comando bower install para carregar dependências .js
- Dentro da pasta do projeto executar o seguinte comando mvn spring-boot:run
- Outra forma é na pasta do projeto executar o comando mvn clean package, com isso na pasta target será gerado o .war que pode ser publicado em um servidor de aplicação.

O projeto estará disponível no contexto http://localhost:8080


<b>Projeto fazendo uso de banco de dados orientado a grafo (Neo4J) e tecnologias java e angular:</b>

<p>- Spring Boot</p>
<p>- Spring Data Neo4J</p>
<p>- Spring Rest</p>
<p>- AngularJS</p>
<p>- D3JS</p>

