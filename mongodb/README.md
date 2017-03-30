IMPLEMENTAÇÃO DE BANCO DE DADOS BASEADO EM DOCUMENTOS

Instalação do MongoDB

A instalação do MongoDB foi realizada através do endereço https://docs.mongodb.com/manual/installation/ onde é descrito os procedimentos necessários para as diversas plataformas e sistemas operacionais, no meu caso foi selecionado a instalação do MongoDB Community Edition no Windows, a recomendação inicial é que seja determinado a versão que você necessita, podendo ser executado os comandos no prompt de comandos wmic os get caption e wmic os get osarchitecture, conforme imagem abaixo:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/001.png)

Em seguida na página de instalação deve-se clicar no link que leva a página de download e baixar o arquivo .msi de acordo com a versão e arquitetura do sistema operacional, seja 32-bits ou 64-bits. Ao finalizar o download deve-se clicar no arquivo de instalação, será então apresentado o assistente de instalação conforme exibido abaixo:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/002.png)

	A instalação é bem simples e o assistente realiza todo o procedimento sem apresentar nenhuma janela duvidosa, apenas uma deles solicita a informação de instalação completa ou customizada, para esta tarefa foi instalado a versão completa.
	Se a instalação ocorrer com sucesso, será disponibilizados o mongoDB na pasta padrão ou na pasta informada na instalação, no meu caso em C:\Program Files\MongoDB\Server\3.4. Um arquivo importante nesta pasta é o README onde é disponibilizado informações importantes da utilização do banco de dados.
	Para iniciar o trabalho com o MongoDB é necessário a criação de diretório para o banco, devendo ser executado como administrador pelo prompt de comando, conforme mostrado a seguir:

	mkdir c:\data\db
	mkdir c:\data\log

	Em seguida deve-se criar um arquivo de configuração para determinar o local de armazenamento e de log, é importante de seja criado com permissão de administrador pois este será salvo no diretório de instalação C:\Program Files\MongoDB\Server\3.4, deverá ser nomeado para mongod.cfg e conter o seguinte conteúdo de acordo com os diretórios criados anteriormente:

systemLog:
    destination: file
    path: c:\data\log\mongod.log
storage:
    dbPath: c:\data\db
	

	Para que o arquivo mongod.cfg seja considerado é necessário executar o seguinte comando como administrador especificando o arquivo de configuração criado anteriormente:

"C:\Program Files\MongoDB\Server\3.4\bin\mongod.exe" --config "C:\Program Files\MongoDB\Server\3.4\mongod.cfg" –install

	A partir de agora é possível iniciar o serviço MongoDB por meio do comando:

net start MongoDB

	A seguinte mensagem é exibida em caso de sucesso:

The MongoDB service is starting.
The MongoDB service was started successfully.

	Para parar o serviço basta executar o seguinte commando:

net stop MongoDB

	A seguinte mensagem é exibida:

The MongoDB service is stopping.
The MongoDB service was stopped successfully.

Instalação de ferramenta visual 

	As ferramentas visuais para administração do banco MongoDB são variadas e com diversas funcionalidades de acordo com o fornecedor, podendo ser gratuita ou paga. Podem auxiliar muito na implantação e administração de dados mongo.
	Para esta atividade a ferramenta escolhida foi a MongoDB Compass, que é sugerida na pagina de documentação do MongoDB, disponível no seguinte contexto https://docs.mongodb.com/ecosystem/tools/administration-interfaces/.
	Na pagina de download foi selecionado a aba Compass e a plataforma Windows 64-bits, conforme exibo na imagem abaixo:
 
![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/003.png)

	Após ser realizado o download a instalação é realizada clicando-se no arquivo e aguardando sua instalação automática. Será portanto exibido uma tela para realizar conexão com o MongoDB, como mostrado abaixo:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/004.png) 

	Uma vez conectado visualmente é mais fácil analisar as informações geradas, agora será apresentado um projeto que irá criar alguns documentos e inserir informações neles, simulando operações no MongoDB via api Spring Data Mongo e visualizando os efeitos no MongoDB Compass.


Criando Projeto Maven Java 

	Para trabalhar com o banco de dados MongoDB e demonstrar suas funcionalidades será criado um projeto Java Maven e descrito as configurações necessárias para comunicar e realizar operações com o banco de dados MongoDB.
	Inicialmente devo informar que foi utilizado IDE de desenvolvimento eclipse neon, instalado em ambiente operacional Windows 10, com jdk versão 8 e criado projeto por meio das opções New/Maven Project, não foi utilizado nenhum archetype prévio e as configurações do projeto são as exibidas a seguir:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/005.png)  

	Uma vez criado o projeto Maven foi definido algumas dependências no arquivo pom.xml para possibilitar trabalhar com a camada de persistência spring data comunicando com MongoDB, algo que traz muito beneficio a projetos de grande porte, pela abstração de complexidades e simplicidade da implementação, abaixo é destacado as principais dependências que foram utilizadas no projeto.

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/006.png)   

	Inicialmente foi criado uma classe de configuração para definir os parâmetros de conexão com o MongoDB, sendo uma classe de extensão do AbstractMongoConfiguration da dependência spring data mongodb, configuração esta que é demonstrada a seguir:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/007.png)    

	A ideia de demonstração neste projeto é a criação de uma estrutura para armazenar informações de localização que pode ser utilizada como componente de outros sistemas e acessadas via serviço REST em implementações futuras, portanto para demonstrar a comunicação e o armazenamento das informações no MongoDB será criado os documentos Regiao, UF, MesoRegiao, MicroRegiao e Municipio, totalizando 5 documentos com vínculos entre si e que representa a organização territorial adotado no Brasil e que possui dados disponíveis no site do IBGE (http://www.ibge.gov.br/home/).
	Inicialmente para compor a estrutura do projeto, foram mapeadas os documentos envolvidos, criando no pacote br.com.unb.wescley.mongodb.entidade os objetos java conforme mostrado a seguir para o documento Regiao:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/008.png)     

	Com declarações simples de anotações spring data mongodb mapeamos o documento região para possibilitar trabalhar a manipulação de persistência com classes de repositório spring. As classes de repositório podem estender as funcionalidades da classe org.springframework.data.mongodb. repository.MongoRepository do spring data mongodb, inserindo nesta classe de repositório as principais funções de manipulação de banco de dados, como insert, findAll, delete, etc. O repositório do documento Regiao é exibido a seguir:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/009.png)     

	Note que existe uma nomenclatura bem intuitiva para a criação de query spring data, como a consulta findBySigla, onde é utilizado um prefixo “findBy” e o nome da coluna a qual se deseja pesquisar.
	Tanto os documentos como as classes de repositório para as outras entidades de domínio seguiram este padrão, formando um conjunto de implementação que possibilita manipular os dados no banco mongodb de forma bem simples e intuitiva.
	Foi pensado então em alimentar essa base de dados para demonstrar consultas diversas utilizando esta estrutura, para isso foi pensado em uma forma de inserir os dados adquiridos no site do IBGE para esta estrutura de documentos e inserir estes dados no MongoDB.
