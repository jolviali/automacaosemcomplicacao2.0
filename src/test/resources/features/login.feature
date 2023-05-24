#language:pt

Funcionalidade: Login

  Contexto:
    Dado que a modal esteja sendo exibida
  @fecharModal
  Cenário: Fechar a modal ao clicar fora da mesma
    Quando for clicado fora da modal
    Entao a janela modal deve fechar

  Cenário: Fechar a modal ao clicar no 'x' (icone de Fechar)
    Quando clicado no 'x' (icone de Fechar)
    Entao a janela modal deve fechar

  Cenário: Clicar em 'Create New account'
    Quando clicado no link 'Create New account'
    Entao a pagina 'Create New account' deve ser exibida


  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma:
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    E seja clicado o botao 'Sign in'
    Entao deve ser possivel logar no sistema

    Exemplos:
      | identificacao       | login   | password | remember |
      | campos obrigatorios | chronos | senha    | false    |
      | todos os campos     | chronos | senha    | true     |


  Esquema do Cenario: Login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma:
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    E seja clicado o botao 'Sign in'
    Entao o sistema deve exibir uma mensagem de erro

    Exemplos:
      | identificacao    | login    | password | remember |
      | usuario invalido | invalido | senha    | false    |
      | senha invalida   | chronos  | invalida | false    |


  Esquema do Cenario: Login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma:
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    E seja clicado o botao 'Sign in'
    Entao o botao Sign in deve permanecer desabilitado

    Exemplos:
      | identificacao     | login   | password | remember |
      | usuario em branco |         | senha    | false    |
      | senha em branco   | chronos |          | false    |