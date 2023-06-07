#language:pt
Funcionalidade: Account CRUD

  //Contexto:
  Dado que a pagina new account esteja sendo exibida

  @cadastroConta
  Cenario: Cadastro nova conta
    Dado que a pagina new account esteja sendo exibida
    Quando os campos de cadastro estiverem preenchidos com
      | username | chronosJol               |
      | email    | jolberti.viali@gmail.com |
      | password | Senha123                 |
      | country  | Brazil                   |
    Entao deve ser possivel criar conta


  @loginCRUD
  Cenario: Realizar login crud
    Dado que a modal esteja sendo exibida
    Quando os campos de login sejam preenchidos da seguinte forma:
      | login    | jolviali |
      | password | Senha123 |
      | remember | false    |
    E seja clicado o botao Sign in
    Entao deve ser possivel logar no sistema

  @alterarCRUD
  Cenario: Realizar alteracao conta
    Dado que esteja logado no sistema com:
      | login    | jolviali |
      | password | Senha123 |
      | remember | false    |
