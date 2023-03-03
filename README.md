Es un programa que va con casos, es decir dependiendo lo que pongas
te dejara hacer una cosa o otra
Algunos de los casos son:
  - addCasa
  - addPlaca
  - addAparell
  - onCasa
  - onAparell
  - offAparell
  - list
  - info
  - quit
Obiamente estos comandos van acompañados de sus respectivos datos
Aqui dejo un par de ejemplos:
  >list
  No hi ha cases registrades.
  > addCasa 40819097P Laura 50
  OK: Casa registrada.
  > addPlaca 40819097P 15 600.99 100
  OK: Placa afegida a la casa.
  > addAparell 40819097P TV 90
  OK: Aparell afegit a la casa.
  > onCasa 40819097P
  ERROR: La casa ja té l'interruptor encès.
  > onAparell 40819097P
  ERROR: Número de paràmetres incorrecte.
  Ús: onAparell [nif] [descripció aparell]
  > onaparell 40819097P TV
  OK: Aparell encès.
  > addCasa 74324544K Mario 100
  OK: Casa registrada.
  > addCasa 67025844A Luis 5
  ERROR: Superfície incorrecta. Ha de ser més gran de 10.
  > addCasa 67025844A Luis 90
  OK: Casa registrada.
  > addPlaca 40819097P 50 1900 320
  ERROR: No hi ha espai disponible per a instal·lar aquesta placa.
  > addPlaca 74324544K 50 1900 320
  OK: Placa afegida a la casa.
  > addCasa 98517098W Mireia 150
  OK: Casa registrada.
  > addAparell 98517098M Nevera 350
  ERROR: No hi ha cap casa registrada amb aquest nif.
  > addAparell 98517098W Nevera 350
  OK: Aparell afegit a la casa.
  > addAparell 40819097P Secador 12
  OK: Aparell afegit a la casa.
  > onAparell 40819097P Nevera
  ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa
  indicada.
  > offAparell
  ERROR: Número de paràmetres incorrecte.
  Ús: offAparell [nif] [descripció aparell]
  > onAparell 40819097P Secador
  ERROR: Han saltat els ploms. La casa ha quedat completament apagada.
  > list
  --- Endolls Solars, S.L. ---
  Cases enregistrades: 4
  Casa 1
  Client: 40819097P - Laura
  Superfície de teulada: 50
  Superfície disponible: 35
  Interruptor general: apagat
  Plaques solars instal·lades: 1
  Aparells registrats: 2
