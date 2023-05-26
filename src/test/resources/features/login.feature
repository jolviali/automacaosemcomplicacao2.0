#language:pt

Funcionalidade: Login

  Contexto:
    Dado que a modal esteja sendo exibida

  @fecharModal
  Cenário: Fechar a modal ao clicar fora da mesma
    Quando for clicado fora da modal
    Entao a janela modal deve fechar

  @fecharModalIcone
  Cenário: Fechar a modal ao clicar no icone de Fechar
    Quando clicado no icone de Fechar
    Entao a janela modal deve fechar

  @createNewAccount
  Cenário: Clicar em Create new account
    Quando clicado no link Create new account
    Entao a pagina Create new account deve ser exibida

  @LoginComSucesso
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma:
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    E seja clicado o botao Sign in
    Entao deve ser possivel logar no sistema

    Exemplos:
      | identificacao       | login    | password | remember |
      | campos obrigatorios | jolviali | Senha123 | false    |
      | todos os campos     | jolviali | Senha123 | true     |

  @LoginInvalido
  Esquema do Cenario: Login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma:
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    E seja clicado o botao Sign in
    Entao o sistema deve exibir uma mensagem de erro

    Exemplos:
      | identificacao    | login    | password | remember |
      | usuario invalido | invalido | Senha123 | false    |
      | senha invalida   | jolviali | invalida | false    |

  @dadosEmBranco
  Esquema do Cenario: Login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma:
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Entao o botao Sign in deve permanecer desabilitado

    Exemplos:
      | identificacao     | login    | password | remember |
      | usuario em branco |          | Senha123 | false    |
      | senha em branco   | jolviali |          | false    |