Uma estratégia utilizada para alimentar a base de documentos foi a criação de arquivos .json com o conteúdo dos dados para cada entidade, de forma que podemos ler esses arquivos e dar carga em nosso banco de dados, para isso uma dependência Jackson(https://github.com/FasterXML/jackson-databind) que é exibida a seguir foi incluída no projeto para possibilitar a conversão destes arquivos .json para objetos java e assim persistir no banco.

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/010.png) 
	
Os arquivos .json foram inseridos na pasta resources do projeto e para realizar a carga uma classe de testes foi criada para ler estes arquivos e persistir no banco de dados. A estrutura geral desta implementação é exibida seguir:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/011.png)

Esta implementação em detalhe basicamente possui uma declaração dos Repositorios de todos os documentos envolvidos, via injeção de dependência com uso da anotação @Autowired, um trecho com anotação @Before que é utilizado para limpar a base caso possua algum registro antes da carga, trecho esse que é exibido a seguir:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/012.png) 
	
E por fim para cada documento um método de teste JUnit para ler o arquivo .json e realizar interação em cada linha, convertendo em documento e inserindo no banco via repositório, conforme exibido a seguir:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/013.png)  
	
Com essa estratégia o banco é alimentado com todos os registros que diz respeito a demarcação territorial brasileira, baseado na base IBGE, se observamos no MongoDB Compass podemos visualizar o resultado desta carga. Podemos notar na imagem a seguir a quantidade de documentos em cada coleção, como 27 em UF e 5.570 em município, algo que já nos fornece algumas informações dessa massa de dados.

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/014.png)   

Clicando em uma coleção especifica como é o caso de município, podemos visualizar os documentos e inclusive realizar algumas consultas, a ferramenta nos permite visualizar informações de tamanho, quantidade de índices e os detalhes da informação armazenada, na imagem a seguir é demonstrado a visualização de registro do município de Abadiânia – GO.

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/015.png)    
 
Com o banco criado e as informações carregadas, podemos realizar algumas implementações para demonstrar como podemos realizar algumas consultas e operações com o uso do framework de persistência escolhido para demonstrar a comunicação de persistência com o MongoDB.
Podemos por exemplo recuperar todos os municípios de um determinado estado da federação, para isso podemos utilizar Query DSL ou mesmo o spring data mongodb. Inicialmente com Query DSL devemos nos lembrar de adicionar a seguinte dependência no pom.xml para que o Maven injete as bibliotecas necessárias:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/016.png)     

O projeto Query DSL com mais informações pode ser encontrado no seguinte site (http://www.querydsl.com/), e apresenta um modulo para MongoDB, permitindo utilizar sua nomenclatura de buscas com a camada de persistência MongoDB trazendo diversas funcionalidades de sua implementação para facilitar a implementação de buscas complexas.
A seguir é exibido uma implementação simples para buscar os municípios do estado de Goiás:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/017.png)     
 

Esta mesma busca será demonstrada a seguir com a utilização do spring data mongodb, para isso devemos criar previamente um método na classe repositório do município, diferente do estilo QueryDSL que possibilita a construção da busca conforme a necessidade do método chamador. Abaixo é apresentado o método em spring data mongodb que possibilita obter os municípios de um determinado estado:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/018.png)      

Notem que a assinatura do método já descreve a busca que se deseja realizar, seguindo um padrão com o prefixo “findBy” e os campos de busca. Por fim a seguir temos um método de testes similar ao anterior usando a busca spring data mongodb:

![alt tag](https://github.com/wescleysrn/mestradounb/blob/master/imagens/mongodb/019.png)       

Com base nos exemplos podemos notar como é poderosa as linguagens de consultas e como podemos utilizar os módulos de frameworks bem consolidados para trabalhar com persistência em banco de dados MongoDB.
Este projeto teve como objetivo, demonstrar a criação de uma estrutura com 5 coleções de documentos no banco de dados Mongo DB e trabalhar alguns comandos de manipulação de dados. Com base na arquitetura desenvolvida podemos construir serviços web para trabalhar informações armazenadas em banco de dados massivos.
