#!/bin/bash
#
# Makefile
# 
# Objetivo: Compilação do jogo Brick Breaker. 
# Projeto do curso de desenvolvimento de games da Danki code.
# 
# Site: http://www.dirackslounge.online
# 
# Versão 1.0
# 
# Programador: Rodolfo Dirack 05/09/2019
# 
# Email (Manutenção): rodolfo_profissional@hotmail.com
# 
# Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.

CC = javac
PAC = $(wildcard ./BrickBreaker/*.java)
DEP = $(PAC:.java=.class)
MAIN = Main.java
MAINCLASS = $(MAIN:.java=.class)
BIN = $(MAIN:.java=)

all:	libbed run

libbed:	$(DEP)

run:	$(MAINCLASS)
	nice -19 java $(BIN)

%.class:	%.java
	$(CC) $<

clean:
	rm $(DEP)
	rm *.class
